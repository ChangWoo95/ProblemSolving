package backtracking;

import java.io.*;
import java.util.*;

public class Boj_15666_N과M12 {
    static int n, m;
    static Set<Integer> set;
    static List<Integer> list;
    static int[] output;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        set = new HashSet<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        output = new int[m];
        st = new StringTokenizer(br.readLine());

        for(int i =0; i < n; i++)
            set.add(Integer.parseInt(st.nextToken()));

        list = new ArrayList<>(set);
        Collections.sort(list);

        dfs(0, 0);
        System.out.print(sb);
    }
    static void dfs(int depth, int start) {
        if(depth == m) {
            for(int i =0; i < m; i++){
                sb.append(output[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i =start; i <list.size(); i++){
            output[depth] = list.get(i);
            dfs(depth + 1, i);
        }
    }
}
