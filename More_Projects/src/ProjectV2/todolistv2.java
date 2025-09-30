package ProjectV2;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;


public class todolistv2 {

    // ====== Config ======
    private static final String SAVE_FILE = "tasks.txt";
    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // ====== Data Model ======
    static class Task {
        String title;
        boolean done;
        Integer priority;      // 1 (high) .. 5 (low). Null if not set.
        LocalDate dueDate;     // Null if not set.

        Task(String title) { this.title = title; }

        String statusIcon() { return done ? "[✓]" : "[ ]"; }

        String prettyDue() { return dueDate == null ? "-" : DATE_FMT.format(dueDate); }

        String prettyPriority() { return priority == null ? "-" : String.valueOf(priority); }

        // to a txt file since its more clear
        String totxt() {
            return escape(title) + "," + (done ? "1" : "0") + ","
                    + (priority == null ? "" : priority) + ","
                    + (dueDate == null ? "" : DATE_FMT.format(dueDate));
        }

        static Task fromCsv(String line) {
            String[] parts = line.split(",", -1);
            if (parts.length < 4) return null;
            Task t = new Task(unescape(parts[0]));
            t.done = "1".equals(parts[1]);
            t.priority = parts[2].isEmpty() ? null : parseIntSafe(parts[2], null);
            t.dueDate = parts[3].isEmpty() ? null : parseDateSafe(parts[3], null);
            return t;
        }

        private static String escape(String s) {
            return s == null ? "" : s.replace(",", " ");
        }

