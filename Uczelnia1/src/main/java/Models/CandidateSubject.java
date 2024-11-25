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
        if (name == null || name.trim().isEmpty()) {
            name = null;
        }
        this.name = name;
    }
}
