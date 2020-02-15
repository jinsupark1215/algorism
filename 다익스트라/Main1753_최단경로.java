package ���ͽ�Ʈ��;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main1753_�ִܰ�� {
	/*
	 * 1. �ִܰ�θ� ���ϱ�
	 * 
	 * 2. V <= 20000, E <=300000
	 * 
	 * 3. ���ͽ�Ʈ�� �˰���
	 */
	static int INF = 2147483647;
	static int[] dist;// ���� �������� ���� ���������� �Ÿ�
	static boolean[] visit;// ������ �湮�߳� ���߳�

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());// ������ ����
		int E = Integer.parseInt(st.nextToken());// ������ ����
		int K = Integer.parseInt(br.readLine());// ���� ������ ��ȣ

		dist = new int[V + 1];// ���� �������κ��� ���� ���������� �ּ� �Ÿ�
		visit = new boolean[V + 1];// �湮 �߳� ���߳�

		// �� ������ ����� ������ ����
		ArrayList<Node>[] list = new ArrayList[V + 1];
		for (int i = 1; i <= V; i++) {
			dist[i] = INF;// ��� ������ �ϴ� ����
			list[i] = new ArrayList<Node>();
		}
		dist[K] = 0;// ���������� ���������� �Ÿ��� 0

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());// ������ ����
			int v = Integer.parseInt(st.nextToken());// ������ ��
			int w = Integer.parseInt(st.nextToken());// ����ġ
			list[u].add(new Node(v, w));
		}

		PriorityQueue<Node> pq = new PriorityQueue<Node>();// �켱���� ť
		pq.add(new Node(K, 0));// ���� ������ �켱���� ť�� ����.

		while (!pq.isEmpty()) {
			Node n = pq.poll();// ť�� ����ִ� ������ ���� ����ġ�� ���� �� ã��.
			if (visit[n.end] == true) {
				continue;
			}
			visit[n.end] = true;
			for (Node k : list[n.end]) {
				if (visit[k.end] == false) {
					dist[k.end] = Math.min(dist[k.end], dist[n.end] + k.value);
					pq.add(new Node(k.end, dist[k.end]));
				}
			}
		}

		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF) {
				System.out.println("INF");
			} else {
				System.out.println(dist[i]);
			}
		}
	}

}

class Node implements Comparable<Node> {
	int end;
	int value;

	Node(int end, int value) {
		this.end = end;
		this.value = value;
	}

	@Override
	public int compareTo(Node o) {
		return this.value - o.value;
	}
}
