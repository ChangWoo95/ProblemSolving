package backtracking;
import java.io.*;

public class Boj_2231_분해합 {
    static String s;
    static char[] list;
    static int min  = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        list = new char[s.length()];
        findSum(0);
        if(min != Integer.MAX_VALUE) System.out.print(min);
        else  System.out.print(0);

    }
    static void findSum(int depth){
        if(depth == s.length()){
            int org = Integer.parseInt(new String(list));
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += list[i] - '0';
            }
            int ans = org + sum;
            if(Integer.parseInt(s) == ans) min = Math.min(min, org);
            return;
        }

        for(int i =0; i <= 9; i++){
            list[depth] = (char) ('0' + i);
            findSum(depth + 1);
        }
    }
}
