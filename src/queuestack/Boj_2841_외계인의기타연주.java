package queuestack;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Boj_2841_외계인의기타연주 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Stack<Integer>[] ss = new Stack[7];
        for(int i = 0 ; i <7; i++) ss[i] = new Stack<>();
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            if(ss[idx].isEmpty()) {
                ss[idx].push(p);
                ++ans;
                continue;
            }
            while(!ss[idx].isEmpty() && ss[idx].peek() > p){
                ss[idx].pop();
                ++ans;
            }
            if(!ss[idx].isEmpty() && ss[idx].peek() != p || ss[idx].isEmpty()){
                ss[idx].push(p);
                ++ans;
            }
        }
        System.out.println(ans);
    }
}
