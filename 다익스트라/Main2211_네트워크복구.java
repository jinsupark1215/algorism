package ���ͽ�Ʈ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2211_��Ʈ��ũ���� {

	/*
	 * 1. �����ؾ��ϴ� ȸ���� ���� ��θ� ���
	 * 
	 * 2. 
	 * 
	 * 3. ���ͽ�Ʈ�� 
	 */
	static boolean bTest = false;
	static int[][] map;
	static int dist[];
	static int N;
	static int M;
	static int[] answer;
	
    public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); //��ǻ�ͼ�
			M = Integer.parseInt(st.nextToken()); //ȸ����			
			map = new int[N+1][N+1];
			answer = new  int[N+1];
			dist = new  int[N+1];
			
			//dist�ʱ�ȭ
			for(int i=0;i<=N;i++)
			{
				dist[i] = Integer.MAX_VALUE;
			}
			
			//ȸ������ �ʱ�ȭ
			for(int i=0;i<M;i++){
				st = new StringTokenizer(br.readLine());
				int A = Integer.parseInt(st.nextToken());
				int B = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				map[A][B]=C;
				map[B][A]=C;
			}
			
			//���ͽ�Ʈ�� ȣ��
			dijkstra(1); //1�� �����Ŀ��� ��������� ���ͽ�Ʈ��
			
			System.out.println(N-1);
			
			for(int i=2;i<=N;i++){
				System.out.println(i + " " + answer[i]);
			}
	}

	private static void dijkstra(int start) {
		PriorityQueue<Node> q = new PriorityQueue<Node>();
		dist[start] =0;
		
		q.add(new Node(start,dist[start]));
		
		while(!q.isEmpty()){
			Node n = q.poll();
			
			if(n.dis>dist[n.next])
				continue;
					
			for(int i=0;i<=N;i++){
				if(map[n.next][i]!=0 && dist[i] > dist[n.next]+map[n.next][i]){
					dist[i] = dist[n.next]+map[n.next][i];
					answer[i] = n.next; 
					q.add(new Node(i,dist[i]));
				}
			}
		}
	}

	public static class Node implements Comparable<Node>{

		int next;
		int dis;
		
		public Node(int next, int dis) {
			this.next = next;
			this.dis = dis;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.dis - o.dis;
		}
	}
}
