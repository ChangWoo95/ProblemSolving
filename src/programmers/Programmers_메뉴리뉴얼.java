package programmers;

import java.util.*;

public class Programmers_메뉴리뉴얼 {
    public static List<Character> alphaList;
    public static int[] bitList;
    public static char[] output;
    public static int max;
    public static List<Node> ans;
    public static List<String> answer;

    public static class Node {
        int cnt;
        String menu;

        Node(int cnt, String menu) {
            this.cnt = cnt;
            this.menu = menu;
        }
    }

    public static String[] solution(String[] orders, int[] course) {
        bitList = new int[orders.length];
        answer = new ArrayList<>();

        alphaList = new ArrayList<>();
        ans = new ArrayList<>();
        for (int i = 0; i < orders.length; ++i) {
            String order = orders[i];
            int bit = 0;
            for (int j = 0; j < order.length(); ++j) {
                char menu = order.charAt(j);
                bit |= 1 << (menu - 'A');
                if (!alphaList.contains(menu)) {
                    alphaList.add(menu);
                }
            }
            bitList[i] = bit;
        }
        Collections.sort(alphaList);
        for (int i = 0; i < course.length; ++i) {
            max = Integer.MIN_VALUE;
            output = new char[course[i]];
            ans = new ArrayList<>();
            comb(0, 0, 0);
            Collections.sort(ans, (o1, o2) -> Integer.compare(o1.cnt, o2.cnt));
            System.out.println(i + " " + max);
            for(int j = 0 ; j < ans.size(); ++j) System.out.println(ans.get(j).menu + " " + ans.get(j).cnt);

            for (int j = ans.size() - 1; j >= 0; --j) {
                if (ans.get(j).cnt == max) answer.add(ans.get(j).menu);
                else break;
            }
        }
        return answer.toArray(new String[answer.size()]);
    }

    public static void comb(int depth, int start, int sumBit) {
        if (depth == output.length) {
            int cnt = 0;
            for (int i = 0; i < bitList.length; ++i) {
                if ((bitList[i] & sumBit) == sumBit) ++cnt;
            }
            if (cnt < 2) return;
            if (max <= cnt) {
                max = cnt;
                ans.add(new Node(cnt, new String(output)));
            }
            return;
        }
        for (int i = start; i < alphaList.size(); ++i) {
            output[depth] = alphaList.get(i);
            comb(depth + 1, i + 1, sumBit | 1 << (alphaList.get(i) - 'A'));
        }
    }

    public static void main(String[] args) {
        String[] s = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] c = {2, 3, 4};
        String[] ss = solution(s, c);
        for (int i = 0; i < ss.length; ++i) {
            System.out.println(ss[i]);
        }
    }
}
