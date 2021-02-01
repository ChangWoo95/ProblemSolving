package greedy;

import java.io.*;
import java.util.*;
/**
* @since 2021-02-01
* @author ChangWoo95
* @see https://www.acmicpc.net/problem/1244
* @time 124 ms
* @mem 14492 KB
* @caution
*/
public class Boj_1244_스위치켜고끄기 {
    static int[] myswitch;
    static StringBuilder sb = new StringBuilder();
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        myswitch = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i =1; i <= n; i++)
            myswitch[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for(int i =0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            if(Integer.parseInt(st.nextToken()) == 1) manSwap(Integer.parseInt(st.nextToken()));
            else womanSwap(Integer.parseInt(st.nextToken()));
        }
        for(int i =1; i<= n; i++){
            sb.append(myswitch[i]).append(" ");
            if(i % 20 == 0) sb.append("\n");
        }
        System.out.print(sb);
    }

    static void manSwap(int val){
        for(int i = val; i<= n; i++)
            if(i % val == 0) myswitch[i] ^= 1;
    }

    static void womanSwap(int val) {
        int left = val - 1;
        int right = val + 1;
        myswitch[val] ^= 1;

        while(left > 0 && right <=n && myswitch[left] == myswitch[right]) {
            myswitch[left] ^= 1;
            myswitch[right] ^= 1;
            left--;
            right++;
        }
    }
}