package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_20551_Sort마스터와배지훈의후계자 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] list = new int[n];
        for(int i = 0 ; i < n; ++i)
            list[i] = Integer.parseInt(br.readLine());
        Arrays.sort(list);
        int ans = -1;


        for(int i = 0 ; i <m; ++i){
            int x = Integer.parseInt(br.readLine());
            int low = 0, high = list.length-1, mid;
            while(low <= high){
                mid = (high + low) /2;
                if(list[mid] < x)
                    low = mid + 1;
                else{
                    if(list[mid] == x) ans = mid;
                    high = mid - 1;
                }
            }
            if(ans < 0 || ans >= list.length) sb.append(-1).append("\n");
            else if(list[ans] != x) sb.append(-1).append("\n");
            else sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
