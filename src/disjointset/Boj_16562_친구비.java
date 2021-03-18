package disjointset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_16562_친구비 {
    static int[] parent, money;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];
        money = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; ++i) {
            money[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= n; ++i) {
            parent[i] = i;
        }
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }
        int ans = 0;
        for (int i = 1; i <= n; ++i) {
            if (find(i) == i) {
                ans += money[i];
                if (k < ans) {
                    System.out.println("Oh no");
                    System.exit(0);
                }
            }
        }

        System.out.println(ans);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;

        if (money[a] < money[b]) parent[b] = a;
        else parent[a] = b;
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}
