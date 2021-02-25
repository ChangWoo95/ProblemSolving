package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2669_직사각형네개의합집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] map = new boolean[101][101];

        for(int t = 0; t < 4; ++t){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int i = 100 -y2; i < 100 -y1; ++i){
                for(int j = x1; j <x2; ++j){
                    map[i][j] = true;
                }
            }
        }
        int cnt = 0;
        for(int i = 0 ; i < 101; ++i){
            for(int j = 0; j < 101; ++j){
                if(map[i][j]) ++cnt;
            }
        }
        System.out.println(cnt);
    }
}
