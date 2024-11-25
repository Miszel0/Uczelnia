package Models;

public enum Major {
    IT("Informatyka"),
    Med("Medycyna"),
    Law("Prawo"),
    Math("Matematyka"),
    Hist("Historia");

    private final String name;

    Major(String name) {
        if (name == null || name.trim().isEmpty()) {
            name = null;
        }
        this.name = name;
    }
}