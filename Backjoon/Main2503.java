package Backjoon;

import java.util.Scanner;

public class Main2503 {

	static int[][] map;
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][5];
		
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			int strike = sc.nextInt();
			int ball = sc.nextInt();
			
			map[i][0] = num/100;
			map[i][1] = (num/10)%10;
			map[i][2] = num%10;
			map[i][3] = strike;
			map[i][4] = ball;
			}

		/*
		 * 	1. �������� : ���ھ߱��� �ؼ� ���� ������ ���� ���ϱ�
		 * 
		 * 	2. ���� ���� : ���� �ٸ� ��. 3�ڸ�
		 * 					�ڸ��� ���ڰ� ������ strike
		 * 					�ڸ��ٸ��� ���� ������ ball
		 * 
		 * 3. ���� : ��ü �� ã�ƺ��� �ߺ��Ǹ� �Ѿ�� strike�� ball üũ.
		 */
		
		solve();
		System.out.println(solve());
		}
	private static int solve() {
		int answer = 0;
		
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if(i == j) continue;
				for (int k = 1; k <= 9; k++) {
					if(i==k) continue;
					if(j==k) continue;
					
					boolean flag = true;
					for (int l = 0; l < n; l++) {
						int strike = 0;
						int ball = 0;
						
						//ù��°�ڸ�
						if(i == map[l][0]) {
							strike++;
						}else if(i == map[l][1] || i == map[l][2]) {
							ball++;
						}
						
						//�ι�°�ڸ�
						if(j == map[l][1]) {
							strike++;
						}else if(j == map[l][0] || j == map[l][2]) {
							ball++;
						}
						
						//����°�ڸ�
						if(k == map[l][2]) {
							strike++;
						}else if(k == map[l][1] || k == map[l][0]) {
							ball++;
						}
						
						if(strike != map[l][3] || ball != map[l][4]) {
							flag = false;
							break;
						}
					}
					
					if(flag) {
						answer++;
					}
				}
			}
		} 
		return answer;
	}
}
