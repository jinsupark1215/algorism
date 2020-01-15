package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2805_�����ڸ��� {

	/*
	 * 1. M�̻� ������ �� �ִ� ���� ���Ͻÿ�
	 * 
	 * 2. N <= 1,000,000, M <=2,000,000,000
	 * 
	 * 3. �̺�Ž������ ã��
	 */
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); 
        int M = Integer.parseInt(st.nextToken()); 
        
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N]; 
        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr); 
        int last = arr[N-1];
        
        int maxHeight = last; 
        int minHeight = 0; 
        int middle = 0;    
        
        while(maxHeight >= minHeight){
            middle = (minHeight+maxHeight)/2;
            
            int cutTree = 0; // �鳯�� ������ �߶��� �� ���� ���� ����
            long sumCutTree = 0; // �߶� ���� ���̵��� ��, long�� ������ ������ ���� int ������ �Ѿ ���� �ִ�.
            
            for(int j=0; j<N; j++){
                
                cutTree = arr[j] - middle; // �̺�Ž������ ������ �鳯�� ���̸� ã�ư���. �߰� ������ �������� �߶󺸰�
                                                 // ������ ����������.
                
                if(cutTree <0){
                    cutTree = 0; // �߸��� ������ 0�̱� ������ ���̳ʽ� ���� ������ �� ����.
                }
                sumCutTree += cutTree;
            }
            
            if(sumCutTree >= M){ // ������ �߶� ���� ���̵��� ���� �ּ������� �������ߵǴ� ���� ���̺��� Ŭ ��
                
                minHeight = middle + 1; // ȯ���� �����ؼ� �� ���� �߶󰡷��� �鳯�� ���̸� ������ ������ ���ݸ� �߶󰡾� �Ѵ�.
                
            }else if(sumCutTree < M){ // ������ �߶� ���� ���̵��� ���� �ּ������� �������� �Ǵ� ���� ���̺��� ���� ��
                
                maxHeight = middle - 1; // �ʿ��� �������̺��� �߶� ���� ���̵��� ���� �۱� ������ �鳯�� ���̸� ���缭 �� ��� ����� �Ѵ�.
                
            }
            
        }
        
        System.out.println(maxHeight);    // �鳯�� ���̸� ������ �� �ִ� ���̿��� �ִ밪
    }
}
