package general;

import java.io.*;
import java.util.*;

public class Boj_2110_공유기설치 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] list = new int[n];
        for (int i = 0; i < n; ++i)
            list[i] = Integer.parseInt(br.readLine());
        Arrays.sort(list);

        int ans = -1;
        int low = 1, high = list[list.length - 1] - list[0], mid;
        while (low <= high) {
            mid = (high + low) / 2;
            int start = list[0];
            int cnt = 1;
            for(int i = 0 ; i <n; ++i){
                int dist = list[i] - start;
                if(mid <= dist){
                    ++cnt;
                    start = list[i];
                }
            }

            if (cnt >= m) {
                ans = mid;
                low = mid + 1;
            }
            else high = mid - 1;
        }
        System.out.print(ans);
    }
}
