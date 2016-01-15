package projekt1.proxy;

import common.game.Game;
import org.jpl7.Query;
import org.jpl7.Term;
import projekt1.common.game.GameSet;
import projekt1.common.question.Question;
import projekt1.common.question.QuestionSet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PrologProxy {

    private List<Question> questions;
    private String path;

    public PrologProxy(String path){
        this.path = path;
    }

    public Question loadEngine() {
        String consult = String.format("consult('%s')", path);
        Query.hasSolution(consult);
        questions = QuestionSet.getInstance().findAll();
        return questions.remove(0);
    }

    public Question onAnswer(String answer, Question question) {
        String query;
        if (question.getAnswersCount() == 3) {
            query = String.format("pamietaj(%s, %s)", question.getEngineQuestion(), answer);
        } else if (question.getAnswersCount() == 4) {
            query = String.format("pamietaj2(%s, %s)", answer, question.getEngineQuestion());
        } else {
            throw new RuntimeException("Wrong question");
        }
        Query.hasSolution(query);
        return questions.size() > 0
                ? questions.remove(0)
                : null;
    }

    public List<Game> getPossibleGames() {
        List<Game> games = new ArrayList<>();
        Map<String, Term>[] results = Query.allSolutions("zagraj(X)");
        for (Map<String, Term> result : results) {
            games.add(GameSet.getInstance().findGame(result.get("X").name()));
        }
        return games;
    }

    public Question restart() {
        String query = "wyczysc_fakty";
        Query.hasSolution(query);
        questions = QuestionSet.getInstance().findAll();
        return questions.remove(0);
    }
}
