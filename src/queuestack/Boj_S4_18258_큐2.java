package queuestack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_S4_18258_큐2 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> dq = new LinkedList<>();
        int n = Integer.parseInt(br.readLine())
                ;
        while(n --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String op = st.nextToken();

            if (op.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                dq.addLast(num);
            }
            else if(op.equals("front")){
                if(dq.isEmpty()) sb.append(-1+"\n");
                else sb.append(dq.peekFirst()+"\n") ;
            }
            else if(op.equals("back")) {
                if(dq.isEmpty()) sb.append(-1+"\n");
                else sb.append(dq.peekLast()+"\n") ;
            }
            else if(op.equals("size")) {
                sb.append(dq.size()+"\n");
            }
            else if(op.equals("empty")) {
                if(dq.isEmpty()) sb.append(1+"\n");
                else sb.append(0+"\n");
            }
            else if(op.equals("pop")){
                if(dq.isEmpty()) sb.append(-1+"\n");
                else sb.append(dq.pollFirst()+"\n");
            }
        }
        System.out.println(sb);
    }
}
