package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution1767_���μ��������ϱ� {

	/*
	 * 1.�ִ��� ���� core�� �������� �� �� ���ᰪ�� �ּ�
	 * 
	 * 2. 7<= N <=12
	 * 
	 * 3.
	 * 3-1. ���õ� �ھ���� ������ dfs, ���ٰ� ������ �ٸ����⵵ ����
	 */
	static int N, corecnt, ans;
	static ArrayList<Core> list;
	static int[][] map;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			ans = Integer.MAX_VALUE;
			corecnt = 0;
			map = new int[N][N];
			list = new ArrayList<>();
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					if(num ==1) {
						map[i][j] = 1;
						if(i ==0 || i ==N-1 || j ==0 || j == N-1)continue;
						list.add(new Core(i,j));
					}
				}
			}
			
			dfs(0,0,0);
			
			System.out.println("#"+ tc + " " + ans);
		}
	}
	private static void dfs(int idx, int cnt, int total) {
		if(idx == list.size()) {
			if(corecnt < cnt) {
				corecnt = cnt;
				ans = total;
			}else if(corecnt == cnt) {
				ans = Math.min(ans, total);
			}
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			int nr = list.get(idx).r;
			int nc = list.get(idx).c;
			int tmp = 0;
			while(true) {
				nr += pos[i][0];
				nc += pos[i][1];
				
				if(nr < 0 || nr ==N || nc < 0 || nc == N) {
					break;
				}
				
				if(map[nr][nc] == 1) {
					tmp = 0;
					break;
				}
				tmp++;
			}
			
			//�׸���
			int r = list.get(idx).r;
			int c = list.get(idx).c;
			for (int j = 0; j < tmp; j++) {
				r += pos[i][0];
				c += pos[i][1];
				
				map[r][c] = 1;
			}
			
			if(tmp == 0) {
				dfs(idx+1 ,cnt, total);
			}else {
				dfs(idx+1, cnt+1, total + tmp);
				
				//�����ֱ�
				r = list.get(idx).r;
				c = list.get(idx).c;
				for (int j = 0; j < tmp; j++) {
					r += pos[i][0];
					c += pos[i][1];
					
					map[r][c] = 0;
				}
			}
		}
	}
	static class Core{
		int r,c;

	public Core(int r, int c) {
		super();
		this.r = r;
		this.c = c;
	}
	}
}
