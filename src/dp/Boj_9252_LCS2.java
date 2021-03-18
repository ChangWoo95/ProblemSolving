package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_9252_LCS2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s1 = br.readLine();
        String s2 = br.readLine();
        int len1 = s1.length();
        int len2 = s2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; ++i) {
            for (int j = 1; j <= len2; ++j) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        sb.append(dp[len1][len2]).append("\n");

        int i = len1;
        int j = len2;
        Stack<Character> stack = new Stack<>();
        while (i >= 1 && j >= 1) {
            // 위와 같은 경우 위로 이동
            if (dp[i][j] == dp[i - 1][j]) i--;
            // 왼쪽과 같은 경우 왼쪽으로 이동
            else if (dp[i][j] == dp[i][j - 1]) j--;
            else {
                // 대각선으로 같다면
                stack.push(s1.charAt(i-1));
                i--;
                j--;
            }
        }

        while (!stack.isEmpty())
            sb.append(stack.pop());
        System.out.println(sb);
    }
}
