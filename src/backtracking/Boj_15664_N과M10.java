package backtracking;

import java.io.*;
import java.util.*;

public class Boj_15664_N과M10 {
    static int n, m, cnt;
    static int[] output, input;
    static Set<String> set = new LinkedHashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        input = new int[n];
        output = new int[m];

        for(int i =0; i <n; i++)
            input[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(input);

        comb(0, 0);

        Iterator<String> it = set.iterator();
        StringBuilder ans = new StringBuilder();

        while(it.hasNext())
            ans.append(it.next());

        System.out.print(ans);
    }
    static void comb(int depth, int start){
        if(depth == m){
            for(int i =0; i < m; i++)
                sb.append(output[i]).append(" ");
            sb.append("\n");
            set.add(sb.toString());
            sb.delete(0, sb.length());
            return;
        }
        for(int i = start; i < n; i++){
            output[depth] = input[i];
            comb(depth + 1, i + 1);
        }
    }
}
