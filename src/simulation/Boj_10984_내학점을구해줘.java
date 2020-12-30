package simulation;

import java.io.*;
import java.util.*;

public class Boj_10984_내학점을구해줘 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int n, c = 0, x;
        double g = 0, y;
        for(int t=0; t < T; t++){
            n = Integer.parseInt(br.readLine());
            c=0;g=0;
            for(int i = 0 ; i <n; i++){
                st = new StringTokenizer(br.readLine());
                x =  Integer.parseInt(st.nextToken());
                y = Double.parseDouble(st.nextToken());
                c += x;
                g += x*y;
            }
            g /=c;
            sb.append(c).append(" ").append(Math.round(g * 10)/ 10.0).append("\n");
        }
        System.out.print(sb);
    }
}
