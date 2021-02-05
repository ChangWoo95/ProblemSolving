package queuestack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_S4_1158_요세푸스문제 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i<=n; i++){
            q.add(i);
        }
        sb.append("<");

        while(!q.isEmpty()){
            for(int i = 0; i < k-1; i++){
                q.add(q.poll());
            }
            if(q.size() == 1) sb.append(q.poll());
            else sb.append(q.poll() +", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}
