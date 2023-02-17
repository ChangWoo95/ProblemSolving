import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1713_후보추천하기 {
    public static Set<Integer> pictures;
    public static int pictureCount;
    public static StudentInfo[] studentInfos;
    public static class StudentInfo {
        int recommends;
        int latestPostTime;

        public StudentInfo(int recommends, int latestPostTime) {
            this.recommends = recommends;
            this.latestPostTime = latestPostTime;
        }

        public void increaseRecommends() {
            ++recommends;
        }

        public void updatePostTime(int time) {
            this.latestPostTime = time;
        }

        public void initRecommends() {
            this.recommends = 0;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        pictures = new HashSet<>();
        studentInfos = new StudentInfo[101];
        for (int i = 0; i < 101; ++i) {
            studentInfos[i] = new StudentInfo(0, 0);
        }

        pictureCount = Integer.parseInt(br.readLine());

        int t = Integer.parseInt(br.readLine());
        int timeCount = 0;
        int fullCount = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < t; ++i) {
            int studentNum = Integer.parseInt(st.nextToken());

            if (pictures.contains(studentNum)) {
                studentInfos[studentNum].increaseRecommends();
            } else {
                if (fullCount == pictureCount) { // 사진틀이 다 차있으면
                    deleteOldestPicture();
                    --fullCount;
                }
                ++fullCount;
                pictures.add(studentNum);
                studentInfos[studentNum].increaseRecommends();
                studentInfos[studentNum].updatePostTime(timeCount);
            }
            ++timeCount;
        }
        List<Integer> results =new ArrayList<>(pictures);
        Collections.sort(results);

        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < results.size(); ++i) {
            sb.append(results.get(i)).append(" ");
        }
        System.out.println(sb);
    }

    public static void deleteOldestPicture() {
        int idx = 0;
        int recommends = 1001;
        for (int studentNum : pictures) {
            if (studentInfos[studentNum].recommends < recommends ) {
                idx = studentNum;
                recommends = studentInfos[studentNum].recommends;
            } else if (studentInfos[studentNum].recommends == recommends) {
                idx = findShortestPostTime(studentNum, idx);
            }
        }
        pictures.remove(idx);
        studentInfos[idx].initRecommends();
    }

    public static int findShortestPostTime(int a, int b) {
        if (studentInfos[a].latestPostTime < studentInfos[b].latestPostTime) {
            return a;
        } else {
            return b;
        }
    }
}
