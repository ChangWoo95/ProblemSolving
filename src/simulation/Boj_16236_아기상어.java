package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_16236_아기상어 {
    static int n;
    static int[][] map, visited;
    static int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static int sx, sy, time = 0;
    static int size = 2, cnt = 0;
    static int minDist = Integer.MAX_VALUE;
    static int minX, minY, maxVal = 401;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        visited = new int[n][n];

        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sx = i;
                    sy = j;
                    map[i][j] = 0;
                }
            }
        }

        while (true) {
            minDist = Integer.MAX_VALUE;
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            for(int i = 0 ; i < n; ++i){
                Arrays.fill(visited[i], -1);
            }

            getTime();

            if (minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
                time += visited[minX][minY];

                ++cnt;

                if (cnt == size) {
                    ++size;
                    cnt = 0;
                }
                map[minX][minY] = 0;
                sx = minX;
                sy = minY;
            } else break;

        }

        System.out.println(time);
    }

    static void getTime() {
        Queue<int[]> q = new LinkedList<>();
        visited[sx][sy] = 0;
        q.add(new int[]{sx, sy});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int cx = node[0];
            int cy = node[1];
            for (int i = 0; i < 4; ++i) {
                int nx = cx + d[i][0];
                int ny = cy + d[i][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n) continue;
                if (visited[nx][ny] != -1 || map[nx][ny] > size) continue;
                visited[nx][ny] = visited[cx][cy] + 1;
                if (map[nx][ny] != 0 && map[nx][ny] < size) {
                    if (minDist > visited[nx][ny]) {
                        minX = nx;
                        minY = ny;
                        minDist = visited[nx][ny];
                    } else if (minDist == visited[nx][ny]) {
                        if (minX == nx && minY > ny) {
                            minX = nx;
                            minY = ny;
                        } else if (minX > nx) {
                            minX = nx;
                            minY = ny;
                        }
                    }
                }
                q.add(new int[]{nx, ny});
            }
        }
    }
}
