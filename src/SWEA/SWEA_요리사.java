package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_요리사 {
    static int[][] map;
    static boolean[] checked;
    static int n, min, tCnt = 0;
    static List<Integer> aList = new ArrayList<>();
    static List<Integer> bList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t <= T; t++){
            n = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;
            map = new int[n][n];
            checked = new boolean[n];
            for(int i =0; i <n; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j <n; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }
            findMinVal(0, 0);
            sb.append("#" + t + " ").append(min).append("\n");
            tCnt = 0;
        }
        System.out.println(sb);
    }

    static void findMinVal(int depth, int start){
        if(depth == n/2) {
            int aSum = 0, bSum = 0, ret;

            for(int i =0; i <n; i++){
                if(checked[i]) aList.add(i);
                else bList.add(i);
            }
            for(int i =0; i< aList.size(); i++){
                for(int j = i+1; j < aList.size(); j++){
                    aSum += map[aList.get(i)][aList.get(j)] + map[aList.get(j)][aList.get(i)];
                }
            }
            for(int i =0; i< bList.size(); i++){
                for(int j = i+1; j < bList.size(); j++){
                    bSum += map[bList.get(i)][bList.get(j)] + map[bList.get(j)][bList.get(i)];
                }
            }
            ret = Math.abs(aSum - bSum);
            min = Math.min(min, ret);
            //System.out.println(aSum + " " +  bSum);
            aList.clear(); bList.clear();
            return ;
        }
        for(int i =start; i < n; i++){
            checked[i] = true;
            findMinVal(depth + 1, i+1);
            checked[i] = false;
        }
        //checked[depth] = true;
        //findMinVal(depth + 1);
        //checked[depth] = false;
        //findMinVal(depth + 1);
    }
}
