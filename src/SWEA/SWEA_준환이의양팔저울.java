package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_준환이의양팔저울 {
    static int n, cnt = 0, totalweight = 0;
    static int[] in, out;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int t= 1; t<= T; ++t){
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            in = new int[n];
            visited = new boolean[n];

            for(int i = 0 ; i <n; ++i) {
                in[i] = Integer.parseInt(st.nextToken());
                totalweight += in[i];
            }
            perm(0, 0, 0);
            sb.append("#").append(t).append(" ").append(cnt).append("\n");
            cnt = 0;
        }
        System.out.print(sb);
    }

    static void perm( int depth, int l, int r ){
        // 1. 뻔한 가지치기.
        if(l < r) return;
        // 2. 이미 왼쪽이 과반을 차지했다면
        /*if(l > totalweight/2) {
            cnt += preCnt[depth];
            return;
        }*/
        if(depth == n) {
            ++cnt;
            return ;
        }
        for(int i = 0 ; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                perm(depth + 1, l + in[i], r);
                if(l < r + in[i]) {
                    visited[i] = false;
                    continue;
                }
                perm(depth + 1, l, r + in[i]);
                visited[i] = false;
            }
        }
    }
}
