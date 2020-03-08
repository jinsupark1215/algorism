package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main3663_����� {

	/*
	 * 1. �ּ� ������ Ƚ��
	 * 
	 * 2. �̸��� �ִ���� 1000
	 * 
	 * 3. ����
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			String input = br.readLine();
			int ans = 0;
	        int len = input.length();
	        int moveCount = input.length() - 1;

	        for(int i=0; i<len; i++){
	            char target = input.charAt(i);
	            if(target < 'N') 
	                ans += target - 'A';
	            else
	                ans += 91 - target;
	            //������� ���Ʒ��� �����̴°� ���亪 N�� �������� ��� ����

	            int next = i + 1;
	            while(next<len && input.charAt(next) == 'A')
	            	next++;
	            //���������� ���鼭 A�� �׳� �Ѿ�鼭 �̵��ϴ� ���
	            
	            int b = i + len - next + Math.min(i, len - next);
	            // i ��ŭ �������� �����̰�, len-right = �� ������ �����ϴ� ����, ������ ���� �� ª�� �Ÿ�
	            moveCount = Math.min(moveCount, b);
	            
	        }
	        ans += moveCount;
			System.out.println(ans);
		}
	}
}
