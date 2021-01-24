package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10808_알파벳개수{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int [] alpha = new int[26];
        String s = br.readLine();
        for(int i = 0; i< s.length(); i++){
            alpha[s.charAt(i)-97]++;
        }
        for(int i : alpha){
            sb.append(i+" ");
        }
        System.out.println(sb);
    }

}
