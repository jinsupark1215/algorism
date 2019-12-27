package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1244_�ִ��� {

	/*
	 * 1. Ƚ����ŭ �مf�� �� �ִ��� ��� �ݾ�.
	 * 
	 * 2. �ٲ� Ƚ���� �� n��ŭ�̾�� ��
	 * 
	 * 3. ���� ����(�ڱ��ڽ��� ���õǸ� �ȵ�)
	 */
	static int answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char[] num = st.nextToken().toCharArray();
			int n = Integer.parseInt(st.nextToken());
			answer = 0;

			dfs(num, n, 0);

			System.out.println("#" + testcase + " " + answer);
		}
	}

	// �ٲ� �ΰ����� �����ϰ� üũ
	private static void dfs(char[] num, int n, int idx) {

		if (n == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < num.length; i++) {
				sb.append(num[i]);
			}
			answer = Math.max(answer, Integer.parseInt(sb.toString()));
			return;
		} 
		

		for (int i = idx; i < num.length; i++) {
			for (int j = i+1; j < num.length; j++) {
				if (num[i] <= num[j]) {
					swap(num,i,j);
					dfs(num, n-1, i);
					swap(num,i,j);
				}
				
			}
		}

	}

	// ���õ� �ΰ��� ��ġ�� �ٲٴ� �Լ�
	private static void swap(char[] num, int idx1, int idx2) {
		char tmp = num[idx1];
		num[idx1] = num[idx2];
		num[idx2] = tmp;

	}
}
