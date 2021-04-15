package jungol;

import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JOL_1828_냉장고 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Point[] list = new Point[n];
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine());
            list[i] = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(list, (o1, o2) -> Integer.compare(o1.y, o2.y));
        int last = list[0].y;
        int cnt = 1;
        for(int i = 0 ; i < n; i++){
            if(list[i].x <= last) continue;
            last = list[i].y;
            cnt++;
        }
        System.out.println(cnt);
    }
}
