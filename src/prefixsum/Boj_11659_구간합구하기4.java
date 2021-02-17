package prefixsum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11659_구간합구하기4 {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken()); int m = Integer.parseInt(st.nextToken());
        int[] list = new int[n];
        int x, y;
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++)
            list[i] = Integer.parseInt(st.nextToken());
        for(int i=1; i<=n-1; i++)
            list[i] = list[i-1] + list[i];

        for(int i = 0 ; i <m; i++){
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken()) - 2;
            y = Integer.parseInt(st.nextToken()) - 1;
            if(x < 0) sb.append(list[y]).append("\n");
            else sb.append(list[y] - list[x]).append("\n");
        }
        System.out.print(sb);

    }
}
