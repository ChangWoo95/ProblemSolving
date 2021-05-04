package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_1208_Flatten {
    static int dumpCnt, t;
    static int[] height = new int[101];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(t = 1; t <= 10; t++) {
            dumpCnt = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens())
                height[Integer.parseInt(st.nextToken())]++;
            dump();
            Arrays.fill(height, 0);
        }
        System.out.print(sb);
    }
    static void dump(){
        int min = 0;
        int max = 0;

        for (int i = 0; i < dumpCnt; i++) {
            min = findMin();
            max = findMax();
            if(max - min <= 1) {
                sb.append("#"+t+" ").append(max-min).append('\n');
                return ;
            }
            height[max--]--;
            height[max]++;
            height[min++]--;
            height[min]++;
        }
        min = findMin();
        max = findMax();
        sb.append("#"+t+" ").append(max-min).append('\n');
    }
    static int findMin(){
        for(int i = 1; i<= 100; i++){
            if(height[i] != 0) return i;
        }
        return 0;
    }
    static int findMax(){
        for(int i = 100; i>= 1; i--){
            if(height[i] != 0) return i;
        }
        return 0;
    }
}
