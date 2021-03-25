package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1647_도시분할계획 {
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
        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n];
        for(int i = 0 ; i <n; ++i){
            parent[i] = i;
        }
        Edge[] edge = new Edge[m];
        for(int i = 0 ; i<m; ++i){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int cost = Integer.parseInt(st.nextToken());
            edge[i] = new Edge(from, to, cost);
        }
        Arrays.sort(edge);
        int result = 0;
        int cnt = 0;
        for(int i = 0 ; i < m; ++i){
            Edge e = edge[i];
            if(find(e.from) != find(e.to)){
                result += e.cost;
                if(++cnt == n-2) break;
                union(e.from, e.to);
            }
        }
        System.out.println(result);
    }
    static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    static void union(int a,int b){
        a = find(a);
        b = find(b);
        if(a == b) return;
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
}
