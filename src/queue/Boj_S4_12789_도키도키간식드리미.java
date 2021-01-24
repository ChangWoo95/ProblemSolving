package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_S4_12789_도키도키간식드리미 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        Stack<Integer> s = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            q.add(Integer.parseInt(st.nextToken()));
        }
        int start = 1;

        while(!q.isEmpty()) { // step1. 큐가 비어있지 않을 동안 순서대로 빼내기
            if(q.peek() != start) {
                if(!s.isEmpty() && s.peek() == start) { // q에 알맞은 순서의 숫자가 없을 때, 스택 안에 있는지 확인, 있다면 빼내면서 비교값 증가
                    s.pop();
                    start++;
                }
                else s.push(q.poll());
            } else {
                q.remove();
                start++;
            }
        }

        while(!s.isEmpty()) { // step2. 큐를 다 비운 시점에서 스택의 top에 현재 순서에 맞는 숫자가 없다면 그 순서들은 실패했다는 걸 의미
            if(s.peek() != start) {
                System.out.println("Sad");
                System.exit(0);
            } else {
                s.pop();
                start++;
            }
        }
        System.out.println("Nice");
    }
}
