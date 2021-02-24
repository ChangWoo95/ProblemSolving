package general;

import java.io.*;
import java.util.*;

public class Boj_1503_세수고르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] chk = new boolean[1002];
        long minVal = Long.MAX_VALUE;
        ArrayList<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; ++i) {
            int x = Integer.parseInt(st.nextToken());
            chk[x] = true;
        }
        for (int i = 1; i < 1002; ++i) {
            if (!chk[i]) list.add(i);
        }
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                for (int k = 0; k < list.size(); k++) {
                    long val = list.get(i) * list.get(j) * list.get(k);
                    minVal = Math.min(minVal, Math.abs(n - val));
                    if (n + 1 < val) break;
                }
            }
        }
        System.out.println(minVal);
    }
}
