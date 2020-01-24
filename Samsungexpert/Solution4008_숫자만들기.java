package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4008_���ڸ���� {

	/*
	 * 1. ����� �ִ� �ִ� ���ڿ��� �ּҼ��ڸ� �� ���� ���
	 * 
	 * 2. 3<= N <= 12, ���ڴ� 1~9, �켱���� ��� ���Ѱ� ���
	 * 
	 * 3. ��Ž
	 * �Ẹ�� �ȽẸ��
	 */
	static int n, max, min;
	static int[] cnt;
	static int[] num;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			n = Integer.parseInt(br.readLine());
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			cnt = new int[4];
			num = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				cnt[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				num[i] = Integer.parseInt(st.nextToken());
			}
			dfs(1,num[0]);
			
			
			System.out.println("#" + tc + " " + (max-min));
		}
	}
	private static void dfs(int idx, int sum) {
		if(idx >= n) {
			min = Math.min(min, sum);
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			if (cnt[i] > 0) {
				cnt[i]--;
				if (i == 0) {
					dfs(idx + 1, sum + num[idx]);
				} else if (i == 1) {
					dfs(idx + 1, sum - num[idx]);
				} else if (i == 2) {
					dfs(idx + 1, sum * num[idx]);
				} else if (i == 3) {
					dfs(idx + 1, sum / num[idx]);
				}
				cnt[i]++;
			}
		}
	}
}
