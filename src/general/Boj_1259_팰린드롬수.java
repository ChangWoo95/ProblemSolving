package general;

import java.io.*;
import java.util.*;

public class Boj_1259_팰린드롬수 {
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while( !((s= br.readLine()).equals("0")) ){
            if(isCorrect()) sb.append("yes").append("\n");
            else sb.append("no").append("\n");
        }
        System.out.print(sb);
    }
    static boolean isCorrect(){
        for(int i =0; i <s.length()/2; i++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    }
}
