package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1475_방번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int [] numList = new int[10]; // 숫자 리스트
        int max = Integer.MIN_VALUE;

        for(int i = 0; i< s.length(); i++){
            numList[s.charAt(i) - '0']++;
        }

        for(int i = 0 ; i < 10; i++){
            //if(max  < numlist[i]) max = numlist[i];
            if(i != 9 && i != 6) max = Math.max(max, numList[i]);
        }

        System.out.println(Math.max(max, (numList[6] + numList[9] + 1) /2));
    }
}
