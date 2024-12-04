package Services;

import Models.*;
import Repositories.CandidateInMemoryRepository;
import Repositories.Contracts.StudentRepository;
import Repositories.StudentInMemoryRepository;
import Repositories.Contracts.CandidateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.IntStream;

import static Repositories.CandidateInMemoryRepository.candidates;

public class CandidateService {

    public CandidateRepository candidateRepository = new CandidateInMemoryRepository();
    private Scanner scanner;

    public StudentRepository studentRepository = new StudentInMemoryRepository();
    public CandidateService() {
        this.scanner = new Scanner(System.in);
        this.candidateRepository = new CandidateInMemoryRepository();

    }

    public Optional<Candidate> findCandidateByName() {
        System.out.print("Wczytaj imię i nazwisko kandydata: ");
        String input = this.scanner.nextLine();
        String[] parts = input.split(" ", 2);
        if (parts.length < 2) {
            System.out.println("Podano niepełne dane. Wymagane imię i nazwisko.");
            return Optional.empty();
        }
        String name = parts[0];
        String surname = parts[1];
        Optional<Candidate> candidateOptional = candidateRepository.findCandidateByName(name, surname);
        if (candidateOptional.isEmpty()) {
            System.out.println("Kandydat nie został znaleziony");
        } else {
            System.out.println("Znaleziony kandydat: " + (candidateOptional.get()));
        }

        return candidateOptional;
    }

    public void printCandidate(Candidate candidate) {
        CandidateSubject[] subjects = CandidateSubject.values();
        System.out.print(
                "==============================================" +
                        "\nKandydat: " + candidate.getName() + candidate.getSurname() +
                        "\n 1. Wybrany kierunek: " + (candidate.getMajor()));

        CandidateSubjectScoreList candidateScoreList = candidate.getScores();

        for (int i = 0; i < subjects.length; i++) {
            CandidateSubject subject = subjects[i];
            CandidateSubjectScore matchingScore = candidateScoreList.getList()
                    .stream()
                    .filter(score -> score.getSubject() == subject)
                    .findFirst()
                    .orElse(null);

            if (matchingScore != null) {
                System.out.println("\n   - " + subject + ": " + matchingScore.getScore());
            } else {
                System.out.println("\n   - " + subject + ": brak wyniku");
            }
        }
    }


    public boolean isAccepted() {
        System.out.println("\n==============================================");
        System.out.println("Czy kandydat spełnia wymagania na ten kierunek?");
        System.out.println("1 - Przyjęcie kandydata");
        System.out.println("2 - Odrzucenie kandydata");

        int option1 = scanner.nextInt();

        switch (option1) {
            case 1 -> {
                System.out.println("Zmieniono status kandydata na studenta.");
                return true;
            }
            case 2 -> {
                System.out.println("Kandydat został usunięty z rejestru.");
                return false;
            }
            default -> {
                System.out.println("Nieprawidłowa opcja.");
                return isAccepted();
            }
        }
    }

    public void verifyByName() {
        if(candidates.isEmpty()){
            System.out.println("Brak zainteresowanych!");
            return;
        }

        Optional<Candidate> candidateByName = findCandidateByName();

        if (candidateByName.isEmpty()) {
            return;
        }
        candidateByName.ifPresent(this::printCandidate);


        if (isAccepted()) {

            candidateByName.ifPresent(candidate -> {
                Student student = new Student(candidate);
                studentRepository.save(student);
            });

            candidateByName.ifPresent(candidate -> candidateRepository.remove(candidate));
        } else {

            candidateByName.ifPresent(candidate -> candidateRepository.remove(candidate));
        }
    }

    public void verifyByList() {
        if(candidates.isEmpty()){
            System.out.println("Brak zainteresowanych!");
            return;
        }

        IntStream.range(0, candidates.size())
                .forEach(i -> {
                    Candidate candidate = candidates.get(i);
                    System.out.println((i+1) + ": " + candidate);
                });

        System.out.println("Proszę wybrać jednego z powyższych kandydatów (podaj numer):");
        if (!scanner.hasNextInt()) {
            System.out.println("Nieprawidłowe dane wejściowe! Podaj liczbę.");
            scanner.nextLine();
            return;
        }
        int option2 = scanner.nextInt();


        if (option2 > 0 && option2 <= candidates.size()) {
            Candidate selectedCandidate = candidates.get(option2-1);


            printCandidate(selectedCandidate);


            if (isAccepted()) {
                Student student = new Student(selectedCandidate);
                candidateRepository.remove(selectedCandidate);
                studentRepository.save(student);
                System.out.println("Kandydat został przyjęty i zapisany jako student: " + student);
            } else {
                candidateRepository.remove(selectedCandidate);
                System.out.println("Kandydat został odrzucony i usunięty z listy.");
            }
        } else {
            System.out.println("Wybrano numer spoza zakresu!");
        }
    }
}
