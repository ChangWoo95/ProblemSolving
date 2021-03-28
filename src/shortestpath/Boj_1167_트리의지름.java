package shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1167_트리의지름 {
    static int n;
    static List<int[]>[] graph;
    static int[] dist;
    static final int INF = (int)1e9;
    static class Node implements Comparable<Node>{
        int cur, cost;
        Node(int cur, int cost){
            this.cur = cur;
            this.cost = cost;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        graph = new List[n+1];
        dist = new int[n+1];
        for(int i=1; i<=n; ++i){
            graph[i] = new ArrayList<>();
            dist[i] = INF;
        }
        int start = 0, end = 0;
        for(int i = 0 ; i <n; ++i){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int nn = Integer.parseInt(st.nextToken());
                if(nn == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                if(start == 0) start = from;
                graph[from].add(new int[]{nn, cost});
            }
        }
        dijkstra(start);
        int max = -1;
        for(int i=1; i<=n; ++i){
            if(max < dist[i]) {
                end = i;
                max = dist[i];
            }
        }
        Arrays.fill(dist, INF);
        dijkstra(end);
        int ans = -1;
        for(int i=1; i<=n; ++i){
            ans = Math.max(ans, dist[i]);
        }
        System.out.println(ans);

    }
    static void dijkstra(int x){
        dist[x] = 0;
        PriorityQueue<Node> pq = new PriorityQueue();
        pq.add(new Node(x, 0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int cur = node.cur;
            int cost = node.cost;
            if(cost > dist[cur]) continue;
            for(int i = 0; i< graph[cur].size(); ++i){
                int nxt = graph[cur].get(i)[0];
                int ncost = graph[cur].get(i)[1] + cost;
                if(ncost < dist[nxt]){
                    dist[nxt] = ncost;
                    pq.add(new Node(nxt, ncost));
                }
            }
        }
    }
}
