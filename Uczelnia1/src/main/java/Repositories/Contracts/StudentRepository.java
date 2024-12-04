package Repositories.Contracts;

import Models.Candidate;
import Models.Student;
import Models.Major;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    Student save(Student student);

    Student remove(Student student);

    List<Student> findAll();

    Optional<Student> findStudentByName(String name, String surname);

}
