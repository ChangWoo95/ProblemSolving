package general;

import java.io.*;
import java.util.*;

public class Boj_1712_손익분기점 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long idx  = 1;
        if(b >= c) idx = -1;
        else while( a +(b*idx) >= c * idx) idx++;
        System.out.println(idx);
    }
}
