package general;

import java.io.*;
import java.util.*;

public class Boj_10952_A_B_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int a, b;

        while(true){
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            if(a == 0 && b == 0) break;
            sb.append(a+b).append("\n");
        }
        System.out.print(sb);
    }
}
