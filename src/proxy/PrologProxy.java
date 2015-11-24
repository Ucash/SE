package proxy;

import common.game.Game;
import common.game.GameSet;
import common.question.Question;
import common.question.QuestionSet;
import org.jpl7.*;

import java.util.List;
import java.util.Map;

public class PrologProxy {

    public Question loadEngine(){
        String consult = "consult('D:/Projekty/SystemyEkspertowe/projekt1.pl')";
        Query.allSolutions(consult);
        Map<String,Term> result = Query.oneSolution("wykonaj.");
        if (result.size() ==0) {
            System.out.println("pusta");
        }
        for (Map.Entry<String, Term> entry: result.entrySet()) {
           // System.out.println(entry.getKey() + " " + entry.getValue().toString());
        }
        //return QuestionSet.getInstance().findQuestion(result.get("X").name());
        return null;
    }

    public Question onAnswer(String answer){
        Map<String,Term> result = Query.oneSolution(answer);
        return QuestionSet.getInstance().findQuestion(result.get(answer).name());
    }

    public List<Game> getPossibleGames() {
        return GameSet.getInstance().findAll();
    }
}
