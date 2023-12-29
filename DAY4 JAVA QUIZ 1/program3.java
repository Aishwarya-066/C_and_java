/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javapro;

import java.util.ArrayList;
import java.util.List;

public class program3{
    public static void main(String[] args) {

        Student student1 = new Student("John");
        Student student2 = new Student("Alice");

        Course mathCourse = new Course("Math");
        Course physicsCourse = new Course("Physics");
        Course programmingCourse = new Course("Programming");
        Course dataStructuresCourse = new Course("Data Structures");
        Course algorithmsCourse = new Course("Algorithms");

        programmingCourse.addPrerequisite(mathCourse);
        dataStructuresCourse.addPrerequisite(programmingCourse);
        algorithmsCourse.addPrerequisite(dataStructuresCourse);

        student1.completeCourse(mathCourse);
        student1.completeCourse(physicsCourse);
        student1.completeCourse(programmingCourse);
        student1.completeCourse(dataStructuresCourse);

        programmingCourse.enrollStudent(student1);
        dataStructuresCourse.enrollStudent(student1);
        algorithmsCourse.enrollStudent(student1);

        programmingCourse.enrollStudent(student2);  

        programmingCourse.displayEnrolledStudents();
        dataStructuresCourse.displayEnrolledStudents();
        algorithmsCourse.displayEnrolledStudents();
    }
}


class Person {
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Student extends Person {
    private List<Course> completedCourses;

    public Student(String name) {
        super(name);
        this.completedCourses = new ArrayList<>();
    }

    public List<Course> getCompletedCourses() {
        return completedCourses;
    }

    public void completeCourse(Course course) {
        completedCourses.add(course);
    }
}

class Professor extends Person {
    public Professor(String name) {
        super(name);
    }
}

class Course {
    private String name;
    private List<Course> prerequisites;
    private List<Student> enrolledStudents;

    public Course(String name) {
        this.name = name;
        this.prerequisites = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
    }

    public void addPrerequisite(Course prerequisite) {
        prerequisites.add(prerequisite);
    }

    public void enrollStudent(Student student) {
        if (hasCompletedPrerequisites(student) && !enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
            System.out.println("Enrolled student " + student.getName() + " in course " + name);
        } else {
            System.out.println("Student " + student.getName() + " cannot be enrolled in course " + name
                    + " due to incomplete prerequisites or already enrolled.");
        }
    }

    private boolean hasCompletedPrerequisites(Student student) {
        for (Course prerequisite : prerequisites) {
            if (!student.getCompletedCourses().contains(prerequisite)) {
                return false;
            }
        }
        return true;
    }

    public void displayEnrolledStudents() {
        System.out.println("Enrolled students in course " + name + ":");
        for (Student student : enrolledStudents) {
            System.out.println("- " + student.getName());
        }
    }
}

//OUTPUT:
//
//run:
//Enrolled student John in course Programming
//Enrolled student John in course Data Structures
//Enrolled student John in course Algorithms
//Student Alice cannot be enrolled in course Programming due to incomplete prerequisites or already enrolled.
//Enrolled students in course Programming:
//- John
//Enrolled students in course Data Structures:
//- John
//Enrolled students in course Algorithms:
//- John
//BUILD SUCCESSFUL (total time: 0 seconds)

