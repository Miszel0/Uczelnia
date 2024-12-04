package Models;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CandidateSubjectScoreList {

    private final List<CandidateSubjectScore> list = new LinkedList<>();

    // Dodawanie wyniku
    public void addScore(CandidateSubjectScore candidateSubjectScore) {
        list.add(candidateSubjectScore);
    }

    // Usuwanie wyniku
    public void removeScore(CandidateSubjectScore candidateSubjectScore) {
        list.remove(candidateSubjectScore);
    }

    // Pobieranie listy
    public List<CandidateSubjectScore> getList() {
        return list;
    }
}