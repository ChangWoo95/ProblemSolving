package programmers;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KaKaoWinter2019_튜플 {
    public int[] solution(String s) {
        s = s.substring(1, s.length()-1);
        int[] answer = {};
        List<String[]> elementSets = getOrderedElementSet(s);
        Set<Integer> answerSet = getTupleSet(elementSets);
        return new ArrayList<Integer>(answerSet).stream().mapToInt(Integer::intValue).toArray();
    }

    public Set<Integer> getTupleSet(List<String[]> elementSets) {
        Set<Integer> ret = new LinkedHashSet<>();

        for(String[] elementSet : elementSets) {
            for(String element : elementSet) {
                if(ret.contains(element)) continue;
                ret.add(Integer.parseInt(element));
            }
        }
        return ret;
    }

    public List<String[]> getOrderedElementSet(String s) {
        List<String[]> ret = new ArrayList<>();
        Pattern elPattern = Pattern.compile("\\{.*?\\}");
        Matcher elSetMatcher = elPattern.matcher(s);

        while(elSetMatcher.find()) {
            String elString = elSetMatcher.group();
            String[] elementSet = elString.substring(1, elString.length()-1).split(",");
            ret.add(elementSet);
        }

        Collections.sort(ret, (x1,x2) -> Integer.compare(x1.length, x2.length));
        return ret;
    }
}
