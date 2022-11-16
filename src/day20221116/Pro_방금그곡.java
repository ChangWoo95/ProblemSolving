package day20221116;

import java.io.IOException;
import java.util.*;

public class Pro_방금그곡 {
    public static String solution(String m, String[] musicinfos) {

        String cm = convertedMelody(m);
        List<String[]> convertedInfos = new ArrayList<>();

        for(String musicInfo : musicinfos) {
            StringTokenizer st = new StringTokenizer(musicInfo, ",");
            String startTime = st.nextToken();
            String endTime = st.nextToken();
            String title = st.nextToken();
            String melodies = st.nextToken();

            String timeDiff = getTimeDiff(startTime, endTime);
            String convertedMelodies = convertedMelody(melodies);

            StringBuilder sb = new StringBuilder();
            int idx = 0;

            for(int i = 0 ; i < Integer.parseInt(timeDiff); ++i) {
                sb.append(convertedMelodies.charAt(idx++));
                if (idx == convertedMelodies.length()) {
                    idx = 0;
                }
            }
            String storedMelody = sb.toString();
            if (storedMelody.contains(cm)) {
                convertedInfos.add(new String[] {timeDiff, startTime, title});
            }
        }

        if(convertedInfos.size() == 0) return "(None)";
        else {
            Collections.sort(convertedInfos, (x1, x2) -> {
                int timeDiff1 = Integer.parseInt(x1[0]);
                int timeDiff2 = Integer.parseInt(x2[0]);
                if(timeDiff1 < timeDiff2) return 1;
                else if (timeDiff1 > timeDiff2) return -1;
                else return x1[1].compareTo(x2[1]);
            });
        }

        return convertedInfos.get(0)[2];
    }

    public static String getTimeDiff(String start, String end) {
        StringTokenizer st = new StringTokenizer(start, ":");
        int startTime = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());

        st = new StringTokenizer(end, ":");
        int endTime = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());

        return String.valueOf(Math.abs(endTime - startTime));
    }

    public static String convertedMelody(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < s.length(); ++i) {
            char ch = s.charAt(i);
            if(Character.isAlphabetic(ch)) {
                sb.append(ch);
            } else {
                char convertedChar = sb.charAt(sb.length() - 1);
                sb.setCharAt(sb.length() - 1, (char) (convertedChar +32));
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) throws IOException {
        System.out.println(solution("ABCDEFG",new String[] {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(solution("CC#BCC#BCC#BCC#B",new String[] {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
        System.out.println(solution("ABC",new String[] {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
    }
}
