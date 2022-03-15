package simulation;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2303_숫자게임 {

    public static int maxValue;
    public static final int MAX_COUNT = 5;
    public static final int MAX_DEPTH = 3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Point[] arr = new Point[n];

        for(int i  = 0 ; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] numbers = new int[MAX_COUNT];

            for(int j = 0 ; j <5; ++j) {
                numbers[j] = Integer.parseInt(st.nextToken());
            }

            maxValue = -1;
            combination(0, 0, 0, numbers);
            arr[i] = new Point(i+1, maxValue);
        }
        Arrays.sort(arr, (x1, x2) -> {
            if(x1.y != x2.y) return Integer.compare(x2.y, x1.y);
            else return Integer.compare(x2.x, x1.x);
        });
        System.out.println(arr[0].x);
    }

    public static void combination(int depth, int start, int val, int[] numbers) {
        if(depth == MAX_DEPTH) {
            maxValue = Math.max(maxValue, val % 10);
            return;
        }

        for(int i = start; i < numbers.length; ++i) {
            int value = numbers[i];
            combination(depth + 1, i + 1, val + value, numbers);
        }
        return;
    }
}
