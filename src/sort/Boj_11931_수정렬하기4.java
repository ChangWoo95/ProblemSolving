package sort;

import java.io.*;
import java.util.*;

public class Boj_11931_수정렬하기4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        Integer[] list = new Integer[n];

        for(int i = 0; i < n; i++)
            list[i] = Integer.parseInt(br.readLine());

        Arrays.sort(list, Collections.reverseOrder());

        for(int i =0; i < list.length; i++){
            sb.append(list[i]).append("\n");
        }
        System.out.print(sb);
    }
}
