package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2577_숫자의갯수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int [] numbers = new int[10];
        int sum = 1;

        for(int i = 0; i < 3; i++){
            sum *= Integer.parseInt(br.readLine());
        }
        String s = Integer.toString(sum);

        for(int i = 0; i< s.length(); i++){
            numbers[s.charAt(i) - '0']++;
        }
        for(int i = 0; i < 10; i++){
            sb.append(numbers[i]).append("\n");
        }
        System.out.print(sb);
    }
}
