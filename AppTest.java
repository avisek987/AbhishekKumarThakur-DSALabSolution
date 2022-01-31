package com;

import java.util.Scanner;
import java.util.Stack;
class StackBalanceStringOpertaion{
	public static boolean checkBracketBalanced(String data) {
		Stack<Character> stack = new Stack<>();
		for(int i=0;i<data.length();i++) {
			char ch = data.charAt(i);
			if(ch=='(' || ch=='{' || ch=='[') {
				stack.push(ch);
				continue;
			}
			//ignore below code if condition is true
			if(stack.isEmpty()) {
				return false;
			}
			char c;
			switch(ch) {
			case ')': c=stack.pop();
			if(c=='{' || c=='[') {
				return false;
			}
				break;
			case '}': c=stack.pop();
			if(c=='(' || c=='[') {
				return false;
			}
				break;
			case ']': c=stack.pop();
			if(c=='{' || c=='(') {
				return false;
			}
				break;
			}
		}
		return stack.isEmpty();
	}
}
public class AppTest {

	public static void main(String[] args) {
		Scanner obj= new Scanner(System.in);
		System.out.println("Enter The String");
		String data=obj.next();
		boolean result = StackBalanceStringOpertaion.checkBracketBalanced(data);
		if(result) {
			System.out.println("The entered String has Balanced Brackets");
		}else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
		
	}

}
