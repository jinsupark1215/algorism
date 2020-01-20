package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution1222_����1 {

	/*
	 * 1. ���� ����
	 * 
	 * 2. ���ڴ� 0~9, �����ڴ� +�ϳ���
	 * 
	 * 3. ���ϱ�
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			
		int n = Integer.parseInt(br.readLine());
		Stack<Character> stack = new Stack<>();
		String input = br.readLine();
		StringBuilder sb = new StringBuilder();
		
		int ans =0;
		for (int i = 0; i < n; i++) {
			if(input.charAt(i)-'0' >=0 && input.charAt(i)-'0' < 10) {
				sb.append(input.charAt(i));
				if(!stack.isEmpty())sb.append(stack.pop());
			}else {
				stack.add(input.charAt(i));
			}
		}
		
		
		
		
		
		System.out.println(sb.toString());
		
		
		Stack<Integer> cal = new Stack<>();
		for (int i = 0; i < n; i++) {
			if(sb.toString().charAt(i)-'0'>=0 && sb.toString().charAt(i)-'0' < 10) {
				cal.add(sb.toString().charAt(i)-'0');
			}else {
				if(sb.toString().charAt(i) == '+') {
				int num = cal.pop() + cal.pop();
				cal.add(num);
				}
			}
		}
		ans =cal.pop();
		System.out.println("#" + tc +" " + ans);
		}
	}
}
