package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution5658_�������ں�й�ȣ {

	/*
	 * 1. ���� �� �ִ� ���� �� K������ ū ���� ���
	 * 
	 * 2. N�� 4�� ��� 8<= N <=28 0~F 16����
	 * 
	 * 3. 
	 * 
	 * 3-1 ���� �� �ִ� ������ �� �����(�ߺ����� Set �̿�)
	 * 3-2 �����鼭 �迭�� ����� 10������ ��ȯ
	 * 3-3 ���� �� �� ���
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			String input = br.readLine();
			StringBuilder sb = new StringBuilder();
			sb.append(input);
			Set<String> set = new HashSet<>();
			for (int i = 0; i < n/4; i++) {
				for (int j = 0; j < n; j+=n/4) {
					set.add(sb.substring(j, j+n/4));
				}
				char tmp = sb.toString().charAt(n-1);
				sb.deleteCharAt(n-1);
				sb.insert(0, tmp);
			}
			
			int[] ans = new int[set.size()];
			int idx = 0;
			Iterator iter = set.iterator();
			while(iter.hasNext()) {
				String tmp = (String) iter.next();
				int sum = 0;
				int mult = 1;
				for (int i = tmp.length()-1; i >=0 ; i--) {
					int su= 0;
					if(tmp.charAt(i) == 'A')su =10;
					else if(tmp.charAt(i) == 'B')su =11;
					else if(tmp.charAt(i) == 'C')su =12;
					else if(tmp.charAt(i) == 'D')su =13;
					else if(tmp.charAt(i) == 'E')su =14;
					else if(tmp.charAt(i) == 'F')su =15;
					else su = tmp.charAt(i)-'0';
					sum += su * mult;
					mult *=16;
				}
				ans[idx++] = sum;
			}
			
			Arrays.sort(ans);
			System.out.println("#" + tc + " " + ans[ans.length-k]);
		}
	}
}
