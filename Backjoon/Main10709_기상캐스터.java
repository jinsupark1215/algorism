package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main10709_���ĳ���� {

	/*
	 * 1. ������ ���������� ���
	 * 
	 * 2. H,W <=100
	 * 
	 * 3. c�������� 0���� ����
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int[][] map = new int[H][W];
		
		for (int i = 0; i < H; i++) {
			String input = br.readLine();
			int idx = -1;
			for (int j = 0; j < W; j++) {
				if(input.charAt(j) == 'c') {
					idx = 0;
				}
				map[i][j] = idx;
				if(idx !=-1)	idx++;
			}
		}
		
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}
