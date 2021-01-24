package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15652_N과M4 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] output = new int[m]; // M개 만큼 뽑았던 집합을 담을 배열
        int[] arr = new int[n];

        for(int i = 0; i< n; i++){
            arr[i] = i+1;
        }
        perm(arr, output, 0, m);
        System.out.print(sb);
    }
    static void perm(int[] arr, int[] output,  int depth, int m){
        if(depth == m) {
            if(isOrdered(output)) { // 뽑은 수가 정해진 m과 동일하다면
                for (int i : output) { // StringBuilder에 저장
                    sb.append(i).append(" ");
                }
                sb.append("\n");
            }
            return;
        }
        for(int i = 0; i < arr.length; i++){ // 자기자신의 중복을 허용하기 떄문에 이대로 진행
            output[depth] = arr[i];
            perm(arr, output, depth+1, m);
        }
    }
    static boolean isOrdered(int[] arr){
        for(int i = 0; i< arr.length-1; i++){
            if(arr[i] > arr[i+1]) return false;
        }
        return true;
    }
}
