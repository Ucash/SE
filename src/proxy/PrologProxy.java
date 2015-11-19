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
        String consult = "consult('C:/Users/Ucash/Documents/AR/game_expert.pl')";
        Query.allSolutions(consult);
        String start = "zagraj(X)";
        Map<String,Term> result = Query.oneSolution(start);
        System.out.print(result.get("X").name());
        return QuestionSet.getInstance().findQuestion(result.get("X").name());
    }

    public Question onAnswer(String answer){
        Map<String,Term> result = Query.oneSolution(answer);
        return QuestionSet.getInstance().findQuestion(result.get(answer).name());
    }

    public List<Game> getPossibleGames() {
        return GameSet.getInstance().findAll();
    }
}
