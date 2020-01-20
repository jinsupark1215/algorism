package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main1756_���ڱ��� {

	/*
	 * 1. ������ ���� ��ġ�� ���϶�.
	 * 
	 * 2. 1<=D,N <= 300000
	 * 
	 * 3. 
	 * 3-1.������ �迭 arr[], ���ڰ� ���� pizza[]
	 * 3-2. ���ڹ����� �迭�� ���ں��� ������  �� �� �ε����� Ʈ��� ������ְ�
	 * 3-3. 0�������� true�� ���� ã���� ��
	 * -> �ð��ʰ� (n^2)
	 * 
	 * 3-1. ���� ũ�⸦ ���Ͱ� ���ؼ� �����͸� �ִ´�
	 * 3-2. ���ڸ� �����鼭 �ش� ��ġ ����
	 * -> n
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		int D = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int[] oven = new int[D];
		int[] pizza = new int[N];
		
		//���� �Ͱ� ���ؼ� ��¥�� ������ ������ ���� �� ����
		st = new StringTokenizer(br.readLine());
		oven[0] = Integer.parseInt(st.nextToken());
		for (int i = 1; i < D; i++) {
			oven[i] = Math.min(oven[i-1], Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			pizza[i] = Integer.parseInt(st.nextToken());
		}
		
		int idx =0;
		int ans = 0;
		
		for (int i = D-1; i >=0; i--) {
			if(oven[i] >= pizza[idx]) {
				idx++;
			}
			
			if(idx == N) {
				ans = i+1;
				break;
			}
		}
		
		System.out.println(ans);
	}
}
