import java.util.List;

public class MyClass {
    public static void main(String[] args) {
        Student student = new Student("Mike",18, List.of(2,3,4,2,5,5));
        System.out.println(student.getSum());
        System.out.println(student.getAvg());
        System.out.println(student);
        student.addMark(2);
        student.addMark(4);
        student.setSave();
        System.out.println(student);
        student.addMark(7);
        student.addMark(7);
        student.setRevoke();
        student.setSave();
        System.out.println(student);
        student.setRevoke();
        System.out.println(student);
    }
}
