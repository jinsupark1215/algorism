package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2003_�������� {
/*
 * 1. i���� j ���� ���� M�� �Ǵ� ����� ���� ���϶�
 * 
 * 2. N <=10000, M <=300000000
 * 
 * 3. firstidx�� secondidx�� �̿��ؼ� 
 * M���� ������ ��+1 secondidx ���ϰ�����
 * M���� ũ�� firstidx ���� ���� 
 * M���� ������ secondidx ���ϰ� ����
 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int firstidx =0, secondidx =0, sum = 0, ans =0;
		
		while(secondidx <= N) {
			if(sum < M) {
				sum += arr[secondidx++];
			}else if(sum == M) {
				ans++;
				sum += arr[secondidx++];				
			}else {
				sum -= arr[firstidx++];
			}
		}
		System.out.println(ans);
	}
}
