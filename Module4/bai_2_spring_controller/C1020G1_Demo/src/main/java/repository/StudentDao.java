package repository;

import model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentDao {
    static Map<Integer, Student> listStudent;
    static {
        listStudent = new HashMap<>();
        listStudent.put(1 , new Student(1,"Thinh"));
        listStudent.put(2 , new Student(2,"Son"));
        listStudent.put(3 , new Student(3,"Dung"));
        listStudent.put(4 , new Student(4,"Tung"));
    }

    public List<Student> getAllStudent(){
        return new ArrayList<>(listStudent.values());
    }

    public void createStudent(Student student){
        listStudent.put(student.getId(), student);
    }
}
