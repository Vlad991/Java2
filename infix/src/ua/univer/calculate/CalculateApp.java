package ua.univer.calculate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import ua.univer.infix.InToPost;
import ua.univer.postfix.ParsePost;

public class CalculateApp {
	
	public static void main(String[] args) throws IOException {
		String input, postfix;
		int output;
		
		while (true) {
			System.out.print("Enter algebraic expression: ");
			System.out.flush();
			input = getString();
			if(input.equals("")) break;
			
			InToPost theTrans = new InToPost(input);
			postfix = theTrans.doTrans();
			System.out.println("Postfix is " + postfix + '\n');
			
			ParsePost aParser =new ParsePost(postfix);
			output = aParser.doParse();
			System.out.println("Evaluates to " + output);
		}
	}
	
	public static String getString() throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
	    BufferedReader br = new BufferedReader(isr);
	    String s = br.readLine();
	    return s;
	}
}
