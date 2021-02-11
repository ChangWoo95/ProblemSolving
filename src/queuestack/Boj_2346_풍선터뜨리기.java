package queuestack;

import java.io.*;
import java.util.*;

public class Boj_2346_풍선터뜨리기 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());

        Deque<Integer[]> dq = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            dq.offer(new Integer[] { Integer.parseInt(st.nextToken()), i });

        while (true) {
            Integer[] arr = dq.poll();
            sb.append(arr[1] + " ");
            if(dq.isEmpty()) break;
            int move = arr[0];
            if (move < 0) {
                move *= -1;
                while (move-- > 0)
                    dq.offerFirst(dq.pollLast());
            } else {
                move--;
                while (move-- > 0)
                    dq.offer(dq.poll());
            }
        }
        System.out.print(sb);
    }
}
