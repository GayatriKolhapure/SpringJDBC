package org.gayatri.SpringJDBC;

import org.gayatri.SpringJDBC.module.Student;
import org.gayatri.SpringJDBC.service.StudentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringJdbcApplication.class, args);
        StudentService service = context.getBean(StudentService.class);

        Student student = context.getBean(Student.class);
        student.setRollNo(105);
        student.setName("Gayatri");
        student.setMarks(88);

        service.addStudent(student);

        List<Student> students = service.getStudents();
        for (Student s: students) {
            System.out.print(s.getRollNo() + "  ");
            System.out.print(s.getName() + "    ");
            System.out.println(s.getMarks());
        }


	}


}
