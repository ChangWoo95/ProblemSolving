package day20221116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3003_킹퀸룩비숍나이트폰 {

    public static final int[] pieces = {1, 1, 2, 2, 2, 8};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < 6; ++i) {
            sb.append(pieces[i] - Integer.parseInt(st.nextToken()) ).append(" ");
        }

        System.out.println(sb);
    }
}
