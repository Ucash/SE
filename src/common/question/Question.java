package common.question;

import java.util.List;

public class Question {
    private String engineQuestion;
    private String fullQuestionText;
    private List<Answer> answers;

    public Question(String engineQuestion, String fullQuestionText, List<Answer> answers){
        this.engineQuestion = engineQuestion;
        this.fullQuestionText = fullQuestionText;
        this.answers = answers;
    }

    public String getEngineQuestion(){
        return engineQuestion;
    }

    public String getFullQuestionText(){
        return fullQuestionText;
    }

    public int getAnswersCount(){
        return answers.size();
    }

    public Answer getAnswer(int index){
        return answers.get(index);
    }
}
