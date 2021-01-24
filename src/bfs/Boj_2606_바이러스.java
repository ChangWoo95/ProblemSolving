package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2606_바이러스 {
    static int ans = 0;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int n;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n+1];
        for(int i = 1; i<= n; i++){
            graph[i] = new ArrayList<Integer>();
        }
        visited = new boolean[n+1];
        k = Integer.parseInt(br.readLine());
        int fir, sec;

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            fir = Integer.parseInt(st.nextToken());
            sec = Integer.parseInt(st.nextToken());
            graph[fir].add(sec);
            graph[sec].add(fir);
        }
        infectedComputer();
        System.out.println(ans);
    }
    static void infectedComputer(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        int cur;

        while(!q.isEmpty()){
            cur = q.poll();
            for(int i : graph[cur]) {
                if(!visited[i]){
                    visited[i] = true;
                    ans++;
                    q.add(i);
                }
            }
        }
    }
}
