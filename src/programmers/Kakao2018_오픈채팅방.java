package programmers;

import java.util.*;
import java.util.stream.Collectors;

public class Kakao2018_오픈채팅방 {

    public String[] solution(String[] record) {
        LinkedHashMap<String, String> userIdNicknameMap = new LinkedHashMap<>();
        List<String[]> messages = new ArrayList<>();

        for(int i = 0 ; i < record.length; ++i) {
            StringTokenizer st = new StringTokenizer(record[i]);
            String option = st.nextToken();
            String uniqueId = st.nextToken();

            if(isChangeOption(option)) {
                String nickname = st.nextToken();
                userIdNicknameMap.put(uniqueId, nickname);
                continue;
            }
            String message = getMessage(option);
            messages.add(new String[]{uniqueId, message});
            if(!isLeaveOption(option)) {
                String nickname = st.nextToken();
                userIdNicknameMap.put(uniqueId, nickname);
            }
        }

        List<String> answer = messages.stream().map(arr -> userIdNicknameMap.get(arr[0]) + arr[1]).collect(Collectors.toList());
        return answer.toArray(new String[0]);
    }

    public String getMessage(String option) {
        return option.equals("Enter") ? "님이 들어왔습니다.": "님이 나갔습니다.";
    }

    public boolean isChangeOption(String option) {
        return option.equals("Change") ? true : false;
    }

    public boolean isLeaveOption(String option) {
        return option.equals("Leave") ? true : false;
    }
}
