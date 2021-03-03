package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1327_소트게임 {
    static class node {
        String s;
        int x;
        node(String s, int x){
            this.s = s;
            this.x = x;
        }
    }
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        String s = br.readLine().replace(" ","");
        bfs(s);
    }

    static void bfs(String s){
        Queue<node> q = new LinkedList<>();
        Set<String> set = new HashSet<>();

        char[] ss = s.toCharArray();
        Arrays.sort(ss);
        String ans = new String(ss);
        q.add(new node(s, 0));
        StringBuilder sb1  = new StringBuilder();

        while(!q.isEmpty()){
            String tmp = q.peek().s;
            int cnt = q.peek().x;
            q.poll();

            if(tmp.equals(ans)) {
                System.out.println(cnt);
                return;
            }

            if(set.contains(tmp)) continue;

            set.add(tmp);
            for(int i =0; i<=n-k; ++i){
                sb1.append(tmp, i, i+k);
                sb1.reverse();
                q.add(new node(tmp.substring(0, i) + sb1.toString()+tmp.substring(i+k) , cnt+1));
                sb1.setLength(0);
            }
        }
        System.out.println(-1);
    }
}
