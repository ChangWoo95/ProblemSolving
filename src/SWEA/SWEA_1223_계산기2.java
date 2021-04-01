package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_1223_계산기2 {
    static String s;
    static StringBuilder back;
    static Stack<Character> calc = new Stack<>();;
    static Stack<Integer> calculator = new Stack<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t<= 10; t++) {
            int n = Integer.parseInt(br.readLine());
            s = br.readLine();
            back = new StringBuilder();
            makeback();

            for(int i =0; i < back.length(); i++){
                char ch = back.charAt(i);
                if(Character.isDigit(ch)) calculator.push(ch- '0');
                else {
                    if(ch == '*') {
                        int result = (calculator.pop()) * (calculator.pop());
                        calculator.push(result);
                    } else{
                        int result = (calculator.pop()) + (calculator.pop());
                        calculator.push(result);
                    }
                }
            }
            sb.append("#"+t +" ").append(calculator.pop()).append("\n");
        }
        System.out.print(sb);
    }
    static void makeback(){
        for(int i =0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) back.append(ch);
            else {
                if(!calc.isEmpty()){
                    if(calc.peek() <= ch) back.append(calc.pop());
                    calc.push(ch);
                }
                else calc.push(ch);
            }
        }
        while(!calc.isEmpty()){
            back.append(calc.pop());
        }
    }
}
