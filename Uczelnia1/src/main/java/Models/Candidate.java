package Models;

public class Candidate {
    String name;
    String surname;
    CandidateSubjectScoreList candidateSubjectScoreList;
    Major major;


    private Candidate(String name, String surname, Major major) {
        setName(name);
        setSurname(surname);
        setMajor(major);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getSurname() {
        return this.surname;
    }


    public void setSurname(String name) {
        this.surname = surname;
    }

    public void setMajor(Major major) {
        this.major = major;
    }

    public Major getMajor() {
        return this.major;
    }

    public CandidateSubjectScoreList getScores(CandidateSubjectScoreList candidateSubjectScoreList) {
        return candidateSubjectScoreList;
    }
}