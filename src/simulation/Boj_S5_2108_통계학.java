package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_S5_2108_통계학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        int[] frequency = new int[8001];
        double ans1 = 0;

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i< n; i++){
            numbers[i] = Integer.parseInt(br.readLine());
            ans1 += numbers[i];
            frequency[numbers[i] + 4000]++;
            if (max < numbers[i]) max = numbers[i];
            if(min > numbers[i]) min = numbers[i];
        }
        int maxFrequency = 0;
        int ans3 = 0;
        boolean flag = false;

        for(int i = min + 4000; i <= max + 4000; i++){
            if(maxFrequency < frequency[i]) {
                maxFrequency = frequency[i];
                ans3 = i - 4000;
                flag = true;
            }

            else if(maxFrequency == frequency[i] && flag == true) {
                ans3 = i - 4000;
                flag = false;
            }
        }
        ans1 /= n;

        int[] copy = new int[n];

        System.arraycopy(numbers, 0, copy,0, numbers.length);
        Arrays.sort(copy);
        int ans2 = copy[n/2];
        int ans4 = Math.abs(copy[0] - copy[copy.length - 1]);

        System.out.println((int)(Math.round(ans1)));
        System.out.println(ans2);
        System.out.println(ans3);
        System.out.println(ans4);
    }
}
