package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Soluotion2382_�̻����ݸ� {

	/*
	 * 1. �����ִ� �̻����� ���� ���϶�.
	 * 
	 * 2. N <= 100, K <=1000, M <=1000 ��ĥ ��� ���� ū���� ��������
	 * 
	 * 3. ���� �� ���⿡ visitó���� 
	 * false�� �̵�
	 * true�� �̻��� ũ�� ���� ������.
	 */
	static int[][] pos = {{},{-1,0},{1,0},{0,-1},{0,1}};
	static int N,M,K,ans;
	static Point[][] map;
	static boolean[][] visit;
	static PriorityQueue<Point> q;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new Point[N][N];
			q = new PriorityQueue<>(new Comparator<Point>() {

				@Override
				public int compare(Point o1, Point o2) {
					return o2.cnt-o1.cnt;
				}
			});
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				map[r][c] = new Point(r,c,cnt,dir);
				q.add(new Point(r,c,cnt,dir));
			}
			ans = 0;
			
			for (int day = 0; day < M; day++) {
				visit = new boolean[N][N];
				map = new Point[N][N];
				
//				for (int i = 0; i < N; i++) {
//					for (int j = 0; j < N; j++) {
//						if(map[i][j] == null)System.out.print(0);
//						else System.out.print(1);
//					}
//					System.out.println();
//				}
//				System.out.println();
				Queue<Point> list = new LinkedList<>();
				int size = q.size();
				for (int i = 0; i < size; i++) {
					Point p = q.poll();
					
					int nr = p.r + pos[p.dir][0];
					int nc = p.c + pos[p.dir][1];
					
						if(nr >0 && nc >0 && nr <N-1 && nc <N-1) {
							if(!visit[nr][nc]) {
								map[nr][nc] = new Point(nr,nc,p.cnt,p.dir);
								visit[nr][nc] = true;
								list.add(map[nr][nc]);
							}else {
								Point tmp = map[nr][nc];
								list.remove(map[nr][nc]);
								if(p.cnt > tmp.cnt) {
									map[nr][nc] = new Point(nr,nc,p.cnt+tmp.cnt, p.dir);
								}else {
									map[nr][nc] = new Point(nr,nc,p.cnt+tmp.cnt, tmp.dir);
								}
								list.add(map[nr][nc]);
							}
						}else {
							p.cnt /=2;
							if(p.dir == 1)p.dir = 2;
							else if(p.dir == 2)p.dir = 1;
							else if(p.dir == 3)p.dir = 4;
							else if(p.dir == 4)p.dir = 3;
							
							if(p.cnt !=0) {
							visit[nr][nc] = true;
							map[nr][nc] = new Point(nr,nc,p.cnt,p.dir);
							list.add(map[nr][nc]);
							}
						}
				}
				size = list.size();
				for (int i = 0; i < size; i++) {
					q.add(list.poll());
				}
			}
			
			//����
			int size = q.size();
			for (int i = 0; i < size; i++) {
				ans += q.poll().cnt;
			}
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					if(map[i][j] != null)ans += map[i][j].cnt;
//				}
//			}
			System.out.println("#" + tc + " " + ans);
		}
	}
//	private static void move(int r, int c) {
//		Point p = map[r][c];
//		
//		int nr = r + pos[p.dir][0];
//		int nc = c + pos[p.dir][1];
//		
//			if(nr >0 && nc >0 && nr <N-1 && nc <N-1) {
//				if(!visit[nr][nc]) {
//					map[nr][nc] = p;
//					visit[nr][nc] = true;
//				}else {
//					if(p.cnt > map[nr][nc].cnt) {
//						map[nr][nc] = new Point(nr,nc,p.cnt+map[nr][nc].cnt, p.dir);
//					}else {
//						map[nr][nc] = new Point(nr,nc,p.cnt+map[nr][nc].cnt, map[nr][nc].dir);
//					}
//				}
//				map[r][c] = null;
//			}else {
//				p.cnt /=2;
//				if(p.dir == 1)p.dir = 2;
//				else if(p.dir == 2)p.dir = 1;
//				else if(p.dir == 3)p.dir = 4;
//				else if(p.dir == 4)p.dir = 3;
//				
//				map[nr][nc] = p;
//				visit[nr][nc] = true;
//				map[r][c] = null;
//			}
//	}
	static class Point{
		int r,c,cnt, dir;

		public Point(int r, int c, int cnt, int dir) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.dir = dir;
		}

	}
}
