package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution7194_D4_ȭ�����ǹ̻������ {

	/*
	 * 1. ȭ���̰� �̻��� s ���� t�� ���� ����� �ּ� ��
	 * 
	 * 2. s,t,a,b <=1000000000, ����� ���� �Ұ����ϸ� -1
	 * 
	 * 3. b�� 1�� ���� ���� �������� b���� ���غ��� a�� ���鼭 �´��� üũ
	 */
	static int s, t, a, b, ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st= new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			ans = 0;
			
			// ���� : b�� 1�� ��찡 �ִ°� ����
            if(b == 1) {
                if((t - s) % a == 0) ans = (t - s) / a;
                else ans = -1;
                
                System.out.println("#" + tc + " " + ans);
			} else {

				// �������� �ϴ� b�����ϰ� a�� �������� �ؼ� ��������
				while (s < t) {
					if (t % b == 0) {
						if (t / b < s) t -= a;
						else t /= b;
					} else {
						t -= a;
					}
					ans++;
				}

				if (s > t) System.out.println("#" + tc + " -1");
				else System.out.println("#" + tc + " " + ans);
			}
		}
	}
}
