package day20221121;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Boj1253_좋다 {
    public static int[] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < n; ++i) {
            map[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(map);

        int count = 0;
        for (int i = 0 ; i <n; ++i) {
                if (isGoodNumber(i, 0, n-1)) ++count;
        }

        System.out.println(count);
    }

    public static boolean isGoodNumber(int idx, int left, int right) {
        int result = map[idx];
        long sum = 0;

        while (left < right) {
            if (left == idx) ++left;
            else if (right == idx) --right;
            else {
                sum = map[left] + map[right];

                if (result > sum) ++left;
                else if (result < sum) --right;
                else return true;
            }
        }
        return false;
    }
}
