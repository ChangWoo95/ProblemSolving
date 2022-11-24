package day20221124;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj24954_물약구매 {
    public static int n;
    public static int[] portion;
    public static List<List<Point>> saleInfos = new ArrayList<>();
    public static boolean[] visited;
    public static int[] selected;
    public static int answer = (int)1e9;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        portion = new int[n + 1];
        selected = new int[n + 1];
        visited = new boolean[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; ++i) {
            portion[i] = Integer.parseInt(st.nextToken());
        }
        saleInfos.add(new ArrayList<>());

        for (int i = 1; i <= n; ++i) {
            int k = Integer.parseInt(br.readLine());

            List<Point> saleInfo = new ArrayList<>();
            for (int j = 0; j < k; ++j) {
                st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                int coin = Integer.parseInt(st.nextToken());
                saleInfo.add(new Point(num, coin));
            }
            saleInfos.add(saleInfo);
        }

        permutation(1);
        System.out.println(answer);
    }

    public static void permutation(int depth) {
        if (depth == n + 1) {
            int coinCount = getMaxCoin();
            answer = Math.min(answer, coinCount);
            return;
        }

        for (int i = 1; i <= n; ++i) {
            if (!visited[i]) {
                visited[i] = true;
                selected[depth] = i;
                permutation(depth + 1);
                visited[i] = false;
            }
        }
    }

    public static int getMaxCoin() {
        int ret = 0;
        int[] copyPortion = portion.clone();

        for (int i = 1; i <= n; ++i) {
            ret += copyPortion[selected[i]];
            List<Point> saleInfo = saleInfos.get(selected[i]);
            for (Point sale : saleInfo) {
                int idx = sale.x;
                int coin = sale.y;
                copyPortion[idx] = (copyPortion[idx] - coin < 1) ? 1 : copyPortion[idx] - coin;
            }
        }
        return ret;
    }
}
