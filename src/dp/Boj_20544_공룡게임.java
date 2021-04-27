package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_20544_공룡게임 {
    static int n;
    static long[][][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        dp = new long[n][3][3][2];
        System.out.println(solve(0, 0,0 ,0));
    }
    static long solve(int pos, int height, int preH, int flag){
        if(pos == n-1){
            if(flag == 1) return 1;
            else return 0;
        }
        if(dp[pos][height][preH][flag] != 0) return dp[pos][height][preH][flag];
        if(height == 0){
            dp[pos][height][preH][flag] += solve(pos + 1, 0, height, flag) % 1000000007;
            dp[pos][height][preH][flag] += solve(pos + 1, 1, height, flag) % 1000000007;
            dp[pos][height][preH][flag] += solve(pos + 1, 2, height, 1) % 1000000007;
        } else if(height == 1){
            if (preH == 0) {
                dp[pos][height][preH][flag] += solve(pos + 1, 0, height, flag) % 1000000007;
                dp[pos][height][preH][flag] += solve(pos + 1, 1, height, flag) % 1000000007;
                dp[pos][height][preH][flag] += solve(pos + 1, 2, height, 1) % 1000000007;
            }
            else {
                dp[pos][height][preH][flag] += solve(pos + 1, 0, height, flag) % 1000000007;
            }
        } else if(height == 2){
            if (preH == 0) {
                dp[pos][height][preH][flag] += solve(pos + 1, 0, height, flag) % 1000000007;
                dp[pos][height][preH][flag] += solve(pos + 1, 1, height, flag) % 1000000007;
            }
            else {
                dp[pos][height][preH][flag] += solve(pos + 1, 0, height, flag) % 1000000007;
            }
        }
        return dp[pos][height][preH][flag] = dp[pos][height][preH][flag] % 1000000007;
    }
}
