package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution5948_D3_��������725���� {

	/*
	 * 1. 7���� ������ 3���� ���� 5��°�� ū �� ã��
	 * 
	 * 2. ���� �ٸ� ��
	 * 
	 * 3. boolean �迭 �̿��ؼ� �ߺ� ���� 5��° �� ã��
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			int[] map = new int[7];
			StringTokenizer st= new StringTokenizer(br.readLine());
			for (int i = 0; i < 7; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			boolean[] ans = new boolean[700];
			for (int i = 0; i < 5; i++) {
				for (int j = i+1; j < 6; j++) {
					for (int k = j+1; k < 7; k++) {
						ans[map[i]+map[j]+map[k]] = true;
					}
				}
			}
			int idx = 0;
			for (int i = 699; i>=0 ; i--) {
				if(ans[i]) {
					idx++;
				}
				if(idx ==5) {
					System.out.println("#" + testcase + " " + i);
					break;
				}
			}
		}
	}
}
