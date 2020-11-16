package jackson.domain;

public class Lecturer extends Person {

    private Course lecturedCourse;

    public Course getLecturedCourse() { return lecturedCourse; }

    public void setLecturedCourse(Course lecturedCourse) { this.lecturedCourse = lecturedCourse; }
}
