package IM;

import java.awt.*;
import java.io.*;
import java.util.*;

public class Boj_10158_개미 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int c = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Point pos = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        int limit = Integer.parseInt(br.readLine());
        pos.x += limit; pos.y += limit;

        pos.x %= (2*c); pos.y %= (2*r);

        if(pos.x > c) pos.x = 2*c - pos.x;
        if(pos.y > r) pos.y = 2*r - pos.y;
        System.out.println(pos.x + " " + pos.y);
    }
}
