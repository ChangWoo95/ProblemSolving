package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_S5_11637_인기투표 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while( T --> 0 ) {
            int n = Integer.parseInt(br.readLine());
            int[] votes = new int[n];
            int max = -1;
            int sum = 0;
            int idx = 0;

            for(int i = 0; i < n; i++){
                int vote = Integer.parseInt(br.readLine());
                sum += vote;
                if(max < vote) {
                    max = vote;
                    idx = i;
                }
                votes[i] = vote;
            }
            Arrays.sort(votes);

            if(max == votes[votes.length - 2]) System.out.println("no winner");
            else if(max > (double)sum / 2) System.out.printf("majority winner %d\n", idx + 1);
            else System.out.printf("minority winner %d\n", idx + 1);
        }
    }

    public static int findWinner(int[] arr, int s) {
        for(int i = 0 ; i < arr.length;i ++){
            if(arr[i] > s/2) return i;
        }
        return -1;
    }
}
