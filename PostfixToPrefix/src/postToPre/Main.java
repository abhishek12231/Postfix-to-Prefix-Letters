package postToPre;

// question -
// Write a prefix stack and show how it works (in main). 

import java.util.Stack;

public class Main {

	public static void main(String[] args) { // main method this is where all the code runs
		// TODO Auto-generated method stub
		
		 String post = "ab*c+dfg-*/"; // postfix value that we are going to pass in
	     
		 System.out.println("Postfix Expression: " + post); // print postfix value
		 
		 String pre = postfixToPrefix(post); // passed in the value to the mehtod
	     System.out.println("Prefix Expression: " + pre);//now print the value after it was passed to method
	     

	}
		
	public static String postfixToPrefix(String post) { //postfixToPrefix method
        
		Stack<String> myStack = new Stack<>(); // stack type string

		
        for (char ch : post.toCharArray()) { // so we are iterating through each character in the postfix expression
            if (isLetter(ch)) {
                myStack.push(Character.toString(ch)); // so if the character is a letter push it onto the stack
            } else if (isSign(ch)) { // else if its a sign like + - / etc pop two operands apply it and push the result back onto the stack
                String op2 = myStack.pop(); // pop
                String op1 = myStack.pop(); // pop

                String result = ch + op1 + op2; 
                myStack.push(result);
            }
        }
        //ch this is a character representing the postfix expression
        // op1 this is the first operand popped from the stack
        //op2 this is the second operand popped from the stack
        //So the line is essentially creating a new string result by concatenating these three values 
        //for example if ch is + and op1 and op2 are A and B result would be the string +AB

        return myStack.pop(); //final result is obtained from the stack in this line
    }
	
	private static boolean isLetter(char ch) { //so this is the method to check if a character is a letter operand
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }

    private static boolean isSign(char ch) { // so this method to check if a character is an operator
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }


}
