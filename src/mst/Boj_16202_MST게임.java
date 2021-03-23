package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_16202_MST게임 {
    static int[] parent;
    static int n;
    static class Edge implements Comparable<Edge> {
        int from, to, cost;
        Edge(int from, int to, int cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(cost, o.cost);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        //PriorityQueue<Edge> pq = new PriorityQueue<>();
        Edge[] edge = new Edge[m];

        for(int i = 0; i < m; ++i){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            //pq.add(new Edge(from, to, i));
            edge[i] = new Edge(from, to, i+1);
        }
        Arrays.sort(edge, (o1, o2) -> Integer.compare(o1.cost, o2.cost));

        for(int t =0; t<T; ++t){
            for(int i = 1; i<=n; ++i){
                parent[i] = i;
            }
            int cnt = 0; int answer = 0;
            //PriorityQueue<Edge> clone = (PriorityQueue<Edge>) pq.clone();

            /*while(!pq.isEmpty()){
                Edge edge = pq.poll();
                if(find(edge.from) != find(edge.to)){
                    ++cnt;
                    if(cnt == n) break;
                    answer += edge.cost;
                    union(edge.from, edge.to);
                }
            }*/
            for(int x = t; x<edge.length; ++x){
                if(find(edge[x].from) != find(edge[x].to)){
                    ++cnt;
                    answer += edge[x].cost;
                    if(cnt == n-1) break;
                    union(edge[x].from, edge[x].to);
                }
            }
            if(cnt == n-1) sb.append(answer+" ");
            else sb.append(0 +" ");
        }
        System.out.println(sb);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return;
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
    static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}
