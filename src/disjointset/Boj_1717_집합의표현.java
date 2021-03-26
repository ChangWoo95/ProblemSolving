package disjointset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1717_집합의표현 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i = 1; i <=n; ++i){
            parent[i] = i;
        }
        while(m --> 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 0){
                union(b, c);
            } else{
                if(find(b) == find(c)) sb.append("YES").append("\n");
                else sb.append("NO").append("\n");
            }
        }
        System.out.print(sb);
    }
    static void union(int b, int c){
        int x = find(b);
        int y = find(c);
        if(x == y) return;

        if(x < y){
            parent[y] = x;
        } else parent[x] = y;
    }
    static int find(int x){
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
}
