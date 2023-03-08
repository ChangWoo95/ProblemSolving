import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Boj23971_ZOAC4 {
    /* 나머지가 남았을 때 +1 해준다의 개념을 어떻게 잡아갈 것인가
    * 또한 +1해주는 개념을 올림함수 등으로 치환할 수 있는가 */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken()) + 1;
        int m = Integer.parseInt(st.nextToken()) + 1;

        int answer = (int) (Math.ceil((double) h / n) * Math.ceil((double) w / m));

        System.out.println(answer);
    }
}
