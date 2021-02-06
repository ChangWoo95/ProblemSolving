package general;

import java.io.*;
import java.util.*;

public class Boj_11652_카드 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Long, Integer> map = new HashMap<>();
        long max = 0;
        long maxIdx = 0;
        int n = Integer.parseInt(br.readLine());
        for(int i =0; i< n; i++){
            long x = Long.parseLong(br.readLine());
            if(!map.containsKey(x)) map.put(x, 1);
            else map.put(x, map.get(x)+1);
        }
        for(Map.Entry<Long, Integer> ll : map.entrySet()) {
            if(max == ll.getValue()) {
                max = Math.max(max, ll.getValue());
                maxIdx = Math.min(maxIdx, ll.getKey());
            }
            else if(max < ll.getValue()) {
                max = Math.max(max, ll.getValue());
                maxIdx = ll.getKey();
            }
        }
        System.out.println(maxIdx);
    }
}
