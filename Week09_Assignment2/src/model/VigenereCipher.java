/**
 * Author: TRAN DUY THANH (thanhtd@uel.edu.vn)
 * Student code: 20207144
 * Professor:Kil-Woong Jang (jangkw@kmou.ac.kr)
 */
package model;

public class VigenereCipher extends Cipher{

	@Override
	public String encrypt(String originalText, String key) {
		String res = "";
		for (int i = 0, j = 0; i < originalText.length(); i++)
		{
			int c = originalText.codePointAt(i);
			int k = key.codePointAt(j) - 65;
			res += (char)(c + k);
			j = ++j % key.length();
		}
		return res;
	}

	@Override
	public String decrypt(String decryptedText, String key) {
		String res = "";
        for (int i = 0, j = 0; i < decryptedText.length(); i++)
        {
            int d = decryptedText.codePointAt(i);
            int k = key.codePointAt(j) - 65;
            res += (char) (d - k);
            j = ++j % key.length();
        }
        return res;
	}
}
