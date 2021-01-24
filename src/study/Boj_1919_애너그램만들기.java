package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1919_애너그램만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();
        int ans = 0;
        int[] s1Alpha = new int[26];
        int[] s2Alpha = new int[26];

        for(int i = 0 ; i < s1.length(); i++){
            s1Alpha[s1.charAt(i) - 97]++;
        }
        for(int  i = 0; i<s2.length(); i++){
            s2Alpha[s2.charAt(i) - 97]++;
        }
        for(int i = 0 ; i< s1Alpha.length; i++){ // 갯수가 다른 만큼 빼주어야 하기 때문에 뺀 절대값을 더해줌
            if(s1Alpha[i] != s2Alpha[i]) ans += Math.abs(s1Alpha[i] - s2Alpha[i]);
        }
        System.out.println(ans);
    }
}