        private static String unescape(String s) {
            return s;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Task> tasks = new ArrayList<>();

        // Load saved tasks 
        loadTasks(tasks);

        while (true) {
            System.out.println("\n-- TASK TO-DO LIST --");
            System.out.println("1. Add Task");// adds the task
            System.out.println("2. View Tasks");// views the task
            System.out.println("3. Edit Task Title");// edits the title of the task
            System.out.println("4. Mark Done / Undone");// set the task done which leads to no update
            System.out.println("5. Delete Task");// deletes the task
            System.out.println("6. Search Tasks");// searches the task by keyword
            System.out.println("7. Filter (All / Pending / Done)");// filters the task by pending or done or all
            System.out.println("8. Set Due Date / Priority");// sets the due date and priority
            System.out.println("9. Save Now");// saves the task
            System.out.println("0. Exit");// exits the program
            System.out.print("Choose an option: ");

            int choice = readInt(sc, -1);
            switch (choice) {
                case 1 -> addTask(sc, tasks);
                case 2 -> viewTasks(tasks);
                case 3 -> editTaskTitle(sc, tasks);
                case 4 -> toggleDone(sc, tasks);
                case 5 -> deleteTask(sc, tasks);
                case 6 -> searchTasks(sc, tasks);
                case 7 -> filterTasks(sc, tasks);
                case 8 -> setDueAndPriority(sc, tasks);
                case 9 -> { saveTasks(tasks); System.out.println("Saved."); }
                case 0 -> { saveTasks(tasks); System.out.println("Exiting..."); return; }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    // ====== Features ======

    private static void addTask(Scanner sc, List<Task> tasks) {
        System.out.print("Enter task title: ");
        String title = readLine(sc);
        if (title.isBlank()) {
            System.out.println("Title cannot be empty.");
            return;
        }
        Task t = new Task(title);

        // Optional quick set for due date & priority
        System.out.print("Set due date? (yyyy-MM-dd or leave blank): ");
        String due = readLine(sc).trim();
        if (!due.isEmpty()) {
            LocalDate d = parseDateSafe(due, null);
            if (d == null) System.out.println("Invalid date. Skipped.");
            else t.dueDate = d;
        }

        System.out.print("Set priority 1 (high) .. 5 (low) or blank: ");
        String pr = readLine(sc).trim();
        if (!pr.isEmpty()) {
            Integer p = parseIntSafe(pr, null);
            if (p == null || p < 1 || p > 5) System.out.println("Invalid priority. Skipped.");
            else t.priority = p;
        }
        // adds the task and saved task afterwards
        tasks.add(t);
        saveTasks(tasks);
        System.out.println("Task added.");
    }
    // views the task if there is any things have been adeed
    private static void viewTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("-- No tasks yet --");
            return;
        }
        printTasks(tasks);
    }
    // edits the title of the task if u wanna edit something
    private static void editTaskTitle(Scanner sc, List<Task> tasks) {
        if (tasks.isEmpty()) { System.out.println("No tasks to edit."); return; }
        printTasks(tasks);
        System.out.print("Enter task number to edit: ");
        int idx = readInt(sc, -1) - 1;
        if (!validIndex(idx, tasks)) return;

        System.out.print("Enter new title: ");
        String title = readLine(sc);
        if (title.isBlank()) { System.out.println("Title cannot be empty."); return; }
        tasks.get(idx).title = title;
        saveTasks(tasks);
        System.out.println("Updated.");
    }
    // set the task done which leads to no update
    private static void toggleDone(Scanner sc, List<Task> tasks) {
        if (tasks.isEmpty()) { System.out.println("No tasks to update."); return; }
        printTasks(tasks);
        System.out.print("Enter task number to toggle done/undone: ");
        int idx = readInt(sc, -1) - 1;
        if (!validIndex(idx, tasks)) return;

        Task t = tasks.get(idx);
        t.done = !t.done;
        saveTasks(tasks);
        System.out.println("Now marked as " + (t.done ? "DONE." : "PENDING."));
    }
    // deletes the task if u wanna delete something
    private static void deleteTask(Scanner sc, List<Task> tasks) {
        if (tasks.isEmpty()) { System.out.println("No tasks to delete."); return; }
        printTasks(tasks);
        System.out.print("Enter task number to delete: ");
        int idx = readInt(sc, -1) - 1;
        if (!validIndex(idx, tasks)) return;

        Task removed = tasks.remove(idx);
        saveTasks(tasks);
        System.out.println("Deleted: " + removed.title);
    }
    // searches the task if u wanna search something by keyword
    private static void searchTasks(Scanner sc, List<Task> tasks) {
        System.out.print("Enter keyword to search: ");
        String q = readLine(sc).toLowerCase(Locale.ROOT).trim();
        if (q.isEmpty()) { System.out.println("Empty query."); return; }

        List<Task> hits = new ArrayList<>();
        for (Task t : tasks) {
            if (t.title.toLowerCase(Locale.ROOT).contains(q)) hits.add(t);
        }
        if (hits.isEmpty()) System.out.println("No matches.");
        else printTasks(hits);
    }
    // filters the task if u wanna filter something by pending or done or all
    private static void filterTasks(Scanner sc, List<Task> tasks) {
        if (tasks.isEmpty()) { System.out.println("No tasks yet."); return; }
        System.out.println("Filter: 1) All  2) Pending  3) Done");
        System.out.print("Choose: ");
        int f = readInt(sc, 1);
        List<Task> out = new ArrayList<>();
        switch (f) {
            case 1 -> out = tasks;
            case 2 -> tasks.stream().filter(t -> !t.done).forEach(out::add);
            case 3 -> tasks.stream().filter(t -> t.done).forEach(out::add);
            default -> { System.out.println("Invalid choice."); return; }
        }
        printTasks(out);
    }
    // sets the due date and priority depends on your time and importance
    private static void setDueAndPriority(Scanner sc, List<Task> tasks) {
        if (tasks.isEmpty()) { System.out.println("No tasks to update."); return; }
        printTasks(tasks);
        System.out.print("Enter task number: ");
        int idx = readInt(sc, -1) - 1;
        if (!validIndex(idx, tasks)) return;

        Task t = tasks.get(idx);

        System.out.print("New due date (yyyy-MM-dd or blank to clear/skip): ");// new due date
        String due = readLine(sc).trim();
        if (due.isEmpty()) {
            t.dueDate = null;
        } else {
            LocalDate d = parseDateSafe(due, null);
            if (d == null) System.out.println("Invalid date. (kept old)");// invalid date
            else t.dueDate = d;
        }

        System.out.print("New priority 1..5 or blank to clear/skip: ");
        String pr = readLine(sc).trim();
        if (pr.isEmpty()) {
            t.priority = null;
        } else {
            Integer p = parseIntSafe(pr, null);
            if (p == null || p < 1 || p > 5) System.out.println("Invalid priority. (kept old)");
            else t.priority = p;
        }

        saveTasks(tasks);
        System.out.println("Updated.");
    }

    // ====== Persistence ======
    
    // loads the task if there is any saved task in the directory
    private static void loadTasks(List<Task> tasks) {
        Path p = Paths.get(SAVE_FILE);
        if (!Files.exists(p)) return;
        try (BufferedReader br = Files.newBufferedReader(p)) {
            String line;
            while ((line = br.readLine()) != null) {
                Task t = Task.fromCsv(line);
                if (t != null) tasks.add(t);
            }
            if (!tasks.isEmpty()) System.out.println("Loaded " + tasks.size() + " task(s).");
        } catch (IOException e) {
            System.out.println("Failed to load tasks: " + e.getMessage());
        }
    }
    // saves the task in the directory as tasks.csv
    private static void saveTasks(List<Task> tasks) {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(SAVE_FILE))) {
            for (Task t : tasks) {
                bw.write(t.totxt());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Failed to save tasks: " + e.getMessage());
        }
    }

