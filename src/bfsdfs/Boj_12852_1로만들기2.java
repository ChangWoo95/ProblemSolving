package bfsdfs;

import java.io.*;
import java.util.*;

public class Boj_12852_1로만들기2 {
    static class Node {
        int x;
        int t;

        Node(int time, int x) {
            this.t = time;
            this.x = x;
        }
    }

    static int[] dp = new int[1000001];
    static int[] before = new int[1000001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        sb.append(solve(n)).append("\n");

        while(n != -1){
            sb.append(n).append(" ");
            n = before[n];
        }
        System.out.print(sb);


    }

    static int solve(int x) {
        dp[1] = 0;
        before[1] = -1;

        for (int i = 2; i <= x; ++i) {
            dp[i] = dp[i - 1] + 1; // -1의 경우
            before[i] = i - 1;

            if (i % 2 == 0 && dp[i] > dp[i / 2] + 1) { // /2의 경우
                dp[i] = dp[i / 2] + 1;
                before[i] = i / 2;
            }
            if (i % 3 == 0 && dp[i] > dp[i / 3] + 1) { // /3의 경우
                dp[i] = dp[i / 3] + 1;
                before[i] = i / 3;
            }
        }
        return dp[x];
    }
}
