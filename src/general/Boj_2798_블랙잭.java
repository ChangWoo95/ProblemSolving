package general;

import java.io.*;
import java.util.*;

public class Boj_2798_블랙잭 {
    static int[] input;
    static int[] output = new int[3];
    static int ans = Integer.MIN_VALUE;
    static int sum = 0;
    static int n,m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new int[n];

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            input[i] = Integer.parseInt(st.nextToken());
        }
        findMax(0, 0);
        System.out.println(ans);
    }

    static void findMax(int depth, int start) {
        if(depth == 3){
            sum = 0;
            for(int i=0; i< 3; i++)
                sum += output[i];
            if(sum <= m)
                ans = Math.max(ans, sum);
            return;
        }
        for(int i =start; i < input.length; i++){
                output[depth] = input[i];
                findMax(depth+1, i+1);
        }
    }
}
