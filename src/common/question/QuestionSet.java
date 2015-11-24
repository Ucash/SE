package common.question;

import java.util.*;

public class QuestionSet {

    private static final QuestionSet instance = new QuestionSet();
    private Map<String, Question> questions = new HashMap<>();

    public static QuestionSet getInstance() {
        return instance;
    }

    private List<Question> prepareQuestions() {
        return new LinkedList<>(Arrays.asList(
                createQuestion("onlne", "Czy chcesz zagrać w grę online?", createDefaultAnswers()),
                createQuestion("komputerowa", "Czy chcesz zagrać w grę komputerową?", createDefaultAnswers()),
                createQuestion("dluga", "W jak długą grę chcesz zagrać?", createLongAnswers()),
                createQuestion("osobowa", "Ilo osobowa gra Cię interesuje?", createPersonAnswers()),
                createQuestion("losowa", "Jaki stopień losowości Cię interesuje?", createRandomAnswers()),
                createQuestion("nowa", "Czy chcesz, aby gra była wydana po 2000 roku?", createDefaultAnswers()),
                createQuestion("turowa", "Czy chcesz zagrać w grę turową?", createDefaultAnswers()),
                createQuestion("rywalizacyjna", "Czy chcesz zagrać w grę rywalizacyjną?", createDefaultAnswers()),
                createQuestion("familijna", "Czy chcesz zagrać w grę familijną?", createDefaultAnswers()),
                createQuestion("zabawna", "Czy chcesz zagrać w grę zabawną?", createDefaultAnswers()),
                createQuestion("prosta", "Czy chcesz zagrać w grę z nieskomplikowanymi zadami?", createDefaultAnswers()),
                createQuestion("realistyczna", "Czy chcesz zagrać w grę realistyczną?", createDefaultAnswers()),
                createQuestion("planszowa", "Czy chcesz zagrać w grę planszową?", createDefaultAnswers()),
                createQuestion("kreatywna", "Czy chcesz zagrać w grę kreatywną?", createDefaultAnswers()),
                createQuestion("umyslowa", "Czy chcesz zagrać w grę umysłową?", createDefaultAnswers()),
                createQuestion("dynamiczna", "Czy chcesz zagrać w grę dynamiczną?", createDefaultAnswers()),
                createQuestion("grupowa", "Czy chcesz zagrać w grę grupową?", createDefaultAnswers()),
                createQuestion("fabularna", "Czy chcesz zagrać w grę fabularną?", createDefaultAnswers())
        ));
    }

    private String prepareQuestionToDisplay(String question) {
        return String.format("<html>%s", question.replace("\n", "<br>"));
    }

    private List<Answer> createDefaultAnswers() {
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("t", "tak"));
        answers.add(new Answer("n", "nie"));
        answers.add(new Answer("o", "obojętne"));
        return answers;
    }

    private List<Answer> createRandomAnswers() {
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("0", "nielosowa"));
        answers.add(new Answer("1", "pseudolosowa"));
        answers.add(new Answer("2", "w pełni losowa"));
        answers.add(new Answer("o", "obojętne"));
        return answers;
    }

    private List<Answer> createPersonAnswers() {
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("0", "jednoosobowa"));
        answers.add(new Answer("1", "dwuosobowa"));
        answers.add(new Answer("2", "wieloosobowa"));
        answers.add(new Answer("o", "obojętne"));
        return answers;
    }

    private List<Answer> createLongAnswers() {
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("0", "0-2 godzin"));
        answers.add(new Answer("1", "1-4 godzin"));
        answers.add(new Answer("2", "powyżej 4 godzin"));
        answers.add(new Answer("o", "obojętneętne"));
        return answers;
    }

    private Question createQuestion(String engineQuestion, String question, List<Answer> answers) {
        return new Question(engineQuestion, prepareQuestionToDisplay(question), answers);
    }

    private QuestionSet() {
        prepareQuestions().forEach(q -> questions.put(q.getEngineQuestion(), q));
    }

    public List<Question> findAll() {
        return new ArrayList<>(questions.values());
    }
}
