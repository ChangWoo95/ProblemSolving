package shortestpath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_13905_세부 {
    static final int INF = (int) 1e9;
    static int n, m, s, e;
    static List<int[]>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        list = new List[n+1];
        for(int i =1; i<=n; ++i){
            list[i] = new ArrayList<>();
        }
        while(m--> 0){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[from].add(new int[]{to, weight});
            list[to].add(new int[]{from, weight});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o2[1], o1[1]));
        boolean[] visited = new boolean[n+1];
        int[] dist = new int[n+1];
        dist[s] = INF;
        pq.add(new int[]{s, 0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            if(visited[cur[0]]) continue;
            visited[cur[0]] = true;
            for(int i = 0 ; i < list[cur[0]].size(); ++i){
                int nxt = list[cur[0]].get(i)[0];
                int wei = list[cur[0]].get(i)[1];
                dist[nxt] = Math.max(dist[nxt], Math.min(dist[cur[0]], wei));
                pq.add(list[cur[0]].get(i));
            }
        }
        int ans = dist[e];
        System.out.println(ans);

    }
}
