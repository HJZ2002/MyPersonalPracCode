package ProjectV2;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;
import java.util.List;

public class todolistv2GUI extends JFrame {

    private static final String SAVE_FILE = "tasks.txt";
    private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    static class Task {
        String title;
        boolean done;
        Integer priority;
        LocalDate dueDate;

        Task(String title) { this.title = title; }

        String prettyDue() { return dueDate == null ? "—" : DATE_FMT.format(dueDate); }
        String prettyPri() { return priority == null ? "—" : String.valueOf(priority); }

        String toCsv() {
            return escape(title) + "," + (done ? "1" : "0") + "," +
                    (priority == null ? "" : priority) + "," +
                    (dueDate == null ? "" : DATE_FMT.format(dueDate));
        }

        static Task fromCsv(String line) {
            String[] p = line.split(",", -1);
            if (p.length < 4) return null;
            Task t = new Task(unescape(p[0]));
            t.done = "1".equals(p[1]);
            t.priority = p[2].isEmpty() ? null : parseIntSafe(p[2], null);
            t.dueDate = p[3].isEmpty() ? null : parseDateSafe(p[3], null);
            return t;
        }

        private static String escape(String s) { return s == null ? "" : s.replace(",", " "); }
        private static String unescape(String s) { return s; }
    }

    static class TaskTableModel extends AbstractTableModel {
        private final String[] cols = {"✓", "Title", "Due", "Pri"};
        private final java.util.List<Task> data;

        TaskTableModel(List<Task> tasks) { this.data = tasks; }

        @Override public int getRowCount() { return data.size(); }
        @Override public int getColumnCount() { return cols.length; }
        @Override public String getColumnName(int c) { return cols[c]; }
        @Override public Class<?> getColumnClass(int c) { return c == 0 ? Boolean.class : String.class; }
        @Override public boolean isCellEditable(int r, int c) { return c != 3 ? true : true; }

        @Override public Object getValueAt(int r, int c) {
            Task t = data.get(r);
            return switch (c) {
                case 0 -> t.done;
                case 1 -> t.title;
                case 2 -> t.prettyDue();
                case 3 -> t.prettyPri();
                default -> null;
            };
        }

        @Override public void setValueAt(Object v, int r, int c) {
            Task t = data.get(r);
            switch (c) {
                case 0 -> t.done = (Boolean) v;
                case 1 -> t.title = (v == null ? "" : v.toString().trim());
                case 2 -> {
                    String s = (v == null ? "" : v.toString().trim());
                    t.dueDate = s.isEmpty() ? null : parseDateSafe(s, null);
                }
                case 3 -> {
                    String s = (v == null ? "" : v.toString().trim());
                    if (s.isEmpty()) t.priority = null;
                    else {
                        Integer p = parseIntSafe(s, null);
                        if (p != null && p >= 1 && p <= 5) t.priority = p;
                    }
                }
            }
            fireTableRowsUpdated(r, r);
        }

        Task getTask(int r) { return data.get(r); }
        void add(Task t) { data.add(t); fireTableRowsInserted(data.size()-1, data.size()-1); }
        void remove(int[] rows, JTable table) {
            int[] m = Arrays.stream(rows).map(table::convertRowIndexToModel).sorted().toArray();
            for (int i = m.length - 1; i >= 0; i--) data.remove(m[i]);
            fireTableDataChanged();
        }
    }

    private final java.util.List<Task> tasks = new ArrayList<>();
    private TaskTableModel model;
    private JTable table;
    private JTextField titleField, dueField, searchField;
    private JComboBox<String> priBox, filterBox;
    private JLabel status;

