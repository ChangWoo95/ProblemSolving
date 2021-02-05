package queuestack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_S4_15828_Router {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();

        while(true) {
            int num = Integer.parseInt(br.readLine());
            if(num == -1) break; // -1은 더 이상 입력이 없다는 의미이므로 탈출

            if(num == 0) q.remove(); // 0은 q가 비어있지 않을 때만 나오므로 그대로 하나 빼준다.
            else {
                if(q.size() >= n) continue; // 큐가 꽉 찼다면 넘김
                q.add(num);
            }
        }

        if(q.isEmpty()) System.out.println("empty");
        else {
            while(!q.isEmpty()) {
                System.out.printf("%d ", q.poll());
            }
        }
    }
}
