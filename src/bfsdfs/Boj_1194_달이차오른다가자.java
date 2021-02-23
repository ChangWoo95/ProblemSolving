package bfsdfs;

import java.io.*;
import java.util.*;

public class Boj_1194_달이차오른다가자 {
    static int n, m ;
    static char[][] map;
    static boolean[][][] visited;
    static int[][] d = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    static int x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m][1 << 6]; // 비트는 a~f는
        map = new char[n][];

        for(int i = 0 ; i<n; ++i) {
            map[i] = br.readLine().toCharArray();
            for(int j = 0; j <m; ++j){
                if(map[i][j] == '0'){
                    x = i;
                    y = j;
                    map[i][j] = '.';
                }
            }
        }
        bfs();
    }
    static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y, 0, 0});
        visited[x][y][0] = true;

        while(!q.isEmpty()){
            int cx = q.peek()[0];
            int cy = q.peek()[1];
            int cnt = q.peek()[2];
            int key = q.peek()[3];

            q.poll();
            for(int i = 0 ; i < 4; ++i){
                int nx = cx + d[i][0];
                int ny = cy + d[i][1];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                if(map[nx][ny] == '1'){
                    System.out.println(cnt+1);
                    return;
                }

                if(!visited[nx][ny][key] && map[nx][ny] != '#'){
                    if(map[nx][ny] == '.') { // 점
                        visited[nx][ny][key] = true;
                        q.add(new int[]{nx, ny, cnt+1, key});
                    }
                    else {
                        char ch = map[nx][ny];
                        if(Character.isLowerCase(ch)){ // 소문자
                            int nkey = key;
                            nkey |= 1 << (ch - 'a');
                            visited[nx][ny][nkey] = true;
                            q.add(new int[]{nx, ny, cnt+1, nkey});
                        } else { // 대문자
                            ch = Character.toLowerCase(ch);
                            if( (key & 1 << (ch - 'a') ) > 0){
                                visited[nx][ny][key] = true;
                                q.add(new int[]{nx, ny, cnt+1, key});
                            }
                        }
                    }
                }

            }

        }
        System.out.println(-1);
    }
}