package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2467_용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i <n; ++i){
            list[i] = Integer.parseInt(st.nextToken());
        }
        int left = 0, right = n-1;
        int lowAns = list[left], highAns = list[right];
        int initSum = Math.abs(list[left] + list[right]);
        while(left < right){
            int sum = list[left] + list[right];
            if(Math.abs(sum) < initSum){
                initSum = Math.abs(sum);
                lowAns = list[left];
                highAns = list[right];
            }
            if(sum < 0) ++left;
            else --right;
        }
        System.out.println(lowAns + " " + highAns);
    }
}
