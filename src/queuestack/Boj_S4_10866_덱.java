package queuestack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Boj_S4_10866_덱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> dq = new LinkedList<>();

        while(n --> 0) {
            st = new StringTokenizer(br.readLine());
            String op = st.nextToken();
            switch(op) {
                case "push_back":
                    dq.add(Integer.parseInt(st.nextToken()));
                    break;
                case  "push_front":
                    dq.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "front":
                    if(dq.isEmpty()) sb.append(-1+"\n");
                    else sb.append(dq.peek() + "\n");
                    break;
                case "back":
                    if(dq.isEmpty()) sb.append(-1+"\n");
                    else sb.append(dq.peekLast() + "\n");
                    break;
                case "size":
                    sb.append(dq.size()+"\n");
                    break;
                case "empty":
                    if(dq.isEmpty()) sb.append(1+"\n");
                    else sb.append(0+"\n");
                    break;
                case "pop_front":
                    if(dq.isEmpty()) sb.append(-1+"\n");
                    else sb.append(dq.poll()+"\n");
                    break;
                case "pop_back":
                    if(dq.isEmpty()) sb.append(-1+"\n");
                    else sb.append(dq.pollLast()+"\n");
                    break;
            }
        }
        System.out.println(sb);
    }
}
