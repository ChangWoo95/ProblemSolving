package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_S4_11866_요세푸스문제0 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        Deque<Integer> dq = new LinkedList<>();
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        for(int  i = 1; i<= n; i++){
            dq.add(i);
        }
        int cnt = 0;
        sb.append("<");
        while(!dq.isEmpty()){
            for(int i = 0; i< k-1; i++){
                dq.add(dq.poll());
            }
            if(dq.size() == 1) sb.append(dq.poll());
            else sb.append(dq.poll()+", ");
        }
        sb.append(">");
        System.out.println(sb);
    }
}
