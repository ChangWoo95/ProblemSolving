package backtracking;

import java.io.*;
import java.util.*;

public class Boj_15650_N과M2 {
    static int[] numbers, output; // numbers: 숫자들의 집합, output: m개씩 뽑았을 경우의 집합
    static boolean[] visited; // 해당 요소를 방문했는지 확인
    static int n, m; // n: 전체 숫자의 갯수, m: 그 중에 뽑을 숫자의 갯수
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        numbers = new int[n];
        visited = new boolean[n];
        output = new int[m];

        for(int i = 0; i<n ; i++){
            numbers[i] = i+1;
        }
        perm(0);
        System.out.print(sb);
    }
    static void perm(int depth) {
        if(depth == m) { //m개만큼 뽑았다면
            if(!isOrdered()) return; // 오름차순이 아니라면 탈출

            for(int i = 0; i < output.length; i++){
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return ;
        }
        for(int i = 0; i < numbers.length; i++){
            if(!visited[i]){ // 해당 요소를 방문하지 않았다면,
                visited[i] = true; // 방문
                output[depth] = numbers[i]; // 해당 값을 output에 담음
                perm(depth+1);
                visited[i] = false;
            }
        }
    }
    static boolean isOrdered(){
        for(int i = 0; i < output.length-1; i++){
            if(output[i] > output[i+1]) return false;
        }
        return true;
    }
}
