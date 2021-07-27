package programmers;

import java.util.Arrays;

public class Kakao2018_파일명정렬 {
    public String[] solution(String[] files) {
        String[][] splitedFiles = splitFileName(files);
        Arrays.sort(splitedFiles, (x1,x2) -> {
            String head1 = x1[0].toLowerCase();
            String head2 = x2[0].toLowerCase();
            int number1 = Integer.parseInt(x1[1]);
            int number2 = Integer.parseInt(x2[1]);

            if(!head1.equals(head2)) return head1.compareTo(head2);
            else if(number1 != number2) return Integer.compare(number1, number2);
            return 0;
        });
        String[] answer = new String[splitedFiles.length];
        for(int i = 0; i < answer.length; ++i) {
            String fileName = convertOrgFileName(splitedFiles[i]);
            answer[i] = fileName;
        }

        return answer;
    }

    public String convertOrgFileName(String[] file) {
        StringBuilder sb = new StringBuilder();
        sb.append(file[0]);
        sb.append(file[1]);
        sb.append(file[2]);
        return sb.toString();
    }

    public String[][] splitFileName(String[] files) {
        String[][] ret = new String[files.length][3];
        for(int i = 0; i < files.length; ++i) {
            String file = files[i];
            String head ="", number ="", tail ="";
            int headIdx = 1, numberIdx = 1;

            headIdx = findHead(file);
            head = file.substring(0, headIdx);
            if(headIdx != file.length()) {
                numberIdx = findNumber(headIdx, file);
                number = file.substring(headIdx, numberIdx);
            }
            if(numberIdx != file.length()) {
                tail = file.substring(numberIdx);
            }
            ret[i][0] = head;
            ret[i][1] = number;
            ret[i][2] = tail;
        }
        return ret;
    }

    public int findHead(String s) {
        int idx = 0;
        while(idx < s.length()) {
            char ch = s.charAt(idx);
            if(!Character.isDigit(ch)) ++idx;
            else return idx;
        }
        return idx;
    }

    public int findNumber(int idx, String s) {
        while(idx < s.length()) {
            char ch = s.charAt(idx);
            if(Character.isDigit(ch)) ++idx;
            else return idx;
        }
        return idx;
    }
}
