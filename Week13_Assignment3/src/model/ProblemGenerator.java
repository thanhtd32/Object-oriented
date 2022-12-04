/**
 * Author: TRAN DUY THANH (thanhtd@uel.edu.vn)
 * Student code: 20207144
 * Professor:Kil-Woong Jang (jangkw@kmou.ac.kr)
 */
package model;

import java.util.Random;

public class ProblemGenerator {
	private int lowerBound;
	private int upperBound;
	private Random rng;
	private String problem;
	private int answer;
	private int remainder;
	private final int ADD=0;
	private final int SUB=1;
	private final int MUL=2;
	private final int DIV=3;
	public ProblemGenerator(int low,int high)
	{
		this.lowerBound=low;
		this.upperBound=high;
	}
	/**
	 * This function will randomly generate arithmetic problems, arithmetic problems 
	 * being defined as equations of addition, subtraction, multiplication, or division.
	 */
	public void nextProblem()
	{
		this.rng=new Random();
		int x1=this.lowerBound+this.rng.nextInt(this.upperBound-this.lowerBound+1);
		int x2=this.lowerBound+this.rng.nextInt(this.upperBound-this.lowerBound+1);
		int op=this.rng.nextInt(4);
		String opstring="";
		switch(op)
		{
		case ADD:
			this.answer=x1+x2;
			opstring="+";
			break;
		case SUB:
			this.answer=x1-x2;
			opstring="-";
			break;
		case MUL:
			this.answer=x1*x2;
			opstring="*";
			break;
		case DIV:
			while(x1==0 || x2==0 || x1%x2!=0)
			{
				x1=this.lowerBound+this.rng.nextInt(this.upperBound-this.lowerBound+1);
				x2=this.lowerBound+this.rng.nextInt(this.upperBound-this.lowerBound+1);
			}
			this.answer=x1/x2;
			this.remainder=x1%x2;
			opstring="/";
			break;
		}
		this.problem=x1+" "+opstring+" "+x2+" = ";	
	}
	public int getAnswer()
	{
		return this.answer;
	}
	public void setRemainder(int rem)
	{
		this.remainder=rem;
	}
	public int getRemainder()
	{
		return this.remainder;
	}
	public String getProblem()
	{
		return this.problem;
	}
}
