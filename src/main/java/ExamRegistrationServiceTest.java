import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.easymock.*;
import static org.easymock.EasyMock.*;

import java.util.Date;

// TEST MODEL
@ExtendWith(EasyMockExtension.class)
public class ExamRegistrationServiceTest {

    @TestSubject
    ExamRegistrationService examRegistrationService = new ExamRegistrationService();

    @Mock
    Exam examMock;

    @Test
    public void registerStudentSuccessfulTest() {

        //TEST SETUP
        /*
        Setup all the additional information you need for your test
         */
        Student student = new Student("Elias", "Dellago");
        student.registrationDate = new Date("15/06/2021");
        Date deadline = new Date("30/06/2021");

        int initialNumberOfExams = student.examList.size();

        // Define what the mock should do when different functions get called on it, then set it to ready ("replay")
        expect(examMock.getDeadline()).andReturn(deadline);
        expect(examMock.register(student)).andReturn(true);
        replay(examMock);

        // TEST PROCEDURE
        /*
        Call functions on the SUT, utilizing collaborators & mock
         */
        examRegistrationService.register(student, examMock);

        // TEST VALIDATION
        /*
        Everything you want to confirm for the test to be succesful
         */
        Assertions.assertTrue(student.registrationDate.before(examMock.getDeadline()));

        int expectedNumberOfExams = initialNumberOfExams + 1;
        int actualNumberOfExams = student.examList.size();

        Assertions.assertEquals(expectedNumberOfExams, actualNumberOfExams);

    }

}
