package bfsdfs;

import java.io.*;
import java.util.*;

public class Boj_16234_인구이동 {
    static int n, l, r;
    static int[][] map;
    static int[][] visited;
    static int[][] d = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
    static int move = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        visited = new int[n][n];

        for(int i = 0 ; i <n; ++i){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j <n; ++j)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        while(true){
            // 연합 구하기
            int idx = 1;
            for(int i = 0 ; i <n; ++i){
                for(int j = 0 ; j <n; ++j){
                    if(visited[i][j] == 0) bfs(i, j, idx++);
                }
            }
            if(move == 0) {
                System.out.println(ans);
                break;
            }
            else ++ans;
            move = 0;
            for(int i = 0 ; i <n; ++i){
                Arrays.fill(visited[i], 0);
            }
        }
    }

    static void bfs(int x, int y, int idx){
        Queue<int[]> q = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        q.add(new int[]{x, y});
        visited[x][y] = idx;
        int val = 0; int cnt = 0;

        while(!q.isEmpty()){
            int cx = q.peek()[0];
            int cy = q.peek()[1];
            q.poll();
            val += map[cx][cy];
            ++cnt;
            list.add(new int[]{cx, cy});
            for(int i = 0 ; i <4; ++i){
                int nx = cx + d[i][0];
                int ny = cy + d[i][1];
                if(nx >=0 && nx < n && ny >=0 && ny < n &&  visited[nx][ny] == 0){
                    int diff = Math.abs(map[cx][cy] - map[nx][ny]);
                    if(l <= diff && diff <= r) {
                        visited[nx][ny] = idx;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
        if(list.size() >= 2){
            ++move;
            val/=cnt;
            for(int i = 0 ; i < list.size(); ++i){
                map[list.get(i)[0]][list.get(i)[1]] = val;
            }
        }
    }

}
