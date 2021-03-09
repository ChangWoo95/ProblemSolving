package priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_2014_소수의곱 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] list = new int[n];
        PriorityQueue<Long> pq = new PriorityQueue<>();

        long head = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; ++i){
            list[i] = Integer.parseInt(st.nextToken());
            pq.add((long) list[i]);
        }

        for(int i = 0 ; i < k; ++i){
            head = pq.poll();
            for(int j = 0; j < n; ++j){
                long value = head * list[j];
                pq.add(value);

                if(head % list[j] == 0) break;
            }
        }
        System.out.println(head);
    }
}