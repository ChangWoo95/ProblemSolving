package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_S4_10845_큐 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        while(n --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            if(order.equals("push")) {
                q.add(Integer.parseInt(st.nextToken()));
            }
            else if(order.equals("front")) {
                if(q.isEmpty()) System.out.println(-1);
                else System.out.println(q.peek().intValue());
            }
            else if(order.equals("back")) {
                if(q.isEmpty()) System.out.println(-1);
                else System.out.println(q.toArray()[q.size() - 1]);
            }
            else if(order.equals("size")) {
                System.out.println(q.size());
            }
            else if(order.equals("pop")) {
                if(q.isEmpty()) System.out.println(-1);
                else System.out.println(q.poll());
            } else {
                if(q.isEmpty()) System.out.println(1);
                else System.out.println(0);
            }
        }
    }
}
