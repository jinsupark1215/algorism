package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main15684_��ٸ����� {

	/*
	 * 1. ��ٸ����� �ּҷ� ���Ƽ� i=i�� �ǵ���
	 * 
	 * 2.N<=10, H<=30, (1,1)���� ����
	 * 
	 * 3. ��Ž
	 */
	static int N,M,H,ans;
    static int[][] map;
    static boolean ok;
    
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        
        map = new int[H+2][N+1];
        ok = false;
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }
        
        for (int i = 0; i <= 3; i++) {
            ans = i;
            solve(1,1,0);
            if(ok) break;
        }
        
        System.out.println(ok? ans : -1);
    }
    
    //�� �ٿ��� �������� ������ ������ �Ǵ��ϰ� �ƴ϶�� ��ٸ��� �����ٰ� �������ٰ� �Ǵ�
    static void solve(int r, int c, int cnt) {
        if(ok) return ;
        
        if(ans == cnt) {
            if(check()) {
                ok = true;
            }
            return ;
        }
        
        for (int i = (c < N ? r : r+1); i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if(map[i][j] == 1 || map[i][j-1] == 1 || map[i][j+1] == 1) continue;
                map[i][j] = 1;
                solve(i,j,cnt+1);
                map[i][j] = 0;
            }
        }
        
    }
    
    //������ i�� ���� i �� ������ �Ǵ�
    static boolean check() {
        for (int j = 1; j <= N; j++) {
            int i = 1;
            int tmp = j;
            while( i <= H+1) {
                
                if(map[i][tmp] == 1) {
                    tmp++;
                }
                else if(map[i][tmp-1] == 1) {
                    tmp--;
                }
                i++;
            }
            if(j != tmp) {
                return false;
            }
        }
        return true;
    }
}
