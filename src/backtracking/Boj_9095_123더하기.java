package backtracking;

import java.io.*;
import java.util.*;

public class Boj_9095_123더하기 {
    static int x, cnt = 0;
    static int[] num = {1, 2, 3};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for(int i =0; i < n; i++) {
            x = Integer.parseInt(br.readLine());
            findNum(0);
            sb.append(cnt).append("\n");
            cnt = 0;
        }
        System.out.print(sb);
    }

    static void findNum(int result){
        if(result == x){
            cnt++;
            return;
        }
        for(int i =0; i <3; i++){
            if(result + num[i] > x) continue;
            findNum(result + num[i]);
        }
    }
}
