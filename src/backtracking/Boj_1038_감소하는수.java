package backtracking;

import java.io.*;
import java.util.*;

public class Boj_1038_감소하는수 {
    static int n;
    static char[] nums = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    static char[] output = new char[11];
    static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < 10; i++)
            list.add(String.valueOf(nums[i]));
        for (int i = 2; i < 11; i++) { // 자릿수 의미
            comb(0, i);
        }
        if (1022 < n) System.out.println(-1);
        else System.out.println(list.get(n));
    }

    static void comb(int depth, int end) {
        if (depth == end) {
            list.add(String.valueOf(output).substring(0, end));
            return;
        }
        for (int i = 0; i < 10; i++) {
            if (depth >= 1 && output[depth - 1] <= nums[i]) continue;
            output[depth] = nums[i];
            comb(depth + 1, end);
        }
    }
}
