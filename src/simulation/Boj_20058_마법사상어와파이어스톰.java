package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_20058_마법사상어와파이어스톰 {
    static int n, fireStormCnt;
    static int[][] map;
    static boolean[][] visited;
    static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int sum = 0;
    static int maxArea = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        fireStormCnt = Integer.parseInt(st.nextToken());
        n = 1 << n;
        map = new int[n][n];
        visited = new boolean[n][n];

        for (int r = 0; r < n; ++r) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < n; ++c) {
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        while (fireStormCnt-- > 0) {
            int rule = 1 << Integer.parseInt(st.nextToken());
            for (int i = 0; i < n; i += rule) {
                for (int j = 0; j < n; j += rule) {
                    fireStorm(i, j, rule);
                }
            }
            deleteIce();
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (!visited[i][j] && map[i][j] != 0) maxArea = Integer.max(maxArea, dfs(i, j));
            }
        }
        System.out.println(sum);
        System.out.println(maxArea);
    }

    static void fireStorm(int x, int y, int rule) {
        int[] list = new int[rule * rule];
        int idx = 0;
        for (int i = 0; i < rule; ++i) {
            for (int j = 0; j < rule; ++j) {
                list[idx++] = map[i + x][j + y];
            }
        }
        idx = 0;
        for (int i = rule - 1; i >= 0; --i) {
            for (int j = 0; j < rule; ++j) {
                map[x + j][y + i] = list[idx++];
            }
        }
    }

    static void deleteIce() {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (map[i][j] == 0) continue;
                int cnt = 0;
                for (int x = 0; x < 4; ++x) {
                    int nx = i + d[x][0];
                    int ny = j + d[x][1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        ++cnt;
                        continue;
                    }
                    if (map[nx][ny] == 0) ++cnt;
                }
                if (cnt > 1) list.add(new int[]{i, j});
            }
        }
        for (int i = 0; i < list.size(); ++i) {
            int x = list.get(i)[0];
            int y = list.get(i)[1];
            if (map[x][y] == 1) map[x][y] = 0;
            else --map[x][y];
        }
    }

    static int dfs(int x, int y) {
        sum += map[x][y];
        visited[x][y] = true;
        int cnt = 1;
        for (int i = 0; i < 4; ++i) {
            int nx = x + d[i][0];
            int ny = y + d[i][1];
            if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
            if (!visited[nx][ny] && map[nx][ny] != 0) {
                cnt += dfs(nx, ny);
            }
        }
        return cnt;
    }
}
