package seang.spring.springtestingfirstday;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import seang.spring.springtestingfirstday.model.Student;
import seang.spring.springtestingfirstday.model.service.StudentService;

import java.util.Scanner;

@SpringBootApplication
public class SpringTestingFirstDayApplication implements CommandLineRunner {
    private final StudentService studentService;

    // Inject StudentService using constructor injection
    public SpringTestingFirstDayApplication(StudentService studentService) {
        this.studentService = studentService;
    }
    public static void main(String[] args) {
        SpringApplication.run(SpringTestingFirstDayApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int option = -1;

        while (option != 0) {
            System.out.println("\n==== Student Menu ====");
            System.out.println("1. List all students");
            System.out.println("2. Add new student");
            System.out.println("3. Find student by ID");
            System.out.println("4. Update student by ID");
            System.out.println("5. Delete student by ID");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 1 -> {
                    System.out.println("Students:");
                    studentService.findAllStudents().forEach(System.out::println);
                }
                case 2 -> {
                    System.out.print("Enter ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter full name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter score: ");
                    double score = Double.parseDouble(scanner.nextLine());
                    studentService.insertingStudent(new Student((long) id, name, gender, score));
                }
                case 3 -> {
                    System.out.print("Enter ID to find: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println(studentService.selectStudentById(id));
                }
                case 4 -> {
                    System.out.print("Enter ID to update: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter new full name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter new gender: ");
                    String gender = scanner.nextLine();
                    System.out.print("Enter new score: ");
                    double score = Double.parseDouble(scanner.nextLine());
                    studentService.updateStudentById(id, new Student((long) id, name, gender, score));
                }
                case 5 -> {
                    System.out.print("Enter ID to delete: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    studentService.deleteStudentById(id);
                }
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }
}
