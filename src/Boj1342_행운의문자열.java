import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1342_행운의문자열 {
    /* 1. 메모리를 줄이기 위해 bitmask를 사용할 줄 아는가(중복을 잡을 때)
    * 2. 서로 다른 개념을 부여할 때 어떻게 적용시킬 수 있을까(validation) */
    public static char[] selected;
    public static char[] input;
    public static boolean[] visited;
    public static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine().toCharArray();
        selected = new char[input.length];
        visited = new boolean[input.length];
        permutation(0, '0');
        System.out.println(answer);
    }

    public static void permutation(int depth, char prev) {
        if (depth == selected.length) {
            ++answer;
            return;
        }

        int bit = 0;

        for (int i = 0; i < input.length; ++i) {
            if (!visited[i] && input[i] != prev && ((bit & 1 << (input[i] - 'a')) == 0)) {
                visited[i] = true;
                bit |= 1 << (input[i] - 'a');
                selected[depth] = input[i];
                permutation(depth + 1, input[i]);
                visited[i] = false;
            }
        }
    }
}
