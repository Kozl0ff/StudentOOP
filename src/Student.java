import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class Student extends Human implements Sumable{
    private List<Integer> list = new ArrayList<>();
    public int sum = 0;

    public Student(String name, int age, List<Integer> list) {
        super(name, age);
        copyMarks(list);
    }

    void copyMarks(List<Integer> list){
        for(int mark : list){
            checkMarks(mark);
            this.list = new ArrayList<>(list);
        }
    }

    void checkMarks(int mark){
        if (mark <= 0 || mark >= 10){
            throw new IllegalArgumentException("Acsses denied!!");
        }
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getName() {
        return "Student's name: "+name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = new ArrayList<>(list);
    }

    public void addMark(int mark){
        this.list.add(mark);
    }


    @Override
    public int getSum() {
        for (int i = 0;i <list.size();i++){
            sum += list.get(i);
        }
        return sum;
    }

    @Override
    public double getAvg() {
        return sum/list.size();
    }

    @Override
    public String toString() {
        return "Student:" +
                " " + list +
                ", name: '" + name + '\'' +
                ", age: " + age +
                '}';
    }

    Shot shot = new Shot();

    public void setSave(){
        shot.save();
    }

    public void setRevoke(){
        shot.revoke();
    }

    class Shot implements Save {
        List<Integer> lst = new ArrayList<>();
        String name;

        public Shot(){
        }

        public Shot(List<Integer> list, String name) {
            this.lst = new ArrayList<>(Student.this.list);
            this.name = name;
        }

        public void save()throws ConcurrentModificationException {
            this.name = Student.this.name;
            for (int x: list){
                list.add(x);
            }
           this.lst = Student.this.list;
        }
        public void  revoke(){
            Student.this.list.addAll(this.lst);
        }
    }
}
