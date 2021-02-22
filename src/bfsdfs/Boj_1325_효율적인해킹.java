package bfsdfs;

import java.io.*;
import java.util.*;

public class Boj_1325_효율적인해킹 {

    static ArrayList<Integer>[] list;
    static int[] ans = new int[10001];
    static boolean[] visited = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n+1];

        for(int i = 1; i <=n; ++i){
            list[i] = new ArrayList<>();
        }

        for(int i = 0 ; i < m; ++i){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
        }
        int maxCnt = Integer.MIN_VALUE;

        for(int i = 1 ; i <=n; ++i){
            if(list[i].size() > 0){
                Arrays.fill(visited, false);
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;
                while(!q.isEmpty()){
                    int x = q.poll();
                    for(int j : list[x]){
                        if(!visited[j]){
                            visited[j] = true;
                            q.add(j);
                            ++ans[j];
                        }
                    }
                }
            }
        }
        for(int i = 1; i <=n; ++i){
            if(maxCnt < ans[i]) maxCnt = ans[i];
        }

        for(int i = 1; i<=n; ++i){
            if(ans[i] == maxCnt) sb.append(i).append(" ");
        }
        System.out.print(sb);
    }
}
