/**
 * Author: TRAN DUY THANH (thanhtd@uel.edu.vn)
 * Student code: 20207144
 * Professor:Kil-Woong Jang (jangkw@kmou.ac.kr)
 */
package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.*;
import model.Cipher;
import model.VigenereCipher;
import model.VigenereCipherAdaptation;

public class VigenereCipherUI  extends JFrame{

	JLabel lblMessage,lblResult;
	JTextField txtMessage,txtResult;
	JTextField txtKey, txtKeyExpand;
	JRadioButton radEncrypt,radDecrypt;
	JRadioButton radCipherAdaption, radCipherAll;
	JButton btnProcess,btnClear;
	JButton btnExit;
	String message="Original Message:";
	String encryptedMessage="Encrypted Message:";
	//Declare cipher object
	Cipher cipher;
	/**
	 * The constructor of VigenereCipherUI with title
	 * @param title
	 */
	public VigenereCipherUI(String title){
		setTitle(title);
	}
	/**
	 * This function use to design the graphic user interface
	 */
	public void addControls()
	{
		//define main frame
		Container con=getContentPane();
		JPanel pnMain=new JPanel();
		con.add(pnMain);
		pnMain.setLayout(new BorderLayout());
		JPanel pnNorth=new JPanel();
		pnNorth.setLayout(new BoxLayout(pnNorth, BoxLayout.Y_AXIS));
		pnMain.add(pnNorth,BorderLayout.NORTH);
		//create title
		JPanel pnTitle=new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lblTitle=new JLabel("Assignment 2- Vigenere Cipher Technique");
		Font fontTitle=new Font("tahoma", Font.BOLD, 15);
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(fontTitle);
		pnTitle.add(lblTitle);
		pnNorth.add(pnTitle);
		//create supervisor
		JPanel pnSupervisor=new JPanel();
		pnSupervisor.setLayout(new FlowLayout());
		JLabel lblSupervisorTitle=new JLabel("Supervisor:");
		JLabel lblSupervisorName=new JLabel("Prof. Kil-Woong Jang");
		lblSupervisorName.setForeground(Color.RED);
		pnSupervisor.add(lblSupervisorTitle);
		pnSupervisor.add(lblSupervisorName);
		pnNorth.add(pnSupervisor);
		//create student
		JPanel pnStudent=new JPanel();
		pnSupervisor.setLayout(new FlowLayout());
		JLabel lblStudentTitle=new JLabel("Student:");
		JLabel lblStudentName=new JLabel("TRAN DUY THANH (20207144)");
		lblStudentName.setForeground(Color.BLUE);
		pnStudent.add(lblStudentTitle);
		pnStudent.add(lblStudentName);
		pnNorth.add(pnStudent);
		JPanel pnCenter=new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter,BoxLayout.Y_AXIS));
		pnMain.add(pnCenter,BorderLayout.CENTER);
		JPanel pnInput=new JPanel();
		pnInput.setLayout(new BoxLayout(pnInput, BoxLayout.Y_AXIS));
		pnCenter.add(pnInput,BorderLayout.CENTER);
		//create encryption and decryption
		JPanel pnEncryptDecrypt=new JPanel();
		pnEncryptDecrypt.setLayout(new FlowLayout());
		radEncrypt=new JRadioButton("Encryption");
		pnEncryptDecrypt.add(radEncrypt);
		radDecrypt=new JRadioButton("Decrytion");
		pnEncryptDecrypt.add(radDecrypt);
		pnInput.add(pnEncryptDecrypt);
		ButtonGroup bgEncrypt=new ButtonGroup();
		bgEncrypt.add(radEncrypt);
		bgEncrypt.add(radDecrypt);
		//create message
		JPanel pnMessage=new JPanel();
		pnMessage.setLayout(new FlowLayout());
		lblMessage=new JLabel(message);
		txtMessage=new JTextField(20);
		pnMessage.add(lblMessage);
		pnMessage.add(txtMessage);
		pnInput.add(pnMessage);
		//create key
		JPanel pnKey=new JPanel();
		pnKey.setLayout(new FlowLayout());
		JLabel lblKey=new JLabel("Key:");
		txtKey=new JTextField(20);
		pnKey.add(lblKey);
		pnKey.add(txtKey);
		pnInput.add(pnKey);
		foreUpercaseTextField(txtKey);
		//create Cipher rules
		JPanel pnAlgorithm=new JPanel();
		pnAlgorithm.setLayout(new BoxLayout(pnAlgorithm,BoxLayout.Y_AXIS));
		radCipherAdaption=new JRadioButton("Cipher with Assignment Rules");
		pnAlgorithm.add(radCipherAdaption);
		radCipherAll=new JRadioButton("Cipher with all unicode characters");
		pnAlgorithm.add(radCipherAll);
		pnInput.add(pnAlgorithm);
		ButtonGroup bgCipher=new ButtonGroup();
		bgCipher.add(radCipherAdaption);
		bgCipher.add(radCipherAll);
		//create button process and clear
		JPanel pnProcess=new JPanel();
		pnProcess.setLayout(new FlowLayout());
		btnProcess=new JButton("Run Cipher");
		btnProcess.setIcon(new ImageIcon("images/ic_process.png"));
		pnProcess.add(btnProcess);
		btnClear=new JButton("Clear");
		pnProcess.add(btnClear);
		btnClear.setIcon(new  ImageIcon("images/ic_clear.png"));
		pnCenter.add(pnProcess,BorderLayout.SOUTH);
		//create output frame
		JPanel pnOutput=new JPanel();
		pnOutput.setLayout(new BoxLayout(pnOutput, BoxLayout.Y_AXIS));
		pnCenter.add(pnOutput,BorderLayout.SOUTH);
		JPanel pnKeyExpanded=new JPanel();
		pnKeyExpanded.setLayout(new FlowLayout());
		pnOutput.add(pnKeyExpanded);
		//create title for input frame
		TitledBorder inputBorder=BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Input Information:");
		pnInput.setBorder(inputBorder);
		//create key expanded
		JLabel lblKeyExpanded=new JLabel("Key Expanded:");
		txtKeyExpand=new JTextField(20);
		pnKeyExpanded.add(lblKeyExpanded);
		pnKeyExpanded.add(txtKeyExpand);
		//create result frame
		JPanel pnResult=new JPanel();
		pnResult.setLayout(new FlowLayout());
		pnOutput.add(pnResult);

		lblResult=new JLabel(encryptedMessage);
		txtResult=new JTextField(20);
		pnResult.add(lblResult);
		pnResult.add(txtResult);
		//create title for result
		TitledBorder resultBorder=BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.RED), "Result Information:");
		pnOutput.setBorder(resultBorder);
		//create exit button
		JPanel pnSouth=new JPanel();
		pnSouth.setLayout(new FlowLayout());
		pnMain.add(pnSouth,BorderLayout.SOUTH);
		btnExit=new JButton("Exit program");
		btnExit.setIcon(new ImageIcon("images/ic_close.png"));
		pnSouth.add(btnExit);
		lblMessage.setPreferredSize( lblResult.getPreferredSize());
		lblKey.setPreferredSize( lblResult.getPreferredSize());
		lblKeyExpanded.setPreferredSize( lblResult.getPreferredSize());
		radEncrypt.setSelected(true);
		radCipherAdaption.setSelected(true);
		txtMessage.setText("I drink only decaf");
		txtKey.setText("COFFEE");
	}
	/**
	 * This function use to process the event for the controls
	 */
	public void addEvents()
	{
		radEncrypt.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(radEncrypt.isSelected())
				{
					lblMessage.setText(message);
					lblResult.setText(encryptedMessage);
				}
				else
				{
					lblMessage.setText(encryptedMessage);
					lblResult.setText(message);
				}
			}
		});
		radDecrypt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(radDecrypt.isSelected()){
					lblMessage.setText(encryptedMessage);
					lblResult.setText(message);
				}
				else{
					lblMessage.setText(message);
					lblResult.setText(encryptedMessage);
				}
			}
		});
		
		btnProcess.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(radCipherAdaption.isSelected())
					cipher=new VigenereCipherAdaptation();
				else
					cipher=new VigenereCipher();
				if(radEncrypt.isSelected()){
					processEncrypt();
				}
				else{
					processDecrypt();
				}
			}
		});
		btnExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				processExit();
			}
		});
		btnClear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				processClear();
			}
		});
	}
	/**
	 * This function use to clear old data
	 */
	protected void processClear() {
		txtMessage.setText("");
		txtKey.setText("");
		txtKeyExpand.setText("");
		txtResult.setText("");
		txtMessage.requestFocus();
	}
	/**
	 * this function use to confirm the exit from the software
	 */
	private void processExit() {
		int ret=JOptionPane.showConfirmDialog(null, "Are you sure you want to exist?","Exit",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(ret==JOptionPane.YES_OPTION)
			System.exit(0);
	}
	/**
	 * processDecrypt method use to decrypt
	 */
	protected void processDecrypt() {
		String message=txtMessage.getText();
		String key=txtKey.getText();
		String keyExpanded=cipher.expandedKey(key, message);
		txtKeyExpand.setText(keyExpanded);
		txtResult.setText(cipher.decrypt(message, keyExpanded));
	}
	/**
	 * processEncrypt method use to encrypt
	 */
	protected void processEncrypt() {
		String message=txtMessage.getText();
		String key=txtKey.getText();
		String keyExpanded=cipher.expandedKey(key, message);
		txtKeyExpand.setText(keyExpanded);
		txtResult.setText(cipher.encrypt(message, keyExpanded));
	}
	/**
	 * foreUpercaseTextField use to fore Uper case for the Text field
	 * @param textfield
	 */
	public void foreUpercaseTextField(JTextField textfield)
	{
		AbstractDocument document = (AbstractDocument) textfield
				.getDocument();
		document.setDocumentFilter(new DocumentFilter() {
			@Override
			public void insertString(FilterBypass fb, int offset,
					String string, AttributeSet attr)
							throws BadLocationException {
				super.insertString(fb, offset, string.toUpperCase(), attr);
			}
			@Override
			public void replace(FilterBypass fb, int offset, int length,
					String text, AttributeSet attrs)
							throws BadLocationException {
				super.insertString(fb, offset, text.toUpperCase(), attrs);
			}
		});
	}
	/**
	 * This function use to show the graphic user interface
	 */
	public void showUI()
	{
		setSize(400, 500);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
