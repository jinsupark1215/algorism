package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution1216_ȸ��2 {

	/*
	 * 1. ȸ���� ã���� �� ���� �� ������ ȸ�� ����ã��
	 * 
	 * 2. ���μ��� ���� ȸ���� ��, �ִ���� 
	 * 
	 * 3. dfs �� üũ �� ���� �� ȸ�� ����ã��
	 */
	static int N, ans;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	static char[][] map;
	static StringBuilder sb;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		for (int testcase = 1; testcase <= 10; testcase++) {
			N = Integer.parseInt(br.readLine());
			map = new char[100][100];
			for (int i = 0; i < 100; i++) {
				String input = br.readLine();
				for (int j = 0; j < 100; j++) {
					map[i][j] = input.charAt(j);
				}
			}
			ans = 0;
			
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					for (int k = 0; k < 4; k++) {
						sb = new StringBuilder();
						dfs(i, j, k);
					}
				}
			}
			System.out.println("#" + testcase + " " + ans);
		}
	}
	private static void dfs(int r, int c, int dir) {
		sb.append(map[r][c]);
			String sb1 = sb.toString();
			String sb2 = sb.reverse().toString();
			
			if(sb1.equals(sb2)) {
				ans = Math.max(ans, sb.length());
			}
			sb.reverse();
		int nr = r + pos[dir][0];
		int nc = c + pos[dir][1];
		if(nr >=0 && nc>=0 && nr<100 && nc <100) {
			dfs(nr,nc,dir);
		}
	}
}
