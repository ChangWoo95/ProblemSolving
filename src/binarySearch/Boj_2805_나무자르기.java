package binarySearch;

import java.io.*;
import java.util.*;

public class Boj_2805_나무자르기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        long[] list = new long[n];
        st = new StringTokenizer(br.readLine());
        long low = 0, high = -1, mid, sum;

        for(int i =0; i < n; i++){
            list[i] = Long.parseLong(st.nextToken());
            high = Math.max(high, list[i]);
        }
        while(low <= high){
            mid = (low + high)/2;
            sum = 0;
            for(int i =0; i <n; i++) {
                if (list[i] < mid) continue;
                sum += list[i] - mid;
            }
            if(sum < m) high = mid - 1; // sum이 원하는 길이보다 작다는 말은 절단기 높이가 너무 높다는 말과 같음
            else low = mid + 1; // sum이 원하는 길이보다 크다는 말은 절단기 높이가 너무 작다라는 의미
        }
        System.out.println(high);
    }
}
