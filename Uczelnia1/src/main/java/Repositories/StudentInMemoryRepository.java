package Repositories;

import Models.Student;
import Models.Major;
import Repositories.Contracts.StudentRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class StudentInMemoryRepository implements StudentRepository {

    private static final List<Student> students = new LinkedList<>();

    public Student save(Student student) {
        students.add(student);

        return student;
    }

    public List<Student> findAll() {
        return students;
    }

    public Optional<Student> findByString(String name, String surname) {
        return students                                                         // źródło danych
                .stream()                                                        // tworzenie strumienia
                .filter(student -> student.getName()+student.getSurname() == name + surname)    // metoda pośrednia; metoda filter pobiera ze strumienia elementy zgodne z predykatem
                .findFirst();                                                    // metoda końcowa; metoda findFirst zwraca pierwszy element strumienia opakowany w instancję typu Optional<T>
    }
    public Optional<Student> findByMajor(Major major) {
        return students
                .stream()
                .filter(student -> student.getMajor().equals(major))
                .findFirst();
    }

}
