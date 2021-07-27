package programmers;

import java.util.*;

public class Kakao2018_압축 {
    public int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        Map<String, Integer> dictionary = init();

        for(int i = 0 ; i < msg.length(); ++i) {
            int unMemorizedWordIdx = findMemorizedWordIdx(dictionary, msg, i);
            String memorizedWord = msg.substring(i, unMemorizedWordIdx);
            int memorizedIndex = dictionary.get(memorizedWord);
            answer.add(memorizedIndex);
            if(unMemorizedWordIdx >= msg.length()) break;

            String unMemorizedWord = msg.substring(i, unMemorizedWordIdx + 1);
            dictionary.put(unMemorizedWord, dictionary.size() + 1);

            if(unMemorizedWordIdx - i != 1) i = unMemorizedWordIdx-1;
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    public Map<String, Integer> init() {
        Map<String, Integer> ret = new HashMap<>();
        char initialCharacter = 'A';
        for(int i= 0 ; i < 26; ++i) {
            String newWord = String.valueOf( (char) (initialCharacter + i) );
            ret.put(newWord, i + 1);
        }
        return ret;
    }

    public int findMemorizedWordIdx(Map<String, Integer> map, String s, int idx) {
        int nextIdx = idx + 1;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(idx));

        while(nextIdx < s.length()) {
            char newCharacter = s.charAt(nextIdx);
            sb.append(newCharacter);
            String newWord = sb.toString();
            if(map.containsKey(newWord)) ++nextIdx;
            else return nextIdx;
        }
        return nextIdx;
    }
}
