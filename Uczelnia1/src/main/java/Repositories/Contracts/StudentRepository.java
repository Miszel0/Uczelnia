package Repositories.Contracts;

import Models.Student;
import Models.Major;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    Student save(Student student);

    List<Student> findAll();

    Optional<Student> findByString(String name, String surname);

    Optional<Student> findByMajor(Major major);
}
