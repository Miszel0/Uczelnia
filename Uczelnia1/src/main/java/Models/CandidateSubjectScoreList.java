package Models;

import java.util.LinkedList;
import java.util.List;

public class CandidateSubjectScoreList {

    private static final List<CandidateSubjectScore> list = new LinkedList<>();

    public static void addScore(CandidateSubject subject, double score) {
        list.add(new CandidateSubjectScore(0, CandidateSubject.ENG));
    }

    public static void removeScore(CandidateSubject subject, double score) {
        list.remove(new CandidateSubjectScore(0, CandidateSubject.ENG));
    }


    public static List<CandidateSubjectScore> getScores() {
        return list;
    }
}