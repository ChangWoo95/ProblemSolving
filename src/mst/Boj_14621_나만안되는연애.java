package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_14621_나만안되는연애 {
    static class Node implements Comparable<Node>{
        int from, to, distance;
        Node(int from ,int to,int distance){
            this.from = from;
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(distance, o.distance);
        }
    }
    static int[] parent;
    static char[] collageType;
    static int n,m;
    static PriorityQueue<Node> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        collageType = new char[n+1];
        for(int i = 1; i <=n; ++i){
            parent[i]= i;
        }
        pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; ++i){
            collageType[i] = st.nextToken().charAt(0);
        }
        for(int i = 0 ; i < m; ++i){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            if(collageType[from] == collageType[to]) continue;
            pq.add(new Node(from, to, distance));
        }
        int cnt = 0;
        int result = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            if(find(node.from) != find(node.to)){
                result += node.distance;
                ++cnt;
                if(cnt == n-1) break;
                union(node.from, node.to);
            }
        }
        if(cnt != n-1) System.out.println(-1);
        else System.out.println(result);

    }
    static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    static void union(int a,int b){
        a = find(a);
        b = find(b);
        if(a == b) return ;
        if(a > b) parent[b] = a;
        else parent[a] = b;
    }
}
