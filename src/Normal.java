import java.util.Arrays;
import java.util.Comparator;

class Student {
    private String name;
    private int id;
    private double grade;

    public Student(String name, int id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    // Getters for the fields
    public String getName() { return name; }
    public int getId() { return id; }
    public double getGrade() { return grade; }

    @Override
    public String toString() {
        return "Student{name='" + name + "', id=" + id + ", grade=" + grade + "}";
    }
}

class StudentSorter {
    public static void sortStudents(Student[] students, String field) {
        Comparator<Student> comparator = null;

        switch (field.toLowerCase()) {
            case "name":
                comparator = new Comparator<Student>() {
                    @Override
                    public int compare(Student s1, Student s2) {
                        return s1.getName().compareTo(s2.getName());
                    }
                };
                break;

            case "id":
                comparator = new Comparator<Student>() {
                    @Override
                    public int compare(Student s1, Student s2) {
                        return Integer.compare(s1.getId(), s2.getId());
                    }
                };
                break;

            case "grade":
                comparator = new Comparator<Student>() {
                    @Override
                    public int compare(Student s1, Student s2) {
                        return Double.compare(s1.getGrade(), s2.getGrade());
                    }
                };
                break;

            default:
                throw new IllegalArgumentException("Invalid field: " + field);
        }

        Arrays.sort(students, comparator);
    }
}

public class Normal {
    public static void main(String[] args) {
        //student1s
        Student[] student1s = {
                new Student("Alice", 3, 85.5),
                new Student("Bob", 1, 90.3),
                new Student("Charlie", 2, 78.9)
        };

        System.out.println("Before sorting:");
        for (Student student1 : student1s) {
            System.out.println(student1);
        }

        // Sort by name
        StudentSorter.sortStudents(student1s, "name");

        System.out.println("\nAfter sorting by name:");
        for (Student student1 : student1s) {
            System.out.println(student1);
        }

        // Sort by grade
        StudentSorter.sortStudents(student1s, "grade");

        System.out.println("\nAfter sorting by grade:");
        for (Student student1 : student1s) {
            System.out.println(student1);
        }

        // Sort by ID
        StudentSorter.sortStudents(student1s, "id");

        System.out.println("\nAfter sorting by ID:");
        for (Student student1 : student1s) {
            System.out.println(student1);
        }
    }
}
