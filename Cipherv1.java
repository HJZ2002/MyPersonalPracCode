package week4;

public class Cipherv1 {

	public static String cipher(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                int offset = (character - base + key) % 26;
                result.append((char) (base + offset));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String text = "Gugma";
        int key = 3; 
        String cipheredText = cipher(text, key);
        System.out.println("Original: " + text);
        System.out.println("Ciphered: " + cipheredText);
    }
}