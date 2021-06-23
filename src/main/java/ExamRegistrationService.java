// SYSTEM UNDER TEST
public class ExamRegistrationService {

    public void register(Student student, Exam exam){
        if(exam.register(student)){
            student.examList.add(exam);
        }
    }
}
