package general;

import java.io.*;
import java.util.*;

public class Boj_2309_일곱난쟁이 {
    static int[] input = new int[9];
    static int[] output = new int[7];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i =0; i <9; i ++){
            input[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(input);
        comb(0, 0, 0);
    }
    static void comb(int depth, int start, int sum){
        if(depth == 7){
            if(sum != 100) return;
            for(int i = 0; i < depth; i++){
                sb.append(output[i]).append("\n");
            }
            System.out.print(sb);
            System.exit(0);
        }
        for(int i = start; i< 9; i++){
            output[depth] = input[i];
            comb(depth + 1, i + 1, sum + input[i]);
        }
    }
}
