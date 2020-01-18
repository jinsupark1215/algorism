package Backjoon;

import java.util.Scanner;

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
	 * -> �ð��ʰ�
	 * 
	 * 3-1 �ں��� ���� ( ���� )
	 */
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		int D = sc.nextInt();
		int N = sc.nextInt();
		int[] arr = new int[D];
		int[] pizza = new int[D];
		int maxarr = 0;
		int maxpizza = 0;
		for (int i = 0; i < D; i++) {
			arr[i] = sc.nextInt();
			maxarr = Math.max(maxarr, arr[i]);
		}
		for (int i = 0; i < N; i++) {
			pizza[i] = sc.nextInt();
			maxpizza = Math.max(maxpizza, pizza[i]);
		}
		int ans =-1;
		int tmp = 0;
		int idx = N-1;
		//�ְ��� ũ�� �� �ȵ����Ƿ� ������ 
		if(maxpizza > maxarr)System.out.println(0);
		else {
		//�� ���� ���ں��� ���� ū�� ã��
		for (int j = 0; j < D; j++) {
			if(pizza[N-1] >arr[j]) {
				ans = j-1;
				tmp = j;
				break;
			}
		}
		
		//���� ��ã������ ���� ���̹Ƿ� 0
		if(ans == -1)System.out.println(0);
		else {
			//�� ���� ��� �׿��ִ��� �Ǵ�
			for (int i = N-2; i >=0 ; i--) {
				if(pizza[i] > arr[tmp]) {
					ans -= idx - i;
					idx = i;
				}else;//������ ����
			}
			//�� ������ ������������ ���� ���̹Ƿ� 1
			if(ans < 1)System.out.println(1);
			else System.out.println(ans+1);
		}
		}
	}
}
