package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution4050_D4_������Ǵ뷮���� {

	/*
	 * 1. ������ ���� ���� �� ������?
	 * 
	 * 2. N <= 100,000
	 * 
	 * 3. ���� �� �ڿ������� ������ ��� ���
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[] map = new int[N];
			int sum = 0;
			
			StringTokenizer st= new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(st.nextToken());
				map[i] = num;
				sum += num;
			}
			Arrays.sort(map);
			
			for (int i = N-3; i >=0; i-=3) {
				sum -= map[i];
			}
			
			System.out.println("#" + tc + " " + sum);
		}
	}
}
