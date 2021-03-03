package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14613_너의티어는 {
    static double wRate, lRate, dRate;
    static double [][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        wRate = Double.parseDouble(st.nextToken());
        lRate = Double.parseDouble(st.nextToken());
        dRate = Double.parseDouble(st.nextToken());
        dp = new double[22][3500];
        dp[0][2000] = 1.0;

        for(int i = 1; i<= 20; ++i){
            for(int j = 1000; j<= 3000; ++j){
                if(dp[i-1][j] == 0) continue;

                dp[i][j- 50] += dp[i-1][j]*lRate;
                dp[i][j + 50] += dp[i-1][j]*wRate;
                dp[i][j] += dp[i-1][j]*dRate;
            }
        }

        double ans = 0.0;
        StringBuilder sb = new StringBuilder();
        for(int i = 1000; i <=3499; ++i){
            ans += dp[20][i];
            if (i == 1499 || i == 1999 || i == 2499 || i == 2999 || i == 3499) {
                sb.append(String.format("%.8f", ans)).append("\n");
                ans = 0.0;
            }
        }

        System.out.print(sb);
    }
}
