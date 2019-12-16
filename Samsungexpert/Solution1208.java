package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution1208 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int testcase = 1; testcase <= 10; testcase++) {
			int dump = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			int[] box = new int[100];
			
			for (int i = 0; i < 100; i++) {
				int tmp = Integer.parseInt(st.nextToken());
				
				for (int j = 0; j < tmp; j++) {
					box[j]++;
				}
			}
			
			/*
			 * 1. �������� : ���� �� �ְ����� �������� ���̸� ��ȯ
			 * 
			 * 2. ���� 100, ���ڳ��� 1~100, ����Ƚ�� 1000
			 * 
			 * 3. ���ڸ� ������ ������ ���� ��, 100�� �ƴ� ���� ã�Ƽ� �ǵں��� �ϳ��� üũ
			 */
			int max = 0;
			int min = 0;
			while(dump >=0) {
				
				fin:
				for (int i = 0; i < 100; i++) {
					if(box[i] != 100) {
						for (int j = 99; j >=0; j--) {
							if(box[j] !=0) {
								box[j]--;
								box[i]++;
								max = j;
								min = i;
								break fin;
							}
						}
					}
				}
				dump--;
			}
			System.out.println("#" + testcase +  " " + (max-min+1));
		}
	}
}
