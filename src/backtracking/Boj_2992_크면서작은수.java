package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2992_크면서작은수 {
    static char[] output;
    static String input;
    static boolean[] visited;
    static int bound;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
        output = new char[input.length()];
        visited = new boolean[input.length()];

        upperbound(0);
        if(ans == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(ans);
    }
    static void upperbound(int depth) {
        if(depth == output.length){
            int result = Integer.parseInt(String.valueOf(output));
            if(result > Integer.parseInt(input)) {
                ans = Math.min(ans, result);
            }
            return;
        }
        for(int i = 0; i < input.length(); i++){
            if(!visited[i]) {
                visited[i] = true;
                output[depth] = input.charAt(i);
                upperbound(depth+1);
                visited[i] = false;
            }
        }
    }
}
