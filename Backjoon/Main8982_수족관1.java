package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main8982_������1 {

	/*
	 * 1. �������� �����ִ� ���� ��?
	 * 
	 * 2. ���� <= 40000
	 * 
	 * 3. ������ ������������  �� ��� ��� ���ֱ�
	 */
	static int[] surface, depth;
	static Node[] hole;
	static int N, K, ans, lastIdx;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		ans = 0;
		surface = new int[40001]; // ǥ�� ����
		depth = new int[40001]; // ���� ����
		
		br.readLine(); // 0,0
		for(int i = 0 ; i < (N / 2) - 1 ; ++i) {
			st = new StringTokenizer(br.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int ex = Integer.parseInt(st.nextToken());
			int ey = Integer.parseInt(st.nextToken());

			for(int j = sx ; j <= ex ; ++j) {
				depth[j] = sy;
			}
			
			lastIdx = ex - 1;
		}
		br.readLine(); // ������
		
		K = Integer.parseInt(br.readLine());

		// ������ ����� ������ �Է� 
		hole = new Node[K];
		for(int i = 0 ; i < K ; ++i) {
			st = new StringTokenizer(br.readLine());
			int idx = Integer.parseInt(st.nextToken());
			int dep = Integer.parseInt(st.nextToken());
			hole[i] = new Node(dep, idx);
		}
		
		for(Node cur : hole) {
			int curDepth = cur.r;
			int col = cur.c;
			
			// �������� ���� 
			for(int i = col ; i >= 0 ; --i) {
				// ���� ���̸� �ּҰ����� �����Ѵ�. 
				curDepth = curDepth > depth[i] ? depth[i] : curDepth;
				surface[i] = curDepth > surface[i] ? curDepth : surface[i];
			}
			
			curDepth = cur.r;
			col = cur.c;
			
			// ���������� ���� 
			for(int i = col ; i <= lastIdx ; ++i) {
				// ���� ���̸� �ּҰ����� �����Ѵ�. 
				curDepth = curDepth > depth[i] ? depth[i] : curDepth;
				surface[i] = curDepth > surface[i] ? curDepth : surface[i];
			}
			
		}
		
		for(int i = 0 ; i <= lastIdx ; ++i) {
			ans += depth[i] - surface[i];
		}
		
		System.out.println(ans);
	}
	static class Node {
		int r, c;
		
		Node(int r, int c){
			this.r = r;
			this.c = c;
		}
	}
}
