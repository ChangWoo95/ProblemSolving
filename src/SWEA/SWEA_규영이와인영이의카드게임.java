package SWEA;

import java.io.*;
import java.util.*;

public class SWEA_규영이와인영이의카드게임 {
    static boolean[] visited = new boolean[9];
    static int[] input1 = new int[9], input2 = new int[9], output = new int[9];
    static boolean[] num = new boolean[19];
    static int cnt = 0;
    static int sum1 = 0, sum2 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i =1; i<=T; i++){
            cnt = 0;
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 9; j++){
                input1[j] = Integer.parseInt(st.nextToken());
                num[input1[j]] = true;
            }
            int idx = 0;
            for(int j =1; j<=18; j++){
                if(!num[j]){
                    input2[idx++] = j;
                }
            }
            perm(0);
            sb.append("#"+ i +" "+ (362880 - cnt) + " " + cnt + "\n");
            Arrays.fill(num, false);Arrays.fill(input1, 0);
            Arrays.fill(input2, 0);Arrays.fill(output, 0);
            Arrays.fill(visited, false);
        }
        System.out.print(sb);
    }
    static void perm(int depth) {
        sum1 = 0; sum2 = 0;
        if(depth == 9){
            for(int i = 0; i < 9; i ++){
                if(input1[i] < output[i]) sum2 += (input1[i] + output[i]);
                else sum1 += (input1[i] + output[i]);
            }
            if(sum1 < sum2) cnt++;
            return;
        }
        for(int i = 0; i < 9; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = input2[i];
                perm(depth +1);
                visited[i] = false;
            }
        }
    }
}
