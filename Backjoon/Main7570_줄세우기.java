package Backjoon;

import java.util.ArrayList;
import java.util.Scanner;

public class Main7570_�ټ���� {

	/*
	 * 1. �ּҷ� �ټ���� ���
	 * 
	 * 2. ��� �� <=1,000,000
	 * 
	 * 3. ���������� 1, ������� �ִ� �� ���� ���̳� �ڷ� �ٺ������� -> (���ӵ� �� ����� ã��)
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int max =0;
		int[] cnt = new int[N+1];
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for (int i = 0; i < N; i++) {
			cnt[arr[i]] = cnt[arr[i]-1] + 1;
			if(cnt[arr[i]] > max)max = cnt[arr[i]];
		}
		System.out.println(N-max);
	}
}
