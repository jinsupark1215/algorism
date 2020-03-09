package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main18428_�������ϱ� {

	/*
	 * 1. 3���� ��ֹ��� ��ġ�� ��� �л��� ���ø� ���Ҽ� �ִ���
	 * 
	 * 2. N<=6, ������ �� <=5, �л� �� <=30
	 * 
	 * 3. 
	 * 3-1. X�� 3���� ���� ���� �� �ִ� ������ ����
	 * 3-2. ������������ ���� �ִ��� ������
	 */
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	static int N;
	static char[][] map;
	static boolean[] visit;
	static boolean flag;
	static ArrayList<Point> teacher, wall;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		teacher = new ArrayList<>();
		wall = new ArrayList<>();
		flag = false;
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = st.nextToken().charAt(0);
				if(map[i][j] == 'X')wall.add(new Point(i,j));
				else if(map[i][j] == 'T')teacher.add(new Point(i,j));
			}
		}
		visit = new boolean[wall.size()];
		
		combi(0, 0);
		
		if(flag)System.out.println("YES");
		else System.out.println("NO");
	}
	private static void combi(int idx, int cnt) {
		if(cnt == 3) {
			for (int i = 0; i < wall.size(); i++) {
				if(visit[i])map[wall.get(i).r][wall.get(i).c] = 'O';
			}
			if(solve())flag= true;
			for (int i = 0; i < wall.size(); i++) {
				if(visit[i])map[wall.get(i).r][wall.get(i).c] = 'X';
			}
			return;
		}
		
		if (!flag) {
			for (int i = idx; i < wall.size(); i++) {
				visit[i] = true;
				combi(i + 1, cnt + 1);
				visit[i] = false;
			}
		}
	}
	private static boolean solve() {
		
		for (int i = 0; i < teacher.size(); i++) {
			Point p = teacher.get(i);
			
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < N; k++) {
					int nr = p.r + (pos[j][0] * k);
					int nc = p.c + (pos[j][1] * k);
					if(nr>=0 && nr < N && nc>=0 && nc< N) {
						if(map[nr][nc] == 'O')break;
						else if( map[nr][nc] == 'S')return false;
					}else break;
				}
			}
		}
		
		return true;
	}
	static class Point{
		int r, c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
}
