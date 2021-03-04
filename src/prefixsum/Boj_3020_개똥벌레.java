package prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/**
* @since 2021-03-03
* @author ChangWoo95
* @see
* @time
* @mem
* @caution 누적합의 
*/
public class Boj_3020_개똥벌레 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] top = new int[h+1];
        int[] bot = new int[h+1];
        for(int i = 0; i < n/2; ++i){
            ++bot[Integer.parseInt(br.readLine())];
            ++top[Integer.parseInt(br.readLine())];
        }
        int min = n, cnt = 0;

        int[] tSum = new int[h+1];
        int[] bSum = new int[h+1];

        for(int i = 1; i< h+1; ++i){
            tSum[i] = tSum[i-1] + top[i];
            bSum[i] = bSum[i-1] + bot[i];
        }

        for(int i = 1; i< h+1; ++i){
            int broken = 0;
            broken += bSum[h] - bSum[i-1];
            broken += tSum[h] - tSum[h-i];
            if(min > broken)  {
                min = broken;
                cnt = 1;
            } else if(min == broken) ++cnt;
        }
        System.out.printf("%d %d", min, cnt);
    }
}
