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
                createQuestion("dluga", "W jak d³ug¹ grê chcesz zagraæ?", createLongAnswers()),
                createQuestion("osobowa", "Ilo osobowa gra Ciê interesuje?", createPersonAnswers()),
                createQuestion("losowa", "Jaki stopieñ losowoœci Ciê interesuje?", createRandomAnswers()),
                createQuestion("nowa", "Czy chcesz, aby gra by³a wydana po 2000 roku?", createDefaultAnswers()),
                createQuestion("turowa", "Czy chcesz zagraæ w grê turow¹?", createDefaultAnswers()),
                createQuestion("rywalizacyjna", "Czy chcesz zagraæ w grê rywalizacyjn¹?", createDefaultAnswers()),
                createQuestion("familijna", "Czy chcesz zagraæ w grê familijn¹?", createDefaultAnswers()),
                createQuestion("zabawna", "Czy chcesz zagraæ w grê zabawn¹?", createDefaultAnswers()),
                createQuestion("prosta", "Czy chcesz zagraæ w grê z nieskomplikowanymi zadami?", createDefaultAnswers()),
                createQuestion("onlne", "Czy chcesz zagraæ w grê online?", createDefaultAnswers()),
                createQuestion("realistyczna", "Czy chcesz zagraæ w grê realistyczn¹?", createDefaultAnswers()),
                createQuestion("planszowa", "Czy chcesz zagraæ w grê planszow¹?", createDefaultAnswers()),
                createQuestion("kreatywna", "Czy chcesz zagraæ w grê kreatywn¹?", createDefaultAnswers()),
                createQuestion("umys³owa", "Czy chcesz zagraæ w grê umys³ow¹?", createDefaultAnswers()),
                createQuestion("dynamiczna", "Czy chcesz zagraæ w grê dynamiczn¹?", createDefaultAnswers()),
                createQuestion("grupowa", "Czy chcesz zagraæ w grê grupow¹?", createDefaultAnswers()),
                createQuestion("fabularna", "Czy chcesz zagraæ w grê fabularn¹?", createDefaultAnswers())
        ));
    }

    private String prepareQuestionToDisplay(String question) {
        return String.format("<html>%s", question.replace("\n", "<br>"));
    }

    private List<Answer> createDefaultAnswers() {
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("t", "tak"));
        answers.add(new Answer("n", "nie"));
        answers.add(new Answer("o", "obojêtne"));
        return answers;
    }

    private List<Answer> createRandomAnswers() {
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("0", "nielosowa"));
        answers.add(new Answer("1", "pseudolosowa"));
        answers.add(new Answer("2", "w pe³ni losowa"));
        answers.add(new Answer("o", "obojêtne"));
        return answers;
    }

    private List<Answer> createPersonAnswers() {
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("0", "jednoosobowa"));
        answers.add(new Answer("1", "dwuosobowa"));
        answers.add(new Answer("2", "wieloosobowa"));
        answers.add(new Answer("o", "obojêtne"));
        return answers;
    }

    private List<Answer> createLongAnswers() {
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("0", "0-2 godzin"));
        answers.add(new Answer("1", "1-4 godzin"));
        answers.add(new Answer("2", "powy¿ej 4 godzin"));
        answers.add(new Answer("o", "obojêtne"));
        return answers;
    }

    private Question createQuestion(String engineQuestion, String question, List<Answer> answers) {
        return new Question(engineQuestion, prepareQuestionToDisplay(question), answers);
    }

    private QuestionSet() {
        prepareQuestions().forEach(q -> questions.put(q.getEngineQuestion(), q));
    }
}
