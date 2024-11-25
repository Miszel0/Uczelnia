package Models;

public class CandidateSubjectScore {

    private int score;
    private CandidateSubject subject;

    public CandidateSubjectScore(int score, CandidateSubject subject){
        setScore(score);
        this.subject = subject;
    }

    public float getScore() {
        return score;
    }


    public void setScore(float price) {
        if (CandidateSubjectScore.ScoreValidator.getInstance().isValid(score)) {
            this.score = score;
        }
    }

    public static class ScoreValidator {
        private static final ScoreValidator INSTANCE = new ScoreValidator();

        private ScoreValidator() {
        }

        public static ScoreValidator getInstance() {
            return INSTANCE;
        }

        public boolean isValid(int score) {
            if (score < 0) {
                throw new IllegalArgumentException("Wynik nie może być niższy niż 0");
            }
            else if (score > 100){
                throw new IllegalArgumentException("Wynik nie może być wyższy niż 100");
            }
            return true;
        }
    }

}
