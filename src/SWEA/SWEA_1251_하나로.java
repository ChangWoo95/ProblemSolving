package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_1251_하나로 {
    static int[] parent;
    static class Edge implements Comparable<Edge>{
        int from, to;
        long cost;
        Edge(int from, int to, long cost){
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
        @Override
        public int compareTo(Edge o) {
            return Long.compare(cost, o.cost);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t<=T; ++t){
            int n = Integer.parseInt(br.readLine());
            int[][] pos = new int[n][2];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i< n; ++i) pos[i][0] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 0 ; i < n; ++i) pos[i][1] = Integer.parseInt(st.nextToken());
            double E = Double.parseDouble(br.readLine());

            Edge[] edge = new Edge[n*(n-1)/2];
            int cnt = 0;

            for(int i =  0 ; i < n-1; ++i){
                for(int j = i+1; j<n; ++j){
                    edge[cnt] = new Edge(i, j, findDist(pos[i][0], pos[j][0], pos[i][1], pos[j][1]));
                    ++cnt;
                }
            }
            Arrays.sort(edge);
            parent = new int[n];
            for(int i = 0 ; i < n; ++i) parent[i] = i;
            long result = 0;
            cnt = 0;
            for(int i = 0 ; i < n*(n-1)/2; ++i){
                int v1 = find(edge[i].from);
                int v2 = find(edge[i].to);
                if(v1!=v2){
                    result += edge[i].cost;
                    ++cnt;
                    if(cnt == n-1) break;
                    union(v1,v2);
                }
            }
            sb.append("#" + t + " " + Math.round(result*E)).append("\n");
        }
        System.out.print(sb);
    }
    static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b) return;
        if(a > b) parent[b] = a;
        else parent[a] = b;

    }
    static long findDist(int x1, int x2, int y1, int y2){
        return (long)(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
    }
}
