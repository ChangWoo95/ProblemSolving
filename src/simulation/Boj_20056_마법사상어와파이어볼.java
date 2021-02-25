package simulation;

import java.io.*;
import java.util.*;

public class Boj_20056_마법사상어와파이어볼 {
    static int n;
    static ArrayList<int[]>[][] map;
    static int[][] d = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new ArrayList[n+1][n+1];

        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                map[i][j] = new ArrayList<>();
            }
        }

        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y].add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        while (k-- > 0) {
            ArrayList<int[]>[][] copymap = new ArrayList[n+1][n+1];
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    copymap[i][j] = new ArrayList<>();
                    for(int s = 0 ; s < map[i][j].size(); ++s)
                        copymap[i][j].add(map[i][j].get(s).clone());
                    map[i][j].clear();
                }
            }
            move(copymap);

            copymap = new ArrayList[n+1][n+1];
            for (int i = 1; i <= n; ++i) {
                for (int j = 1; j <= n; ++j) {
                    copymap[i][j] = new ArrayList<>();
                    for(int s = 0 ; s < map[i][j].size(); ++s)
                        copymap[i][j].add(map[i][j].get(s).clone());
                    map[i][j].clear();
                }
            }
            split(copymap);
        }
        int answer = 0;
        for(int i = 1; i <= n; ++i){
            for(int j = 1; j<=n; ++j){
                for(int l = 0 ; l < map[i][j].size(); ++l){
                    answer += map[i][j].get(l)[0];
                }
            }
        }
        System.out.println(answer);
    }

    static void move(ArrayList<int[]>[][] copymap) {
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                for(int k = 0; k < copymap[i][j].size(); ++k){
                    int m = copymap[i][j].get(k)[0]; int s = copymap[i][j].get(k)[1]; int dir = copymap[i][j].get(k)[2];
                    int x = ((i + d[dir][0] *  s) % n + n) % n + 1;
                    int y = ((j + d[dir][1] *  s) % n + n) % n + 1;
                    map[x][y].add(new int[]{m , s, dir});
                }
            }
        }

    }

    static void split(ArrayList<int[]>[][] copymap){
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= n; ++j) {
                if(copymap[i][j].size() >= 2) {
                    int mSum = 0;
                    int sSum = 0;
                    for(int k = 0 ; k < copymap[i][j].size(); ++k){
                        mSum += copymap[i][j].get(k)[0];
                        sSum += copymap[i][j].get(k)[1];
                    }
                    mSum /= 5;
                    if(mSum == 0) continue;
                    sSum /= copymap[i][j].size();
                    if(isOddEven(copymap[i][j])){
                        for(int k = 0; k < 4; ++k){
                            map[i][j].add(new int[]{mSum, sSum, k*2});
                        }
                    } else {
                        for(int k = 0; k < 4; ++k){
                            map[i][j].add(new int[]{mSum, sSum, k*2 + 1});
                        }
                    }
                } else if(copymap[i][j].size() == 1) {
                    map[i][j].add(copymap[i][j].get(0).clone());
                }
            }
        }
    }

    static boolean isOddEven(ArrayList<int[]> list){
        int oddCnt = 0;
        int evenCnt = 0;
        for(int i = 0 ; i < list.size(); ++i){
            if( list.get(i)[2] % 2 == 0) ++evenCnt;
            else ++oddCnt;
        }
        if(evenCnt == 0 || oddCnt == 0) return true;
        else return false;
    }
}

