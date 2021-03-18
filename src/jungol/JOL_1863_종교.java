package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class JOL_1863_종교 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i = 1; i <=n; ++i){
            parent[i] = i;
        }
        for(int i = 0 ; i < m; ++i){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            union(x,y);
        }

        Set<Integer> s = new HashSet<>();
        for(int i = 1; i<=n; ++i){
            s.add(find(parent[i]));
        }
        System.out.println(s.size());
    }
    static void union(int a,int b){
        a = find(a);
        b = find(b);
        if(a == b) return;
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}
