package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main2246_�ܵ����� {

	/*
	 * 1. �ĺ��� �� �� �ִ� �ܵ��� ��
	 * 
	 * 2. N <= 10000
	 * 
	 * 3. �Ÿ���ʷ� ���� �� ��� ���� ������ �����ϰ� �����  ���� �Ǵ�
	 */
public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//�ܵ��� ����
		int N = Integer.parseInt(br.readLine());

		int[][] condo = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			//D �ٴ尡�κ����� �Ÿ�
			condo[i][0] = Integer.parseInt(st.nextToken());
			//C ���ں�
			condo[i][1] = Integer.parseInt(st.nextToken());
		}
		
//		X���� �ٴ尡�� �� ����� �ܵ����� ��� X���� ���ں� �� ��δ�.
//		X���� ���ں� �� �� �ܵ����� ��� X���� �ٴ尡���� �� �ִ�.
		int ans = 0;
		
		//�Ÿ��� �� ������ ���� //�Ÿ��� ������ ���ں� �Ѽ����� ����
		Arrays.sort(condo,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]!=o2[0]) return (o1[0]-o2[0])*(-1);
				else return o1[1]-o2[1];
			}
			
		});
		
		
		int tmp = 0;
		
		for (int i = 0; i < N; i++) {
			boolean flag = true;
			if(tmp!=condo[i][0]){
				for (int j = i+1; j < N; j++) {
					if(condo[i][1] >= condo[j][1]) {
						flag = false;
						break;
					}
				}
				if(flag){
					ans++;
				}
			}
			tmp = condo[i][0];
		}
		
		System.out.println(ans);

	}

}
