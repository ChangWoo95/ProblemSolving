package backtracking;

import java.io.*;
import java.util.*;

public class Boj_1182_부분수열의합 {
    static int n, m, cnt = 0, ans = 0;
    static int[] list;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new int[n];
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i =0; i <n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }
        func(0);
        System.out.print(ans);
    }
    static void func(int depth) {
        if(depth == n) {
            long sum = 0;
            boolean flag = false;
            for(int i =0; i <n; i++){
                if(visited[i]) {
                    sum += list[i];
                    flag = true;
                }
            }
            System.out.println(Arrays.toString(visited));
            if(flag && sum == m) ans++;
            cnt++;
            return;
        }
        visited[depth] = true;
        func(depth + 1);
        visited[depth] = false;
        func(depth + 1);
    }
}
