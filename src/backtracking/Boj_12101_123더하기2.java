package backtracking;

import java.io.*;
import java.util.*;

public class Boj_12101_123더하기2 {
    static int n, x, idx = 0;
    static int[] num = {1, 2, 3};
    static List<String> s = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        findNum(0, "");
        Collections.sort(s);
        if(s.size() < x) System.out.println(-1);
        else System.out.println(s.get(x-1).substring(1));
    }

    static void findNum(int result, String ss){
        if(result == n){
           s.add(ss);
           return;
        }
        for(int i =0; i <3; i++){
            if(result + num[i] > n) continue;
            findNum(result + num[i], ss + ("+" + num[i] ));
        }
    }

}
