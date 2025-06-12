package seang.spring.springtestingfirstday.model.service;

import org.hibernate.sql.Update;
import org.springframework.stereotype.Service;
import seang.spring.springtestingfirstday.model.Student;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    private final List<Student> students;
    public StudentService(List<Student> students) {
        this.students = students;
    }


    public List<Student> findAllStudents() {
        if (!students.isEmpty()) {
            return students;
        }
        return null;
    }
    public Student insertingStudent(Student student) {
        if(student!=null){
            students.add(student);
            System.out.println("Inserted student: " + student + " successfully");
        }

        return student;
    }

    public Student selectStudentById(int id) {
        return students.stream().filter(stu-> stu.getId() == id).findFirst().get();
    }
    public Student updateStudentById(Integer id,Student newStudent) {
        Student student = selectStudentById(id);
        if (student != null) {
            for (int i=0;i<students.size();i++) {
                if (students.contains(student)) {
                    students.set(id-1, newStudent);
                }
            }
            System.out.println("Student updated: " + student + " successfully");
            return student;
        }
        return null;
    }
    public Integer deleteStudentById(Integer id) {
        Student student = selectStudentById(id);
        boolean remove = false;
        if (student != null) {
            remove = students.remove(student);
            System.out.println("Removed student: " + student +" successfully");
        }
        return remove? 1:0;
    }
}
