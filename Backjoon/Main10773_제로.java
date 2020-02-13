package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main10773_���� {

	/*
	 * 1. ���������� ���� �� �� �� ��
	 * 
	 * 2. K <= 100,000
	 * 
	 * 3. stack �̿�
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int K = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			if(num == 0)stack.pop();
			else stack.add(num);
		}
		int sum = 0;
		int size = stack.size();
		for (int i = 0; i < size; i++) {
			sum += stack.pop();
		}
		System.out.println(sum);
	}
}
