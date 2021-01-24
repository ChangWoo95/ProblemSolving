package backtracking;

import java.io.*;
import java.util.*;

public class Boj_15650_N과M2 {
    static int[] numbers; // numbers: 숫자들의 집합
    static int n, m; // n: 전체 숫자의 갯수, m: 그 중에 뽑을 숫자의 갯수
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers = new int[n];

        for(int i = 0; i<n ; i++){
            numbers[i] = i+1;
        }
        perm(0, 1);
        System.out.print(sb);
    }
    static void perm(int depth, int start) {
        if(depth == m) { //m개만큼 뽑았다면
            for(int i = 0; i < depth; i++){
                sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return ;
        }
        for(int i = start; i <= n; i++){
            numbers[depth] = i;
            perm(depth+1, start+1);
        }
    }
}
