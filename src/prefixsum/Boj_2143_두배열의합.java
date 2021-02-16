package prefixsum;

import java.io.*;
import java.util.*;

public class Boj_2143_두배열의합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long req = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        List<Long> listA = new ArrayList<>();
        List<Long> listB = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i <n; i++)
            listA.add(Long.parseLong(st.nextToken()));
        for(int i = 0; i < n; i++){
            long sum = listA.get(i);
            for(int j = i+1; j<n; j++){
                sum += listA.get(j);
                listA.add(sum);
            }
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i <m; i++)
            listB.add(Long.parseLong(st.nextToken()));
        for(int i = 0; i < m; i++){
            long sum = listB.get(i);
            for(int j = i+1; j<m; j++){
                sum += listB.get(j);
                listB.add(sum);
            }
        }
        Collections.sort(listB);

        long result = 0;
        for(int i = 0; i < listA.size(); i++){
            long sum = req - listA.get(i);
            int ll = 0, lr = listB.size()-1, lMid;
            long lCnt = -1, rCnt = -1;

            while(ll <= lr){
                lMid = (ll + lr) >> 1;
                if(listB.get(lMid) >= sum){
                    if(listB.get(lMid) == sum) lCnt = lMid;
                    lr = lMid -1;
                } else ll = lMid + 1 ;
            }
            ll = 0; lr = listB.size()-1;
            while(ll <= lr){
                lMid = (ll + lr) >> 1;
                if(listB.get(lMid) > sum) lr = lMid -1;
                else {
                    if(listB.get(lMid) == sum) rCnt = lMid;
                    ll = lMid + 1 ;
                }
            }
            if( lCnt != -1 && rCnt != -1) result += (rCnt - lCnt + 1);
        }
        System.out.println(result);
    }
}
