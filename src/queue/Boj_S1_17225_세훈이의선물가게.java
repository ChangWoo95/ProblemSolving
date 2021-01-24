package queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_S1_17225_세훈이의선물가게 {

    static class Order implements Comparable<Order> {
        int time;
        char type;

        public Order(int time, char type) {
            this.time =time;
            this.type = type;
        }

        @Override
        public int compareTo(Order target) {
            if(this.time == target.time)  return target.type - this.type;
            return this.time - target.time;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Order> pq = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int smSpeed = Integer.parseInt(st.nextToken());
        int jsSpeed = Integer.parseInt(st.nextToken());
        int customers = Integer.parseInt(st.nextToken());

        int cTime, giftCnt;
        char cType;
        int smMax = 0;
        int jsMax = 0;

        for(int i = 0; i < customers; i++) {
            st = new StringTokenizer(br.readLine());
            cTime = Integer.parseInt(st.nextToken());
            cType = st.nextToken().charAt(0);
            giftCnt = Integer.parseInt(st.nextToken());

            for(int j = 0; j < giftCnt; j++){
                if(cType == 'B') {
                    if(smMax >= cTime){
                        pq.add(new Order(smMax, 'B'));
                        smMax += smSpeed;
                    } else { // 예를 들어 상민이가 첫줄에서 6초에 마지막 주문을 받았는데, 뒤의 상민에게 주문한 시각이 7초라면 7초에 맞춰서 진행해야 타임라인이 맞음
                        pq.add(new Order(cTime, 'B'));
                        smMax = smSpeed + cTime;
                    }
                }
                else{
                    if(jsMax >= cTime) {
                        pq.add(new Order(jsMax, 'A'));
                        jsMax += jsSpeed;
                    } else {
                        pq.add(new Order(cTime, 'A'));
                        jsMax = jsSpeed + cTime;
                    }
                }
            }
        }
        ArrayList<Integer> smInfo = new ArrayList<>();
        ArrayList<Integer> jsInfo = new ArrayList<>();
        int order = 1;

        while(!pq.isEmpty()) {
            Order o = pq.poll();
            if(o.type == 'B') smInfo.add(order++);
            else jsInfo.add(order++);
        }

        sb.append(smInfo.size() +"\n");
        for(int i : smInfo) {
            sb.append(i+" ");
        }
        sb.append("\n");
        sb.append(jsInfo.size() +"\n");
        for(int i : jsInfo) {
            sb.append(i+" ");
        }
        sb.append("\n");
        System.out.println(sb);
    }
}
