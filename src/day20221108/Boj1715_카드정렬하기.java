package day20221108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj1715_카드정렬하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0 ; i < n; ++i) {
            pq.offer(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;

        if(pq.size() == 1) {
            cnt = 0;
        } else {
            while (!pq.isEmpty()) {
                int a = pq.poll();
                int b = pq.poll();
                cnt += a + b;

                if (pq.size() == 0) {
                    break;
                }

                pq.offer(a + b);
            }
        }

        System.out.println(cnt);
    }
}
