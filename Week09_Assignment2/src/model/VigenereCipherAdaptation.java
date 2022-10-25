/**
 * Author: TRAN DUY THANH (thanhtd@uel.edu.vn)
 * Student code: 20207144
 * Professor:Kil-Woong Jang (jangkw@kmou.ac.kr)
 */
package model;

public class VigenereCipherAdaptation extends Cipher {

	@Override
	public String encrypt(String originalText, String key) {
		 String res = "";
	        for (int i = 0, j = 0; i < originalText.length(); i++)
	        {
	            int c = originalText.codePointAt(i);
	            int k = key.codePointAt(j) - 65;
	            if (c == 32) 
	            {
	                res += "-";
	            } else if (c >= 65 && c <= 90){
	                if ((c + k) > 90 ){
	                    res += (char)(c + k - 26);
	                }else{
	                    res += (char)(c + k);
	                }
	            } else if (c >= 97 && c <= 122){
	                if ((c + k) > 122 ){
	                    res += (char)(c + k - 26);
	                }else{
	                    res += (char)(c + k);
	                }
	            } else
	            {
	                res += (char)(c);
	            }
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
            if (d == 45)
            {
                res += " ";
            } else if (d >= 65 && d <= 90){
                if ((d-k) < 65){
                    res += (char)(d - k + 26);
                }else {
                    res += (char)(d - k);
                }
            } else if (d >= 97 && d <= 122)
            {
                if ((d-k) < 97){
                    res += (char)(d - k + 26);
                }else {
                    res += (char)(d - k);
                }
            } else
            {
                res += (char)(d);
            }
            j = ++j % key.length();
        }
        return res;
	}

}
