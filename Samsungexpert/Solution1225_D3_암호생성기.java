package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1225_D3_��ȣ������ {

	/*
	 * 1. ��ȣ�� ���Ͽ���
	 * 
	 * 2. 8���� ������
	 * 
	 * 3. Queue �̿��ؼ� 0>= �ΰ� ������ ��
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			int T = Integer.parseInt(br.readLine());
			Queue<Integer> q = new LinkedList<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for (int i = 0; i < 8; i++) {
				q.add(Integer.parseInt(st.nextToken()));
			}
			
			int idx = 1;
			while(true) {
				int num = q.poll();
				
				int tmp = num-idx;
				
				if(tmp <=0) {
					q.add(0);
					break;
				}else {
					q.add(tmp);
					idx++;
					if(idx == 6)idx=1;
				}
			}
			
			System.out.print("#" + tc + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(q.poll()+ " ");
			}
			System.out.println();
		}
	}
}
