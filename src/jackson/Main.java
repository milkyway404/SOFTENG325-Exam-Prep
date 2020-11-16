package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jackson.domain.Course;
import jackson.domain.Lecturer;
import jackson.domain.Student;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main (String[] args) {

        Object objectToBeSerialized = createObject();

        ObjectMapper mapper = new ObjectMapper(); // use jackson
        ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter(); // this is to make nicely formatted json

        try {
            System.out.println(writer.writeValueAsString(objectToBeSerialized));
        } catch (JsonProcessingException e) {
            e.printStackTrace(); // you can use this to debug, e.g. infinite loop
        }

    }

    /**
     * Create any object and its data you need here. This is a sample from our test data.
     * @return created object.
     */
    private static Object createObject() {
        // course basic data
        Course course = new Course();
        course.setName("Software Architecture");
        course.setCode("SOFTENG325");
        course.setStartDate(LocalDate.of(2020, 1, 1));

        // course students
        List<Student> studentList = new ArrayList<>();
        Student anne = new Student();
        anne.setName("Anne");
        Student bob = new Student();
        bob.setName("Bob");
        studentList.add(anne);
        studentList.add(bob);

        course.setEnrolledStudents(studentList);

        // course's lecturer. Note that the circular reference can be shown better
        // only if you add the course to the lecturer as well
        Lecturer lecturer = new Lecturer();
        lecturer.setName("Steve");
        lecturer.setLecturedCourse(course);
        course.setLecturer(lecturer);

        return course;
    }


}
