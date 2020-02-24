package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2933_�̳׶� {

	/*
	 * 1. �� �ν� �� �� ǥ��
	 * 
	 * 2. R,C <= 100
	 * 
	 * 3.
	 * 3-1. ���� â�� ������ �νñ�(���� ������ �νñ�)
	 * 3-2. bfs�� 1���� �� üũ �Ǵ��� üũ
	 * 3-3. 1���� üũ �ȵǸ� �� ������
	 */
	static int R, C;
	static ArrayList<Point> list;
	static char[][] map;
	static boolean[][] visit;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int i = 0; i < R; i++) {
			String input = br.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		boolean flag = false;
		
		for (int i = 0; i < N; i++) {
			int n = R - Integer.parseInt(st.nextToken());
			
			crack(n,flag);	// �νñ�
			
			list = new ArrayList<>();
			chk();	//üũ
			if(list.size() !=0)down();	//������
			
			
			if(flag)flag = false;
			else flag = true;
		}
		
		//���
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	private static void down() {// �̿�
		int cnt = 0;
		for (Point p : list) {
			map[p.r][p.c] = '.';
		}

		// ���� ������ Ŭ�����Ͱ� ��ĭ�̳� ������ �� �ִ��� üũ�Ѵ�.
		fin: 
		for (int i = 1; i < R; ++i) {
			for (Point p : list) {
				if (p.r + i >= R || map[p.r + i][p.c] == 'x') {
					break fin;
				}
			}
			cnt = i;
		}

		// ���� ĭ ��ŭ �̵���Ų Ŭ�����͸� ���� �׸���.
		for (Point p : list) {
			map[p.r + cnt][p.c] = 'x';
		}
	}
	private static void chk() {
		visit = new boolean[R][C];
		Queue<Point> q = new LinkedList<>();
			for (int j = 0; j < C; j++) {
				if(map[R-1][j] == 'x' && !visit[R-1][j]) {
					visit[R-1][j] = true;
					q.add(new Point(R-1,j));
					while(!q.isEmpty()) {
						Point p = q.poll();
						
						for (int k = 0; k < 4; k++) {
							int nr = p.r + pos[k][0];
							int nc = p.c + pos[k][1];
							if(nr>=0 && nr < R && nc >=0 && nc < C && !visit[nr][nc] && map[nr][nc] == 'x') {
								visit[nr][nc] = true;
								q.add(new Point(nr,nc));
							}
						}
					}
			}
		}
			
			// �湮üũ���� ���� ���߿� �� �ִ� Ŭ�����͸� ����Ʈ�� ��´�.
			for(int i = 0 ; i < R ; ++i) {
				for(int j = 0 ; j < C ; ++j) {
					if(map[i][j] == 'x' && !visit[i][j]) {
						list.add(new Point(i,j));
					}
				}
			}
		
	}
	private static void crack(int idx, boolean flag) {
		if(!flag) {
			for (int i = 0; i < C; i++) {
				if(map[idx][i] == 'x') {
					map[idx][i] = '.';
					break;
				}
			}
		}else {
			for (int i = C-1; i >=0; i--) {
				if(map[idx][i] == 'x') {
					map[idx][i] = '.';
					break;
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
