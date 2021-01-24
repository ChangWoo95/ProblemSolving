package general;


import java.util.Arrays;
import java.util.Scanner;

public class BOJ_B1_1546_평균 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double[] arr = new double[n];
        double answer = 0;

        for (int i = 0;i < arr.length; i++) {
            arr[i] = input.nextDouble();
        }

        Arrays.sort(arr);

        for (int i = 0;i < arr.length; i++) {
            arr[i] = arr[i]/ arr[arr.length-1] * 100;
        }

        for (double val : arr) {
            answer += val;
        }
        answer /= n;
        System.out.println(answer);
    }
}
