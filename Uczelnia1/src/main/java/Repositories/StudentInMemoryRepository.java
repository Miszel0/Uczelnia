package Repositories;

import Models.Candidate;
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


    public Student remove(Student student) {
        students.remove(student);

        return student;
    }

    public List<Student> findAll() {
        return students;
    }

    public Optional<Student> findStudentByName(String name, String surname) {
        return students
                .stream()
                .filter(student -> (student.getName() + student.getSurname()).equals(name + surname))
                .findFirst();
    }




}
