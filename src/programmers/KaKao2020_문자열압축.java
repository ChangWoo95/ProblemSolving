package programmers;

public class KaKao2020_문자열압축 {

    class Solution {
        public int maxCount = 1001;

        public int solution(String s) {
            maxCount = Math.min(maxCount, s.length());

            for (int i = 0; i < s.length() / 2; ++i) {
                int len = getCompressedStrLen(s, i + 1);
                maxCount = Math.min(maxCount, len);
            }

            return maxCount;
        }

        public int getCompressedStrLen(String s, int bound) {
            String findingStr = s.substring(0, bound);
            int count = 0;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < s.length(); ++i) {
                String subStr = "";

                if(i + bound > s.length()) subStr = s.substring(i);
                else subStr = s.substring(i, i + bound);

                if (subStr.equals(findingStr)) ++count;
                else {
                    if (count > 1) sb.append(count);
                    sb.append(findingStr);
                    count = 1;
                    findingStr = subStr;
                }

                i += bound - 1;
            }

            if (count == 1) sb.append(findingStr);
            else sb.append(count).append(findingStr);

            return sb.length();
        }

    }
}
