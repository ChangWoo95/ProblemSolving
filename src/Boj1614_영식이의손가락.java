import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1614_영식이의손가락 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long cnt = Long.parseLong(br.readLine());

        long result;
        if (n == 1) {
            result = cnt * 8;
        } else if (n == 2) {
            result = (1 + (cnt / 2) * 8 + (cnt % 2) * 6);
        } else if (n == 3) {
            result = (2 + (cnt / 2) * 8 + (cnt % 2) * 4);
        } else if (n == 4) {
            result =  (3 + (cnt / 2) * 8 + (cnt % 2) * 2);
        } else {
            result = (4 + cnt * 8);
        }
        System.out.println(result);
    }
}
