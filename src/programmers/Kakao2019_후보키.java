package programmers;
import java.util.*;

public class Kakao2019_후보키 {


    List<Integer> validCandidateKeyBits;

    public int solution(String[][] relation) {
        validCandidateKeyBits = new ArrayList<>();
        int attributeCount = relation[0].length;

        for(int i = 1; i <= attributeCount; ++i) {
            int[] pickSet = new int[i];
            findValidCandidateKey(pickSet, relation, 0, 0);
        }
        return validCandidateKeyBits.size();
    }

    public void findValidCandidateKey(int[] pickSet, String[][] relation, int depth, int start) {

        if(depth == pickSet.length) {
            int bitNum = bitmasking(pickSet);
            if(isUnique(pickSet, relation) && isMinimal(bitNum))
                validCandidateKeyBits.add(bitNum);
            return;
        }

        for(int i = start; i < relation[0].length; ++i) {
            pickSet[depth] = i + 1;
            findValidCandidateKey(pickSet, relation, depth + 1, i + 1);
        }

    }

    public int bitmasking(int[] pickSet) {
        int ret = 1;

        for(int pick : pickSet)
            ret |= (1 << pick);

        return ret;
    }

    public boolean isUnique(int[] pickSet, String[][] relation) {
        Set<String> candidateKeySet = new HashSet<>();
        for(int i = 0 ; i < relation.length; ++i) {
            String[] tuple = relation[i];
            StringBuilder sb = new StringBuilder();

            Arrays.stream(pickSet).forEach( pick -> sb.append(tuple[pick - 1]) );
            String candidateKey = sb.toString();

            if(candidateKeySet.contains(candidateKey)) return false;
            candidateKeySet.add(candidateKey);
        }
        return true;
    }

    public boolean isMinimal(int newBit) {
        for(int bit : validCandidateKeyBits) {
            if( (bit & newBit) >= bit) return false;
        }
        return true;
    }
}
