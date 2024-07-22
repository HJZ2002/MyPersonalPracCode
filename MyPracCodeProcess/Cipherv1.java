package week4;

import java.util.Scanner;

public class Cipherv1 {

    // Method to encrypt or decrypt a given text with a given key
    public static String cipher(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                int offset = (character - base + key) % 26;
                if (offset < 0) offset += 26; // Ensure offset is positive for decryption
                result.append((char) (base + offset));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input original message
        System.out.print("Enter the message: ");
        String text = scanner.nextLine();

        // Fixed encryption key
        int key = 3;

        // Encrypt the message
        String cipheredText = cipher(text, key);

        // Decrypt the message
        String decryptedText = cipher(cipheredText, -key);

        // Display original, encrypted, and decrypted messages
        System.out.println("Original message: " + text);
        System.out.println("Encrypted message: " + cipheredText);
        System.out.println("Decrypted message: " + decryptedText);
    }
}
