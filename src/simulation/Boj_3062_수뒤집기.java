package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_3062_수뒤집기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        while(n --> 0) {
            calculator.create(br.readLine());
            calculator.plus();
            if(calculator.isPalindrome()) answer.append("YES").append("\n");
            else answer.append("NO").append("\n");
        }
        System.out.println(answer);
    }
    public static class calculator {
        public static StringBuilder result;
        public static StringBuilder number;

        static void create(String s) {
            number  = new StringBuilder(s);
            return ;
        }

        static void plus() {
            result = new StringBuilder();
            int a = Integer.parseInt(number.toString());
            int b = Integer.parseInt(number.reverse().toString());
            result.append(a+b);
            return;
        }
        static boolean isPalindrome() {
            for(int i = 0 ; i <result.length()/2; ++i) {
                if(result.charAt(i) == result.charAt(result.length() -1 - i)) continue;
                else return false;
            }
            return true;
        }
    }
}
