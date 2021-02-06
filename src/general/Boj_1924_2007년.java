package general;

import java.io.*;
import java.util.*;

public class Boj_1924_2007년 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> month = new HashMap<>();
        month.put(1, 31); month.put(2, 28);
        month.put(3, 31); month.put(4, 30);
        month.put(5, 31); month.put(6, 30);
        month.put(7, 31); month.put(8, 31);
        month.put(9, 30); month.put(10, 31);
        month.put(11, 30); month.put(12, 31);
        Map<Integer, String> d = new HashMap<>();
        d.put(5, "FRI"); d.put(4, "THU");
        d.put(6, "SAT"); d.put(0, "SUN");
        d.put(1, "MON"); d.put(2, "TUE");
        d.put(3, "WED");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int mon = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        if(mon == 1) System.out.print(d.get(day%7));
        else {
            for(int i = 1; i< mon; i++) day += month.get(i);
            System.out.print(d.get(day%7));
        }
    }
}
