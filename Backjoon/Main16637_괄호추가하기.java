package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main16637_��ȣ�߰��ϱ� {

	/*
	 * 1. ��ȣ�� ������ �߰��ؼ� ���� �� �ִ� �ִ�
	 * 
	 * 2. 1<= N <=19, ������ +,-,*  , ���ʺ��� ������� ���
	 * 
	 * 3. dfs -> ��Ž
	 * ��ȣ�� ģ ��� 
	 * ��ȣ�� ��ġ�� �������� ��ȣ�� ģ ���
	 * 
	 */
	
	static int ans, n;
	static int[] num;
	static char[] operation;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		num = new int[n/2+1];
		operation = new char[n/2];
		String input = br.readLine();
		for (int i = 0; i < n; i++) {
			if(i%2==0) {
				num[i/2] = input.charAt(i)-'0';
			}else {
				operation[i/2] = input.charAt(i);
			}
		}
		ans = Integer.MIN_VALUE;
		dfs(0,num[0]);
		System.out.println(ans);
	}

	private static void dfs(int idx, int sum) {
		if(idx >=n/2) {
			ans = Math.max(ans, sum);
			return;
		}
		
		//���� idx���� ��ȣ�� ħ
		int res = cal(sum,operation[idx],num[idx+1]);
		dfs(idx +1, res);
		
		//���� �����ڿ� ��ȣ�� ħ
		if(idx+1 < n/2) {
			res = cal(sum, operation[idx], cal(num[idx+1],operation[idx+1], num[idx+2]));
			dfs(idx+2, res);
		}
	}

	private static int cal(int a, char oper, int b) {
		if(oper == '+')return a + b;
		else if(oper == '-')return a - b;
		else if(oper == '*')return a * b;
		return 0;
	}
}
