package bfsdfs;

import java.io.*;
import java.util.*;

public class Boj_9466_텀프로젝트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t= 0; t<T; t++){
           int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] visited = new int[n+1], list = new int[n+1], num = new int[n+1];
            for(int i = 1; i<=n; i++)
                list[i] = Integer.parseInt(st.nextToken()); // 입력 받기
            int ans = 0;
            for(int i = 1; i<=n; i++){
                if(visited[i] >0) continue; // 이미 방문했던 곳이면 넘김
                visited[i] = i; // 방문 처리
                int nxt = list[i]; // 다음 이동할 곳
                int cnt = 0;
                num[i] = cnt++; // 이동할 곳마다 카운트를 매김

                while(visited[nxt] == 0){ // 방문하지
                    visited[nxt] = i; // 일종의 백트래킹으로 이용하기 위함
                    num[nxt] = cnt++;
                    nxt = list[nxt];
                }
                if(i!=visited[nxt]) ans+=cnt; // 자기 자신이 나오지 않았기 때문에 사이클 x
                else ans += num[nxt]; // 완벽한 사이클
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
