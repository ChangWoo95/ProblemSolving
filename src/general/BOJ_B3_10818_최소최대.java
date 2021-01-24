package general;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ_B3_10818_최소최대 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = input.nextInt();
        }
        Arrays.sort(arr);
        System.out.printf("%d %d",arr[0], arr[arr.length-1]);
    }
}
