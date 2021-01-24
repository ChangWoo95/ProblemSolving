package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Boj_S5_2998_8진수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> jinsu = new HashMap<String, String>();
        jinsu.put("000","0");
        jinsu.put("001","1");
        jinsu.put("010","2");
        jinsu.put("011","3");
        jinsu.put("100","4");
        jinsu.put("101","5");
        jinsu.put("110","6");
        jinsu.put("111","7");

        String input = br.readLine();
        while(input.length() % 3 != 0) {
            input = "0"+ input;
        }
        String answer = "";
        for(int i = 0; i < input.length(); i += 3){
            answer += jinsu.get(input.substring(i, i+3));
        }
        System.out.println(answer);
    }
}
