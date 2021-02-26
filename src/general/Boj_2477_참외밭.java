package general;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.*;
import java.util.StringTokenizer;

public class Boj_2477_참외밭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        int[] array = new int[6];
        int w = 0;
        int h = 0;
        int ww = 0;
        int hh = 0;
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            array[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) w = Integer.max(w, array[i]);
            else h = Integer.max(h, array[i]);
        }

        for (int i = 0; i < 6; i++) {
            if (i % 2 == 0) {
                if (h == array[(i + 5) % 6] + array[(i + 1) % 6]) {
                    ww = array[i];
                }
            } else {
                if (w == array[(i + 5) % 6] + array[(i + 1) % 6]) {
                    hh = array[i];
                }
            }
        }
        System.out.println((w * h - ww * hh) * k);
    }
}
