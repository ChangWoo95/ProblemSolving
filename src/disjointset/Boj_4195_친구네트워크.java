package disjointset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_4195_친구네트워크 {

    static int[] parent, lev;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        while(n --> 0) {
            int m = Integer.parseInt(br.readLine());
            parent = new int[m * 2];
            lev = new int[m * 2];
            for (int i = 0; i < m * 2; ++i) {
                parent[i] = i;
                lev[i] = 1;
            }
            int idx = 0;
            Map<String, Integer> map = new HashMap<>();

            while (m-- > 0) {
                st = new StringTokenizer(br.readLine());
                String s1 = st.nextToken();
                String s2 = st.nextToken();
                if (!map.containsKey(s1)) map.put(s1, idx++);
                if (!map.containsKey(s2)) map.put(s2, idx++);

                sb.append(union(map.get(s1), map.get(s2))).append("\n");
            }
        }
        System.out.print(sb);
    }

    static int union(int b, int c) {
        int x = find(b);
        int y = find(c);
        if (x != y) {
            parent[y] = x;
            lev[x] += lev[y];
        }
        return lev[x];
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

}
