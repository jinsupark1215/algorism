package Samsungexpert;

import java.util.Scanner;

public class Solution1244_�ִ��� {

	/*
	 * 1. ����� �ִ밡 �Ǵ� ���
	 * 
	 * 2. �ִ� 6�ڸ�����
	 * 
	 * 3. ��Ž
	 */
	
	static String input;
    static char[] arr;
    static int answer;
    static int N;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcase = sc.nextInt();
        for (int tc = 1; tc <= testcase; tc++) {
            input = sc.next();
            arr = input.toCharArray();
            N = sc.nextInt();
            answer = Integer.parseInt(input);
            find(0, 0);
            
            System.out.println("#" + tc + " " + answer);
        }
    }
 
    private static void find(int n, int index) {
        if (n == N) {
            answer = Math.max(answer, Integer.parseInt(input));
            return;
        }
        for (int i = index; i < input.length(); i++) {
            for (int j = i + 1; j < input.length(); j++) {
                if(input.charAt(i)<=input.charAt(j)) {
                swap(i, j);
                find(n + 1, i);
                swap(j, i);
                }
            }
        }
    }
 
    private static void swap(int i, int j) {
        StringBuilder sb = new StringBuilder(input);
        char a = input.charAt(i);
        char b = input.charAt(j);
        sb.setCharAt(i, b);
        sb.setCharAt(j, a);
        input = sb.toString();
    }
}
