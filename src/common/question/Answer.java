package common.question;

public class Answer {
    private String value;
    private String displayValue;

    public Answer(String engineName, String displayValue){
        this.value = engineName;
        this.displayValue = displayValue;
    }

    public String getValue(){
        return value;
    }

    public String getDisplayValue(){
        return displayValue;
    }
}
