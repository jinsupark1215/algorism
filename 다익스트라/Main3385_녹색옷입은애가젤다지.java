package ���ͽ�Ʈ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main3385_����������ְ������� {

	/*
	 * 1. �ּ� ���ط�
	 * 
	 * 2. N<= 125, 0�Է¹����� ��
	 * 
	 * 3. ���ͽ�Ʈ�� ����
	 */
	static int N;
	static int[][] map, dist;
	static int[][] pos = {{1,0},{-1,0},{0,1},{0,-1}};
	static PriorityQueue<Node> pq;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = 0;
		
		while(true) {
			tc++;
			
			N = Integer.parseInt(br.readLine());
			if(N == 0)break;
			
			map = new int[N][N];
			dist = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			//����
			pq = new PriorityQueue<>();
			pq.add(new Node(0,0,map[0][0]));
			
			dist[0][0] = map[0][0];
			
			while(!pq.isEmpty()) {
				Node n = pq.poll();
				
				if(dist[n.r][n.c]< n.cost )continue;
				
				for (int i = 0; i < 4; i++) {
					int nr = n.r + pos[i][0];
					int nc = n.c + pos[i][1];
					
					if(nr>=0 && nr < N && nc >=0 && nc < N 
							&& dist[nr][nc] > dist[n.r][n.c]+ map[nr][nc] ) {
						dist[nr][nc] = dist[n.r][n.c]+ map[nr][nc];
						pq.add(new Node(nr,nc,dist[nr][nc]));
					}
				}
			}
			
			System.out.println("Problem " + tc + ": " + dist[N-1][N-1]);
		}
	}
	static class Node implements Comparable<Node>{
		int r,c, cost;

		public Node(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost- o.cost;
		}
	}
}
