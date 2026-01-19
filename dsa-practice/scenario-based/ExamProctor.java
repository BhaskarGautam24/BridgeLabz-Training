import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class ExamProctor {

    static Stack<Integer> navigationStack = new Stack<Integer>();

    static HashMap<Integer, String> studentAnswers = new HashMap<Integer, String>();

    // fixed size array for correct answers
    static String[] correctAnswers = new String[6]; 
    // index = questionId (ignoring index 0)

    static void visitQuestion(int questionId) {
        navigationStack.push(questionId);
        System.out.println("Visited Question : " + questionId);
    }

    static void saveAnswer(int questionId, String answer) {
        studentAnswers.put(questionId, answer);
        System.out.println("Answer saved for Question " + questionId);
    }

    static int calculateScore() {
        int score = 0;

        for (int qId : studentAnswers.keySet()) {
            if (studentAnswers.get(qId).equals(correctAnswers[qId])) {
                score++;
            }
        }
        return score;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        correctAnswers[1] = "A";
        correctAnswers[2] = "B";
        correctAnswers[3] = "C";
        correctAnswers[4] = "D";
        correctAnswers[5] = "E";

        visitQuestion(1);
        saveAnswer(1, "A");

        visitQuestion(2);
        saveAnswer(2, "D");

        visitQuestion(3);
        saveAnswer(3, "C");

        visitQuestion(4);
        saveAnswer(4, "D");

        visitQuestion(5);
        saveAnswer(5, "E");

        int finalScore = calculateScore();   
 
        System.out.println("Final Score is : " + finalScore);     
    }
}
