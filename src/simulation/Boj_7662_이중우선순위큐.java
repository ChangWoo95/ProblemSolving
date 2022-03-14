package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_7662_이중우선순위큐 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < T; ++i) {
            PriorityQueue<Integer> maxQueue = new PriorityQueue<>(Comparator.reverseOrder());
            PriorityQueue<Integer> minQueue = new PriorityQueue<>();
            Map<Integer, Integer> queueMap = new HashMap<>();
            int k = Integer.parseInt(br.readLine());

            for(int j = 0 ; j < k; ++j) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String oper = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if(oper.equals("I")) {
                    maxQueue.offer(num);
                    minQueue.offer(num);

                    queueMap.put(num, queueMap.getOrDefault(num, 0) + 1);

                } else {
                    if(queueMap.isEmpty()) continue;
                    int popNum = 0 ;

                    if( num == -1) {
                        popNum(minQueue, queueMap);
                    } else {
                        popNum(maxQueue, queueMap);
                    }
                }
            }

            if(queueMap.isEmpty()) sb.append("EMPTY").append("\n");
            else {

            }
        }
        System.out.println(sb);
    }

    public static int popNum(PriorityQueue<Integer> pq, Map<Integer, Integer> map) {
        int num = 0;
        while(!pq.isEmpty()) {
             num = pq.poll();
             if(map.get(num) == 0) continue;
             map.put(num, map.get(num) - 1);
             break;
        }
        return num;
    }

}
