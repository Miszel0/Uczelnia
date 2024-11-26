package Models;

import java.util.LinkedList;
import java.util.List;

public class CandidateSubjectScoreList {

    private static final List<CandidateSubjectScore> list = new LinkedList<>();
    
    public static void addScore(CandidateSubjectScore candidateSubjectScore) {
        list.add(candidateSubjectScore);
    }

    public static void removeScore(CandidateSubjectScore candidateSubjectScore) {
        list.remove(candidateSubjectScore);
    }


    public static List<CandidateSubjectScore> getScores() {
        return list;
    }
}
