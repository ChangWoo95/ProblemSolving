package day20221107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1706_크로스워드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        char[][] puzzle = new char[r][c];
        for (int i = 0; i < r; ++i) {
            puzzle[i] = br.readLine().toCharArray();
        }

        List<String> answers = new ArrayList<>();

        /* 가로에 존재하는 단어 탐색 */
        for (int i = 0; i < r; ++i) {
            int idx = 0;
            StringBuilder sb = new StringBuilder();
            while (idx < c) {
                if (puzzle[i][idx] == '#') {
                    if (sb.length() > 1) {
                        answers.add(sb.toString());
                    }
                    sb.setLength(0);
                } else {
                    sb.append(puzzle[i][idx]);
                }
                ++idx;
            }

            if (sb.length() > 1) {
                answers.add(sb.toString());
            }
        }

        /* 세로에 존재하는 단어 탐색 */
        for (int i = 0; i < c; ++i) {
            int idx = 0;
            StringBuilder sb = new StringBuilder();
            while (idx < r) {
                if (puzzle[idx][i] == '#') {
                    if (sb.length() > 1) {
                        answers.add(sb.toString());
                    }
                    sb.setLength(0);
                } else {
                    sb.append(puzzle[idx][i]);
                }
                ++idx;
            }

            if (sb.length() > 1) {
                answers.add(sb.toString());
            }
        }
        Collections.sort(answers);
        System.out.println(answers.get(0));
    }
}
