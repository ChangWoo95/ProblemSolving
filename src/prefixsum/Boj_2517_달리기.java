package prefixsum;
import java.util.*;
import java.io.*;

public class Boj_2517_달리기 {
    static int[] runList, statTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int h = (int) Math.ceil(Math.log10(n) / Math.log10(2));
        runList = new int[n];
        statTree = new int[1 << (h + 1)];

        for (int i = 0; i < n; ++i) {
            runList[i] = Integer.parseInt(br.readLine());
        }
        int[] copy = runList.clone();
        Arrays.sort(copy);
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < n; ++i) {
            if (!map.containsKey(copy[i])) {
                map.put(copy[i], ++idx);
            }
        }

        for (int i = 0; i < n; ++i) {
            int val = sum(1, 1, n, 1, map.get(runList[i]) - 1);
            update(1, 1, n, map.get(runList[i]), 1);
            sb.append(i+1 - val).append("\n");
        }
        System.out.print(sb);
    }

    static void update(int node, int start, int end, int index, int diff) {
        if (index < start || index > end) return;
        statTree[node] = statTree[node] + diff;
        if (start != end) {
            update(node * 2, start, (start + end) / 2, index, diff);
            update(node * 2 + 1, (start + end) / 2 + 1, end, index, diff);
        }
    }

    static int sum(int node, int start, int end, int left, int right) {
        if (left > end || right < start) return 0;
        if (left <= start && end <= right) return statTree[node];
        return sum(node * 2, start, (start + end) / 2, left, right) + sum(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
    }
}
