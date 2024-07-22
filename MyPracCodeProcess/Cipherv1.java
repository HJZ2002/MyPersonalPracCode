package week4;

import java.util.Scanner;

public class Cipherv1 {

    // Method to encrypt or decrypt 
    public static String cipher(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                int offset = (character - base + key) % 26;
                if (offset < 0) offset += 26; // Ensure offset is positive
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

        // encryption key
        int key = 3;

        // Encrypt the message
        String cipheredText = cipher(text, key);

     
        // Display original, encrypted, and decrypted messages
        System.out.println("Original message: " + text);
        System.out.println("Encrypted message: " + cipheredText);
        
        System.out.println("Enter the message to decrypt: ");
        
        String encryptedTextToDecrypt = scanner.nextLine();
        
        String decryptedText = cipher(encryptedTextToDecrypt, -key);
        
        System.out.println("The message says: " + decryptedText);
    }
}
