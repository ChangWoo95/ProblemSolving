package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_20119_클레어와물약 {
    static int n,m;
    static List<Integer>[] list;
    static int[] ind, tar;
    static int[] chk;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ind = new int[n+1];
        list = new List[n+1];
        tar = new int[n+1];
        chk = new int[n+1];

        for(int i = 1; i<=n; ++i){
            list[i] = new ArrayList<>();
        }
        for(int t = 1; t <= m; ++t){
            st = new StringTokenizer(br.readLine());
            ind[t] = Integer.parseInt(st.nextToken());
            for(int j = 1; j<=ind[t]; ++j){
                int org = Integer.parseInt(st.nextToken());
                list[org].add(t);
            }
            tar[t] = Integer.parseInt(st.nextToken());
        }

        int cnt = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        for(int i = 1; i <= cnt; ++i){
            int x = Integer.parseInt(st.nextToken());
            if(chk[x] != 0) continue;
            chk[x] = 1;
            for(int t : list[x]) {
                if(--ind[t] == 0) q.add(tar[t]);
            }
        }

        while(!q.isEmpty()){
            int x = q.poll();
            if(chk[x] != 0) continue;
            chk[x] = 1;

            for(int i : list[x]){
                if(--ind[i] == 0) q.add(tar[i]);
            }
        }
        int ans = 0;
        for(int i = 1; i <=n; ++i){
            if(chk[i] != 0) ++ans;
        }

        sb.append(ans).append("\n");
        for(int i =1; i<=n; ++i){
            if(chk[i] != 0) sb.append(i).append(" ");
        }
        System.out.print(sb);
    }
}
