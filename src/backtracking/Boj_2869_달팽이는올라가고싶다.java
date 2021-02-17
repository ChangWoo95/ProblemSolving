package backtracking;

import java.io.*;
import java.util.*;

public class Boj_2869_달팽이는올라가고싶다 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        int day = 0;

        day = (v - b - 1) / (a - b) + 1;
        System.out.println(day);
    }
}
