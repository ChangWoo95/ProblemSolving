package bfsdfs;

import java.io.*;
import java.util.*;

public class Boj_1260_DFS와BFS {
    static List<Integer>[] list;
    static int n, m, start;
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x, y;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken());
        list = new List[n+1];
        visited = new boolean[n+1][2];

        for(int i =1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for(int i =1; i<= m; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        for(int i =1; i<=n; i++){
            Collections.sort(list[i]);
        }
        dfs(start);
        sb.append("\n");
        bfs();

        System.out.print(sb);
    }
    static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start][0] = true;
        int cur;
        while(!q.isEmpty()) {
            cur = q.poll();
            sb.append(cur).append(" ");
            for(int nxt : list[cur]) {
                if(!visited[nxt][0]){
                    visited[nxt][0] = true;
                    q.add(nxt);
                }
            }
        }
        sb.append("\n");
    }

    static void dfs(int cur) {
        visited[cur][1] = true;
        sb.append(cur).append(" ");
        for(int nxt : list[cur]) {
            if(!visited[nxt][1]){
                dfs(nxt);
            }
        }
    }
}
