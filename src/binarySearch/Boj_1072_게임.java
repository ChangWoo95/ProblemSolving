package binarySearch;

import java.io.*;
import java.util.*;

/**
* @since 2021-02-01
* @author ChangWoo95
* @see https://www.acmicpc.net/problem/1072
* @time 176 ms
* @mem 16612 KB
* @caution
*/

public class Boj_1072_게임 {
    static long rate;
    static long x, y;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());
        rate = y * 100 / x;
        if(x == y || rate >= 99) {
            System.out.println(-1);
            System.exit(0);
        }
        binarySearch();
        System.out.println(ans);

    }

    static void binarySearch(){
        long low = 0;
        long high = 1000000000;
        long mid = 0;

        while(low <= high) {
            mid = (low + high) / 2;
            long result = (y + mid) * 100 / (x + mid);
            if(result > rate) {
                high = mid - 1;
                ans = mid;
            }
            else low = mid + 1;
        }
    }
}
