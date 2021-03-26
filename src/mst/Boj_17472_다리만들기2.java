package mst;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_17472_다리만들기2 {
    static List<List<int[]>> island = new ArrayList<>();
    static int r, c, islandCnt = 0;
    static int[][] map;
    static boolean[][] visited;
    static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static List<int[]> area;
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new int[r][c];
        visited = new boolean[r][c];

        for (int i = 0; i < r; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < c; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int cnt = 0;
        for (int i = 0; i < r; ++i) {
            for (int j = 0; j < c; ++j) {
                if (!visited[i][j] && map[i][j] == 1) {
                    ++cnt;
                    area = new ArrayList<>();
                    dfs(i, j, cnt);
                    island.add(area);
                    ++islandCnt;
                }
            }
        }
        List<Edge> edge = new ArrayList<>();

        for (int i = 0; i < island.size(); ++i) {
            List<int[]> area = island.get(i);
            for (int j = 0; j < area.size(); ++j) {
                int v1 = map[area.get(j)[0]][area.get(j)[1]];
                for (int dir = 0; dir < 2; ++dir) {
                    int curx = area.get(j)[0] + d[dir][0];
                    int cury = area.get(j)[1] + d[dir][1];

                    int distCnt = 0;
                    while (isIn(curx, cury) &&  map[curx][cury] == 0) {
                        ++distCnt;
                        curx += d[dir][0];
                        cury += d[dir][1];
                    }

                    if (isIn(curx, cury) && distCnt >= 2) {
                        int v2 = map[curx][cury];
                        edge.add(new Edge(v1, v2, distCnt));
                    }
                }
            }
        }
        Collections.sort(edge);
        parent = new int[islandCnt + 1];
        for (int i = 1; i <= islandCnt; ++i) {
            parent[i] = i;
        }
        int result = 0;
        int edgeCnt = 0;
        for (int i = 0; i < edge.size(); ++i) {
            Edge e = edge.get(i);
            if (find(e.from) != find(e.to)) {
                result += e.cost;
                if (++edgeCnt == islandCnt - 1) break;
                union(e.from, e.to);
            }
        }
        if(result != 0 && edgeCnt == islandCnt - 1) System.out.println(result);
        else System.out.println(-1);
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

    static void dfs(int x, int y, int cnt) {
        visited[x][y] = true;
        map[x][y] = cnt;
        area.add(new int[]{x, y});
        for (int i = 0; i < 4; ++i) {
            int nx = x + d[i][0];
            int ny = y + d[i][1];
            if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
            if (!visited[nx][ny] && map[nx][ny] == 1) dfs(nx, ny, cnt);
        }
    }

    static boolean isIn(int x, int y) {
        return x >= 0 && x < r && y >= 0 && y < c;
    }
}
