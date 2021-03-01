package bitmasking;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_9328_열쇠 {
    static char[][] map;
    static boolean[][] visited;
    static boolean[] key;
    static int n, m, maxCnt;
    static ArrayList<int[]>[] list;
    static int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            maxCnt = 0;
            map = new char[n + 2][m + 2];
            visited = new boolean[n + 2][m + 2];
            key = new boolean[26];
            list = new ArrayList[26];

            for (int i = 0; i < 26; ++i) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < n + 2; ++i) {
                for (int j = 0; j < m + 2; ++j) {
                    map[i][j] = '.';
                }
            }

            for (int i = 1; i <= n; ++i) {
                String s = br.readLine();
                for (int j = 1; j <= m; ++j) {
                    map[i][j] = s.charAt(j - 1);
                }
            }

            String s = br.readLine();
            for (int i = 0; i < s.length(); ++i) {
                if (s.charAt(i) == '0') break;
                key[s.charAt(i) - 'a'] = true;
            }

            bfs();
            sb.append(maxCnt).append("\n");
        }
        System.out.print(sb);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {

            int cx = q.peek()[0];
            int cy = q.peek()[1];
            q.poll();

            for (int i = 0; i < 4; ++i) {
                int nx = cx + d[i][0];
                int ny = cy + d[i][1];

                if (nx < 0 || nx >= n+2 || ny < 0 || ny >= m+2 ) continue;
                if (visited[nx][ny] || map[nx][ny] == '*') continue;

                if (map[nx][ny] == '$') {
                    ++maxCnt;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                } else if (Character.isUpperCase(map[nx][ny])) {
                    if (key[map[nx][ny] - 'A']) {
                        map[nx][ny] = '.';
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    } else {
                        list[map[nx][ny] - 'A'].add(new int[]{nx, ny});
                    }
                } else if (map[nx][ny] == '.') {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                } else {
                    key[map[nx][ny] - 'a'] = true;
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});

                    for (int j = 0; j <= 25; j++) {
                        if (list[j].size() != 0 && key[j]) {
                            for (int z = 0; z < list[j].size(); z++) {
                                int x = list[j].get(z)[0];
                                int y = list[j].get(z)[1];

                                map[x][y] = '.';
                                visited[x][y] = true;
                                q.add(new int[]{x, y});
                            }
                        }
                    }
                }

            }
        }
    }
}
