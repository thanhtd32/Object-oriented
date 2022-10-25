/**
 * Author: TRAN DUY THANH (thanhtd@uel.edu.vn)
 * Student code: 20207144
 * Professor:Kil-Woong Jang (jangkw@kmou.ac.kr)
 */
package model;

public abstract class Cipher {
	/**
	 * This function use to encrypt the text with key follow the Vigenere Cipher algorithm 
	 * @param text
	 * @param key
	 * @return
	 */
	public abstract String encrypt(String originalText, String key);
	/**
	 * This function use to decrypt the text with key follow the Vigenere Cipher algorithm 
	 * @param text
	 * @param key
	 * @return
	 */
	public abstract String decrypt(String decryptedText, String key);
	/**
	 * This function use to expand key for the same length with text
	 * @param key
	 * @param text
	 * @return
	 */
	public String expandedKey(String key,String text) {
		StringBuilder sb = new StringBuilder(text.length() + key.length() - 1);
		while (sb.length() < text.length()) {
			sb.append(key);
		}		
		sb.setLength(text.length());

		String expandedKey = sb.toString();

		return expandedKey;
	}
}
