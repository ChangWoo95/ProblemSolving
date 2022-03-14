package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_19564_반복 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int answer = 1;
        for(int i = 0 ; i < s.length() - 1; ++i) {
            if(s.charAt(i) < s.charAt(i+1) ) continue;
            ++answer;
        }

        System.out.println(answer);
    }
}
