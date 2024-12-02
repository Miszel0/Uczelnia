package Models;

public class Candidate {
    private String name;
    private String surname;
    private CandidateSubjectScoreList candidateSubjectScoreList;
    private Major major;


    public Candidate(String name, String surname, Major major) {
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

    public void setCandidateSubjectScoreList (CandidateSubjectScoreList candidateSubjectScoreList){
        this.candidateSubjectScoreList = candidateSubjectScoreList;
    }


    public CandidateSubjectScoreList getScores(CandidateSubjectScoreList candidateSubjectScoreList) {
        return candidateSubjectScoreList;
    }

    public String toString(){
        return "Imię: "+ name +
        " Nazwisko: " + surname +
        " Kierunek: " + major;

    }
}