package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution8888_���� {

	/*
	 * 1. �������� ������ ����� ���
	 * 
	 * 2. P,N,T <= 2000
	 * 
	 * 3. 1�� ǰ,0�� ��ǰ
	 * ����
	 */
	static int N,M,P;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			P = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][M];
			int[][] ans = new int[N][2];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < M; i++) {
				int score = 0;
				for (int j = 0; j < N; j++) {
					if(arr[j][i] == 0)score++;
				}
				for (int j = 0; j < N; j++) {
					if(arr[j][i] == 1) {
						ans[j][0]+=score;
						ans[j][1]++;
					}
				}
			}
			
			int answer = 0;
			// �ڽź��� ���� ����
			for (int i = 0; i < N; i++) {
				if(i != P-1 &&ans[i][0] > ans[P-1][0])answer++;
			}
			//������������ ������ ������
			for (int i = 0; i < N; i++) {
				if(i != P-1 &&ans[i][0] == ans[P-1][0] && ans[i][1] > ans[P-1][1])answer++;
			}
			//������������ ���� ���������� ������ȣ �� ������
			for (int i = 0; i < P-1; i++) {
				if(ans[i][0] == ans[P-1][0]&& ans[i][1] == ans[P-1][1])answer++;
			}
			answer +=1;
			
			System.out.println("#" + tc + " "+ans[P-1][0] + " " + answer );
		}
	}
}
