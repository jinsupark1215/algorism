package Backjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main17837_���ο����2 {

	/*
	 * 1. ����Ǵ� �� ��
	 * 
	 * 2. 4���� ���̸� ��, 1000���� ������ -1
	 * 
	 * 3. 
	 */
	static int N,K;
	static int[][] map, board, horse;
	static int[][] pos = {{}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine().trim());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];		//��
		board = new int[N + 1][N + 1];	//��� ��
		horse = new int[K + 1][5];			//�� ��ġ
		
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1; i <= K; i++) {
			st = new StringTokenizer(br.readLine().trim());
			for(int j = 0; j < 3; j++) {
				horse[i][j] = Integer.parseInt(st.nextToken());
			}
			board[horse[i][0]][horse[i][1]] = i;
		}
		
		int r, c, next, count = 0, tmp, bottom;
		for(int t = 1; t <= 1000; t++) {
			for(int i = 1; i <= K; i++) {
				r = horse[i][0] + pos[horse[i][2]][0];
				c = horse[i][1] + pos[horse[i][2]][1];
				
				//�Ķ����̰ų� ���� ���� ���
				if(r < 1 || r > N || c < 1 || c > N || map[r][c] == 2) {
					horse[i][2] = (6 - horse[i][2]) % 4 + 1;
					r = horse[i][0] + pos[horse[i][2]][0];
					c = horse[i][1] + pos[horse[i][2]][1];
				}
				
				//������, �Ͼ��
				if(r >= 1 && r <= N && c >= 1 && c <= N && map[r][c] != 2) {
					count = 0;
					tmp = horse[i][3];
					horse[i][3] = board[r][c];	//��� ���� �ִ���
					
					if(board[r][c] != 0) {
						horse[board[r][c]][4] = i;
					}
					board[r][c] = board[horse[i][0]][horse[i][1]];
					board[horse[i][0]][horse[i][1]] = tmp;
					if(tmp != 0) {
						horse[tmp][4] = 0;
					}
					next = i;
					while(next != 0) {
						horse[next][0] = r;
						horse[next][1] = c;
						count++;
						next = horse[next][4];
					}
					next = horse[i][3];
					while(next != 0) {
						count++;
						next = horse[next][3];
					}
					if(count >= 4) {	//�װ��� �Ѿ��  ��
						System.out.println(t);
						return;
					}
					if(map[r][c] == 1) {	// �������� ��� �Ųٷ�
						bottom = next = board[r][c];
						while(next != i) {
							tmp = horse[next][3];
							horse[next][3] = horse[next][4];
							next = horse[next][4] = tmp;
						}
						horse[bottom][3] = horse[i][3];
						if(horse[i][3] != 0) {
							horse[horse[i][3]][4] = bottom;
						}
						if(horse[i][4] != 0) {
							horse[i][3] = horse[i][4];
							horse[i][4] = 0;
						}
						board[r][c] = i;
					}
				}
			}
		}
		System.out.println(-1);
	}
}
