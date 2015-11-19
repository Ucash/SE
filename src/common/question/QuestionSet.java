package common.question;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionSet {

    private static final QuestionSet instance = new QuestionSet();
    private Map<String, Question> questions = new HashMap<>();

    public static QuestionSet getInstance(){
        return instance;
    }

    public Question findQuestion(String engineQuestion){
        return questions.get(engineQuestion);
    }

    private String prepareQuestionToDisplay(String question){
        return String.format("<html>%s", question.replace("\n", "<br>"));
    }

    private List<Answer> createDefaultAnswers(){
        List<Answer> answers = new ArrayList<>();
        answers.add(new Answer("t", "Tak"));
        answers.add(new Answer("n", "Nie"));
        answers.add(new Answer("o", "Nie ma dla mnie znaczenia"));
        return answers;
    }

    private QuestionSet(){
        //todo: prepare real questions
        Question q = new Question("cZY", prepareQuestionToDisplay("co jestttttttttttttttttttttt?"), createDefaultAnswers());
        List<Answer> b = new ArrayList<>();
        b.add(new Answer("0", "Tak"));
        b.add(new Answer("1", "Nie"));
        b.add(new Answer("2", "Bardzo Tak"));
        b.add(new Answer("o", "walic to"));
        Question q1 = new Question("Gluhie", prepareQuestionToDisplay("dluzsze\ndfgfffh"), b);
        questions.put(q.getEngineQuestion(), q);
        questions.put(q1.getEngineQuestion(), q1);
    }
}
