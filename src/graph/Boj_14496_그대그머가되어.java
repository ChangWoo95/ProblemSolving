package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_14496_그대그머가되어 {
    static final int INF = (int)1e9;
    static List<int[]>[] list;
    static int[] dist;
    static int start, end;
    static int n;
    static class Node implements Comparable<Node>{
        int cost;
        int nxt;
        Node(int cost, int nxt){
            this.cost = cost;
            this.nxt = nxt;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(cost, o.cost);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        list = new List[n+1];
        for(int i = 1; i<= n; ++i){
            list[i] = new ArrayList<>();
        }
        dist = new int[n+1];
        int T = Integer.parseInt(st.nextToken());
        while(T-->0){
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            list[to].add(new int[]{1, from});
            list[from].add(new int[]{1, to});
        }
        Arrays.fill(dist, INF);
        dijkstra();
        if(dist[end] != INF) System.out.println(dist[end]);
        else System.out.println(-1);
    }
    static void dijkstra(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Node(0, start));
        while(!pq.isEmpty()){
            int cur = pq.peek().nxt;
            int cost = pq.peek().cost;
            pq.poll();
            if(cost > dist[cur]) continue; // 현재 정점의 최단거리값이 예전 경로보다 더 짧다면 넘기

            for(int i = 0 ; i < list[cur].size(); ++i){
                int nxt = list[cur].get(i)[1];
                int ncost = list[cur].get(i)[0] + cost;
                if(dist[nxt] > ncost){
                    dist[nxt] = ncost;
                    pq.add(new Node(ncost, nxt));
                }
            }
        }
    }
}