    public todolistv2GUI() {
        super("To-Do List");
        applyNimbusTheme();
        loadTasks(tasks);

        model = new TaskTableModel(tasks);
        table = new JTable(model);
        table.setFillsViewportHeight(true);
        table.setRowHeight(26);
        table.setShowVerticalLines(false);
        table.setGridColor(new Color(240, 240, 240));

        center(table, 0);
        center(table, 2);
        center(table, 3);

        JScrollPane scroll = new JScrollPane(table);
        scroll.setBorder(BorderFactory.createEmptyBorder());

        JPanel topBar = makeTopBar();
        JPanel bottom = makeBottom();

        JPanel root = new JPanel(new BorderLayout(10, 10));
        root.setBackground(Color.WHITE);
        root.setBorder(new EmptyBorder(15, 15, 15, 15));
        root.add(topBar, BorderLayout.NORTH);
        root.add(scroll, BorderLayout.CENTER);
        root.add(bottom, BorderLayout.SOUTH);

        setContentPane(root);
        setMinimumSize(new Dimension(720, 480));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        model.addTableModelListener(e -> saveTasks(tasks));
        refreshStatus();
        setResizable(false);
    }

    private JPanel makeTopBar() {
        // --- Inputs ---
        titleField = new JTextField();
        titleField.setPreferredSize(new Dimension(180, 25)); // widened Title box

        dueField = new JTextField();
        dueField.setToolTipText("yyyy-MM-dd");
        dueField.setPreferredSize(new Dimension(120, 25)); // slightly wider Due box

        priBox = new JComboBox<>(new String[]{"", "1", "2", "3", "4", "5"});
        priBox.setPreferredSize(new Dimension(70, 25));

        // --- Buttons ---
        JButton add  = styledBtn("Add Task", new Color(51,122,255), Color.WHITE, e -> onAdd());
        JButton del  = styledBtn("Delete",   new Color(231,76,60),  Color.WHITE, e -> onDelete());
        JButton save = styledBtn("Save",     new Color(46,204,113), Color.WHITE, e -> saveTasks(tasks));

        // A group for the buttons to customized 
        JPanel btnGroup = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        btnGroup.setOpaque(false);
        btnGroup.setBorder(new EmptyBorder(6, 0, 0, 0)); // lowers just the buttons
        btnGroup.add(add);
        btnGroup.add(del);
        btnGroup.add(save);

        // --- Search & Filter ---
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(180, 25)); // widened Search box
        searchField.setToolTipText("Search title...");
        searchField.getDocument().addDocumentListener(new SimpleDoc(this::applyFilter));

        filterBox = new JComboBox<>(new String[]{"All", "Pending", "Done"});
        filterBox.setPreferredSize(new Dimension(90, 25));
        filterBox.addActionListener(e -> applyFilter());

        // --- Row 1: Title, Due, Pri, Buttons ---
        JPanel row1 = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        row1.setOpaque(false);
        row1.add(labelled("Title", titleField));
        row1.add(labelled("Due", dueField));
        row1.add(labelled("Pri", priBox));
        row1.add(btnGroup);

        // --- Row 2: Search, Filter ---
        JPanel row2 = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        row2.setOpaque(false);
        row2.add(labelled("Search", searchField));
        row2.add(labelled("Filter", filterBox));

        // --- Stack both rows ---
        JPanel addPanel = new JPanel(new GridLayout(2, 1, 8, 4));
        addPanel.setOpaque(false);
        addPanel.add(row1);
        addPanel.add(row2);

