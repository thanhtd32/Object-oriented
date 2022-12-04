/**
 * Author: TRAN DUY THANH (thanhtd@uel.edu.vn)
 * Student code: 20207144
 * Professor:Kil-Woong Jang (jangkw@kmou.ac.kr)
 */
package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

import model.ProblemGenerator;

public class TeachArithmeticFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	public final int DEFAULT_LOW=0;
	public final int DEFAULT_HIGH=99;
	private final int FRAME_WIDTH=500;
	private final int FRAME_HEIGHT=500;
	private final int FIELD_WIDTH=120;
	private final int FIELD_HEIGHT=40;
	private final String OK="OK";
	private final String NEXT="NEXT";
	private JLabel problem;
	private JLabel rlabel;
	private JTextField answer;
	private JButton ok;
	private JButton next;
	private JLabel imageResult;
	
	private ProblemGenerator problemGenerator;
	
	public TeachArithmeticFrame(String title) 
	{
		setTitle(title);
		Toolkit kit=Toolkit.getDefaultToolkit();
		setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		Image icon=kit.getImage("images/ic_icon.png");
		setIconImage(icon);
		addComponents(getContentPane());
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
	}
	/**
	 * This function use to add components
	 * @param contentPane
	 */
	private void addComponents(Container contentPane)
	{
		JPanel pnMain=new JPanel();
		contentPane.add(pnMain,BorderLayout.CENTER);
		pnMain.setLayout(new BorderLayout());
		
		pnMain.add(createBanner(),BorderLayout.NORTH);
		pnMain.add(createLeftPanel(),BorderLayout.WEST);
		pnMain.add(createSouthPanel(),BorderLayout.SOUTH);
		pnMain.add(createArithmeticPanel(),BorderLayout.CENTER);
		
		problemGenerator=new ProblemGenerator(DEFAULT_LOW, DEFAULT_HIGH);
		problemGenerator.nextProblem();
		
		problem.setText(problemGenerator.getProblem());
		
		ok.addActionListener(this);
		next.addActionListener(this);
		answer.addActionListener(this);
	}
	/**
	 * This function use to crate banner and title
	 * @return
	 */
	private JPanel createBanner()
	{
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout());
		JLabel lblTitle=new JLabel("Children  Arithmetic");
		Font font=new Font("BroadwayEngraved BT", Font.BOLD, 20);
		lblTitle.setFont(font);
		lblTitle.setForeground(Color.BLUE);
		panel.add(lblTitle,BorderLayout.WEST);
		JLabel lblBanner=new JLabel();
		lblBanner.setIcon(new ImageIcon("images/ic_banner.png"));
		panel.add(lblBanner,BorderLayout.CENTER);
		return panel;
	}
	/**
	 * This function use to create left panel
	 * @return
	 */
	private JPanel createLeftPanel()
	{
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout());
		JLabel lblBanner=new JLabel();
		lblBanner.setIcon(new ImageIcon("images/ic_left.png"));
		panel.add(lblBanner,BorderLayout.CENTER);
		return panel;
	}
	/**
	 * This function use to create footer information
	 * @return
	 */
	private JPanel createSouthPanel()
	{
		JPanel panel=new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		JLabel lblProfessor=new JLabel("Advisor: Prof. Kil-Woong Jang");
		lblProfessor.setForeground(Color.BLUE);
		JLabel lblStudent=new JLabel("Student: Tran Duy Thanh");
		lblStudent.setForeground(Color.MAGENTA);
		panel.add(lblProfessor);
		panel.add(Box.createHorizontalStrut(5));
		panel.add(lblStudent);
		return panel;
	}
	/**
	 * This function use to create Arithmetic Panel
	 * @return
	 */
	private JPanel createArithmeticPanel()
	{
		JPanel panel=new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel pnNorth=new JPanel();
		pnNorth.setLayout(new BorderLayout());
		pnNorth.setPreferredSize(new Dimension(0, 30));
		Font font=new Font("Bauhaus 93", Font.BOLD, 18);
		panel.add(pnNorth,BorderLayout.NORTH);
		
		JPanel pnCenter=new JPanel();
		pnCenter.setLayout(new BorderLayout());
		TitledBorder border=new TitledBorder(
				BorderFactory.createSoftBevelBorder(BevelBorder.RAISED, Color.GREEN, Color.ORANGE, 
						Color.BLUE,Color.PINK),
				"Baby please answer the question!",
				TitledBorder.CENTER, TitledBorder.CENTER);
		border.setTitleFont(font);
		border.setTitleColor(Color.MAGENTA);
		pnCenter.setBorder(border);
		
		panel.add(pnCenter,BorderLayout.CENTER);
		
		JPanel pnProblem=new JPanel();
		problem=new JLabel("8+7=");
		problem.setForeground(Color.BLUE);
		font=new Font("BroadwayEngraved BT", Font.BOLD, 25);
		problem.setFont(font);
		pnProblem.add(problem);
		answer=new JTextField(3);
		answer.setPreferredSize(new Dimension(FIELD_WIDTH, FIELD_HEIGHT));
		answer.setFont(font);
		answer.setBackground(Color.YELLOW);
		pnProblem.add(answer);
		pnCenter.add(pnProblem,BorderLayout.NORTH);
		
		JPanel pnResponse=new JPanel();
		Font fontButton=new Font("BroadwayEngraved BT", Font.BOLD, 15);
		ok=new JButton(OK);
		ok.setFont(fontButton);
		ok.setIcon(new ImageIcon("images/ic_ok.png"));
		pnResponse.add(ok);
		next=new JButton(NEXT);
		next.setFont(fontButton);
		next.setIcon(new ImageIcon("images/ic_next.png"));
		pnResponse.add(Box.createHorizontalStrut(10));
		pnResponse.add(next);
		pnCenter.add(pnResponse,BorderLayout.SOUTH);
		
		JPanel pnResult=new JPanel();
		pnResult.setLayout(new BorderLayout());
		JPanel pnImageResult=new JPanel();
		pnImageResult.setLayout(new FlowLayout(FlowLayout.CENTER));
		imageResult=new JLabel();
		imageResult.setIcon(new ImageIcon("images/ic_result.png"));
		pnImageResult.add(imageResult);
		pnResult.add(pnImageResult,BorderLayout.CENTER);
		pnCenter.add(pnResult,BorderLayout.CENTER);
		
		JPanel pnTextResult=new JPanel();
		pnTextResult.setLayout(new FlowLayout(FlowLayout.CENTER));
		rlabel=new JLabel("How many?");
		rlabel.setForeground(Color.RED);
		rlabel.setFont(font);
		pnTextResult.add(rlabel);
		pnResult.add(pnTextResult,BorderLayout.SOUTH);
		
		return panel;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(arg0.getSource().equals(ok))
		{
			checkTheSolution();
		}
		else if(arg0.getSource().equals(next))
		{
			showNextProblem();
		}
		else if(arg0.getSource().equals(answer))
		{
			checkTheSolution();
		}
	}
	/**
	 * This function use to show next problem
	 */
	private void showNextProblem() {
		problemGenerator.nextProblem();		
		imageResult.setIcon(new ImageIcon("images/ic_result.png"));
		answer.setText("");
		problem.setText(problemGenerator.getProblem());
		rlabel.setText("How many?");		
		answer.selectAll();
		answer.requestFocus();
	}
	/**
	 * This function use to check the solution is correct or not
	 */
	private void checkTheSolution() {
		try
		{
			double r=Double.parseDouble(answer.getText().toString());
			if(problemGenerator.getAnswer()==r)
			{
				imageResult.setIcon(new ImageIcon("images/ic_correct.png"));
				rlabel.setText("Correct!");				
			}
			else
			{
				imageResult.setIcon(new ImageIcon("images/ic_uncorrect.png"));
				rlabel.setText("Uncorrect!");
			}
		}
		catch(Exception ex){
			JOptionPane.showMessageDialog(null, "Please input valid answer", "Error inpout", JOptionPane.ERROR_MESSAGE);
			answer.selectAll();
		}
	}
}
