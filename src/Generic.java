
import java.util.*;
import java.util.function.Function;


class Student1 {
    private String name;
    private int age;
    private double gpa;

    public Student1(String name, int age, double gpa) {
        this.name = name;
        this.age = age;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student1{name='" + name + "', age=" + age + ", gpa=" + gpa + "}";
    }
}

// Generic Comparator class
class GenericComparator<T extends Comparable<T>> implements Comparator<Student1> {
    private final Function<Student1, T> keyExtractor;

    public GenericComparator(Function<Student1, T> keyExtractor) {
        this.keyExtractor = keyExtractor;
    }

    @Override
    public int compare(Student1 s1, Student1 s2) {
        return keyExtractor.apply(s1).compareTo(keyExtractor.apply(s2));
    }
}

// Normal class to demonstrate sorting
public class Generic {
    public static void main(String[] args) {
        List<Student1> student1s = new ArrayList<>();
        student1s.add(new Student1("Alice", 20, 3.5));
        student1s.add(new Student1("Bob", 22, 3.8));
        student1s.add(new Student1("Charlie", 21, 3.2));

        // Sort by name (String)
        student1s.sort(new GenericComparator<>(Student1::getName));
        System.out.println("Sorted by name:");
        student1s.forEach(System.out::println);

        // Sort by age (Integer)
        student1s.sort(new GenericComparator<>(Student1::getAge));
        System.out.println("\nSorted by age:");
        student1s.forEach(System.out::println);

        // Sort by GPA (Double)
        student1s.sort(new GenericComparator<>(Student1::getGpa));
        System.out.println("\nSorted by GPA:");
        student1s.forEach(System.out::println);
    }
}
