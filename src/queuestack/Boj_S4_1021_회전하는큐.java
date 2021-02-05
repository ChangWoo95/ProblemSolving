package queuestack;

import java.util.Deque;
import java.util.LinkedList;

public class Boj_S4_1021_회전하는큐 {
    public static void main(String[] args) {
        Deque<Integer> dq = new LinkedList<>();
        dq.add(1);
        dq.add(10);
        System.out.println(dq.toArray().toString());
    }
}
