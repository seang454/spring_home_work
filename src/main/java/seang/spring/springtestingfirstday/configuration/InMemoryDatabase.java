package seang.spring.springtestingfirstday.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import seang.spring.springtestingfirstday.model.Student;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class InMemoryDatabase {
    @Bean
    public List<Student> students() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(1L, "Alice Johnson", "Female", 85.0));
        students.add(new Student(2L, "Bob Smith", "Male", 78.5));
        students.add(new Student(3L, "Catherine Lee", "Female", 92.0));
        students.add(new Student(4L, "David Kim", "Male", 88.0));
        students.add(new Student(5L, "Eva Brown", "Female", 75.0));
        students.add(new Student(6L, "Frank Green", "Male", 69.5));
        students.add(new Student(7L, "Grace Park", "Female", 91.0));
        students.add(new Student(8L, "Henry White", "Male", 82.0));
        students.add(new Student(9L, "Isabella Scott", "Female", 87.5));
        students.add(new Student(10L, "Jack Davis", "Male", 73.0));
        return students;
    }
}
