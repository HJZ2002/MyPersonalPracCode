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
    // Method to brute-force decrypt a message with all possible keys
    public static void bruteForceDecrypt(String text) {
        System.out.println("Trying all possible keys: ");
        for (int key = 1; key < 26; key++) {
            String decryptedText = cipher(text, -key);
            System.out.println("Key " + key + ": " + decryptedText);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int key = 3;
        boolean continueLoop = true;

        // Looping method so that it can be asked again
        while (continueLoop) {
            System.out.println("Choose an option:");
            System.out.println("1. Encrypt a message");
            System.out.println("2. Decrypt a message with known key");
            System.out.println("3. Decrypt a message with unknown key");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Input original message
                    System.out.print("Enter the message to encrypt: ");
                    String textToEncrypt = scanner.nextLine();
                    // Encrypt the message
                    String cipheredText = cipher(textToEncrypt, key);
                    // Display original and encrypted messages
                    System.out.println("Original message: " + textToEncrypt);
                    System.out.println("Encrypted message: " + cipheredText);
                    break;

                case 2:
                    // Decrypting the message with known key
                    System.out.print("Enter the message to decrypt: ");
                    String encryptedTextToDecrypt = scanner.nextLine();
                    String decryptedText = cipher(encryptedTextToDecrypt, -key);
                    System.out.println("Decrypted message: " + decryptedText);
                    break;

                case 3:
                    // Decrypting the message with unknown key 
                    System.out.print("Enter the encrypted message: ");
                    String textToBruteForce = scanner.nextLine();
                    bruteForceDecrypt(textToBruteForce);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            System.out.print("Do you want to perform another operation? (y/n): ");
            String response = scanner.nextLine().toLowerCase();
            if (!response.equals("y")) {
                continueLoop = false;
            }
        }

        scanner.close();
        System.out.println("Exiting");
    }
}
