package general;

import java.io.*;
import java.util.*;

public class Boj_3040_백설공주와일곱난쟁이 {
    static int[] list ;
    static int[] output;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        list = new int[9];
        output = new int[7];
        for(int i = 0; i <9; i++)
            list[i] = Integer.parseInt(br.readLine());

        comb(0, 0, 0);
        System.out.print(sb);
    }
    static void comb(int depth, int start, int sum){
        if(depth == 7){
            if(sum == 100){
                for(int i = 0; i < 7; i++)
                    sb.append(output[i]).append("\n");
            }
            return;
        }
        for(int i = start; i < 9; i++){
            if(list[i] + sum > 100) continue;
            output[depth] = list[i];
            comb(depth + 1, i + 1, sum + list[i]);
        }
    }
}
