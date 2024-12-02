package Seeders;

import Models.*;
import Repositories.CandidateInMemoryRepository;
import Repositories.Contracts.CandidateRepository;
import Repositories.Contracts.StudentRepository;
import Repositories.StudentInMemoryRepository;
import com.github.javafaker.Faker;

import java.io.OptionalDataException;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Random;

public class MainSeeder {

    public static Major getRandomMajor() {
        Major[] majors = Major.values();
        Random random = new Random();
        int randomIndex = random.nextInt(majors.length);
        return majors[randomIndex];
    }
    public static void seed() {
        System.out.println("Generowanie danych");
        CandidateRepository candidateRepository = new CandidateInMemoryRepository();
        Faker faker = new Faker(new Locale("pl-PL"));
        Random rand = new Random();

        int i;
        for(i = 0; i < 4; ++i) {
            Candidate candidate = new Candidate(faker.name().firstName(), faker.name().lastName(), getRandomMajor());
            CandidateSubject[] subjects = CandidateSubject.values();
            CandidateSubjectScoreList scoreList = new CandidateSubjectScoreList();
            for(int y = 0; y < subjects.length; y++) {
                int randomScore = rand.nextInt(100);
                CandidateSubjectScore subjectScore = new CandidateSubjectScore(randomScore, subjects[y]);
                scoreList.addScore(subjectScore);
            }
            candidateRepository.save(candidate);
            System.out.println(candidate);
        }


        System.out.println("Zakończono generowanie danych");
        System.out.println("==============================================");
    }
}


