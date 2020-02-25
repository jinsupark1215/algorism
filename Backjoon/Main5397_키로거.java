package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main5397_Ű�ΰ� {

	/*
	 * 1. ��й�ȣ ���
	 * 
	 * 2. L<=1,000,000
	 * 
	 * 3. idx�� �ξ� �ش� idx�� �̵��ϰ� stringbulilder ���� �� ���� -> �ð��ʰ�
	 * 
	 * stack �̿�
	 * st1 ��� ��. st2 �ӽ� �����ϰ� �Ѱ��ֱ�. �ٽô���ֱ�.
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			String input = br.readLine();
			Stack<Character> st1 = new Stack<>();
			Stack<Character> st2 = new Stack<>();
			
			for (int i = 0; i < input.length(); i++) {
				if(input.charAt(i) == '<') {
					if(!st1.isEmpty())
						st2.push(st1.pop());
				}else if(input.charAt(i) == '>') {
					if(!st2.isEmpty())
						st1.push(st2.pop());
				}else if(input.charAt(i) == '-') {
					if(!st1.isEmpty())
						st1.pop();
				}else {
					st1.push(input.charAt(i));
				}
			}
			
			while(!st2.isEmpty())st1.push(st2.pop());
			
			StringBuilder sb = new StringBuilder();
			while(!st1.isEmpty())sb.append(st1.pop());
			
			System.out.println(sb.reverse());
		}
	}
}
