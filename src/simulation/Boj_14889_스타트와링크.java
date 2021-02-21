package simulation;

import java.io.*;
import java.util.*;

public class Boj_14889_스타트와링크 {
    static int n;
    static int[][] map;
    static int maxVal = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        for(int i = 0 ; i <n; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j <n; ++j){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        findMinStat(0,0,  new boolean[n]);
        System.out.println(maxVal);
    }
    static void findMinStat(int depth, int start,  boolean[] chk){
        if(depth == n>>1){
            int[] sStat = new int[n/2];
            int[] lStat = new int[n/2];
            int sIdx = 0, lIdx = 0, sSum = 0, lSum = 0;

            for(int i = 0 ; i <n; ++i){
                if(chk[i]) sStat[sIdx++] = i;
                else lStat[lIdx++] = i;
            }
            for(int i = 0 ; i <n/2; ++i){
                for(int j = i+1; j <n/2; ++j){
                    sSum += map[sStat[i]][sStat[j]] + map[sStat[j]][sStat[i]];
                    lSum += map[lStat[i]][lStat[j]] + map[lStat[j]][lStat[i]];
                }
            }
            maxVal = Integer.min(maxVal, Math.abs(sSum - lSum));
            return;
        }
        for(int i =start; i < n; ++i){
            chk[i] = true;
            findMinStat(depth + 1, i+1, chk);
            chk[i] = false;
        }
    }
}
