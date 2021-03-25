package mst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2887_행성터널 {
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int from, to, cost;

        Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(cost, o.cost);
        }
    }

    static class planet {
        int idx, x, y, z;

        planet(int idx, int x, int y, int z) {
            this.idx = idx;
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n];
        for (int i = 0; i < n; ++i) {
            parent[i] = i;
        }
        planet[] pl = new planet[n];
        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            pl[i] = new planet(i, x, y, z);
        }
        List<planet> xPos = new ArrayList<>(Arrays.asList(pl));
        Collections.sort(xPos,(o1, o2) -> o1.x - o2.x);
        List<planet> yPos = new ArrayList<>(Arrays.asList(pl));
        Collections.sort(yPos,(o1, o2) -> o1.y - o2.y);
        List<planet> zPos = new ArrayList<>(Arrays.asList(pl));
        Collections.sort(zPos,(o1, o2) -> o1.z - o2.z);
        List<Edge> edge = new ArrayList<>();

        for (int i = 0; i < n - 1; ++i) {
            planet xp1 = xPos.get(i);
            planet xp2 = xPos.get(i + 1);
            edge.add(new Edge(xp1.idx, xp2.idx, findDist(xp1.x, xp2.x, xp1.y, xp2.y, xp1.z, xp2.z)));
            planet yp1 = yPos.get(i);
            planet yp2 = yPos.get(i + 1);
            edge.add(new Edge(yp1.idx, yp2.idx, findDist(yp1.x, yp2.x, yp1.y, yp2.y, yp1.z, yp2.z)));
            planet zp1 = zPos.get(i);
            planet zp2 = zPos.get(i + 1);
            edge.add(new Edge(zp1.idx, zp2.idx, findDist(zp1.x, zp2.x, zp1.y, zp2.y, zp1.z, zp2.z)));
        }

        Collections.sort(edge);
        long result = 0;
        int cnt = 0;
        for (int i = 0; i < edge.size(); ++i) {
            if (find(edge.get(i).from) != find(edge.get(i).to)) {
                result += edge.get(i).cost;
                if (++cnt == n - 1) break;
                union(edge.get(i).from, edge.get(i).to);
            }
        }
        System.out.println(result);
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

    static int findDist(int x1, int x2, int y1, int y2, int z1, int z2) {
        x1 = Math.abs(x1 - x2);
        y1 = Math.abs(y1 - y2);
        z1 = Math.abs(z1 - z2);
        return Math.min(x1, Math.min(y1, z1));
    }
}
