package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main9012_��ȣ {

	/*
	 * 1. ��ȣ�� �ùٸ��� Ʋ����
	 * 
	 * 2. 
	 * 
	 * 3. stack �̿�
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String input = br.readLine();
			Stack<Character> stack = new Stack<>();
			
			for (int j = 0; j < input.length(); j++) {
				if(input.charAt(j) == '(')stack.add('(');
				else if(input.charAt(j) == ')') {
					if(!stack.isEmpty() && stack.peek() == '(')stack.pop();
					else stack.add(')');
				}
			}
			
			if(stack.isEmpty())System.out.println("YES");
			else System.out.println("NO");
		}
	}
}
