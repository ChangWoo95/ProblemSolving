package general;

import java.util.Scanner;

public class BOJ_B4_14681_사분면고르기 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();

        if (a > 0 && b > 0) {
            System.out.println(1);
        }
        else if (a < 0 && b > 0) {
            System.out.println(2);
        }
        else if (a > 0 && b < 0) {
            System.out.println(4);
        } else {
            System.out.println(3);
        }
    }
}
