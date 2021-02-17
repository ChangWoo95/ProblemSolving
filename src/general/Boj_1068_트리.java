package general;

import java.io.*;
import java.util.*;

public class Boj_1068_트리 {
    static int n, l, cnt, root;
    static ArrayList<Integer>[] list;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList[n]; visited = new boolean[n]; int idx;
        for(int i = 0; i <n; i++)
            list[i] = new ArrayList<>();

        for(int i = 0; i < n; i++){
            idx = Integer.parseInt(st.nextToken());
            if(idx == -1) {
                root = i;
                continue;
            }
            list[idx].add(i);
        }
        l = Integer.parseInt(br.readLine());
        visited[l] = true;
        if(!visited[root]) dfs(root);

        System.out.println(cnt);
    }

    static void dfs(int x){
        if(visited[x]) return;
        visited[x] = true;
        boolean flag = true;
        for(int i = 0; i < list[x].size(); i++){
            int y = list[x].get(i);
            if(!visited[y]) {
                dfs(y);
                flag = false;
            }
        }
        if(flag) cnt++;
    }
}
