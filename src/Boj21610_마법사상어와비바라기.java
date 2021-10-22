import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj21610_마법사상어와비바라기 {
    static int n, m;
    static int[][] map;
    static int[][] d = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    static List<int[]> clouds;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        clouds = new ArrayList<>();
        clouds.add(new int[]{n - 1, 0});
        clouds.add(new int[]{n - 1, 1});
        clouds.add(new int[]{n - 2, 0});
        clouds.add(new int[]{n - 2, 1});

        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int direction = Integer.parseInt(st.nextToken()) - 1;
            int moves = Integer.parseInt(st.nextToken());

            rain(direction, moves);
            copyWaterBug();
            saveClouds();
        }

        System.out.println(sumWaters());

    }

    public static int sumWaters() {
        int ret = 0;

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                ret += map[i][j];
            }
        }
        return ret;
    }
    public static void saveClouds() {
        List<int[]> ret = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (map[i][j] >= 2 && !isExist(i, j)) {
                    map[i][j] -= 2;
                    ret.add(new int[]{i, j});
                }
            }
        }
        clouds = ret;

        return;
    }

    public static boolean isExist(int x, int y) {
        for (int[] cloud : clouds) {
            if (cloud[0] == x && cloud[1] == y) return true;
        }

        return false;
    }

    public static void copyWaterBug() {
        int[][] copyMap = new int[n][];
        for(int i = 0 ; i <n; ++i) {
            copyMap[i] = map[i].clone();
        }

        for (int i = 0; i < clouds.size(); ++i) {
            int x = clouds.get(i)[0];
            int y = clouds.get(i)[1];
            int cnt = 0;

            for (int j = 0; j < 4; ++j) {
                int diagnalX = x + d[2*j + 1][0];
                int diagnalY = y + d[2*j + 1][1];
                if (isIn(diagnalX, diagnalY) && map[diagnalX][diagnalY] > 0 ) ++cnt;
            }

            copyMap[x][y] += cnt;
        }

        map = copyMap;
        return;
    }

    public static boolean isIn(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    public static void rain(int direction, int moves) {
        int moveX = d[direction][0] * moves % n;
        int moveY = d[direction][1] * moves % n;

        for (int i = 0; i < clouds.size(); ++i) {
            clouds.get(i)[0] = (clouds.get(i)[0] + moveX) % n;
            clouds.get(i)[1] = (clouds.get(i)[1] + moveY) % n;
            clouds.get(i)[0] = (clouds.get(i)[0] < 0) ? n + clouds.get(i)[0] : clouds.get(i)[0];
            clouds.get(i)[1] = (clouds.get(i)[1] < 0) ? n + clouds.get(i)[1] : clouds.get(i)[1];

            map[clouds.get(i)[0]][clouds.get(i)[1]]++;
        }
        return;
    }
}