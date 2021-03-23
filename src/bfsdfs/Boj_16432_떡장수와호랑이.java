package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_16432_떡장수와호랑이 {
    static List<Integer>[] list;
    static boolean[][] visited;
    static int[] output;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new List[n + 1];
        for (int i = 1; i <= n; ++i) {
            list[i] = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            for (int j = 0; j < m; ++j) {
                list[i].add(Integer.parseInt(st.nextToken()));
            }
        }
        output = new int[n + 1];
        visited = new boolean[n + 2][10];
        dfs(1, 0);
        System.out.println(-1);
    }

    static void dfs(int start, int prev) {
        if (start == n + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; ++i) {
                sb.append(output[i]).append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }

        for (int i = 1; i < 10; ++i) {
            if (i != prev && !visited[start + 1][i] && list[start].contains(i)) {
                visited[start + 1][i] = true;
                output[start] = i;
                dfs(start + 1, i);
            }
        }
    }
}
