package CoddyTech;

public class Speakeasy {
		 public static String[] decodeMessage(String[] secretCodes, int shift) {
		        String[] result = new String[secretCodes.length];

		        for (int i = 0; i < secretCodes.length; i++) {
		            StringBuilder decoded = new StringBuilder();

		            for (char ch : secretCodes[i].toCharArray()) {
		                if (Character.isUpperCase(ch)) {
		                    char shifted = (char) ('A' + (ch - 'A' - shift + 26) % 26);
		                    decoded.append(shifted);
		                } else if (Character.isLowerCase(ch)) {
		                    char shifted = (char) ('a' + (ch - 'a' - shift + 26) % 26);
		                    decoded.append(shifted);
		                } else {
		                    decoded.append(ch);
		                }
		            }

		            result[i] = decoded.toString();
		        }

		        return result;
		    }
		
	}

