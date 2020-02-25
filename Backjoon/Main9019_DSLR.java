package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main9019_DSLR {

	/*
	 * 1. A ���� B�� �ܶ� �ּ����� ���
	 * 
	 * 2. A,B <10000
	 * 
	 * 3. BFS�� �ش� ���� ��ȯ, BFS �� �湮ó���ʼ�!, str ó��
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			String[] chk = new String[10000];
			Arrays.fill(chk, "");
			boolean[] visit = new boolean[10000];
			Queue<Integer> q = new LinkedList<>();
			q.add(A);
			visit[A] = true;
			
			while(true) {
				int num = q.poll();
				
				
				if(num == B) {
					break;
				}
				
				int tmp = 0;
				//D
				tmp = (num * 2) % 10000;
				if (!visit[tmp]) {
					q.add(tmp);
					visit[tmp] = true;
					chk[tmp] = chk[num]+'D';
				}
				// S
				tmp = num - 1;
				if (tmp == -1)
					tmp = 9999;
				if (!visit[tmp]) {
					q.add(tmp);
					visit[tmp] = true;
					chk[tmp] = chk[num] + 'S';
				}
				// L
				tmp = ((num - ((num / 1000) * 1000)) * 10) + (num / 1000);
				if (!visit[tmp]) {
					q.add(tmp);
					visit[tmp] = true;
					chk[tmp] = chk[num] +  'L';
				}
				// R
				tmp = ((num - (num % 10)) / 10) + ((num % 10) * 1000);
				if (!visit[tmp]) {
					q.add(tmp);
					visit[tmp] = true;
					chk[tmp] = chk[num] +  'R';
				}
			}
			
			System.out.println(chk[B]);
		}
	}
}
