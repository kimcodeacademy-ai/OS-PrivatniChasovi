package JavaNitki.FinkiEnrolment;

public class Test {
    public static void main(String[] args) {
        FinkiEnrolment.init();

        // Create members
        FinkiEnrolment.Member[] members = new FinkiEnrolment.Member[4];
        for(int i = 0; i < 4; i++){
            members[i] = new FinkiEnrolment.Member();
            members[i].start();
        }

        // Create students
        int numStudents = 40;
        FinkiEnrolment.Student [] students = new FinkiEnrolment.Student[numStudents];
        for (int i = 0; i < numStudents; i++){
            students[i] = new FinkiEnrolment.Student();
            students[i].start();
        }
    }
}
