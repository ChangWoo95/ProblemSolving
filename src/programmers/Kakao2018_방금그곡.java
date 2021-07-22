package programmers;

public class Kakao2018_방금그곡 {

    public class Music {
        private int time;
        private String name;
        private String melody;

        Music(int time, String name, String melody){
            this.time = time;
            this.name = name;
            this.melody = melody;
        }
    }

    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int ansTime = -1;
        m = replaceMelody(m);

        Music[] filteredMusicInfo = filteringTimeNameMelody(musicinfos);
        for(int i = 0 ; i < filteredMusicInfo.length; ++i) {
            Music music = filteredMusicInfo[i];
            if(!music.melody.contains(m)) continue;
            if(ansTime < music.time) {
                ansTime = music.time;
                answer = music.name;
            }
        }
        if(ansTime == -1) return "(None)";
        else return answer;
    }

    public Music[] filteringTimeNameMelody(String[] musicinfos){
        int len = musicinfos.length;
        Music[] ret = new Music[len];

        for(int i = 0 ; i < musicinfos.length; ++i) {
            String[] musicinfo = musicinfos[i].split(",");
            int startTime = Integer.parseInt(musicinfo[0].substring(0, 2))*60 + Integer.parseInt(musicinfo[0].substring(3));
            int endTime = Integer.parseInt(musicinfo[1].substring(0, 2))*60 + Integer.parseInt(musicinfo[1].substring(3));
            int playTime = endTime - startTime;
            String name = musicinfo[2];
            String melody = convertString(playTime, musicinfo[3]);
            ret[i] = new Music(playTime, name, melody);
        }
        return ret;
    }

    public String convertString(int time, String s){
        s = replaceMelody(s);
        if(time <= s.length()) return s.substring(0, time);
        else {
            StringBuilder sb = new StringBuilder(s);
            int idx = time - s.length();
            for(int i = 0; i < idx; ++i) {
                sb.append(sb.charAt(i));
            }
            return sb.toString();
        }
    }

    public String replaceMelody(String s) {
        s = s.replaceAll("C#", "c");
        s = s.replaceAll("D#","d");
        s = s.replaceAll("F#", "f");
        s = s.replaceAll("G#", "g");
        s = s.replaceAll("A#", "a");
        return s;
    }

}
