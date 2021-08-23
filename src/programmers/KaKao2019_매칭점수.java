package programmers;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KaKao2019_매칭점수 {

    static class PageInfo {
        public double normalScore;
        public int externalLinkCount;
        public double linkScore;
        public double myLinkScore;
        public List<String> linkedExternUrls;

        PageInfo(double normalScore, int externalLinkCount, double myLinkScore, List<String> linkedExternUrls) {
            this.normalScore = normalScore;
            this.externalLinkCount = externalLinkCount;
            this.myLinkScore = myLinkScore;
            this.linkedExternUrls = linkedExternUrls;

        }

        public void addLinkScore(double linkScore) {
            this.linkScore += linkScore;
            return ;
        }

        public double caculateMatchingScore() {
            return this.normalScore + this.linkScore;
        }

    }

    public static int solution(String word, String[] pages) {
        Map<String, PageInfo> pageManager = new LinkedHashMap<>();

        for(String page : pages) {
            String uniqueUrl = getScoreInfo("<meta property=\"og:url\" content=\"(\\S*)\"", page);
            List<String> externUrls = getScoreInfo("<a href=\"(\\S*)\"", page, new ArrayList<>());
            int externalLinkCount = externUrls.size();
            double normalScore = getScoreInfo("\\b(?i)" + word +"\\b", page.split("<body>")[1].split("</body>")[0].replaceAll("[0-9]", " "), word);
            PageInfo pageInfo = new PageInfo(normalScore, externalLinkCount, normalScore / externalLinkCount, externUrls);
            pageManager.put(uniqueUrl, pageInfo);
        }

        for(Map.Entry<String, PageInfo> pageLinkInfo : pageManager.entrySet()) {
            PageInfo info = pageLinkInfo.getValue();
            List<String> externUrls = info.linkedExternUrls;

            for(String externUrl : externUrls) {
                if(pageManager.containsKey(externUrl)) {
                    PageInfo externPageInfo = pageManager.get(externUrl);
                    externPageInfo.linkScore += info.myLinkScore;
                    pageManager.put(externUrl, externPageInfo);
                }
            }
        }

        int answer = findMaximumScoreIndex(pageManager);

        return answer;
    }
    public static int findMaximumScoreIndex(Map<String, PageInfo> pageManager) {
        double maximumScore = -1;
        int idx = -1;
        int maximumIndex = 0;

        for(Map.Entry<String, PageInfo> pageLinkInfo : pageManager.entrySet()) {
            ++idx;
            double pageMaximumScore = pageLinkInfo.getValue().caculateMatchingScore();
            if(maximumScore < pageMaximumScore) {
                maximumScore = pageMaximumScore;
                maximumIndex = idx;
            }
            else if(maximumScore == pageMaximumScore) maximumIndex = Math.min(maximumIndex, idx);
        }
        return maximumIndex;
    }

    public static String getScoreInfo(String pattern, String page) {
        Pattern uniqueUrlPattern = Pattern.compile(pattern);
        String uniqueUrl = "";
        Matcher uniqueUrlMatcher = uniqueUrlPattern.matcher(page);
        if (uniqueUrlMatcher.find()) {
            uniqueUrl = uniqueUrlMatcher.group().split("=")[2].replaceAll("\"", "");
        }

        return uniqueUrl;
    }

    public static List<String> getScoreInfo(String pattern, String page, ArrayList<String> externUrls) {
        Pattern neighborUrlPattern = Pattern.compile(pattern);
        Matcher neighborUrlMatcher = neighborUrlPattern.matcher(page);

        while(neighborUrlMatcher.find()) {
            String externUrl = neighborUrlMatcher.group().split("=")[1].replaceAll("\"", "");
            externUrls.add(externUrl);
        }

        return externUrls;
    }

    public static double getScoreInfo(String s, String page, String word) {
        Pattern wordPattern = Pattern.compile(s);
        Matcher wordWatcher = wordPattern.matcher(page);
        double normalScore = 0d;
        while(wordWatcher.find()) {
            ++normalScore;
        }
        return normalScore;
    }
}
