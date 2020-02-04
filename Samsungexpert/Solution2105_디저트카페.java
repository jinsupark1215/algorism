package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2105_����Ʈī�� {

	/*
	 * 1. �ִ��� ���� ������ ����Ʈ�� �Դ� ���
	 * 
	 * 2. 4<= N <=20, ����Ʈ ���� 100������
	 * 
	 * 3. dfs,
	 * 3-1 ���� �� �ִ���?(�Ծ��� ������ �Ǵ�)
	 * 3-2 ������ ���� ��ġ�� �������� ������ ������ �밢���� �´��� �Ǵ�
	 */
	static int N, ans, sr, sc;
	static int[][] map;
	static boolean[] chk;
	static int[][] pos = {{1,1},{1,-1},{-1,-1},{-1,1}};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			ans = -1;
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N-2; i++) {
				for (int j = 1; j < N-1; j++) {
					chk = new boolean[101];
					sr = i; sc = j;
					dfs(i,j,1,0);
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
	private static void dfs(int r, int c, int cnt,int dir) {
		//��������
		if(sr == r && sc == c && dir ==3) {
			ans = Math.max(ans, cnt-1);
		}
		
		//���� 3�� ������
		if(dir > 3)return;
		//�̹� ���� ����Ʈ�� ����
		if(chk[map[r][c]]) return;
		//�ȸ��� ����Ʈ�� �Ա�
		chk[map[r][c]] = true;
		

			int nr = r + pos[dir][0];
			int nc = c + pos[dir][1];
			if(nr>= 0 && nr < N && nc >=0 && nc <N) {
				//���� ������ �� �� �ִ� ���� �� ����
				dfs(nr,nc,cnt+1,dir);
				dfs(nr, nc, cnt+1, dir+1);
			}
			
			
		chk[map[r][c]] = false;
		return;
	}
}
