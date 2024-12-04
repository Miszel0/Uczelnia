package Repositories;

import Models.Candidate;
import Models.Major;
import Repositories.Contracts.CandidateRepository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class CandidateInMemoryRepository implements CandidateRepository {

    public static final List<Candidate> candidates = new LinkedList<>();

    public Candidate save(Candidate candidate) {
        candidates.add(candidate);

        return candidate;
    }

    public Candidate remove(Candidate candidate) {
        candidates.remove(candidate);

        return candidate;
    }

    public List<Candidate> findAll() {
        return candidates;
    }


    public Optional<Candidate> findCandidateByName(String name, String surname) {
        return candidates                                                        //źródło danych
                .stream()                                                        // tworzenie strumienia
                .filter(candidate -> (candidate.getName() + candidate.getSurname()).equals(name + surname))    // metoda pośrednia; metoda filter pobiera ze strumienia elementy zgodne z predykatem
                .findFirst();                                                    // metoda końcowa; metoda findFirst zwraca pierwszy element strumienia opakowany w instancję typu Optional<T>
    }


}
