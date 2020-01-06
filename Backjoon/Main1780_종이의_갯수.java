package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1780_������_���� {

	/*
	 * 1. -1,0,1�θ� �̷���� ������ ������ ���ض�.
	 * 
	 * 2. 1<=N <= 3^7 2��
	 * 
	 * 3. ����Ž������ �ڸ��� Ȯ���ϰ� �ڸ��� Ȯ���ϴ� ���.
	 */
	static int ans1,ans2,ans3, N;
	static int[][] map;
	static int[][] pos = {{1,0},{0,1},{1,1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		chk(0,0,N);
		
		System.out.println(ans1);
		System.out.println(ans2);
		System.out.println(ans3);
	}

	//�� �ǿ� �Ȱ��� ���ڷ� �Ǿ��ִ��� �Ǵ�
	private static void chk(int r, int c, int cnt) {
		int tmp1 =0, tmp2=0, tmp3=0;
		for (int i = r; i < r+cnt; i++) {
			for (int j = c; j < c+cnt; j++) {
				if(map[i][j] == -1)tmp1++;
				if(map[i][j] == 0)tmp2++;
				if(map[i][j] == 1)tmp3++;
			}
		}
		if(tmp2 ==0 && tmp3 ==0) {
			ans1++;
		}else if(tmp1 ==0 && tmp3==0) {
			ans2++;
		}else if(tmp1 ==0 && tmp2 ==0) {
			ans3++;
		}else {
			for (int i = r; i < r+cnt; i+=(cnt/3)) {
				for (int j = c; j < c+cnt; j+=(cnt/3)) {
					chk(i,j,(cnt/3));
				}
			}
		}
	}

	
}
