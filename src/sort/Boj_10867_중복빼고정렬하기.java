package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10867_중복빼고정렬하기 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] arr = new int[2001];
        int n = Integer.parseInt(br.readLine());
        int num;
        StringTokenizer st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()) {
            num = Integer.parseInt(st.nextToken()) + 1000;
            if(arr[num] == 0 ) arr[num]++;
        }

        for(int i=0; i < arr.length; i++){
            if(arr[i] != 0 ) sb.append(i - 1000).append(" ");
        }
        System.out.print(sb);
    }
}
