
public class Twice {
	public static void main(String[] args) {
        String lyrics = "Shot thru the heart\n"
                + "내 심장을 쏴\n"
                + "사랑의 총알이\n"
                + "떨어져 가고 있어\n"
                + "숨결이 멎을 때\n"
                + "니가 나타날 때\n"
                + "이미 난 어느새\n"
                + "너에게 빠져 있어";

        String[] lines = lyrics.split("\n");

        String[] members = {"Nayeon", "Jeongyeon", "Momo", "Sana", "Jihyo", "Mina", "Dahyun", "Chaeyoung", "Tzuyu"};

        for (int i = 0; i < lines.length; i++) {
            String line = lines[i];
            String member = members[i % members.length];
            String colorCode = getColorCode(member);

            String formattedLine = String.format("[%s] %s", member, line);
            String colorCodedLine = colorCode + formattedLine + "\u001B[0m";
            System.out.println(colorCodedLine);
        }
    }

    private static String getColorCode(String member) {
        switch (member) {
            case "Nayeon":
                return "\u001B[31m"; // Red
            case "Jeongyeon":
                return "\u001B[32m"; // Green
            case "Momo":
                return "\u001B[33m"; // Yellow
            case "Sana":
                return "\u001B[34m"; // Blue
            case "Jihyo":
                return "\u001B[35m"; // Purple
            case "Mina":
                return "\u001B[36m"; // Cyan
            case "Dahyun":
                return "\u001B[37m"; // White
            case "Chaeyoung":
                return "\u001B[91m"; // Light Red
            case "Tzuyu":
                return "\u001B[93m"; // Light Yellow
            default:
                return "\u001B[0m"; // Reset
        }
    }
}