        JPanel top = new JPanel(new BorderLayout());
        top.setOpaque(false);
        top.add(addPanel, BorderLayout.CENTER);
        return top;
    }



    private JPanel makeBottom() {
        status = new JLabel(" ");
        status.setFont(status.getFont().deriveFont(Font.PLAIN, 13f));
        status.setForeground(new Color(80, 80, 80));
        JPanel p = new JPanel(new BorderLayout());
        p.setOpaque(false);
        p.add(status, BorderLayout.WEST);
        return p;
    }

    private JPanel labelled(String label, JComponent field) {
        JPanel p = new JPanel(new BorderLayout());
        p.setOpaque(false);
        JLabel l = new JLabel(label);
        l.setFont(l.getFont().deriveFont(Font.PLAIN, 11f));
        l.setForeground(new Color(90, 90, 90));
        p.add(l, BorderLayout.NORTH);
        field.setPreferredSize(new Dimension(110, 25));
        p.add(field, BorderLayout.CENTER);
        return p;
    }

    private JButton styledBtn(String text, Color bg, Color fg, ActionListener act) {
        JButton b = new JButton(text);
        b.addActionListener(act);
        b.setBackground(bg);
        b.setForeground(fg);
        b.setFocusPainted(false);
        b.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        return b;
    }

    private void onAdd() {
        String t = titleField.getText().trim();
        if (t.isEmpty()) { toast("Title required."); return; }
        Task task = new Task(t);

        String due = dueField.getText().trim();
        if (!due.isEmpty()) {
            LocalDate d = parseDateSafe(due, null);
            if (d == null) toast("Invalid date format."); else task.dueDate = d;
        }

        String p = Objects.toString(priBox.getSelectedItem(), "");
        if (!p.isBlank()) {
            Integer v = parseIntSafe(p, null);
            if (v != null && v >= 1 && v <= 5) task.priority = v;
        }

        model.add(task);
        saveTasks(tasks);
        titleField.setText(""); dueField.setText(""); priBox.setSelectedIndex(0);
        refreshStatus();
    }

    private void onDelete() {
        int[] rows = table.getSelectedRows();
        if (rows.length == 0) { toast("Select a task first."); return; }
        model.remove(rows, table);
        saveTasks(tasks);
        refreshStatus();
    }

    private void applyFilter() {
        String query = searchField.getText().trim().toLowerCase();
        String filter = Objects.toString(filterBox.getSelectedItem(), "All");

        TableRowSorter<TaskTableModel> sorter = new TableRowSorter<>(model);
        sorter.setRowFilter(new RowFilter<>() {
            public boolean include(Entry<? extends TaskTableModel, ? extends Integer> e) {
                Task t = model.getTask(e.getIdentifier());
                if ("Pending".equals(filter) && t.done) return false;
                if ("Done".equals(filter) && !t.done) return false;
                return query.isEmpty() || t.title.toLowerCase().contains(query);
            }
        });
        table.setRowSorter(sorter);
        refreshStatus();
    }

    private void refreshStatus() {
        long total = tasks.size();
        long done = tasks.stream().filter(t -> t.done).count();
        status.setText("Total: " + total + " | Pending: " + (total - done) + " | Done: " + done);
    }

    private void toast(String msg) {
        status.setText(msg + "   •   " + status.getText());
    }

    private static void loadTasks(List<Task> tasks) {
        Path p = Paths.get(SAVE_FILE);
        if (!Files.exists(p)) return;
        try (BufferedReader br = Files.newBufferedReader(p)) {
            String line; while ((line = br.readLine()) != null) {
                Task t = Task.fromCsv(line);
                if (t != null) tasks.add(t);
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    private static void saveTasks(List<Task> tasks) {
        try (BufferedWriter bw = Files.newBufferedWriter(Paths.get(SAVE_FILE))) {
            for (Task t : tasks) {
                bw.write(t.toCsv());
                bw.newLine();
            }
        } catch (IOException e) { e.printStackTrace(); }
    }

    private static Integer parseIntSafe(String s, Integer fb) {
        try { return Integer.valueOf(s.trim()); } catch (Exception e) { return fb; }
    }
    private static LocalDate parseDateSafe(String s, LocalDate fb) {
        try { return LocalDate.parse(s.trim(), DATE_FMT); }
        catch (DateTimeParseException e) { return fb; }
    }

    private static void center(JTable t, int col) {
        DefaultTableCellRenderer r = new DefaultTableCellRenderer();
        r.setHorizontalAlignment(SwingConstants.CENTER);
        t.getColumnModel().getColumn(col).setCellRenderer(r);
    }

    private static void applyNimbusTheme() {
        try {
            for (UIManager.LookAndFeelInfo i : UIManager.getInstalledLookAndFeels())
                if ("Nimbus".equals(i.getName())) UIManager.setLookAndFeel(i.getClassName());
            UIManager.put("control", Color.WHITE);
        } catch (Exception ignored) {}
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new todolistv2GUI().setVisible(true));
    }

    private static class SimpleDoc implements DocumentListener {
        private final Runnable fn;
        SimpleDoc(Runnable fn) { this.fn = fn; }
        public void insertUpdate(DocumentEvent e) { fn.run(); }
        public void removeUpdate(DocumentEvent e) { fn.run(); }
        public void changedUpdate(DocumentEvent e) { fn.run(); }
    }
}
