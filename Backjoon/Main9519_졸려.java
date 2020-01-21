package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main9519_���� {

	/*
	 * 1. X�� �����̱� ���� ���ڸ� ã�ƶ�
	 * 
	 * 2. Ȧ���� ��� �ڿ����ڰ� �� ����, X�� 10������
	 * 
	 * 3. X����ŭ stingbulider�� 
	 * ¦��
	 * Ȧ����° ���ϰ� �ڿ������� ¦����°���Ѵ�
	 * Ȧ��
	 * Ȧ����° ���ϰ� ������ ����������
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int x = Integer.parseInt(br.readLine());
		String input = br.readLine();
		ArrayList<String> ans= new ArrayList<>();
		ans.add(input);
		while(true) {
			StringBuilder sb = new StringBuilder();
			
			int length = input.length();
			if(length%2 ==0) {
				for (int i = 0; i < length; i+=2) {
					sb.append(input.charAt(i));
				}
				for (int i = length-1; i > 0; i-=2) {
					sb.append(input.charAt(i));
				}
			}else {
				for (int i = 0; i < length; i+=2) {
					sb.append(input.charAt(i));
				}
				for (int i = length-2; i > 0; i-=2) {
					sb.append(input.charAt(i));
				}
			}
			input = sb.toString();
			if(ans.get(0).equals(input))break;
			ans.add(input);
		}
		System.out.println(ans.get(x%ans.size()));
	}
}
