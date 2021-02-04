package binarySearch;
import java.io.*;
import java.util.*;

public class Boj_1654_랜선자르기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int result = Integer.parseInt(st.nextToken());
        long[] list = new long[n];
        long high = 0, low = 1;
        for(int i =0; i <n; i++){
            list[i] = Integer.parseInt(br.readLine());
            high = Math.max(high, list[i]);
        }
        while(low <= high) {
            long mid = (low + high) / 2;
            long cnt = 0;
            for(int i = 0; i < n; i++)
                cnt += list[i]/mid;
            if(cnt >= result) low = mid + 1;
            else high = mid - 1;
        }
        System.out.println(high);
    }
}
