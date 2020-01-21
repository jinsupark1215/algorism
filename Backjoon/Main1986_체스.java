package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main1986_ü�� {

	/*
	 * 1. ������ ���� ����� ����
	 * 
	 * 2. ���� ������ (1,1)�� ���� n,m <=1000
	 * 
	 * 3. ���� �ִ� ��� �� visit
	 * visit ���� : ����Ʈ -> ��   
	 * ����Ʈ�� �Ѿ �� �ֱ⶧���� ���� ���� �ִ°� ��üũ �� 
	 * ���� ���� �ִ� �� �� �����ϰ� ��ֹ������� ó�� X 
	 */
	static int[][] pos1 = {{2,1},{2,-1},{-2,-1},{-2,1},{1,2},{1,-2},{-1,2},{-1,-2}};
	static int[][] pos2 = {{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1},{0,1},{1,1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		boolean[][] visit= new boolean[n][m];
		Queue<Point> queen = new LinkedList<>();
		Queue<Point> knight = new LinkedList<>();
		
		//�� �Է�
		st = new StringTokenizer(br.readLine());
		int cnt = Integer.parseInt(st.nextToken());
		for (int i = 0; i < cnt; i++) {
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1] =1;
			visit[r-1][c-1] = true;
			queen.add(new Point(r-1,c-1));
		}
		//����Ʈ �Է�
		st = new StringTokenizer(br.readLine());
		cnt = Integer.parseInt(st.nextToken());
		for (int i = 0; i < cnt; i++) {
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1] =2;
			visit[r-1][c-1] = true;
			knight.add(new Point(r-1,c-1));
		}
		//�� �Է�
		st = new StringTokenizer(br.readLine());
		cnt = Integer.parseInt(st.nextToken());
		for (int i = 0; i < cnt; i++) {
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			map[r-1][c-1] =3;
			visit[r-1][c-1] = true;
		}
		
		//����Ʈ �̵�
		while(!knight.isEmpty()) {
			Point p = knight.poll();
			
			for (int i = 0; i < 8; i++) {
				int nr = p.r + pos1[i][0];
				int nc = p.c + pos1[i][1];
				if(nr>=0 && nr<n && nc>=0 && nc < m && map[nr][nc] == 0 ) {
					visit[nr][nc]= true; 
				}
			}
		}
		
		//�� �̵�
		while(!queen.isEmpty()) {
			Point p = queen.poll();
			
			for (int i = 0; i < 8; i++) {
				for (int j = 1; j < 1000; j++) {
					int nr = p.r + pos2[i][0]*j;
					int nc = p.c + pos2[i][1]*j;
					if (nr >= 0 && nr < n && nc >= 0 && nc < m && map[nr][nc] == 0) {
						visit[nr][nc] = true;
					}else break;
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(!visit[i][j])ans++;
			}
		}
		System.out.println(ans);
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
