package Samsungexpert;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Solution6731_ȫ������_�����ΰ��� {
		 /*
		  * 1. �ּ� Ƚ���� �־��� ���� ����� ���
		  * 
		  * 2. N < 10^3, N�� ¦��, dfs�� bfs ������ �޸��ʰ�, ��Ģã��
		  * 
		  * 3. �� ���� ���� ���� ����.
		  * B�� �ÿ� �ڱ� �ڽ� ������ ���� Ȧ���� ���� üũ
		  */
	    public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	         
	        int T = Integer.parseInt(br.readLine());
	         
	        for(int testcase=1; testcase<= T; testcase++) {
	            int N = Integer.parseInt(br.readLine());
	            char [][] map = new char[N][N];
	            int [] row = new int[N];
	            int [] col = new int[N];
	             
	            for(int i=0; i<N; i++) {
	                String input = br.readLine();
	                for(int j=0; j<N; j++) {
	                    map[i][j] = input.charAt(j);
	                     
	                    if(map[i][j] == 'B') {
	                        row[i]++;
	                        col[j]++;
	                    }
	                }
	            }
	             
	            int result = 0;
	            for(int i=0; i<N; i++) {
	                for(int j=0; j<N; j++) {
	                    int stone = row[i] + col[j];
	                    if(map[i][j] == 'B') {
	                    	stone--;
	                    }
	                     
	                    if(stone%2 != 0)
	                        result++;
	                }
	            }
	            bw.write("#"+testcase+" "+result+"\n");
	        }
	        bw.flush();
	    }
}
