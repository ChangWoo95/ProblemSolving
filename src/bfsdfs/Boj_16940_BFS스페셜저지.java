package bfsdfs;

import java.io.*;
import java.util.*;

public class Boj_16940_BFS스페셜저지 {
    static ArrayList<Integer>[] list;
    static int[] ans, seq;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        visited = new boolean[n+1];
        ans = new int[n];

        for(int i = 1; i <=n; ++i) list[i] = new ArrayList<>();

        for(int i = 0; i <n-1; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        StringTokenizer st = new StringTokenizer(br.readLine());
        ans = new int[n+1];
        seq = new int[n+1];
        for(int i = 1 ; i <=n; ++i) {
            seq[i] = Integer.parseInt(st.nextToken());
            ans[seq[i]] = i;
        }
        for(int i = 1; i <=n; ++i)
            Collections.sort(list[i], (o1,o2) -> Integer.compare(ans[o1], ans[o2]));
        bfs(1);
    }

    static void bfs(int x){
        Queue<Integer> q = new LinkedList<>();
        int idx = 1;
        int[] myans = new int[n+1];
        q.add(x);
        visited[x] = true;

        while(!q.isEmpty()){
            int cx = q.poll();
            myans[idx++] = cx;
            for(int i = 0 ; i <list[cx].size(); ++i){
                int nx = list[cx].get(i);
                if(!visited[nx]){
                    visited[nx] = true;
                    q.add(nx);
                }
            }
        }
        for(int i = 1; i<=n; ++i){
            if(seq[i] != myans[i]){
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
