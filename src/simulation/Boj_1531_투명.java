package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1531_투명 {

    public static int[][] picture;
    public static int bound;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int paperCount = Integer.parseInt(st.nextToken());
        bound = Integer.parseInt(st.nextToken());
        picture = new int[100][100];

        for(int i = 0 ; i < paperCount; ++i) {
            st = new StringTokenizer(br.readLine());
            int posX1 = 100 - Integer.parseInt(st.nextToken());
            int posY1 = Integer.parseInt(st.nextToken()) - 1;
            int posX2 = 100 - Integer.parseInt(st.nextToken());
            int posY2 = Integer.parseInt(st.nextToken()) - 1;

            hide(posX1, posY1, posX2, posY2);
        }

        System.out.println(findInvisiblePixel());

    }

    public static void hide(int x1, int y1, int x2, int y2) {
        for(int i = x2; i <= x1; ++i) {
            for(int j = y1; j <= y2; ++j) {
                ++picture[i][j];
            }
        }
        return;
    }

    public static int findInvisiblePixel() {
        int ret = 0;
        for(int i = 0 ; i < 100; ++i) {
            for(int j = 0; j< 100; ++j) {
                if(picture[i][j] > bound) ++ret;
            }
        }
        return ret;
    }

}
