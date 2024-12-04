package Repositories.Contracts;

import Models.Candidate;
import Models.Major;
import Models.Student;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository {
    Candidate save(Candidate candidate);

    Candidate remove(Candidate candidate);

    List<Candidate> findAll();

    Optional<Candidate> findCandidateByName(String name, String surname);


}
