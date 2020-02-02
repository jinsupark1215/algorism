package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution2115_����ä�� {

	/*
	 * 1. ���� ä������ �� �ִ� �̵�
	 * 
	 * 2. M <=N <=10, C�� 10~30
	 * 
	 * 3.
	 * 3-1 ������ �����ϰ�
	 * 3-2 ������ ���뿡�� ���� �� �ִ� �ִ� ����
	 */
	static int N,M,C,ans;
	static int[][] map;
	static boolean[][] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			visit = new boolean[N][N];
			ans = 0;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ArrayList<Integer> list = new ArrayList<>();
			dfs(0,0,0,0,list);
			System.out.println("#" + tc + " " + ans);
		}
	}
	private static void dfs(int r, int c, int cnt, int sum, ArrayList<Integer> list) {
		if(r >= N)return;
		
		ArrayList<Integer> tmp = new ArrayList<>(list);
		tmp.add(r);
		tmp.add(c);
		
		if (cnt < 2) {
			// ���ð���
			if (c + M - 1 < N) {
				int tmpsum = sum+benefit(r,c);
				if (tmpsum > ans) {
					ans = tmpsum;
				}
                //col�� N���� Ŀ���� ���� low�� �Ѿ���Ѵ�.
				dfs((r + (c + M) / N), ((c + M) % N), cnt + 1, sum + benefit(r, c), tmp);
			}

			// �������� ����
			dfs(r + (c + 1) / N, (c + 1) % N, cnt, sum, tmp);
		}
	}

	//r,c���� M���� ������ �����Ͽ� ���� �� �ִ� �ִ��� ������ �����Ѵ�.
	static int benefit(int r, int c) {

		//M���� �����߿� ���� �� �� �ִ� ����� ���� 2�� M���̴�. ��Ʈ����ũ ����
		int num = 1 << M;
		int max = 0;
		
		//M���� ���� �߿� ��� ���ÿ� ���ؼ�
		for (int i = 0; i < num; i++) {
			int bit = i;
			int sum = 0;
			int benefit = 0;
			for (int j = 0; j < M; j++, bit >>= 1) {
				//���õ� ������ �հ� ���� ���� ���Ѵ�.
				if ((bit & 1) == 1) {
					sum += map[r][c + j];
					benefit += (map[r][c + j] * map[r][c + j]);
				}
			}
			//���õ� ���� ���� K���� ������ �ʰ� ������ �ִ��� �����Ѵ�
			if (sum <= C && benefit >= max)
				max = benefit;
		}
		return max;
	}
}
