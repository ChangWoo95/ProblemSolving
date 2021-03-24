package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1774_우주신과의교감 {
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int from, to;
        double cost;

        Edge(int from, int to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(cost, o.cost);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] pos = new int[n][2];
        parent = new int[n];

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pos[i][0] = a;
            pos[i][1] = b;
            parent[i] = i;
        }
        Edge[] edge = new Edge[n * (n - 1) / 2];
        int cnt = 0;
        // 모든 정점에 대한 간선을 구하는 edge
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if(i == j) continue;
                edge[cnt] = new Edge(i, j, findDist(pos[i][0], pos[j][0], pos[i][1], pos[j][1]));
                ++cnt;
            }
        }
        Arrays.sort(edge);
        double result = 0;
        cnt = 0;

        //이미 연결된 부분
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            if (find(a) != find(b)) {
                ++cnt;
                union(a, b);
            }
        }
        if(cnt >= n-1) {
            System.out.printf("%.2f",result);
            System.exit(0);
        }
        for(int i = 0 ; i < n*(n-1)/2; ++i){
            int v1 = find(edge[i].from);
            int v2 = find(edge[i].to);
            if(v1 != v2){
                result += edge[i].cost;
                ++cnt;
                if(cnt == n-1) break;
                union(edge[i].from, edge[i].to);
            }
        }
        System.out.printf("%.2f",result);
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        if (a < b) parent[b] = a;
        else parent[a] = b;

    }

    static double findDist(int x1, int x2, int y1, int y2) {
        long xDist = Math.abs(x1 - x2);
        long yDist = Math.abs(y1 - y2);
        return Math.sqrt(xDist * xDist + yDist * yDist);
    }
}
