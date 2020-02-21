package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16987_������ΰ��ġ�� {

	/*
	 * 1. ����� ���� �� ������ �ִ� ����
	 * 
	 * 2. N <=8
	 * 
	 * 3. ��Ʈ��ŷ ��Ž
	 */
	static int N, ans;
	static int[][] egg;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		egg = new int[N][2];
		ans = 0;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			egg[i][0] = Integer.parseInt(st.nextToken());
			egg[i][1] = Integer.parseInt(st.nextToken());
		}


		dfs(0);

		System.out.println(ans);
	}

	private static void dfs(int idx) {
		//�� ���� ����
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if(egg[i][0] <= 0)cnt++;
		}
		ans = Math.max(ans, cnt);
		//�� �������̸� ��
		if (idx == N) {
			return;
		}

		//��Ʈ��ŷ
		if(egg[idx][0] > 0) {
			for (int i = 0; i < N; i++) {
				if(i != idx && egg[i][0] > 0) {
					egg[idx][0] -= egg[i][1];
					egg[i][0] -= egg[idx][1];
					dfs(idx+1);
					egg[idx][0] += egg[i][1];
					egg[i][0] += egg[idx][1];
				}
			}
		}else dfs(idx+1);
	}
}
