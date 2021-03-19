package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1197_최소스패닝트리 {
    static class Edge implements Comparable<Edge>{
        int start,end,dist;
        Edge(int start, int end, int dist){
            this.start = start;
            this.end = end;
            this.dist =dist;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.dist, o.dist);
        }
    }
    //static List<Edge> list;
    static int[] parent;
    static PriorityQueue<Edge> pq;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //list = new ArrayList<>();
        pq = new PriorityQueue<>();
        parent = new int[n+1];
        for(int i = 1; i <=n; ++i){
            parent[i] = i;
        }
        for(int i = 0 ; i <m; ++i){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            //list.add(new Edge(from, to, dist));
            pq.add(new Edge(from, to, dist));
        }
        //Collections.sort(list);
        int cnt = 0;
        long dist = 0;
        while(!pq.isEmpty()){
            Edge e = pq.poll();
            if(find(e.start) != find(e.end)){
                dist += e.dist;
                cnt +=1;
                if(cnt == n) break;
                union(e.start, e.end);
            }
        }
        /*for(int i = 0 ; i < list.size(); ++i){
            Edge e = list.get(i);
            if(find(e.start) != find(e.end)){
                dist += e.dist;
                cnt +=1;
                if(cnt == n) break;
                union(e.start, e.end);
            }
        }*/
        System.out.println(dist);
    }
    static void union(int start, int end){
        int a = find(start);
        int b = find(end);
        parent[b] = a;
    }
    static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}
