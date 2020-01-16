package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main1713_�ĺ���õ�ϱ� {

	/*
	 * 1. ���� �ĺ� N���� ������� ���
	 * 
	 * 2. N <=20, �� ��õ Ƚ�� 1000��, �л���ȣ 1~100
	 * 
	 * 3. ����
	 * �л����� ��õ�� �����ϱ� ���� ��� ����Ʋ�� ����ִ�.
		� �л��� Ư�� �л��� ��õ�ϸ�, ��õ���� �л��� ������ �ݵ�� ����Ʋ�� �ԽõǾ�� �Ѵ�.
		����ִ� ����Ʋ�� ���� ��쿡�� ������� ��õ ���� Ƚ���� ���� ���� �л��� ������ �����ϰ�,
 		�� �ڸ��� ���Ӱ� ��õ���� �л��� ������ �Խ��Ѵ�. �̶�, ������� ��õ ���� Ƚ����
  		���� ���� �л��� �� �� �̻��� ��쿡�� �Խõ� �� ���� ������ ������ �����Ѵ�.
		���� ������ �Խõ� �л��� �ٸ� �л��� ��õ�� ���� ��쿡�� ��õ���� Ƚ���� ������Ų��.
		����Ʋ�� �Խõ� ������ �����Ǵ� ��쿡�� �ش� �л��� ��õ���� Ƚ���� 0���� �ٲ��.
	 */
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int[] arr= new int[101]; // ��õ Ƚ��
		ArrayList<Integer> list = new ArrayList<Integer>(); //����Ʋ
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int chk = 0; chk < M; chk++) {
			int num = Integer.parseInt(st.nextToken());
			if(list.size() == N) {	//�� ã�� ��
				boolean flag = false;
				for (int i = 0; i < list.size(); i++) {
					if(list.get(i) == num) {
						flag = true;
						break;
					}
				}
				if(flag)arr[num]++;		//�̹� ����Ʋ�� �����ϸ� ��õȽ���� ����
				else {
				int min = Integer.MAX_VALUE;
				
				// ����Ʋ���� ��õ Ƚ���� ���� ���� ��ã��
				for (int i = 0; i < N; i++) {
					min = Math.min(min, arr[list.get(i)]);
				}	
				
				//���� ������ ���� �ָ� �̾Ƴ��� 
				// ���� ��쿡�� ���� �ɷ��ִ� ���̸� �̾Ƴ�
					for (int i = 0; i < N; i++) {
						if(arr[list.get(i)] == min) {
							list.remove(i);
							arr[list.get(i)] = 0;
							list.add(num);
							arr[num]++;
							break;
						}
					}
				}
			}else {	// ��õ �� ����Ʋ�� ��ã���� list�� �̸� �ø�
				boolean flag = false;
				for (int i = 0; i < list.size(); i++) {
					if(list.get(i) == num) {
						flag =true;
						break;
					}
				}
				if(flag)arr[num]++;	//�̹� �����ϸ� ��õ���� ����
				else {
					list.add(num);	//�ƴϸ� ����Ʋ�� �ø��� ��õ�� ����
					arr[num]++;
				}
			}
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
