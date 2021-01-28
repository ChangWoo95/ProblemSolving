package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_1431_시리얼번호 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String[] base = new String[n];
        for(int i =0; i< n; i++){
            base[i] = br.readLine();
        }
        Arrays.sort(base, (s1, s2) -> {
            if(s1.length() != s2.length()) return s1.length() - s2.length();
            int s1Num = 0;
            int s2Num = 0;
            for (int i = 0; i < s1.length(); i++) {
                if (Character.isDigit(s1.charAt(i))) s1Num += (s1.charAt(i) - '0');
                if (Character.isDigit(s2.charAt(i))) s2Num += (s2.charAt(i) - '0');
            }
            if(s1Num == s2Num) return s1.compareTo(s2);
            return s1Num - s2Num;
        });
        for(int i = 0; i < n; i++){
            sb.append(base[i]).append("\n");
        }
        System.out.print(sb);
    }
}
