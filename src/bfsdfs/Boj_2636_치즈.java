package bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2636_치즈 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited, air;
    static int count = 0;
    static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        air = new boolean[n][m];

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) ++count;
            }
            Arrays.fill(air[i], true);
        }
        int hour = 0;
        while (count > 0) {
            ++hour;
            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{0, 0});
            visited[0][0] = true;
            air[0][0] = false;

            while (!q.isEmpty()) {
                int cx = q.peek()[0];
                int cy = q.peek()[1];
                q.poll();

                for (int k = 0; k < 4; ++k) {
                    int nx = cx + d[k][0];
                    int ny = cy + d[k][1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= m || visited[nx][ny] || map[nx][ny] == 1) continue;
                    visited[nx][ny] = true;
                    air[nx][ny] = false;
                    q.offer(new int[]{nx, ny});
                }
            }
            List<int[]> list = new ArrayList<>();

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < m; ++j) {
                    visited[i][j] = false;
                    if (map[i][j] == 1) {
                        for (int l = 0; l < 4; ++l) {
                            int airx = i + d[l][0];
                            int airy = j + d[l][1];
                            if (airx >= 0 && airx < n && airy >= 0 && airy < m && !air[airx][airy]) {
                                list.add(new int[]{i, j});
                                break;
                            }
                        }
                    }
                }
            }
            int meltingCheese = list.size();
            for (int i = 0; i < list.size(); ++i) {
                int x = list.get(i)[0];
                int y = list.get(i)[1];
                air[x][y] = false;
                map[x][y] = 0;
            }
            if (count - meltingCheese == 0) {
                System.out.println(hour + "\n" + meltingCheese);
                break;
            }
            count -= meltingCheese;
        }
    }
}
