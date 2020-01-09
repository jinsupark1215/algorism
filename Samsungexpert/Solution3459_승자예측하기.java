package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution3459_���ڿ����ϱ� {

	/*
	 * 1. Alice �� Bob�� ������ �ؼ� ���� �̱����?
	 * 
	 * 2. 2x, 2x+1 �� ���� N < 10^18, �ּ��� ���� �����Ѵ�.
	 * 
	 * 3. 4�� ° ���� ��Ģ
	 */

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int testcase = 1; testcase <= T; testcase++) {
			long N = Long.parseLong(br.readLine());

			String answer = "Alice";
            while(N > 10) {
                N = (N/2) + 1;
                N = (N/2) - 1;
            }
            if( N == 1 || (N >= 6 && N <= 9)){
                answer = "Bob";
            }

			System.out.println("#"+ testcase + " " + answer);
		}
	}
}
