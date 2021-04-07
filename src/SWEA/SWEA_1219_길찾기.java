package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_1219_길찾기 {
    static ArrayList<Integer>[] list;
    static int n;
    static boolean flag;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i <10; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            list = new ArrayList[n];
            visited = new boolean[100];
            for(int x = 0; x< n; ++x){
                list[x] = new ArrayList<>();
            }
            flag = false;
            st = new StringTokenizer(br.readLine());
            for(int x = 0 ; x < n; ++x){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
            }
            dfs(0);
            if(flag) sb.append("#" + t).append(" " + 1).append("\n");
            else sb.append("#" + t).append(" " + 0).append("\n");
        }
        System.out.print(sb);
    }
    static void dfs(int x){
        visited[x] = true;
        for(int nxt : list[x]){
            if(nxt == 99){
                flag = true;
                return;
            }
            if(!visited[nxt]) dfs(nxt);
        }
        if(flag) return;
    }
}
