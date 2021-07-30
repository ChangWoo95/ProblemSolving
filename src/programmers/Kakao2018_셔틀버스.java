package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kakao2018_셔틀버스 {
    static int idx = 0;

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";

        int busRunningTime = 9 * 60;
        int[] crewArrivedTimeArr = convertStringArrToIntArr(timetable);
        List[] shuttleBuses = getShuttleBus(n);

        for(int i = 0 ; i < n; ++i) {
            shuttleBuses[i] = findCrewRidingTimeListPerBus(crewArrivedTimeArr, busRunningTime, m);
            if(i != n-1) busRunningTime += t;
        }

        List<Integer> lastShuttleBus = shuttleBuses[n-1];

        if(lastShuttleBus.size() < m) return getConArrivedTime(busRunningTime);
        else {
            for(int i = m-1; i >0; --i){
                int curArrivedTime = lastShuttleBus.get(i);
                int prevArrivedTime = lastShuttleBus.get(i - 1);
                if(curArrivedTime != prevArrivedTime) return getConArrivedTime(curArrivedTime - 1);
            }
            return getConArrivedTime(lastShuttleBus.get(0) - 1);
        }
    }

    public String getConArrivedTime(int time) {
        return String.format("%02d:%02d", time/60, time%60);
    }

    public List<Integer> findCrewRidingTimeListPerBus(int[] crewArrivedTimeArr, int busRunningTime, int maxPassengers) { // 버스당 타는 승객의 도착시간 집합 구하기
        ArrayList<Integer> crewRidingTimeList = new ArrayList<>();
        while(idx < crewArrivedTimeArr.length && crewRidingTimeList.size() < maxPassengers && crewArrivedTimeArr[idx] <= busRunningTime){
            crewRidingTimeList.add(crewArrivedTimeArr[idx++]);
        }
        return crewRidingTimeList;
    }

    public int[] convertStringArrToIntArr(String[] timetable) { // timetable을 시간으로 변경
        return Arrays.stream(timetable)
                .mapToInt(time -> Integer.parseInt(time.substring(0,2)) * 60 + Integer.parseInt(time.substring(3)))
                .sorted()
                .toArray();
    }

    public List[] getShuttleBus(int n) { // 셔틀버스 구하기
        List[] ret = new List[n];
        for(int i = 0 ; i < n; ++i) {
            ret[i] = new ArrayList();
        }
        return ret;
    }
}
