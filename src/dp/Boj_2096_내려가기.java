package dp;

import java.io.*;
import java.util.*;

public class Boj_2096_내려가기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[][] list = new int[n][3];
        int[] dpMax = new int[3];
        int[] dpMin = new int[3];

        st = new StringTokenizer(br.readLine());
        list[0][0] = Integer.parseInt(st.nextToken()); list[0][1] = Integer.parseInt(st.nextToken()); list[0][2] = Integer.parseInt(st.nextToken());
        dpMax[0] = list[0][0]; dpMax[1] = list[0][1]; dpMax[2] = list[0][2];
        dpMin[0] = list[0][0]; dpMin[1] = list[0][1]; dpMin[2] = list[0][2];
        int tmp1, tmp2;

        for(int i =1; i< n; i++){
            st = new StringTokenizer(br.readLine());
            list[i][0] = Integer.parseInt(st.nextToken()); list[i][1] = Integer.parseInt(st.nextToken()); list[i][2] = Integer.parseInt(st.nextToken());
            tmp1 = dpMax[0]; tmp2 = dpMax[2];
            dpMax[0] = Math.max(tmp1, dpMax[1]) + list[i][0];
            dpMax[2] = Math.max(dpMax[1], tmp2) + list[i][2];
            dpMax[1] = Math.max(Math.max(tmp1, tmp2), dpMax[1]) + list[i][1];
            tmp1 = dpMin[0]; tmp2 = dpMin[2];
            dpMin[0] = Math.min(tmp1, dpMin[1]) + list[i][0];
            dpMin[2] = Math.min(dpMin[1], tmp2) + list[i][2];
            dpMin[1] = Math.min(Math.min(tmp1, tmp2), dpMin[1]) + list[i][1];
        }

        System.out.println(Math.max(Math.max(dpMax[0], dpMax[2]), dpMax[1]) + " " + Math.min(Math.min(dpMin[0], dpMin[2]), dpMin[1]));

    }
}
