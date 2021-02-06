package backtracking;

import java.io.*;
import java.util.*;

public class Boj_2697_다음수구하기 {
    static int n;
    static StringBuilder sb = new StringBuilder();
    static String[] list;
    static char[] output;
    static boolean[] visited;
    static String min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        list = new String[n];
        for(int i =0; i <n; i++){
            list[i] = br.readLine();
        }
        for(int i =0; i < n; i++) {
            output = new char[list[i].length()];
            visited=  new boolean[list[i].length()];
            min = "A";
            findMax(0, list[i]);
            if(min == "A") sb.append("BIGGEST\n");
            else sb.append(min);
        }
        System.out.print(sb);
    }
    static void findMax(int depth, String s){
        if(depth == s.length()) {
            String val = new String(output);
            if(s.compareTo(val) < 0 ) min = (min.compareTo(val) < 0) ? min : val;
            return;
        }
        for(int i =0; i <s.length(); i++){
            if(!visited[i]){
                output[depth] = s.charAt(i);
                String ss = new String(output).substring(0, depth+1);
                /*if(ss.compareTo(s.substring(0, depth+1)) < 0) {
                    continue;
                }*/

                visited[i] = true;
                findMax(depth + 1, s);
                visited[i] = false;
            }
        }
    }
}
