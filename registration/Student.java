package registration;

import java.util.ArrayList;

public class Student {
    private String id;
    private String name;
    private ArrayList<Course> registeredCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public boolean registerCourse(Course course) {
        if (course.registerStudent(this)) {
            registeredCourses.add(course);
            return true;
        }
        return false;
    }

    public boolean removeCourse(Course course) {
        if (course.removeStudent(this)) {
            registeredCourses.remove(course);
            return true;
        }
        return false;
    }
}