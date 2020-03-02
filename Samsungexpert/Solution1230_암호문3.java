package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1230_��ȣ��3 {

	/*
	 * 1. ���� �� ó�� 10�� �� ���
	 * 
	 * 2. N <= 4000
	 * 
	 * 3. ����
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> list = new ArrayList<>();
		StringTokenizer st= new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int x,y;
		for (int i = 0; i < N; i++) {
			char input = st.nextToken().charAt(0);
			if(input == 'I') {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				int[] tmp = new int[y];
				for (int j = 0; j < y; j++) {
					tmp[j] = Integer.parseInt(st.nextToken());
				}
				for (int j = y-1; j >=0; j--) {
					list.add(x, tmp[j]);
				}
			}else if( input == 'D') {
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				for (int j = 0; j < y; j++) {
					list.remove(x);					
				}
			}else if( input == 'A') {
				y = Integer.parseInt(st.nextToken());
				for (int j = 0; j < y; j++) {
					list.add(Integer.parseInt(st.nextToken()));
				}
			}
		}
		
		System.out.print("#" + tc + " ");
		for (int i = 0; i < 10; i++) {
			System.out.print(list.get(i) + " ");
		}
		}
	}
}
