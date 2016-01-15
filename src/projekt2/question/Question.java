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
                put("online", "<html>Czy chcesz zagraæ w grê online?<br>");
                put("komputerowa", "<html>Czy chcesz zagraæ w grê komputerow¹?");
                put("dluga", "<html>W jak d³ug¹ grê chcesz zagraæ?");
                put("osobowa", "<html>Ilo osobowa gra Ciê interesuje?");
                put("losowa", "<html>Jaki stopieñ losowoœci Ciê interesuje?");
                put("nowa", "<html>Czy chcesz, aby gra by³a wydana po 2000 roku?");
                put("turowa", "<html>Czy chcesz zagraæ w grê turow¹?");
                put("rywalizacyjna", "<html>Czy chcesz zagraæ w grê rywalizacyjn¹?<br>");
                put("familijna", "<html>Czy chcesz zagraæ w grê familijn¹?");
                put("zabawna", "<html>Czy chcesz zagraæ w grê zabawn¹?");
                put("prosta", "<html>Czy chcesz zagraæ w grê z nieskomplikowanymi zadami?");
                put("realistyczna", "<html>Czy chcesz zagraæ w grê realistyczn¹?");
                put("planszowa", "<html>Czy chcesz zagraæ w grê planszow¹?");
                put("kreatywna", "<html>Czy chcesz zagraæ w grê kreatywn¹?");
                put("umyslowa", "<html>Czy chcesz zagraæ w grê umys³ow¹?");
                put("dynamiczna", "<html>Czy chcesz zagraæ w grê dynamiczn¹?");
                put("grupowa", "<html>Czy chcesz zagraæ w grê grupow¹?");
                put("fabularna", "<html>Czy chcesz zagraæ w grê fabularn¹?");
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
