package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution2805_���۹���Ȯ�ϱ� {

	/*
	 * 1. ���簢���� ���̾� �κ��� ���� ���϶�
	 * 
	 * 2.  N�� 49 ���� Ȧ��
	 * 
	 * 3. ��簪�� ���ϰ� ���õ��� ���� �κ��� �ε���ó���� ���� ����
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int sum = 0;
			for (int i = 0; i < N; i++) {
				String input = br.readLine();
				for (int j = 0; j < N; j++) {
					int num =input.charAt(j)-'0';
					map[i][j] = num;
					sum += num;
				}
			}
			
			int idx = 0;
			//������
			idx = (N/2)-1;
			for (int i = 0; i < N/2; i++) {
				for (int j = idx; j >=0; j--) {
					sum -= map[i][j];
					map[i][j] = 0;
				}
				idx--;
			}
			
			//��������
			idx = (N/2)+1;
			for (int i = 0; i < N/2; i++) {
				for (int j = idx; j <N; j++) {
					sum -= map[i][j];
					map[i][j] = 0;
				}
				idx++;
			}
			
			//���ʾƷ�
			idx = (N/2)-1;
			for (int i = N-1; i > (N/2); i--) {
				for (int j = idx; j >=0; j--) {
					sum -= map[i][j];
					map[i][j] = 0;
				}
				idx--;
			}
			
			//�����ʾƷ�
			idx = (N/2)+1;
			for (int i = N-1; i > (N/2); i--) {
				for (int j = idx; j <N; j++) {
					sum -= map[i][j];
					map[i][j] = 0;
				}
				idx++;
			}
			
			System.out.println("#" + testcase + " " + sum);
		}
	}
}
