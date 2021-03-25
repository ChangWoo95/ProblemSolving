package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2352_반도체설계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[n];
        int[] Lis = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i <n; ++i){
            list[i] = Integer.parseInt(st.nextToken());
        }
        int size = 0;
        for(int i = 0 ; i <n; ++i){
            int temp = Arrays.binarySearch(Lis, 0, size, list[i]);
            temp = Math.abs(temp) - 1;
            Lis[temp] = list[i];
            if(temp == size) ++size;
        }
        System.out.println(size);
    }
}
