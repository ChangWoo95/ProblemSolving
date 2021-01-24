package backtracking;

import java.io.*;
import java.util.*;

public class Boj_15656_N과M7 {
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

        perm(0);
        System.out.print(sb);

    }
    static void perm(int depth) {
        if(depth == m) {
            for(int i = 0 ; i < depth; i++){
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return ;
        }
        for(int i = 0; i < input.length; i++){
            output[depth] = input[i];
            perm(depth + 1);
        }
    }
}
