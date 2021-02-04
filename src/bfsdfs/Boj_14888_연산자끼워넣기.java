package bfsdfs;

import java.io.*;
import java.util.*;

public class Boj_14888_연산자끼워넣기 {
    static int n, add, sub, mul, div;
    static int[] list;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i < n; i++)
            list[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        add = Integer.parseInt(st.nextToken());
        sub = Integer.parseInt(st.nextToken());
        mul  = Integer.parseInt(st.nextToken());
        div = Integer.parseInt(st.nextToken());

        calc(list[0], 1, add, sub, mul, div);
        sb.append(max).append("\n").append(min);
        System.out.print(sb);
    }

    static void calc(int sum, int depth, int add, int sub, int mul, int div){
        if(depth == n) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        if(add != 0) calc(sum + list[depth], depth + 1, add - 1, sub, mul, div);
        if(sub != 0) calc(sum - list[depth], depth + 1, add, sub - 1 , mul, div);
        if(mul != 0) calc(sum * list[depth], depth + 1, add, sub, mul - 1, div);
        if(div != 0) calc(sum / list[depth], depth + 1, add, sub, mul, div - 1);
    }
}
