package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Boj_S3_12018_YonseiTOTO {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] ConsumToken = new int[n]; // 과목당 소비해야할 최소의 마일리지 수를 담은 배열

        for(int i = 0; i< n; i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());


            st = new StringTokenizer(br.readLine());
            if(p < l) ConsumToken[i] = 1;
            else{
                Integer[] tokens = new Integer[p];
                for(int j = 0; j < p; j++){
                    tokens[j] = Integer.parseInt(st.nextToken());
                }
                Arrays.sort(tokens, Comparator.reverseOrder());
                ConsumToken[i] = tokens[l-1];
            }
        }
        Arrays.sort(ConsumToken);
        int ans = 0;
        for(int i = 0 ; i < ConsumToken.length; i++){
            if(m - ConsumToken[i] < 0) break;
            ans++;
            m -= ConsumToken[i];
        }
        System.out.println(ans);
    }
}
