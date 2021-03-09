package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_1865_웜홀 {
    static int n, m, w;
    static final int INF = (int)1e9;
    static List<int[]>[] list;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        while(T --> 0){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            list = new List[n+1];
            for(int i=1; i<=n; ++i){
                list[i] = new ArrayList<>();
            }
            for(int i = 0 ; i < m; ++i){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                list[s].add(new int[]{e, t});
                list[e].add(new int[]{s, t});
            }

            for(int i = 0 ; i <w; ++i){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                list[s].add(new int[]{e, -t});
            }
            dist = new int[n+1];


            boolean isMinusCycle = false;
            for(int i =1; i<=n; ++i){
                if(bellmanFord(i)){
                    isMinusCycle = true;
                    sb.append("YES").append("\n");
                    break;
                }
            }
            if(!isMinusCycle) sb.append("NO").append("\n");
        }
        System.out.print(sb);
    }

    static boolean bellmanFord(int start){
        Arrays.fill(dist, INF);
        dist[start] = 0;
        boolean update = false;

        for(int i = 1; i< n;++i){
            update = false;
            for(int j = 1; j <=n; ++j){
                for(int[] x : list[j]){
                    if(dist[j] != INF && dist[x[0]] > dist[j] + x[1]){
                        dist[x[0]] = dist[j] + x[1];
                        update = true;
                    }
                }
            }
            if(!update) break;
        }
        if(update){
            for(int i = 1; i <=n; ++i){
                for(int[] x : list[i]){
                    if(dist[i] != INF && dist[x[0]] > dist[i] + x[1]){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
