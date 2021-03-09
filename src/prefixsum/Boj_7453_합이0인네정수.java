package prefixsum;

import java.io.*;
import java.util.*;

public class Boj_7453_합이0인네정수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        long[] a = new long[n], b = new long[n], c = new long[n], d = new long[n];
        for(int i = 0; i <n; i++){
            st = new StringTokenizer(br.readLine());
            a[i] = Long.parseLong(st.nextToken());
            b[i] = Long.parseLong(st.nextToken());
            c[i] = Long.parseLong(st.nextToken());
            d[i] = Long.parseLong(st.nextToken());
        }
        long[] listA = new long[n*n];
        long[] listB = new long[n*n];

        int idx = 0;
        for(int i=0; i <n; i++){
            for(int j = 0 ; j <n; j++){
                listA[idx] = a[i] + b[j];
                listB[idx] = c[i] + d[j];
                idx++;
            }
        }
        Arrays.sort(listA);
        Arrays.sort(listB);

        long ans = 0;
        for(int i = 0; i < listA.length; i++){
            long sum = listA[i];
            int ll = 0, lr = listB.length-1, lMid;
            long lCnt = -1, rCnt = -1;

            while(ll <= lr){
                lMid = (ll + lr) >> 1;
                if(listB[lMid] + sum >= 0){
                    if(listB[lMid] + sum == 0) lCnt = lMid;
                    lr = lMid -1;
                } else ll = lMid + 1 ;
            }
            ll = 0; lr = listB.length-1;
            while(ll <= lr){
                lMid = (ll + lr) >> 1;
                if(listB[lMid] + sum > 0) lr = lMid -1;
                else {
                    if(listB[lMid] + sum == 0) rCnt = lMid;
                    ll = lMid + 1 ;
                }
            }
            if( lCnt != -1 && rCnt != -1) ans += (rCnt - lCnt + 1);
        }
        System.out.println(ans);
    }
}
