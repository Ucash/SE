package projekt2;

import common.gui.GameExpertFrame;
import common.gui.GamesPanel;
import projekt2.gui.QuestionPanel;

public class Main {

    public static void main(String[] args) {
        GamesPanel gamesPanel = new GamesPanel();
        GameExpertFrame.getInstance().open("gry.xdsl", new QuestionPanel(gamesPanel, "gry.xdsl"), gamesPanel);
    }
}
