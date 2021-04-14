package binarySearch;

import java.io.*;
import java.util.*;

public class Boj_10815_숫자카드 {
    static long[] list1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        list1 = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i <n; i++)
            list1[i] = Long.parseLong(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Arrays.sort(list1);

        for(int i = 0 ; i < m; i++){
            long num = Long.parseLong(st.nextToken());
            if(isMine(num)) sb.append(1).append(" ");
            else sb.append(0).append(" ");
        }
        System.out.print(sb);
    }
    static boolean isMine(long num){
        int low = 0, high = list1.length-1, mid;
        while(low <= high){
            mid = (low + high) /2;
            if(list1[mid] == num) {
                return true;
            }
            else if(list1[mid] > num) high = mid -1;
            else low = mid + 1;
        }
        return false;
    }
}
