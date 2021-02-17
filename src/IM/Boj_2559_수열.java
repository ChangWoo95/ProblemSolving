package IM;

import java.io.*;
import java.util.*;

public class Boj_2559_수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        int result = 0;
        int[] list = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++)
            list[i] = Integer.parseInt(st.nextToken());

        int s = 0;
        int sum = 0;
        for (int i = s; i < s+day; i++) {
            sum += list[i];
        }
        result = sum;

        while (true) {
            sum -= list[s];
            if (s+day >= n) break;
            sum += list[s+day];
            if (sum > result) result = sum;
            s++;
        }
        System.out.println(result);
    }
}
