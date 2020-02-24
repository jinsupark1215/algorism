package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution2806_D3_NQueen {

	/*
	 * 1.N-Queen
	 * 
	 * 2. 1<= N <=10
	 * 
	 * 3. ��Ʈ��ŷ
	 */
	static int N, ans;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			ans = 0;
			for (int i = 1; i <= N; i++) {
				int[] col = new int[N+1];
				
				col[1] = i; // 1�� i��
				
				dfs(col,1);
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	private static void dfs(int[] col, int row) {
		if(row == N) {
			ans++;
		}else {
			for (int i = 1; i <= N; i++) {
				col[row+1] = i;
				if(isPossible(col,row+1)) {
					dfs(col, row+1);
				}
			}
		}
		
	}

	private static boolean isPossible(int[] col, int row) {
		for (int i = 1; i < row; i++) {
			//������
			if(col[i] == col[row]) return false;
			//�밢��
			if(Math.abs(i-row) == Math.abs(col[i] - col[row])) return false;
		}
		return true;
	}
	
}
