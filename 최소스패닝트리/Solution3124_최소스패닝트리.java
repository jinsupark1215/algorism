package �ּҽ��д�Ʈ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution3124_�ּҽ��д�Ʈ�� {

	/*
	 * 1. �ּ� �Ÿ�
	 * 
	 * 2. V <= 100000, E <=200000, C�� �����ϼ� ������ ���밪�� �鸸 �Ʒ�, cnt�� 21�� ������������ long
	 * 
	 * 3.Kuskal �̿�
	 */
	static int[] parent;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				pq.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			parent = new int[N+1];
			for (int i = 1; i <= N; i++) {
				parent[i] = i;
			}
			
			long cnt = 0;
			while(!pq.isEmpty()) {
				Node n = pq.poll();
				
				if(find(n.start) != find(n.end)) {
					union(n.start, n.end);
					cnt += n.dis;
				}
			}
			System.out.println("#"+ tc + " " + cnt);
		}
	}
	private static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		parent[rootB] = rootA;
	}
	private static int find(int num) {
		if(parent[num] == num)return num;
		return parent[num] = find(parent[num]);
	}
	static class Node implements Comparable<Node>{
		int start, end, dis;

		public Node(int start, int end, int dis) {
			super();
			this.start = start;
			this.end = end;
			this.dis = dis;
		}

		@Override
		public int compareTo(Node o) {
			return this.dis - o.dis;
		}
	}
}
