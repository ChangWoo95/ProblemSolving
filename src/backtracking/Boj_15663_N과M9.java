package backtracking;

import java.io.*;
import java.util.*;

public class Boj_15663_N과M9 {
    static int n,m;
    static int[] list;
    static int[] output;
    static Set<String> set = new LinkedHashSet<>();
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static StringBuilder word = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new int[n];
        visited= new boolean[n];
        output = new int[m];
        st = new StringTokenizer(br.readLine());

        for(int i =0; i <n; i++)
            list[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(list);
        perm(0);
        Iterator<String> ss = set.iterator();
        while(ss.hasNext()){
            sb.append(ss.next());
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static void perm(int depth){
        if(depth == m){
            for(int i =0; i < m; i++)
                word.append(output[i]).append(" ");
            set.add(word.toString());
            word.delete(0, word.length());
            return;
        }
        for(int i =0; i < n; i++){
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = list[i];
                perm(depth + 1);
                visited[i] = false;
            }
        }
    }
}
