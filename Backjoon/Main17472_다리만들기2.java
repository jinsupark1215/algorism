package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main17472_�ٸ������2 {

    static Queue<Node> q;
    static ArrayList<Node> bridge;
    static int[] parent;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int[][] map;
    static boolean[][] visited;
    static int N, M, label;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        label = 0;
        map = new int[N][M];
        visited = new boolean[N][M];

        q = new LinkedList<>();
        bridge = new ArrayList<>();

        for(int r = 0 ; r < N ; ++r) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0 ; c < M ; ++c) {
                // �ٴٴ� -1, ���� 0���� �ʱ�ȭ 
                map[r][c] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        // 1. �� �󺧸� �۾�
        for(int r = 0 ; r < N ; ++r) {
            for(int c = 0 ; c < M ; ++c) { 
                if(map[r][c] == 0 && !visited[r][c]) {
                    label++;
                    visited[r][c] = true;
                    map[r][c] = label;
                    q.offer(new Node(r, c, 0));
                    labeling();
                }
            }
        }
        // 2. �ٸ� ���� �� �ִ� ��� ��츦 bridge�� �ִ´�. 
        for(int r = 0 ; r < N ; ++r) {
            for(int c = 0 ; c < M ; ++c) { 
                if(map[r][c] > 0) {
                    q.add(new Node(r, c, 0));
                    calDistance(map[r][c]);
                }
            }
        }

        // 3. Kruskal �˰����� �̿��Ͽ� ��� ���� �����ϴ� �ּҰ��� ã�´�.
        parent = new int[label + 1];
        for(int i = 1 ; i <= label ; ++i) parent[i] = i;

        kruskal();
    }

    private static void kruskal() {
        Collections.sort(bridge);

        int cnt = 0;
        int dis = 0;
        for(Node node : bridge) {
            if(find(node.r) != find(node.c)) {
                union(node.r, node.c);
                dis += node.d;
                cnt++;
            }
        }

        if(cnt != label - 1) System.out.println(-1);
        else System.out.println(dis);
    }

    private static int find(int a) {
        if(parent[a] == a) {
            return a;
        }
        return parent[a] = find(parent[a]);
    }

    private static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        parent[rootB] = rootA;
    }

    private static void calDistance(int start) {
        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i = 0 ; i < 4 ; ++i) {
                int nr = cur.r + dir[i][0];
                int nc = cur.c + dir[i][1];

                // ���� ���� 
                int distance = 0;
                boolean flag = false;
                while(true) {
                    if(nr >= N || nr < 0 || nc >= M || nc < 0 || map[nr][nc] == start) break;
                    if(map[nr][nc] != -1) {
                        flag = true;
                        break;
                    }
                    distance++;
                    // ���� �������� ���ư��� 
                    nr += dir[i][0];
                    nc += dir[i][1];
                }
                // �ٸ� ���� ���� ��쿡�� �Ÿ�����
                if(flag) {
                    // �ٸ� ���� 2 �̸��� ��� 
                    if(distance < 2) continue;
                    bridge.add(new Node(start, map[nr][nc], distance));
                }
            }
        }
        q.clear();
    }

    private static void labeling() {
        while(!q.isEmpty()) {
            Node cur = q.poll();

            for(int i = 0 ; i < 4 ; ++i) {
                int nr = cur.r + dir[i][0];
                int nc = cur.c + dir[i][1];
                if(nr >= N || nr < 0 || nc >= M || nc < 0 || visited[nr][nc]) continue;
                if(map[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    map[nr][nc] = label;
                    q.add(new Node(nr, nc, 0));
                }
            }
        }
        q.clear();
    }

    // ��ǥ ǥ�������� ���ٰ� Kruskal�� ���� �ٸ��� ǥ���ϱ� ���� �����
    static class Node implements Comparable<Node> {
        int r, c, d;

        Node(int r, int c, int d){
            this.r = r;
            this.c = c;
            this.d = d;
        }

        @Override
        public int compareTo(Node o) {
            return this.d - o.d;
        }
    }
}
