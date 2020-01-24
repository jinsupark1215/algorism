package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main17281_�߱��� {

	/*
	 * 1. ������ ���ؼ� ���� �� ���� �� �ִ� �ִ� ����
	 * 
	 * 2. 1�������� 4��Ÿ�ڷ� �̸� ���س� 2<=N<=50
	 * 
	 * 3. 
	 * ������ ���� ���� ���ϱ�
	 * ������ üũ�ϰ� 4�� �Ǹ� +1�� �������
	 * 
	 */
	static int n, ans;
	static int[][] score;
	static int[] order;
	static boolean[] visit;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		ans = 0;
		score = new int[n][9];
		//�̴� �� ����
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//���� �迭
			order = new int[9];
			visit = new boolean[9];
			order[3] = 0;
			visit[3] = true;
			nCr(1);
			
			System.out.println(ans);
	}

	//����¥�� ����
	private static void nCr(int idx) {
		if(idx == 9) {
			ans = Math.max(ans, cal());
			return;
		}
		
		for (int i = 0; i < 9; i++) {
			if(!visit[i]) {
				visit[i] = true;
				order[i] = idx;
				nCr(idx+1);
				visit[i] = false;
			}
		}
	}

	private static int cal() {
		int start = 0;	 // ������
		int sum = 0; 	// ���� 
		for (int i = 0; i < n; i++) {
			int[] base = new int[5];
			while(base[0] <3) {
				// 
				for (int j = 0; j < score[i][order[start]]; j++) {
					base[4] += base[3];
					base[3] = base[2];
					base[2] = base[1];
					base[1] = 0;
				}
				base[score[i][order[start]]]++;
				
				if(start == 8) {
					start = 0;
				}else {
					start++;
				}
			}
			sum += base[4];
		}
		return sum;
	}
}
