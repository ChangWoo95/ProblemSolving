package backtracking;

import java.io.*;
import java.util.*;

public class Boj_15657_N과M8 { //중복조합
    static int n, m, output[], input[];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        output = new int[m];
        input = new int[n];

        for(int i = 0; i< n; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(input);

        reComb(0, 0);
        System.out.print(sb);

    }
    static void reComb(int depth, int start) {
        if(depth == m) {
            for(int i = 0 ; i < depth; i++){
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return ;
        }
        for(int i = start; i < input.length; i++){
            output[depth] = input[i];
            reComb(depth + 1, i);
        }
    }
}
