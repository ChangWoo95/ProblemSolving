package general;

import java.io.*;
import java.util.*;

public class Boj_4344_평균은넘겠지 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t<T; t++){
            st = new StringTokenizer(br.readLine());
            double sum = 0; int cnt = 0;
            int[] list = new int[Integer.parseInt(st.nextToken())];
            for(int i = 0; i <list.length; i++){
                list[i] = Integer.parseInt(st.nextToken());
                sum += list[i];
            }
            sum /= list.length;
            for(int i = 0 ; i <list.length; i++){
                if(sum < list[i]) ++cnt;
            }
            double ans = (double)cnt / list.length * 100;
            sb.append( String.format("%.3f", ans)).append("%").append("\n");
        }
        System.out.print(sb);
    }
}
