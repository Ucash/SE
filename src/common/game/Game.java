package common.game;

public class Game {

    private String engineName;
    private String displayName;
    private double value;

    public Game(String engineName, String displayName){
        this.engineName = engineName;
        this.displayName = displayName;
    }

    public String getEngineName(){
        return engineName;
    }

    public String getDisplayName(){
        return displayName;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
