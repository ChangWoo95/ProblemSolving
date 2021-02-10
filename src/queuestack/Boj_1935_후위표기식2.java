package queuestack;

import java.io.*;
import java.util.*;

public class Boj_1935_후위표기식2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<Character, Integer> alpha = new HashMap<>();
        Stack<Double> numbers = new Stack<>();
        int[] list;
        double result = 0;
        String s = br.readLine();
        int idx = 0;
        list = new int[n];
        char ch;

        for (int i = 0; i < n; i++) {
            list[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < s.length(); i++) {
            ch = s.charAt(i);
            if (Character.isAlphabetic(ch)) numbers.push((double)list[ch-'A']);
            else {
                double fir, sec;
                switch (ch) {
                    case '+':
                        numbers.push(numbers.pop() + numbers.pop());
                        break;
                    case '-':
                        fir = numbers.pop();
                        sec = numbers.pop();
                        numbers.push(sec - fir);
                        break;
                    case '*':
                        numbers.push(numbers.pop() * numbers.pop());
                        break;
                    case '/':
                        fir = numbers.pop();
                        sec = numbers.pop();
                        numbers.push(sec / fir);
                        break;
                }
            }
        }
        while(!numbers.isEmpty()) result += numbers.pop();
        System.out.printf("%.2f", result);
    }
}
