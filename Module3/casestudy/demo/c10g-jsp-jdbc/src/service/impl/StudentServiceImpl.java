package service.impl;

import bean.Student;
import repository.StudentRepository;
import repository.impl.StudentRepositoryImpl;
import service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository = new StudentRepositoryImpl();

    @Override
    public String save(Student student) {
        if (student.getName().equals("") || student.getDateOfBirth().equals("")) {
            return "Please input!";
        } else {
            studentRepository.save(student);
            return "OK";
        }
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public void deleteById(Integer id) {

    }
}
