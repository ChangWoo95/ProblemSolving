package shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_10217_KCM_Travel {
    static final int INF = (int) 1e9;
    static int[][] time;
    static List<int[]>[] graph;
    static int n, m;

    static class Node implements Comparable<Node> {
        int cost;
        int nxt;
        int time;

        Node(int cost, int nxt, int time) {
            this.cost = cost;
            this.nxt = nxt;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            if (this.time < o.time) return -1;
            else if (this.time == o.time) {
                if (this.cost < o.cost) return -1;
                return 0;
            }
            return 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            graph = new List[n + 1];
            time = new int[n + 1][m + 1];
            for (int i = 1; i <= n; ++i) {
                graph[i] = new ArrayList<>();
                Arrays.fill(time[i], INF);
            }

            while (k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                int time = Integer.parseInt(st.nextToken());
                graph[from].add(new int[]{to, cost, time});
            }
            dijkstra();
            int min = INF;
            for(int i = 0 ;i <=m; ++i){
                min = Math.min(min, time[n][i]);
            }

            if (min == INF) sb.append("Poor KCM").append("\n");
            else sb.append(min).append("\n");
        }
        System.out.print(sb);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(0, 1, 0));
        time[1][0] = 0;

        while (!pq.isEmpty()) {
            int cur = pq.peek().nxt;
            int cost = pq.peek().cost;
            int curTime = pq.peek().time;

            pq.poll();
            if (cur == n) break;

            for (int i = 0; i < graph[cur].size(); ++i) {
                int nxt = graph[cur].get(i)[0];
                int ncost = graph[cur].get(i)[1] + cost;
                int ntime = graph[cur].get(i)[2] + curTime;

                if (ncost > m) continue;
                if (time[nxt][ncost] <= ntime) continue;

                for (int j = ncost; j <= m; ++j) {
                    if (time[nxt][j] > ntime) time[nxt][j] = ntime;
                }
                time[nxt][ncost] = ntime;

                pq.add(new Node(ncost, nxt, ntime));

            }
        }
    }
}
