package disjointset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10775_공항 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        for(int i = 1; i<=n; ++i){
            parent[i] = i;
        }
        int m = Integer.parseInt(br.readLine());
        int cnt = 0;
        while(m --> 0){
            int x = Integer.parseInt(br.readLine());
            x = find(x);
            if(x != 0){
                ++cnt;
                union(x, x-1);
            } else break;
        }
        System.out.print(cnt);
    }
    static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    static void union(int a,int b){
        a = find(a);
        b = find(b);
        parent[a] = b;
    }
}
