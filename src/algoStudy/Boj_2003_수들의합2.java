package algoStudy;

import java.io.*;
import java.util.*;

public class Boj_2003_수들의합2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] list = new int[n];
        int start = 0, end = 0, sum = 0, cnt = 0;
        st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < n; i++)
            list[i] = Integer.parseInt(st.nextToken());

        while(true) {
            if(sum >= m) sum -= list[start++];
            else if(end == n) break;
            else sum += list[end++];
            if(sum == m) cnt++;
        }
        System.out.print(cnt);
    }
}
