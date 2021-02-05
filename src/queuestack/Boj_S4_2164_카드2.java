package queuestack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Boj_S4_2164_카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> dq = new LinkedList<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++){
            dq.addLast(i); //뒤에서부터 집어넣는다는 의미
        }
        while(dq.size() != 1) {
            dq.remove();
            dq.add(dq.pollFirst());
        }
        System.out.println(dq.poll());

    }
}
