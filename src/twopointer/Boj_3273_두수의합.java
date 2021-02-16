package twopointer;

import java.io.*;
import java.util.*;

public class Boj_3273_두수의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        Set<Integer> s = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i =0; i <n; i++)
            s.add(Integer.parseInt(st.nextToken()));

        Arrays.sort(list);

        int m = Integer.parseInt(br.readLine());
        int start = 0, end = 0, sum = 0, count = 0;

        while(true) {
            if(sum >= m) sum -= list[start++];
            else if(end == n) break;
            else sum += list[end++];
            if(sum == m) count++;
        }

        System.out.println(count);
    }
}
