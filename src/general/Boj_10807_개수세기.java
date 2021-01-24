package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10807_개수세기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] numbers = new int[201];
        for(int i = 0; i < n; i++) {
            numbers[100 + Integer.parseInt(st.nextToken())]++;
        }
        int ans = Integer.parseInt(br.readLine());
        System.out.println(numbers[ans+100]);
    }
}
