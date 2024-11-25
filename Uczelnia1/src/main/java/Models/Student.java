package Models;

import Models.Candidate;
import Models.Major;

public class Student {
    String name;
    String surname;
    Major major;

    private Student(Candidate Candidate) {
        setNameFromCandidate(Candidate);
        setSurnameFromCandidate(Candidate);
        setMajorFromCandidate(Candidate);
    }

    public String getName() {
        return this.name;
    }
    public String getSurname() {
        return this.surname;
    }


    public void setNameFromCandidate(Candidate Candidate) {
        this.name = Candidate.getName();
    }

    public void setSurnameFromCandidate(Candidate Candidate) {
        this.surname = Candidate.getSurname();
    }

    public void setMajorFromCandidate(Candidate Candidate) {
        this.major = Candidate.getMajor();
    }

    public Major getMajor() {
        return this.major;
    }

}

