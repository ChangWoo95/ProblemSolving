package general;

import java.io.*;
import java.util.*;

public class Boj_11501_주식 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; ++t) {
            long ans = 0;
            int cnt = 0;
            int n = Integer.parseInt(br.readLine());
            int[] list = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0 ; i < n; i++)
                list[i] = Integer.parseInt(st.nextToken());
            int maxVal = Integer.MIN_VALUE;

            for(int i = n-1 ; i >= 0; --i) {
                if (maxVal < list[i]) maxVal = list[i];
                else ans += maxVal - list[i];
            }

            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
