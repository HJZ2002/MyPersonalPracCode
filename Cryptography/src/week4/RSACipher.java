package week4;

import javax.swing.*;
import java.math.BigInteger;
import java.util.Random;
public class RSACipher {

	public static void main(String[] args) {
		
		
		while(true) {
			String[]options = {"Encrpyt","Decrpyt","Exit"};
			int choice = Integer.parseInt(JOptionPane.showInputDialog(null, "Choose among the choices:","Sample Rsa",JOptionPane.DEFAULT_OPTION));
			
			switch(choice) {
			case 1:
				if(choice == 0) {
					encrypt();
				} else if (choice == 1) {
					decrypt();
					break;
				}
			case 2:
				System.exit(0);
			default:
				JOptionPane.showMessageDialog(null,"Invalid option");
			}
		}
	}

	private static void decrypt() {
	 String ciphertext = JOptionPane.showInputDialog("Enter CipherText");
	 if(ciphertext!=null) {
		 String nValue = JOptionPane.showInputDialog("Enter n:");
		 String publicKeyValue = JOptionPane.showInputDialog("Enter public key (e):");
		 String privatekeyvalue= JOptionPane.showInputDialog("Enter private key (e):");
		 
		 if(nValue !=null && publicKeyValue != null && privatekeyvalue !=null) {
			 BigInteger useN = new BigInteger(nValue);
			 BigInteger usePublicKey = new BigInteger(publicKeyValue);
			 BigInteger usePrivateKey = new BigInteger(privatekeyvalue);
			 
			 String decryptedText = decrypt(ciphertext,useN,usePrivateKey);
			 displaykeys("Decryption","Public Key","(n,e)",useN,usePublicKey,"Private Key","(n,d",useN,usePrivateKey,ciphertext);
		 }
	 }
		
	}

	private static void encrypt() {
		Random random = new Random();
		BigInteger a,c,n,b,phis,e,d;
		
		do {
			a = BigInteger.probablePrime(random.nextInt(3)+3,random);
			c = BigInteger.probablePrime(random.nextInt(3)+3,random);
			n = a.multiply(c);
			phis = a.subtract(BigInteger.ONE).multiply(c.subtract(BigInteger.ONE));
			e = new BigInteger(phis.bitLength(),random);
		} while (e.compareTo(BigInteger.ONE)<= 0 || e.compareTo(phis)>=0 || !e.gcd(phis).equals(BigInteger.ONE));
		d = e.modInverse(phis);
		
		String plaintext = JOptionPane.showInputDialog("Enter the plaintext:");
		if(plaintext != null) {
			String ciphertext = encrypt(plaintext,n,e);
			displaykeys("Encryption","Public Key","(n,e)",n,e,"Private Key","(n,d",n,d,ciphertext);
		}
	}
		private static String encrypt(String plaintext,BigInteger n, BigInteger e) {
			StringBuilder encryptedText = new StringBuilder();
			
			for(char c :plaintext.toCharArray()) {
				int asciValue = (int)c;
				BigInteger message = BigInteger.valueOf(asciValue);
				BigInteger ciphertext = message.modPow(e, n);
				encryptedText.append(ciphertext).append(" ");
			}
			return encryptedText.toString();
	}
		private static String decrypt(String cipherText,BigInteger useN, BigInteger usePrivateKey) {
			StringBuilder decryptText = new StringBuilder();
			String[]ciphertextArray = cipherText.trim().split(" ");
			
			for(String c : ciphertextArray) {
				BigInteger encrpytedMessage = new BigInteger(c);
				BigInteger decrpytedMessage = encrpytedMessage.modPow(usePrivateKey, useN);
				int asciValue = decrpytedMessage.intValue();
				
			}
			return decryptText.toString();
   }
		private static void displaykeys(String operation, String label1, String keyType1,BigInteger key1,BigInteger key2,String 
				label2,String keytype2,BigInteger key3,BigInteger key4 ,String result) {
			String info1 = label1 + ": "+ keyType1 +":("+ key1 +" ," + key2 + ")";
			String info2 = label2 + ": "+ keytype2 +":("+ key3 +" ," + key4 + ")";
			JOptionPane.showMessageDialog(null, operation + " Result:\n\n" + result +"\n\nKey Information:\n\n"+info1+ "\n"+info2);
		}
}

