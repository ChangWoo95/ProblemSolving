package IM;

import java.io.*;
import java.util.*;

public class Boj_11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] list = new int[n];
        int sum = 0, result = 0;
        for(int i = 0 ; i < n; i++)
            list[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(list);
        for(int i = 0 ; i < n; i++){
            sum +=list[i];
            result += sum;
        }
        System.out.println(result);
    }
}
