package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1868_D4_������������ã�� {

	/*
	 * 1. �ּ��� ���� Ŭ������ ���� ���� �� �ּ�Ŭ������ ã�ƶ�
	 * 
	 * 2.  N <= 300
	 * 
	 * 3. ���� �ֺ��� ���ڼ��� üũ�ϰ� �� ���ڼ��� �ʿ� üũ
	 * �״��� visit �迭�� ����� 0�� �Ϳ� bfs�� �湮 üũ
	 * üũ�Ѵ��� üũ���� ���� ���ڰ� �ִ� ���ڵ� �� üũ
	 */
	
	static int ans,N;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1},{1,1},{1,-1},{-1,1},{-1,-1}};
	static int[][] map;
	static boolean[][] visit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visit = new boolean[N][N];
			ans = 0;
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					char tmp = input.charAt(j);
					if(tmp =='*') {
						map[i][j] = 10;
						for (int k = 0; k < 8; k++) {
							int nr = i + pos[k][0];
							int nc = j + pos[k][1];
							if(nr>=0 && nc >=0 && nr < N && nc < N) {
								map[nr][nc]++;
							}
						}
						visit[i][j] = true;
					}
				}
			}
			
			//BFS�� üũ
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] ==0 && !visit[i][j]) {
						bfs(i,j);
						ans++;
					}
				}
			}
			
			//üũ �ȴ��� ���� üũ
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visit[i][j])ans++;
				}
			}
			System.out.println("#"+ testcase+" " + ans);
		}
	}
	private static void bfs(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(r,c));
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			visit[p.r][p.c] = true;
			
			for (int i = 0; i < 8; i++) {
				int nr = p.r + pos[i][0];
				int nc = p.c + pos[i][1];
				if(nr >=0 && nc>=0 && nr< N && nc < N && !visit[nr][nc]) {
					if(map[nr][nc] == 0) {
						q.add(new Point(nr,nc));
						visit[nr][nc] = true;
					}
					else if(map[nr][nc] <10 && map[nr][nc] > 0)visit[nr][nc] = true;
				}
			}
		}
	}
	static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
