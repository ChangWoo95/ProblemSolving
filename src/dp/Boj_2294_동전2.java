package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2294_동전2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] tokens = new int[n];
        int[] dp = new int[k + 1];
        for (int i = 1; i <= k; ++i) {
            dp[i] = 10001;
        }
        for (int i = 0; i < n; ++i) {
            tokens[i] = Integer.parseInt(br.readLine());
            for (int j = tokens[i]; j <= k; ++j) {
                dp[j] = Math.min(dp[j], dp[j - tokens[i]] + 1);
            }
        }
        System.out.println((dp[k] == 10001) ? -1 : dp[k]);
    }
}
