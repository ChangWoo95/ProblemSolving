package general;

import java.io.*;
import java.util.*;

public class Boj_10951_A_B_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String s = "";
        int a, b;

        while( (s = br.readLine()) != null && s.length() != 0 ){
            st = new StringTokenizer(s);
            a = Integer.parseInt(st.nextToken()); b = Integer.parseInt(st.nextToken());
            sb.append(a+b).append("\n");
        }
        System.out.print(sb);
    }
}
