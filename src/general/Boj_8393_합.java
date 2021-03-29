package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_8393_합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] list = new int[10001];
        for(int i = 1; i<= n; ++i){
            list[i] = list[i-1] + i;
        }
        System.out.print(list[n]);
    }
}
