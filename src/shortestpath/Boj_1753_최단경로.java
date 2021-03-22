package shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1753_최단경로 {
    static int[] dist;
    static List<int[]>[] list;
    static int start, n;
    static final int INF = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        dist = new int[n+1];
        list = new List[n+1];
        for(int i =1; i<=n; ++i){
            dist[i] = INF;
            list[i] = new ArrayList<>();
        }

        start = Integer.parseInt(br.readLine());
        for(int i = 0 ; i <m; ++i){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list[from].add(new int[]{to, cost});
        }
        dijkstra();
        for(int i =1; i<=n; ++i){
            if(dist[i] != INF) sb.append(dist[i]).append("\n");
            else sb.append("INF").append("\n");
        }
        System.out.print(sb);
    }
    static void dijkstra(){
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        dist[start] = 0;

        pq2.add(new int[]{start, 0});
        while(!pq2.isEmpty()){
            int cur = pq2.peek()[0];
            int cost = pq2.peek()[1];

            pq2.poll();

            if(cost > dist[cur]) continue;

            for(int i = 0 ; i <list[cur].size(); ++i){
                int nxt = list[cur].get(i)[0];
                int ncost = list[cur].get(i)[1] + cost;
                if(dist[nxt] > ncost ){
                    dist[nxt] = ncost;
                    pq2.add(new int[]{nxt, ncost});
                }
            }
        }
    }
}
