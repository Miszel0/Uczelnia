package Models;

import Models.Candidate;
import Models.Major;

public class Student {
    private String name;
    private String surname;
    private Major major;

    public Student(Candidate candidate) {
        setNameFromCandidate(candidate);
        setSurnameFromCandidate(candidate);
        setMajorFromCandidate(candidate);
    }



    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }


    public void setNameFromCandidate(Candidate candidate) {
        this.name = candidate.getName();
    }

    public void setSurnameFromCandidate(Candidate candidate) {
        this.surname = candidate.getSurname();
    }

    public void setMajorFromCandidate(Candidate candidate) {
        this.major = candidate.getMajor();
    }

    public Major getMajor() {
        return this.major;
    }

    public String toString(){
        return "Imię: "+ name +
                " Nazwisko: " + surname +
                " Kierunek: " + major;

    }
}

