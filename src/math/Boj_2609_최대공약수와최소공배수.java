package math;
import java.io.*;
import java.util.*;

public class Boj_2609_최대공약수와최소공배수 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int tmp = 0;
        if(a < b) {
            tmp = b;
            b = a;
            a = tmp;
        }
        int ans = gcd(a, b);
        sb.append(ans).append("\n").append(a*b/ans).append("\n");
        System.out.print(sb);
    }
    /*static int gcd(int a, int b){
        if(b == 0) return a;
        else return gcd(b, a%b);
    }*/
    static int gcd(int a, int b){
        while(b != 0){
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        return a;
    }
}
