package projekt2.question;

import java.util.HashMap;
import java.util.Map;

public class Question {

    private static final Map<String, String> questions = prepareQuestions();
    private final String questionId;

    public Question(String questionId) {
        this.questionId = questionId;
    }

    private static Map<String, String> prepareQuestions() {
        return new HashMap<String, String>() {
            {
                put("online", "<html>Czy chcesz zagra� w gr� online?<br>");
                put("komputerowa", "<html>Czy chcesz zagra� w gr� komputerow�?");
                put("dluga", "<html>W jak d�ug� gr� chcesz zagra�?");
                put("osobowa", "<html>Ilo osobowa gra Ci� interesuje?");
                put("losowa", "<html>Jaki stopie� losowo�ci Ci� interesuje?");
                put("nowa", "<html>Czy chcesz, aby gra by�a wydana po 2000 roku?");
                put("turowa", "<html>Czy chcesz zagra� w gr� turow�?");
                put("rywalizacyjna", "<html>Czy chcesz zagra� w gr� rywalizacyjn�?<br>");
                put("familijna", "<html>Czy chcesz zagra� w gr� familijn�?");
                put("zabawna", "<html>Czy chcesz zagra� w gr� zabawn�?");
                put("prosta", "<html>Czy chcesz zagra� w gr� z nieskomplikowanymi zadami?");
                put("realistyczna", "<html>Czy chcesz zagra� w gr� realistyczn�?");
                put("planszowa", "<html>Czy chcesz zagra� w gr� planszow�?");
                put("kreatywna", "<html>Czy chcesz zagra� w gr� kreatywn�?");
                put("umyslowa", "<html>Czy chcesz zagra� w gr� umys�ow�?");
                put("dynamiczna", "<html>Czy chcesz zagra� w gr� dynamiczn�?");
                put("grupowa", "<html>Czy chcesz zagra� w gr� grupow�?");
                put("fabularna", "<html>Czy chcesz zagra� w gr� fabularn�?");
            }
        };
    }

    public String getFullQuestionText() {
        return questions.get(questionId);
    }

    public String getQuestionId() {
        return questionId;
    }
}
