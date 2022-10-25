/**
 * Author: TRAN DUY THANH (thanhtd@uel.edu.vn)
 * Student code: 20207144
 * Professor:Kil-Woong Jang (jangkw@kmou.ac.kr)
 */
package test;

import ui.VigenereCipherUI;

public class TestVigenereCipherUI {

	public static void main(String[] args) {
		VigenereCipherUI vcui=new VigenereCipherUI("KMOU-Object Oriented Theory");
		vcui.addControls();
		vcui.addEvents();
		vcui.showUI();
	}
}
