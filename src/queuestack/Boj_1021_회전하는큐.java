package queuestack;

import java.io.*;
import java.util.*;

public class Boj_1021_회전하는큐 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());

        int findnum, cnt, ans = 0;
        Deque<Integer> dq = new LinkedList<>();

        for(int i =1; i <=n; i++)
            dq.offer(i);
        st= new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()){
            findnum = Integer.parseInt(st.nextToken()); cnt = 0;

            while(!dq.isEmpty()){
                if(dq.peek() == findnum) {
                    ans += Math.min(cnt, dq.size() - cnt); dq.poll();
                    break;
                } else { dq.offerLast(dq.poll()); cnt++; }
            }
        }
        System.out.println(ans);
    }
}
