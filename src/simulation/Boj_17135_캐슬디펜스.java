package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17135_캐슬디펜스 {
    static int n, m, d;
    static int[][] map;
    static int enermy = 0, kCnt = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        map = new int[n+1][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) enermy++;
            }
        }
        findRangerComb(0, 0);
        System.out.println(kCnt);
    }
    static void findRangerComb(int depth, int start){
        if(depth == 3){
            int[][] copymap = new int[n+1][];
            int copyEnermy = enermy;
            for(int i = 0; i <=n; i++) copymap[i] = map[i].clone();
            game(copymap, copyEnermy);
            return;
        }
        for(int i =start; i<m; i++){
            map[n][i] = 2;
            findRangerComb(depth+1, i+1);
            map[n][i] = 0;
        }
    }
    static void game(int[][] copymap, int copyEnermy){
        int cnt = 0;
        while(copyEnermy > 0) {
            for (int idx = 0; idx < m; idx++) {
                if(copymap[n][idx] == 2){ // 선택되었다면
                    int minDist = Integer.MAX_VALUE;
                    int[] fir = {-1, -1};
                    for(int i = 0 ; i <n; i++){
                        for(int j = 0 ; j < m; j++){
                            if(copymap[i][j] != 0) {
                                int dist = Math.abs(n - i) + Math.abs(idx - j);
                                if (dist <= d) {
                                    if (dist < minDist) {
                                        fir[0] = i;
                                        fir[1] = j;
                                    } else if (dist == minDist && j < fir[1]) {
                                        fir[0] = i;
                                        fir[1] = j;
                                    }
                                    minDist = Math.min(minDist, dist);
                                }
                            }
                        }
                    }
                    if(fir[0]!= -1 && copymap[fir[0]][fir[1]] == 1) copymap[fir[0]][fir[1]] = -1;
                }
            }
            for(int i = n-1; i >=0; i--){ // 제거 및 카운트.
                for(int j = 0; j<m; j++){
                    if(copymap[i][j] == 0) continue;
                    if(copymap[i][j] < 0) {
                        --copyEnermy;
                        ++cnt;
                    }
                    else if(copymap[i][j] == 1){
                        if(i+1 == n) --copyEnermy;
                        else copymap[i+1][j] = 1;
                    }
                    copymap[i][j] = 0;
                }
            }
        }
        kCnt = Math.max(kCnt, cnt);
    }
}
