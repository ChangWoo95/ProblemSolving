package general;

import java.io.*;
import java.util.*;

public class Boj_2475_검증수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int val = 0;

        while( (s=br.readLine()) != null && s.length() != 0 ){
            StringTokenizer st = new StringTokenizer(s);
            while(st.hasMoreTokens()){
                int x = Integer.parseInt(st.nextToken())%10;
                val += x*x;
            }
        }

        System.out.println(val%10);
    }
}
