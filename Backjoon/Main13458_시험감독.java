package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13458_���谨�� {

	/*
	 * 1. �ּ��� ����� ���� ���Ͽ���
	 * 
	 * 2. N <=1000000, i<=1000000, B,C<=1000000, �Ѱ������� �ִ� 1�� �ΰ��� ������
	 * 
	 * 3. 
	 * b > c : ((i-b)/c) �������� 0�� �ƴϸ� +1;
	 * b =< c : (i/c) �������� 0�� �ƴϸ� +1;
	 * 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if(arr[i] <=b) {
				ans++;
			}else {
				ans++;
				if((arr[i]-b)%c ==0)ans += (arr[i]-b)/c;
				else ans += ((arr[i]-b)/c)+1;
			}
		}
		System.out.println(ans);
	}
}
