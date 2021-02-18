package bitmasking;

import java.io.*;
import java.util.*;

public class Boj_18119_단어암기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int bit = 67108863;
        int[] wordBits = new int[n];

        for(int i = 0 ; i < n; ++i){
            char[] s = br.readLine().toCharArray();
            for(int j = 0 ; j <s.length; ++j)
                wordBits[i] |= 1 << (s[j] - 'a');
        }
        for(int i = 0 ; i <m; ++i){
            st = new StringTokenizer(br.readLine());
            int cnt = 0;
            int o = Integer.parseInt(st.nextToken());
            char x = st.nextToken().charAt(0);
            if(o == 1) bit ^= (1 << (x - 'a'));
            else bit |= (1 << (x - 'a'));

            for(int j = 0 ; j < n; ++j){
                if( (bit & wordBits[j]) == wordBits[j]) ++cnt;
            }
            sb.append(cnt).append("\n");
        }
        System.out.print(sb);
    }
}
