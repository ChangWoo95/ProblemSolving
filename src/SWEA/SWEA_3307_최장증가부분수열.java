package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class SWEA_3307_최장증가부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; ++t) {
            int n = Integer.parseInt(br.readLine());
            int[] list = new int[n];
            ArrayList<Integer> dp = new ArrayList<>();
            dp.add(Integer.MIN_VALUE);
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; ++i) {
                list[i] = Integer.parseInt(st.nextToken());
                if (dp.get(dp.size() - 1) < list[i]) {
                    dp.add(list[i]);
                } else {
                    int left = 1, right = dp.size() - 1;

                    while (left < right) {
                        int mid = (left + right) / 2;
                        if (dp.get(mid) >= list[i]) right = mid;
                        else left = mid + 1;
                    }
                    dp.set(right, list[i]);
                }
            }
            sb.append("#" + t + " " + (dp.size() - 1)).append("\n");
        }
        System.out.print(sb);
    }
}
