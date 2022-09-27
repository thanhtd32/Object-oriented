/**
 * Author: TRAN DUY THANH (thanhtd@uel.edu.vn)
 * Student code: 20207144
 * Professor:Kil-Woong Jang (jangkw@kmou.ac.kr)
 */
package tranduythanh.com;
import java.util.Scanner;
import java.util.Random;
public class SlotMachine {

	//Define constant pieces BELL, GRAPHE, CHERRY for reuse
	static final String BELL="BELL";
	static final String GRAPE="GRAPE";
	static final String CHERRY="CHERRY";	
	/*Function calcPayoff use to calculate payoff matching with combination rules:
	 *  No. 			Combination 				Payoff
		1 		BELL 		BELL 		BELL 		10
		2 		GRAPE 		GRAPE 		GRAPE 		7
		3 		CHERRY 		CHERRY 		CHERRY 		5
		4 		CHERRY 		CHERRY 		------- 	3
		5 		CHERRY 		------- 	CHERRY 		3
		6 		------- 	CHERRY 		CHERRY 		3
		7 		CHERRY 		------- 	------- 	1
		8 		------- 	CHERRY 		------- 	1
		9 		------- 	------- 	CHERRY 		1
	 * */
	public static int calcPayoff(String slotItem1,String slotItem2,String slotItem3)
	{
		int payOff=0;

		if(slotItem1.equals(BELL) &&
		   slotItem2.equals(BELL) && 
		   slotItem3.equals(BELL))
			payOff=10;
		else if(slotItem1.equals(GRAPE) &&
				slotItem2.equals(GRAPE) && 
				slotItem3.equals(GRAPE))
			payOff=7;
		else if(slotItem1.equals(CHERRY) &&
				slotItem2.equals(CHERRY) && 
				slotItem3.equals(CHERRY))
			payOff=5;
		else if((slotItem1.equals(CHERRY) &&slotItem2.equals(CHERRY) && 
					!slotItem3.equals(CHERRY))||
				(slotItem1.equals(CHERRY) && !slotItem2.equals(CHERRY) && 
					slotItem3.equals(CHERRY))||
				(!slotItem1.equals(CHERRY) && slotItem2.equals(CHERRY) && 
					slotItem3.equals(CHERRY)))
			payOff=3;
		else if((slotItem1.equals(CHERRY) &&!slotItem2.equals(CHERRY) && 
					!slotItem3.equals(CHERRY))||
				(!slotItem1.equals(CHERRY) && slotItem2.equals(CHERRY) && 
					!slotItem3.equals(CHERRY))||
				(!slotItem1.equals(CHERRY) && !slotItem2.equals(CHERRY) && 
						slotItem3.equals(CHERRY)))
			payOff=1;
		return payOff;
	}
	/**
	 * getSlotItem function return a random slot item
	 * @return
	 */
	public static String getSlotItem()
	{
		Random rand = new Random();
		int slot=rand.nextInt(3);

		String slotItem="";
		if(slot==0)
			slotItem=BELL;
		else if(slot==1)
			slotItem=GRAPE;
		else if(slot==2)
			slotItem=CHERRY;
		return slotItem;
	}

	public static void main(String[] args)
	{
		//declarations for user input
		Scanner scan = new Scanner(System.in);  

		int M;
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("WELCOME TO SLOT MACHINE");
		System.out.println("Player can bet 1 to 4 coins, and if player enter 0 the program will stop");
		System.out.println("--------------------------------------------------------------------------");
		System.out.println("Enter initialization coins:");
		M=scan.nextInt();

		int playerBet = 0;  

		String slotItem1="", slotItem2="", slotItem3="";    
		int i=0;                       

		int M_Original=M;

		String results="";
		do
		{
			System.out.println("Enter your bet coins:");

			playerBet = scan.nextInt();

			if(playerBet ==0)
			{
				//end game because player bet 0 coin
				System.out.println("Player wants to stop game!");
				break;
			}
			if(playerBet <1 || playerBet >4)
			{
				System.out.println("Player has to enter bet coins within 1 to 4 coins");
				continue;
			}

			if(M-playerBet<0)
			{
				System.out.println("Your current coins are "+M +" can not bet "+playerBet+" coins");
				continue;
			}

			slotItem1=getSlotItem();

			slotItem2=getSlotItem();

			slotItem3=getSlotItem();

			int payOff=calcPayoff(slotItem1, slotItem2, slotItem3);
			String result="";
			if(payOff==0)
			{
				M=M-playerBet;				
			}
			else
			{
				M=M-playerBet+playerBet*payOff;
			}

			//System.out.println("No.\t\tCombinition\tPlayer Bet\tPayOff\tPayOff(Times)\tCurrent Coin");
			result=slotItem1 + "\t" + slotItem2 + "\t" + slotItem3+"\t\t"+playerBet+"\t"+payOff+"\t\t"+(payOff*playerBet)+"\t"+M;			

			i++;

			results+=i+".\t"+result+"\n";

			System.out.println(i+".\t"+result);

		}
		while(true);
		System.out.println("------------------------------Results:------------------------------");
		System.out.println("Your default coins: "+M_Original);
		System.out.println("No.\t\tCombinition\tPlayer Bet\tPayOff\tPayOff(Times)\tCurrent Coin");
		System.out.println(results);
		System.out.println("We can change 25  cents  per coin, so the current value of Player:25*"
							+M+"="+M*25 +" cents="+(M*25/100.0)+" Dollars");
	}
}
