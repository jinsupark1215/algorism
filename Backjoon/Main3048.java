package Backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class Main3048 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		String ant1 = sc.next();
		String ant2 = sc.next();
		int t = sc.nextInt();
		
		/*
		 * 1. T�� ���� ���̵��� ��� ������ ���
		 * 
		 * 2. -> <- ������ ����
		 * 0�� �� 	CBADEF		000000
		 * 1�� ��		CBDAEF		00+1-100
		 * 2�� ��		CDBEAF		0+1+2-2-10
		 * 3�� ��		DCEBFA		+1+2+3-3-2-1
		 * 4�� ��		DECFBA		+2+3+3-3-3-2
		 * 5�� ��		DEFCBA		+3+3+3-3-3-3
		 * 
		 * 3. �迭���� index ����
		 */
		
		char[] arr= new char[n1+n2];
		int idx = n1-1;
		for (int i = 0; i < n1; i++) {
			if(t <= 0) {
				arr[idx] = ant1.charAt(i);
			}else if (t >= n2) {
				arr[idx + n2] = ant1.charAt(i);
			} else if (t < n2) {
				arr[idx + t] = ant1.charAt(i);
			}
			t--;
			idx--;
		}
		
		idx =0;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				arr[i] = ant2.charAt(idx);
				idx++;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);			
		}
	}
}