    // ====== Helpers ======
    // prints the task in a formatted way and clean as possible
    private static void printTasks(List<Task> tasks) {
        if (tasks.isEmpty()) {
            System.out.println("-- No tasks to show --");
            return;
        }
        // Sort pending first, then by due date (earliest first), then by priority, then title
        List<Task> copy = new ArrayList<>(tasks);
        copy.sort((a, b) -> {
            if (a.done != b.done) return a.done ? 1 : -1; // pending first
            int dueCmp = compareNullable(a.dueDate, b.dueDate);
            if (dueCmp != 0) return dueCmp;
            int prCmp = compareNullable(a.priority, b.priority);
            if (prCmp != 0) return prCmp;
            return a.title.compareToIgnoreCase(b.title);
        });

        System.out.println("\n#  Status  Title                                      Due        Pri");
        System.out.println("-----------------------------------------------------------------------");
        int i = 1;
        for (Task t : copy) {
            System.out.printf(Locale.ROOT, "%-3d%-8s%-43s%-11s%-3s%n",
                    i++, t.statusIcon(), truncate(t.title, 42), t.prettyDue(), t.prettyPriority());
        }
    }

    private static String truncate(String s, int max) {
        if (s.length() <= max) return s;
        return s.substring(0, Math.max(0, max - 1)) + "…";
    }

    private static boolean validIndex(int idx, List<Task> tasks) {
        if (idx < 0 || idx >= tasks.size()) {
            System.out.println("Invalid task number.");
            return false;
        }
        return true;
    }

    private static int readInt(Scanner sc, int fallback) {
        String s = readLine(sc).trim();
        try { return Integer.parseInt(s); }
        catch (NumberFormatException e) { return fallback; }
    }

    private static String readLine(Scanner sc) {
        String line;
        if (sc.hasNextLine()) line = sc.nextLine();
        else {
            // If nextInt was used before, consume pending newline safely
            sc = new Scanner(System.in);
            line = sc.nextLine();
        }
        return line;
    }

    private static Integer parseIntSafe(String s, Integer fallback) {
        try { return Integer.valueOf(s.trim()); }
        catch (Exception e) { return fallback; }
    }

    private static LocalDate parseDateSafe(String s, LocalDate fallback) {
        try { return LocalDate.parse(s.trim(), DATE_FMT); }
        catch (DateTimeParseException e) { return fallback; }
    }

    private static <T extends Comparable<T>> int compareNullable(T a, T b) {
        if (a == null && b == null) return 0;
        if (a == null) return 1;    // nulls last
        if (b == null) return -1;
        return a.compareTo(b);
    }
}
