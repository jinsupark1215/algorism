package Samsungexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1808_D4_�����ǰ��峭���� {
/*
 * 1. �ּ��� ��ư���� X�� ����� �� �ִ��� ���
 * 
 * 2. �Ұ����ϸ� -1, X<100000
 * 
 * 3.dfs �̿� 
 *  X�� ���� �� �ִ� �� �Ǵ� -> ������ ��
 *  								������ ���� �� �ִ� ���� ������ �Ǵ�
 */
	 static int T, X, ans;
	    static boolean[] num;
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	 
	        T = Integer.parseInt(st.nextToken());
	        for(int tc = 1; tc <= T; tc++){
	            ans = Integer.MAX_VALUE;
	            num = new boolean[10];
	            st = new StringTokenizer(br.readLine());
	            for(int i = 0; i < 10; i++){
	                if(Integer.parseInt(st.nextToken()) == 1){
	                    num[i] = true;
	                }
	            }
	            X = Integer.parseInt(br.readLine());
	            ans = go(X);
	            if(ans == -1) ans = -2;
	            System.out.println("#" + tc + " " + (ans + 1));
	        }
	    }
	 
	    static int go(int x) {
	        int min = Integer.MAX_VALUE;
	        for(int i = 2 ; i * i <= x ; ++i) {
	            if(x % i == 0) {
	                int num = pushPossible(i);
	                if(num != -1) {
	                    int sub = go(x/i);
	                    if(sub != -1)
	                        min = (min > (sub + num + 1)) ? (sub + num + 1) : min;
	                }
	            }
	        }
	 
	        int a = pushPossible(x);
	 
	        if(min==Integer.MAX_VALUE) {
	            return (a != -1)? a : -1;
	        }
	        else
	            return (a != -1 && a < min)? a : min;
	    }
	 
	    static int pushPossible(int a) {
	        if(a < 10)
	            return (num[a] == true) ? 1 : -1;
	 
	        else {
	            if(num[a % 10]) {
	                int b = pushPossible(a / 10);
	                if(b != -1)
	                    return b+1;
	                else
	                    return -1;
	            }
	            else
	                return -1;
	        }
	    }
}
