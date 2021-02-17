package IM;

import java.io.*;
import java.util.*;

public class Boj_2578_빙고 {
    static int[][] map;
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        map = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                delete(Integer.parseInt(st.nextToken()));
                if (isBingo()) {
                    System.out.println(cnt);
                    System.exit(0);
                }
            }
        }
    }

    static void delete(int del) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == del) {
                    map[i][j] = 0;
                    cnt++;
                    return;
                }
            }
        }
    }

    static Boolean isBingo() {
        int result = 0;
        int diagCnt1 = 0, diagCnt2 = 0;

        for (int i = 0; i < 5; i++) {
            if (map[i][i] == 0) ++diagCnt1;
            if (map[i][4 - i] == 0) ++diagCnt2;
        }
        if (diagCnt1 == 5) ++result;
        if (diagCnt2 == 5) ++result;

        int bCnt = 0;
        for (int i = 0; i < 5; i++) {
            bCnt = 0;
            for (int j = 0; j < 5; j++) {
                if (map[i][j] == 0) ++bCnt;
            }
            if (bCnt == 5) ++result;
            if (result >= 3) return true;
        }
        for (int i = 0; i < 5; i++) {
            bCnt = 0;
            for (int j = 0; j < 5; j++) {
                if (map[j][i] == 0) ++bCnt;
            }
            if (bCnt == 5) ++result;
            if (result >= 3) return true;
        }
        return false;
    }
}
