package general;

import java.io.*;
import java.util.*;

public class Boj_2741_N찍기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        for(int i = 1; i <= n; i++){
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }
}
