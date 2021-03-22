package disjointset;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1976_여행가자 {
    static  int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        parent = new int[n+1];
        for(int i = 1; i <=n; ++i){
            parent[i] = i;
        }
        for(int i = 1; i<=n; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j<=n; ++j){
                int x = Integer.parseInt(st.nextToken());
                if(x == 1){
                    if(find(i) != find(j)){
                        union(i, j);
                    }
                }
            }
        }
        int[] travel = new int[m+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <=m; ++i){
            travel[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i<=m-1; ++i){
            int a = find(travel[i]);
            int b = find(travel[i+1]);
            if(a != b){
                System.out.println("NO");
                System.exit(0);
            }
        }
        System.out.println("YES");
    }
    static int find(int x){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
    static void union(int i, int j){
        i = find(i);
        j = find(j);
        if(i == j) return;
        if(i < j) parent[j] = i;
        else parent[i] = j;
    }
}
