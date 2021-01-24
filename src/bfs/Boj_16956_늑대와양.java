package bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16956_늑대와양 {
    static int R;
    static int C;
    static char[][] pasture;
    static int[][] deltas = {{0, 1}, {0,-1}, {-1,0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        pasture = new char[R][C];
        String s;
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < R; i++){
            s = br.readLine();
            for(int j = 0; j<s.length(); j++){
                if(s.charAt(j) == '.') pasture[i][j] = 'D';
                else pasture[i][j] = s.charAt(j);
            }
        }

        if(isDied()) sb.append(0);
        else {
            sb.append(1).append("\n");
            for(int i = 0; i< R; i++) {
                sb.append(pasture[i]).append("\n");
            }
        }
        System.out.println(sb);
    }

    static boolean isIn(int x, int y){
        if(x >= 0 && x < R && y >= 0 && y < C) return true;
        return false;
    }

    static boolean isDied() {
        for(int i = 0; i< R; i++){
            for(int j = 0; j < C; j++){
                if(pasture[i][j] != 'S') continue;

                for(int k = 0; k < 4; k++){
                    int nx = i + deltas[k][0];
                    int ny = j + deltas[k][1];
                    if(!isIn(nx, ny)) continue;
                    if(pasture[nx][ny] == 'W') return true;
                }
            }
        }
        return false;
    }
}
