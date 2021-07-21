package programmers;

import java.util.HashMap;
import java.util.Map;

public class Kakao2018_뉴스클러스터링 {
    public int solution(String str1, String str2) {
        Map<String, Integer> StringMap1  = makeSet(str1);
        Map<String, Integer> StringMap2  = makeSet(str2);
        if(StringMap1.size() ==0 && StringMap2.size() == 0) return 65536;
        int interSectionCount = findInterSerctionCount(StringMap1, StringMap2);
        int unionCount = findUnionCount(StringMap1, StringMap2);
        return 65536 * interSectionCount / unionCount;
    }
    public Map<String, Integer> makeSet(String s) {
        Map<String, Integer> ret = new HashMap<>();
        s = s.toLowerCase();

        for(int i = 0 ; i < s.length() -1; ++i) {
            if(!Character.isAlphabetic(s.charAt(i)) || !Character.isAlphabetic(s.charAt(i+1)) ) continue;
            String subString = s.substring(i, i+2);
            if(ret.containsKey(subString)) ret.replace(subString, ret.get(subString) + 1);
            else ret.put(subString, 1);
        }
        return ret;
    }

    public int findInterSerctionCount(Map<String, Integer> map1, Map<String, Integer> map2) {
        int interSerctionCount = 0;
        for(Map.Entry<String, Integer> StringSet : map1.entrySet()) {
            String s = StringSet.getKey();
            if(map2.containsKey(s)) interSerctionCount += Math.min(StringSet.getValue(), map2.get(s));
        }
        return interSerctionCount;
    }

    public int findUnionCount(Map<String, Integer> map1, Map<String, Integer> map2) {
        int unionCount = 0;
        for(Map.Entry<String, Integer> StringSet : map1.entrySet()) {
            String s = StringSet.getKey();
            if(map2.containsKey(s)) unionCount += Math.max(StringSet.getValue(), map2.get(s));
            else unionCount += StringSet.getValue();
        }
        for(Map.Entry<String, Integer> StringSet : map2.entrySet()) {
            String s = StringSet.getKey();
            if(map1.containsKey(s)) continue;
            else unionCount += StringSet.getValue();
        }
        return unionCount;
    }
}
