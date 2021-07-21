package programmers;

import java.util.HashMap;
import java.util.Map;

public class Kakao2018_캐시 {

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Map<String, Integer> caches = new HashMap<>();
        if(cacheSize == 0) return 5 * cities.length;

        for(int i = 0 ; i <cities.length; ++i) {
            String lowercaseCity = cities[i].toLowerCase();
            if(caches.containsKey(lowercaseCity)){
                caches.replace(lowercaseCity, i);
                answer += 1;
            } else {
                if(caches.size() == cacheSize) {
                    String changingCity = findLruKey(caches);
                    caches.remove(changingCity);
                }
                caches.put(lowercaseCity, i);
                answer += 5;
            }
        }

        return answer;
    }
    public String findLruKey(Map<String, Integer> caches){
        String ret = "";
        int minTime = 100001;
        for(Map.Entry<String, Integer> cache : caches.entrySet()) {
            if(cache.getValue() <= minTime) {
                minTime = cache.getValue();
                ret = cache.getKey();
            }
        }
        return ret;
    }
}
