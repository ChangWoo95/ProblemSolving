package simulation;

import java.io.*;
import java.util.*;

public class Boj_5587_카드캡터상근이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] list = new int[2 * n + 1];
        int[] bList = new int[n];
        int[] aList = new int[n];
        boolean[] boolA = new boolean[n];
        boolean[] boolB = new boolean[n];

        for (int i = 0; i < n; ++i) {
            aList[i] = Integer.parseInt(br.readLine());
            --list[aList[i]];
        }
        int idx = 0;
        for (int i = 1; i <= 2 * n; ++i) {
            if (list[i] != -1) bList[idx++] = i;
        }
        Arrays.sort(aList);
        int aCnt = n, bCnt = n;
        int last = aList[0];
        boolA[0] = true;
        --aCnt;
        while (true) {
            boolean flag = false;
            if (aCnt == 0 || bCnt == 0) break;

            for (int i = 0; i < n; ++i) {
                if (boolB[i]) continue;
                if (last < bList[i]) {
                    last = bList[i];
                    flag = true;
                    boolB[i] = true;
                    --bCnt;
                    break;
                }
            }
            if(!flag) last = 0;
            flag = false;

            for (int i = 0; i < n; ++i) {
                if (boolA[i]) continue;
                if (last < aList[i]) {
                    last = aList[i];
                    flag = true;
                    boolA[i] = true;
                    --aCnt;
                    break;
                }
            }
            if(!flag) last = 0;
        }
        System.out.println(bCnt);
        System.out.println(aCnt);
    }
}
