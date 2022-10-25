/**
 * Author: TRAN DUY THANH (thanhtd@uel.edu.vn)
 * Student code: 20207144
 * Professor:Kil-Woong Jang (jangkw@kmou.ac.kr)
 */
package test;

import model.Cipher;
import model.VigenereCipher;

public class TestVigenereCipher {

	public static void main(String[] args) {
			String key = "COFFEE";  
	        String message = "I drink only decaf";
	        Cipher ci=new  VigenereCipher();
	        key=ci.expandedKey(key,message);
	        String encryptedMsg = ci.encrypt(message, key);
	        System.out.println("String: " + message + "\n");
	        System.out.println("Encrypted message: " + encryptedMsg + "\n");
	        System.out.println("Decrypted message: " + ci.decrypt(encryptedMsg, key));
	}
}
