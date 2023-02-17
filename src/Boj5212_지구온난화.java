import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj5212_지구온난화 {
    public static Queue<int[]> islandQueue = new LinkedList<>();
    public static int[][] d = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    public static int r;
    public static int c;
    public static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];

        for (int i = 0 ; i < r; ++i) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0 ; i < r ; ++i) {
            for (int j = 0; j < c; ++j) {
                if (map[i][j] == 'X') {
                    islandQueue.offer(new int[] {i, j});
                }
            }
        }
        bfs();
        int maxX = 0;
        int minX = 11;
        int maxY = 0;
        int minY = 11;

        for (int i = 0 ; i < r ; ++i) {
            for (int j = 0 ; j < c; ++j) {
                if (map[i][j] == 'X') {
                    maxX = Math.max(i, maxX);
                    minX = Math.min(i, minX);
                    maxY = Math.max(j, maxY);
                    minY = Math.min(j, minY);
                }

            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = minX; i <= maxX; ++i) {
            for (int j = minY; j <= maxY; ++j) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs() {
        int count = islandQueue.size();
        while ( count > 0) {
            int cx = islandQueue.peek()[0];
            int cy = islandQueue.peek()[1];
            islandQueue.poll();
            --count;

            if (isSinked(cx, cy)) {
                islandQueue.offer(new int[] {cx, cy});
            }
        }
        while (!islandQueue.isEmpty()) {
            int[] node = islandQueue.poll();
            map[node[0]][node[1]] = '.';
        }
        return;
    }

    public static boolean isSinked(int x,int y) {
        int count = 0;
        for (int i = 0 ; i < 4; ++i) {
            if (isIn(x + d[i][0], y + d[i][1])) {
                ++count;
            }
        }
        return count >= 3;
    }

    public static boolean isIn(int x,int y) {
        return x < 0 || x >= r || y < 0 || y >= c || map[x][y] == '.';
    }
}
