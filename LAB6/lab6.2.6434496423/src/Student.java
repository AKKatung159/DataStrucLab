import java.util.Objects;

public class Student {
    private String ID,fname,lname;
    public Student(String ID,String fname,String lname){
        this.ID=ID;
        this.fname=fname;
        this.lname=lname;
    }
    public Student(String ID){
        this.ID=ID;
    }
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(ID, student.ID);
    }
    public int hashCode() {
        return ID.substring(3,6).hashCode();
    }
}
