package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_0318_서로소집합 {
    static int n,m;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int t = 1; t<=T; ++t){
            sb.append("#"+t+" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            parent = new int[n+1];
            for(int i = 1; i<=n; ++i){
                parent[i] = i;
            }
            for(int i = 0; i <m; ++i){
                st = new StringTokenizer(br.readLine());
                int op = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(op == 0){
                    union(a,b);
                } else {
                    int x = find(a);
                    int y = find(b);
                    if(x == y) sb.append(1);
                    else sb.append(0);
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    static void union(int a,int b){
        a = find(a);
        b = find(b);
        if(a < b) parent[b] = a;
        else parent[a] = b;
    }
    static int find(int x){
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}
