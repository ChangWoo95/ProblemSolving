package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1922_네트워크연결 {
    static int[] parent;
    static class Edge implements Comparable<Edge>{
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
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        for(int i =1; i<=n; ++i){
            parent[i] = i;
        }
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        while(m --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Edge(from, to, cost));
        }
        int cnt = 0;
        int answer = 0;
        while(!pq.isEmpty()){
            Edge edge = pq.poll();
            if(find(edge.from) != find(edge.to)){
                answer += edge.cost;
                ++cnt;
                if(cnt == n) break;
                union(edge.from, edge.to);
            }
        }
        System.out.println(answer);
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
