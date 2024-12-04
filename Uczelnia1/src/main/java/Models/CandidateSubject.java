package Models;

public enum CandidateSubject {
    PL("Język Polski"),
    ENG("Język Angielski"),
    PHYS("Fizyka"),
    MATH("Matematyka"),
    HIST("Historia"),
    BIO("Biologia"),
    CHEM("Chemia"),
    GEO("Geografia");
    private final String name;

    CandidateSubject(String name) {
        this.name = name;
    }
}
