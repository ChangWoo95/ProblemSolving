package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1439_뒤집기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int oneCnt = 0;
        int zeroCnt = 0;

        for(int i = 0 ; i < s.length()-1; ++i) {
            if(s.charAt(i) == s.charAt(i+1)) continue;
            else {
                if(s.charAt(i+1) == '0') ++oneCnt;
                else ++zeroCnt;
            }
        }
        if(s.charAt(s.length() -1) == '0') ++zeroCnt;
        else ++oneCnt;

        System.out.println(Math.min(oneCnt, zeroCnt));
    }

}
