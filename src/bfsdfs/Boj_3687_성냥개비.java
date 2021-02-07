package bfsdfs;

import java.io.*;

public class Boj_3687_성냥개비 {
    static int[] numbers = { 0, 0, 1, 7, 4, 2, 0, 8, 10};
    static int n;
    static long[] dp = new long[101];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringBuilder maxs = new StringBuilder();
        CalcMin();

        for(int t = 0; t< T; t++){
            n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append(" ");
            while(n != 0){
                if(n % 2 != 0) { maxs.append("7"); n-=3; }
                else { maxs.append("1"); n-=2; }
            }
            sb.append(maxs + "\n");
            maxs.delete(0, maxs.length());
        }
        System.out.print(sb);
    }
    static void CalcMin(){
        for(int i=1; i<9; i++)
            dp[i] = numbers[i];
        dp[6] = 6;
        for(int i=9; i<101; i++){
            dp[i] = dp[i-2]*10 + numbers[2];
            for(int j=3; j<8; j++){
                dp[i] = Math.min(dp[i], dp[i-j]*10 + numbers[j]);
            }
        }
    }
}
