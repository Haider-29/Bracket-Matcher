/** Programming Assignment 3
By: Syed Haider Naqvi and Japmeet Bedi

The BracketMatcher class tests if user input contains the proper
opening and corresponding closing brackets by using an ArrayStack

The main method is in the BracketMatcherApp class
*/

import java.util.Scanner;  //Used for user input

public class BracketMatcher{ //Constructor with private static variables

	private static String openings = "([{<";
	private static char[] openingBrackets = openings.toCharArray();

	private static String closings = ")]}>";
	private static char[] closingBrackets = closings.toCharArray();
	//ArrayStack object declaration
	private static ArrayStack <Character> bracketStack = new ArrayStack<Character>();



/** The isOpeningBracket() is a boolean method that checks if char c  
	contains an open bracket

	@param char
	@return boolean

*/	

	public static boolean isOpeningBracket(char c){

		for(int i = 0; i < 4; i++){
		//For loop running through the char list and comparing brackets
			if(openingBrackets[i] == c){ 

				return true;	//if matches
			}
		
		}
		
		return false; //if it does not match
	}




/** The isClosingBracket() is a boolean method that checks if char c
	contains a closing bracket

	@param char
	@return boolean

*/

	public static boolean isClosingBracket(char c){

		for(int i = 0; i < 4; i++){
		//For loop running through the char list and comparing brackets
			if(closingBrackets[i] == c){

				return true; //if matches
			}
		
		}
		
		return false;	//if it does not match
	}



/** The corresponds() method is another boolean method that checks
	if two characters contain corresponding brackets by checking
	their index placements in the list to see if they match

	@param char,char
	@return boolean

*/

	public static boolean corresponds(char open, char close){

		int openingIndex = 0; //Variables used to store index
		int closingIndex = 0; // to compare them at the end 

		for(int i = 0; i < 4; i++){		//for loop for opening bracket

			if (openingBrackets[i] == open) {

				openingIndex = i; //index is stored
				
			}
		}

		for(int i = 0; i < 4; i++){		//for loop for closing bracket

			if (closingBrackets[i] == close) {

				closingIndex = i; //index is stored
				
			}
		}

		if(closingIndex == openingIndex){ //comparison statement

			return true;
		}

		else{

			return false;
		}
	}




/** The checkBrackets() is a boolean method that checks if a user input
	string contains matching brackets using stacks

	@param String
	@return boolean

*/

	public boolean checkBrackets(String s){

		for(char c : s.toCharArray()){	
		//for loop that goes through the characters of s
			if(isOpeningBracket(c)){
				//checks for opening bracket then pushes it
				bracketStack.push(c);
			}

			else if(isClosingBracket(c)){	

				if (bracketStack.isEmpty()){
					//if it is empty, returns false
					return false;
				}

				if (!corresponds((char) bracketStack.pop(), c)){
					//if they do not correspond, returns false
					return false;
				}
			}			
		}

		return bracketStack.isEmpty();
	}
}


/** Tester class that contains the 
	main method
*/

class BracketMatcherApp{

	public static void main(String[] args) {
		//Creates new object of BracketMatcher 
		BracketMatcher brackets = new BracketMatcher();

		//get input from user 
		System.out.println("\nPlease enter the text for which you want to check the brackets in the next line:\n");
		Scanner input = new Scanner(System.in);
		String userInput = input.nextLine();

		//Tests checkBrackets method
		boolean trueOrFalse = brackets.checkBrackets(userInput);

		if (trueOrFalse) {	//Conditional statements to print out based on results

			System.out.println("\nThe brackets in this string are matched!");
		}

		else {

			System.out.println("\nThe brackets in this string are not matched");

		}
	}
}