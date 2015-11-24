package common.question;

import java.util.*;

public class QuestionSet {

    private static final QuestionSet instance = new QuestionSet();
    private Map<String, Question> questions = new HashMap<>();

    public static QuestionSet getInstance() {
        return instance;
    }

    public Question findQuestion(String engineQuestion) {
        return questions.get(engineQuestion);
    }

    private List<Question> prepareQuestions() {
        return new LinkedList<>(Arrays.asList(
                createQuestion("dluga", "W jak d�ug� gr� chcesz zagra�?", createLongAnswers()),
                createQuestion("osobowa", "Ilo osobowa gra Ci� interesuje?", createPersonAnswers()),
                createQuestion("losowa", "Jaki stopie� losowo�ci Ci� interesuje?", createRandomAnswers()),
                createQuestion("nowa", "Czy chcesz, aby gra by�a wydana po 2000 roku?", createDefaultAnswers()),
                createQuestion("turowa", "Czy chcesz zagra� w gr� turow�?", createDefaultAnswers()),
                createQuestion("rywalizacyjna", "Czy chcesz zagra� w gr� rywalizacyjn�?", createDefaultAnswers()),
                createQuestion("familijna", "Czy chcesz zagra� w gr� familijn�?", createDefaultAnswers()),
                createQuestion("zabawna", "Czy chcesz zagra� w gr� zabawn�?", createDefaultAnswers()),
                createQuestion("prosta", "Czy chcesz zagra� w gr� z nieskomplikowanymi zadami?", createDefaultAnswers()),
                createQuestion("onlne", "Czy chcesz zagra� w gr� online?", createDefaultAnswers()),
                createQuestion("realistyczna", "Czy chcesz zagra� w gr� realistyczn�?", createDefaultAnswers()),
                createQuestion("planszowa", "Czy chcesz zagra� w gr� planszow�?", createDefaultAnswers()),
                createQuestion("kreatywna", "Czy chcesz zagra� w gr� kreatywn�?", createDefaultAnswers()),
                createQuestion("umys�owa", "Czy chcesz zagra� w gr� umys�ow�?", createDefaultAnswers()),
                createQuestion("dynamiczna", "Czy chcesz zagra� w gr� dynamiczn�?", createDefaultAnswers()),
                createQuestion("grupowa", "Czy chcesz zagra� w gr� grupow�?", createDefaultAnswers()),
                createQuestion("fabularna", "Czy chcesz zagra� w gr� fabularn�?", createDefaultAnswers())
        ));
    }

    private String prepareQuestionToDisplay(String question) {
        return String.format("<html>%s", question.replace("\n", "<br>"));
    }

    private List<Answer> createDefaultAnswers() {
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("t", "tak"));
        answers.add(new Answer("n", "nie"));
        answers.add(new Answer("o", "oboj�tne"));
        return answers;
    }

    private List<Answer> createRandomAnswers() {
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("0", "nielosowa"));
        answers.add(new Answer("1", "pseudolosowa"));
        answers.add(new Answer("2", "w pe�ni losowa"));
        answers.add(new Answer("o", "oboj�tne"));
        return answers;
    }

    private List<Answer> createPersonAnswers() {
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("0", "jednoosobowa"));
        answers.add(new Answer("1", "dwuosobowa"));
        answers.add(new Answer("2", "wieloosobowa"));
        answers.add(new Answer("o", "oboj�tne"));
        return answers;
    }

    private List<Answer> createLongAnswers() {
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("0", "0-2 godzin"));
        answers.add(new Answer("1", "1-4 godzin"));
        answers.add(new Answer("2", "powy�ej 4 godzin"));
        answers.add(new Answer("o", "oboj�tne"));
        return answers;
    }

    private Question createQuestion(String engineQuestion, String question, List<Answer> answers) {
        return new Question(engineQuestion, prepareQuestionToDisplay(question), answers);
    }

    private QuestionSet() {
        prepareQuestions().forEach(q -> questions.put(q.getEngineQuestion(), q));
    }
}
