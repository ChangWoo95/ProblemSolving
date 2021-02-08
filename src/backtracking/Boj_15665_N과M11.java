package backtracking;

import java.io.*;
import java.util.*;

public class Boj_15665_N과M11 {
    static int n, m;
    static int[] list, output;
    static Set<String> set = new LinkedHashSet<>();
    static StringBuilder sb = new StringBuilder();
    static StringBuilder ans = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new int[n];
        output = new int[m];
        st = new StringTokenizer(br.readLine());

        for(int i =0; i < n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(list);
        seq(0);
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            ans.append(it.next());
        }
        System.out.print(ans);
    }
    static void seq(int depth) {
        if(depth == m){
            for(int i =0; i <m; i++){
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            set.add(sb.toString());
            sb.delete(0, sb.length());
            return;
        }
        for(int i =0; i < n; i++){
            output[depth] = list[i];
            seq(depth + 1);
        }
    }
}
