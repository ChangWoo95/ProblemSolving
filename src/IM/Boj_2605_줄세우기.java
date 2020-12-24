package IM;

import java.io.*;
import java.util.*;

public class Boj_2605_줄세우기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        int x;
        for (int i = 1; i <= n; i++) {
            x = Integer.parseInt(st.nextToken());
            if (x == 0) list.add(i);
            else list.add(i - x - 1, i);
        }
        for (int i = 0; i < list.size(); i++)
            sb.append(list.get(i)).append(" ");
        System.out.print(sb);
    }
}
