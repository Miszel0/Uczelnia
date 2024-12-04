package Models;

public enum Major {
    CS("Informatyka"),
    Med("Medycyna"),
    Law("Prawo"),
    Math("Matematyka"),
    Hist("Historia");

    private final String name;

    Major(String name) {
        this.name = name;
    }
}