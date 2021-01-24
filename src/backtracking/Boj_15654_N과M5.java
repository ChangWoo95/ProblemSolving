package backtracking;

import java.io.*;
import java.util.*;

public class Boj_15654_N과M5 {
    static int n, m, output[], visited[];
    static ArrayList<Integer> numbers = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        output = new int[m];
        visited = new int[n];

        for(int i = 0; i< n; i++){
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(numbers);
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
        for(int i = 0; i < numbers.size(); i++){
            if(visited[i] == 0) {
                visited[i] = 1;
                output[depth] = numbers.get(i);
                perm(depth + 1);
                visited[i] = 0;
            }
        }
    }
}
