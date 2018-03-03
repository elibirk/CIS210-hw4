/*PROGRAM: Assignment 3 
 * AUTHOR: Leah Perry
 * Due Date: September 17, 2015
 * SUMMARY: Interactive slot machine program
 */

import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class hw4_perry_leah {
	public static void main(String[]args) throws IOException {
		Scanner keyboard = new Scanner(System.in);
		Scanner scanner = new Scanner(new File("inputfile.txt"));
		Scanner inputfile = scanner.useDelimiter(":|\\n");
	
		
		final double moneyEntered ; //the amount of money from the machine (AKA the file)
		double endMoney; //the amount of money the user has
		int wordChosen; //the number representing the word the user chose
		int bet; //stores bet value that the user makes
		char programLoop = 'Y';//determines whether or not to rerun the program
		String cash;//used to convert string from file to a double

		
		if (inputfile.hasNext()){//if there is something in the file
			cash = inputfile.next();//next string is cash
		moneyEntered =  Double.parseDouble(cash);//moneyEntered is cash, but a double
		}//end if
		else {
			System.out.println("Are you sure your input.txt file has a number?\n" + 
		"Setting moneyEntered as 10.00 for a default value.");
			moneyEntered = 10.00;//default value in case the file is being dumb
		}
		endMoney = moneyEntered;//initializes endMoney to moneyEntered
		
	while (programLoop == 'Y' || programLoop == 'y') {//while user wants to run
		
		System.out.println("Please enter a number to choose a word from this list:" +
		"\n1. Cherry\n2. Orange\n3. Apple\n4. Peach\n5. Melon\n6. Pear");//word prompt 
		wordChosen = keyboard.nextInt(); //scans in wordChosen
		while(wordChosen > 6 || wordChosen < 1) {//while chosen # isn't 1-6
			System.out.println("I'm sorry, that number does not correspond with this list. " +
		    "Please choose a number from this list: \n1. Cherry\n2. Orange\n3. Apple\n" + 
	    	"4. Peach\n5. Melon\n6. Pear");
			wordChosen = keyboard.nextInt(); //scans in wordChosen
		}
		
		System.out.println("You have $" + endMoney + " remaining to bet. Enter a number to" +
		" bet. Enter 1 for $10, 2 for $20, etc.");//bet prompt
		bet = keyboard.nextInt();//scans in bet
		while (bet * 10 > endMoney || bet * 10 < 1){//while bet is out of range
			System.out.println("I'm sorry, that amount is either less than the minimum $10 or " +
		"more money than you have available. \nYou have $" + endMoney + " remaining to bet. " +
		"\nEnter a number to bet. Enter 1 for $10, 2 for $20, etc.");//bet reprompt
			bet = keyboard.nextInt();//scans in bet
		}
		
		endMoney = endMoney - bet * 10;//subtract bet from end money
		
		endMoney = SlotFunction(endMoney, wordChosen, bet);//calculates slot action results
		
		System.out.println("Do you want to bet again? Enter Y or y for yes or N or n for no.");
		programLoop = keyboard.next().charAt(0); //scans in choice
		
		while (programLoop != 'Y' && programLoop != 'y' && programLoop != 'N' && programLoop != 'n')
		{
		System.out.println("Sorry that is an invalid choice. Enter 'Y' or 'y' for yes, or 'N' "+
		"or 'n' for no.");
		programLoop = keyboard.next().charAt(0); //scans in choice
		}//end user choice loop

		
	}//end program loop

	if (moneyEntered < endMoney) {//if money gained, print how much
	System.out.println("You currently have $" + endMoney + "\n You've won $" + (endMoney -
			moneyEntered));
	}//end if
	else{//if money lost, print how much
		System.out.println("You currently have $" + endMoney + "\n You've lost $" + (moneyEntered -
				endMoney));
	}//end else
	
		scanner.close();
		inputfile.close();
		keyboard.close();//keyboard.close(); //closes keyboard Scanner object to prevent memory leaks
	}	




	
	
public static double SlotFunction(double endMoney, int wordChosen, double bet){
	/* FUNCTION: SlotFunction
	 * PURPOSE: Calculates random slot words and winnings results
	 * @Parameter	endMoney	final money to return
	 * @Parameter	wordChosen	user-chosen slot word
	 * @Parameter	bet			amount of money user bet
	 * @Parameter	winnings	keeps track of how often the user's choice has been chosen
	 * @Parameter	loop		keeps track of how many slot words have been chosen
	 * @Parameter	random		calculates random number to turn into random slot word
	 */

	double winnings = 0;
for(int loop = 1; loop < 4; loop++){//loops 3 times
	Random r = new Random(); //gets new random number
	int random = r.nextInt(6) + 1; //sets random as a random int 1-6

	switch (random) {//checks the value of random
	case 1:
		System.out.println(loop + ". Cherry");//if one word is Cherry
		if(wordChosen == 1){
			winnings++;//if success, add one to winnings
		}
		break;
	case 2:
		System.out.println(loop + ". Orange");//if two word is Orange
		if(wordChosen == 2){
			winnings++;//if success, add one to winnings
		}
		break;
	case 3:
		System.out.println(loop + ". Apple");//if three word is Apple
		if(wordChosen == 3){
			winnings++;//if success, add one to winnings
		}
		break;
	case 4:
		System.out.println(loop + ". Peach");//if four word is Peach
		if(wordChosen == 4){
			winnings++;//if success, add one to winnings
		}
		break;
	case 5: 
		System.out.println(loop + ". Melon");//if five word is Melon
		if(wordChosen == 5){
			winnings++;//if success, add one to winnings
		}
		break;
	case 6:
		System.out.println(loop + ". Pear");//if six word is Pear
		if(wordChosen == 6){
			winnings++;//if success, add one to winnings
		}
		break;
	}//end switch case
}//end for loop

endMoney = endMoney + winnings * bet * 10;//calculates end money after winnings
System.out.println("You were right " + winnings + " times! You won $" + (winnings * bet * 10));

	return endMoney;
}//end slot function





public static char FunctionLoop(char programLoop){
	/* FUNCTION: FunctionLoop
	 * PURPOSE: Determines whether or not a user wants to repeat a function
	 * @Parameter	programLoop		holds user input
	 */
	
	Scanner keyboarda = new Scanner(System.in); 
	while (programLoop != 'Y' && programLoop != 'y' && programLoop != 'N' && programLoop != 'n')
	{
	System.out.println("Sorry that is an invalid choice. Enter 'Y' or 'y' for yes, or 'N' "+
	"or 'n' for no.");
	programLoop = keyboarda.nextLine().charAt(0); //scans in choice
	}//end user choice loop
	keyboarda.close();
	
	return programLoop;	
}//end FunctionLoop

}//end class