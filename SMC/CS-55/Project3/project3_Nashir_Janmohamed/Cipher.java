/*
 * Write a program that decrypts the intercepted message. The ASCII codes for the unencrypted message are limited to the 
 * visible ASCII characters. You only know that the key used is a number between 1 and 100. Your program should try to 
 * decode the message using all possible keys between 1 and 100. When you try the valid key, the message will make sense. 
 * For all other keys, the message will appear as gibberish.
 * :mmZ\dxZmx]Zpgy
 *       if(originalChar + key > 126) then
 *              encryptedChar = 32 + ((originalChar + key)-127)
 *       else
 * 			    encryptedChar = (originalChar + key)
 */

public class Cipher {

	public static void main(String[] args) {
		//message to crack
		String message = ":mmZ\\dxZmx]Zpgy";
		char originalChar, decryptedChar;
		
		//decrypt - brute force, iterate closed interval [1, 100]
		for (int key = 1; key <= 100; key++) {
			//declare decryptedString inside loop so that it doesn't append every iteration
			String decryptedString = "";
			
			//iterate over message
			for (int i = 0; i < message.length(); i++) {
				originalChar = message.charAt(i);
				//make sure decryptedChar is in bounds
				if (originalChar - key < 32) {
					decryptedChar = (char)((originalChar - key) + 127 - 32);
				}
				else
					decryptedChar = (char)(originalChar - key);
				//append decrypted char to string
				decryptedString += decryptedChar;
			}	
			//print contents of current iteration
			System.out.println("Iteration #" + key + ": " + decryptedString);
		}		
	}
}
