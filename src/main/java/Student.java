import java.util.ArrayList;
import java.util.Date;

// EXISTING PART OF SYSTEM
public class Student {
    Date registrationDate;
    ArrayList<Exam> examList;
    String name;
    String surname;

    Student(String name, String surname){
        this.name = name;
        this.surname = surname;
        this.examList = new ArrayList<Exam>();
    }
}
