package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main16234_�α��̵� {

	/*
	 * 1. �α��̵� �� �߻��ϴ� Ƚ��
	 * 
	 * 2. N<=50, 1<=L,R<=100
	 * 
	 * 3.
	 * 3-1 �� ������ ���̰� L�� R ���̸� visitó��
	 * 3-2 bfs�� �� ������ ��ġ�� ���� �����ؼ� �ٽ� �ѷ���  
	 * 3-3 ������ ���� �ݺ�.
	 */
	static int N,L,R,ans;
	static boolean flag;
	static int[][] map;
	static boolean[][] visit;
	static boolean[][] tmp;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		ans = 0;
		flag = true;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(true) {
			visit = new boolean[N][N];
			flag = true;
			
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(!visit[i][j]) {
						go(i,j);	//�α������ֱ�
						cnt++;
					}
				}
			}
			if(!flag && cnt == N*N)break;
			
			ans++;
		}
		System.out.println(ans);
	}


	private static void go(int r, int c) {
		Queue<Point> q = new LinkedList<>();
		ArrayList<Point> list = new ArrayList<>();
		list.add(new Point(r,c));
		q.add(new Point(r,c));
		visit[r][c] = true;
		
		int sum = map[r][c];
		int cnt = 1;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int i = 0; i < 4; i++) {
				int nr = p.r + pos[i][0];
				int nc = p.c + pos[i][1];
				if(nr>=0 && nr<N && nc>=0 && nc< N && !visit[nr][nc]) {
					int tmp = Math.abs(map[p.r][p.c] - map[nr][nc]);
					if(L<= tmp && tmp <= R) {
						visit[nr][nc] = true;
					sum+= map[nr][nc];
					cnt++;
					q.add(new Point(nr,nc));
					list.add(new Point(nr,nc));
					}
				}
			}
		}
		
		if(list.size() == 1)flag = false;
		
		for (Point p : list) {
			map[p.r][p.c]= sum/cnt; 
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
