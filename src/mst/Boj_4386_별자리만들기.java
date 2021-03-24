package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_4386_별자리만들기 {
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
        int n = Integer.parseInt(br.readLine());
        parent = new int[n];
        for (int i = 0; i < n; ++i) parent[i] = i;
        double[][] pos = new double[n][2];

        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pos[i][0] = Double.parseDouble(st.nextToken());
            pos[i][1] = Double.parseDouble(st.nextToken());
        }
        Edge[] edge = new Edge[n * (n - 1) / 2];
        int cnt = 0;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                edge[cnt] = new Edge(i, j, findDist(pos[i][0], pos[j][0], pos[i][1], pos[j][1]));
                ++cnt;
            }
        }
        Arrays.sort(edge);
        double result = 0;
        cnt = 0;
        for(int i = 0 ; i < n*(n-1)/2; ++i){
            int v1 = find(edge[i].from);
            int v2 = find(edge[i].to);
            if(v1 != v2){
                result += edge[i].cost;
                ++cnt;
                if(cnt == n-1) break;
                union(v1, v2);
            }
        }
        System.out.printf("%.2f", result);
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        if (a > b) parent[b] = a;
        if (a < b) parent[a] = b;
    }

    static double findDist(double x1, double x2, double y1, double y2) {
        double a1 = Math.abs(x1 - x2);
        double a2 = Math.abs(y1 - y2);
        return Math.sqrt(a1 * a1 + a2 * a2);

    }
}
