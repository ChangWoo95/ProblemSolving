package algoStudy;

import java.io.*;
import java.util.*;

public class Boj_1806_부분합 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0, sum = 0;
        int[] list = new int[n];
        st = new StringTokenizer(br.readLine());

        for(int i =0; i <n; i++){
            list[i] = Integer.parseInt(st.nextToken());
        }

        while(true){
            if(sum >= m) {
                ans = Math.min(ans, end  - start);
                sum -= list[start++];
            }
            else if(end == n) break;
            else sum += list[end++];
        }
        if(ans != Integer.MAX_VALUE) System.out.println(ans);
        else System.out.println(0);
    }
}
