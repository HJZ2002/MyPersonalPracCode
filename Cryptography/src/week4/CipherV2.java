package week4;
import java.util.Scanner;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class CipherV2 {

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

    // Method to add obfuscation to the encrypted message
    public static String obfuscate(String text) {
        Random random = new Random();
        StringBuilder obfuscated = new StringBuilder();
        for (char character : text.toCharArray()) {
            obfuscated.append(character);
            if (Character.isLetter(character)) {
                obfuscated.append((char) (random.nextInt(26) + 'a')); // Insert random lowercase letter
            }
        }
        return obfuscated.toString();
    }

    // Method to remove obfuscation from the message
    public static String deobfuscate(String text) {
        StringBuilder deobfuscated = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            deobfuscated.append(text.charAt(i));
            if (Character.isLetter(text.charAt(i))) {
                i++; // Skip the next character
            }
        }
        return deobfuscated.toString();
    }

    // Method to brute-force decrypt a message with all possible keys
    public static void bruteForceDecrypt(String text) {
        System.out.println("All possible keys: ");
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
            System.out.println("Choose an option :");
            System.out.println("1. Encrypt a message");
            System.out.println("2. Decrypt a message with known key: ");
            System.out.println("3. Decrypt a message with unknown key: ");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Input original message
                    System.out.print("Enter the message: ");
                    String textToEncrypt = scanner.nextLine();
                    // Encrypt the message
                    String cipheredText = cipher(textToEncrypt, key);
                    // Obfuscate the encrypted message
                    String obfuscatedText = obfuscate(cipheredText);
                    // Display original and obfuscated encrypted messages
                    System.out.println("Original message: " + textToEncrypt);
                    System.out.println("Obfuscated encrypted message: " + obfuscatedText);
                    
                    // making a file text
                    try(FileWriter fw = new FileWriter("OriginalMessage.txt")){
                    	fw.write("Original Message: " + textToEncrypt + "\n");
                    	fw.write("Obfuscated Message: " + obfuscatedText + "\n");
                    	System.out.println("Obfuscated Message was writtien in OriginalMessage_.txt" );
                    } catch (IOException e) {
                    	System.out.println("an error occurred");
                    	e.printStackTrace();
                    }
                    break;

                case 2:
                    // Decrypting the message with known key
                    System.out.print("Enter the obfuscated encrypted message to decrypt: ");
                    String obfuscatedTextToDecrypt = scanner.nextLine();
                    // De-obfuscate the message
                    String deobfuscatedText = deobfuscate(obfuscatedTextToDecrypt);
                    // Decrypt the de-obfuscated message
                    String decryptedText = cipher(deobfuscatedText, -key);
                    System.out.println("Decrypted message: " + decryptedText);
                    
                    // making a file text
                    try(FileWriter fw = new FileWriter("OriginalMessage.txt")){
                    	fw.write("obfuscated Message: " + deobfuscatedText + "\n");
                    	fw.write("Decrypted Message: " + decryptedText + "\n");
                    	System.out.println("Obfuscated Message was writtien in OriginalMessage_.txt" );
                    } catch (IOException e) {
                    	System.out.println("an error occurred");
                    	e.printStackTrace();
                    }
                    break;

                case 3:
                    // Decrypting the message with unknown key 
                    System.out.print("Enter the obfuscated encrypted message: ");
                    String obfuscatedTextToBruteForce = scanner.nextLine();
                    // De-obfuscate the message
                    String deobfuscatedTextToBruteForce = deobfuscate(obfuscatedTextToBruteForce);
                    bruteForceDecrypt(deobfuscatedTextToBruteForce);
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