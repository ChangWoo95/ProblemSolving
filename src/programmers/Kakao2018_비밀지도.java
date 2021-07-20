package programmers;

public class Kakao2018_비밀지도 {

    public static String[] solution(int n, int[] arr1, int[] arr2) {

        String[] twoBitConverter1 = convertTwoBits(arr1);
        String[] twoBitConverter2 = convertTwoBits(arr2);

        String[] answer = mergeArr(twoBitConverter1, twoBitConverter2);

        return answer;
    }

    public static String[] convertTwoBits(int[] arr1) {
        String[] twoBitConverter = new String[arr1.length];
        int len = arr1.length;

        for(int i = 0; i< arr1.length; ++i) {
            twoBitConverter[i] = String.format("%0" + len + "d", Long.parseLong( Integer.toBinaryString(arr1[i])) );
            //Integer.toBinaryString(arr1[i]);
        }
        return twoBitConverter;
    }

    public static String[] mergeArr(String[] arr1, String[] arr2) {
        String[] ret = new String[arr1.length];
        for(int i = 0 ; i <arr1.length; ++i) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < arr1[i].length(); ++j) {
                int xorValue = (arr1[i].charAt(j) - '0') | (arr2[i].charAt(j) - '0');
                if (xorValue == 1) {
                    sb.append('#');
                } else {
                    sb.append(' ');
                }
            }
            ret[i] = sb.toString();
        }
        return ret;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] arr1 = {9, 20, 28, 18, 11};
        int[] arr2 = {30, 1, 21, 17, 28};
        String[] ss = solution(n, arr1, arr2);
    }
}
