package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_8979_올림픽 {

    public static int n, k;

    public static class Nation {
        int nationNum;
        int goldCount;
        int silverCount;
        int bronzeCount;

        public Nation(int nationNum, int goldCount, int silverCount, int bronzeCount) {
            this.nationNum = nationNum;
            this.goldCount = goldCount;
            this.silverCount = silverCount;
            this.bronzeCount = bronzeCount;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Nation[] nations = new Nation[n];

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            int nationNum = Integer.parseInt(st.nextToken());
            int goldCount = Integer.parseInt(st.nextToken());
            int silverCount = Integer.parseInt(st.nextToken());
            int bronzeCount = Integer.parseInt(st.nextToken());
            nations[i] = new Nation(nationNum, goldCount, silverCount, bronzeCount);
        }

        Arrays.sort(nations, (x1, x2) -> {
            if (x1.goldCount > x2.goldCount) return -1;
            else if (x1.goldCount == x2.goldCount) {
                if (x1.silverCount > x2.silverCount) return -1;
                else if (x1.silverCount == x2.silverCount) {
                    if (x1.bronzeCount > x2.bronzeCount) return -1;
                    else if (x1.bronzeCount == x2.bronzeCount) return 0;
                    else return 1;
                } else return 1;
            } else return 1;

        });

        int idx = getAnswerIdx(nations);
        int sequence = 1;

        for (int i = idx; i > 0; --i) {
            Nation nation1 = nations[i];
            Nation nation2 = nations[i - 1];
            if (isSame(nation1, nation2)) continue;
            else {
                sequence = i+1;
                break;
            }
        }
        System.out.println(sequence);
    }

    public static boolean isSame(Nation nation1, Nation nation2) {
        return nation1.goldCount == nation2.goldCount && nation1.silverCount == nation2.silverCount && nation1.bronzeCount == nation2.bronzeCount;
    }

    public static int getAnswerIdx(Nation[] nations) {
        int ret = 0;

        for (int i = 0; i < nations.length; ++i) {
            if (nations[i].nationNum == k) {
                ret = i;
                break;
            }
        }
        return ret;
    }
}