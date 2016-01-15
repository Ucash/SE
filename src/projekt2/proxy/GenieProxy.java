package projekt2.proxy;

import common.game.Game;
import projekt2.question.Question;
import smile.Network;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class GenieProxy {

    private final Network network = new Network();

    private static final List<String> gameNames = Arrays.asList("Age_Of_Empires_2", "Heroes_3", "Civilization_5", "Theme_Park_Worlld", "The_Sims", "Wow", "Tibia", "DOTa", "League_Of_Legends", "CS", "Quake", "CallOfDuty", "Dyna");

    private final List<Game> games = new ArrayList<>();
    private static final List<String> questionIds = Arrays.asList("nowa", "rywalizacyjna", "umyslowa", "fabularna", "kreatywna", "dluga", "turowa", "familijna", "online", "realistyczna", "prosta");

    private final List<Question> questions = new ArrayList<>();

    private Iterator<Question> iterator;

    public GenieProxy(String path) {
        network.readFile(path);
        network.clearAllEvidence();

        for (String questionId : questionIds) {
            questions.add(new Question(questionId));
        }

        iterator = questions.iterator();
    }

    public Question getNextQuestion() {
        return iterator.hasNext() ? iterator.next() : null;
    }

    public List<Game> updateGames() {
        games.clear();
        network.updateBeliefs();
        for (String gameName : gameNames) {
            double[] values = network.getNodeValue(gameName);
            Game game = new Game(gameName, String.format("%s (%d%%)", gameName, (int) (values[0] * 100)));
            game.setValue(values[0]);
            games.add(game);
        }

        games.sort((g1, g2) -> Double.compare(g2.getValue(), g1.getValue()));
        return games;
    }


    public Question onAnswer(Question question, double[] values) {
        network.setVirtualEvidence(question.getQuestionId(), values);
        return getNextQuestion();
    }

    public Question restart() {
        network.clearAllEvidence();
        iterator = questions.iterator();
        return getNextQuestion();
    }
}
