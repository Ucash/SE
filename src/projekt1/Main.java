package projekt1;

import common.gui.GameExpertFrame;
import common.gui.GamesPanel;
import projekt1.gui.QuestionPanel;

public class Main {

    public static void main(String[] args) {
        String path = String.format("%s/%s", System.getProperty("user.dir").replace('\\', '/'), "projekt1");
        GamesPanel gamesPanel = new GamesPanel();
        GameExpertFrame.getInstance().open(path, new QuestionPanel(gamesPanel, path), gamesPanel);
    }
}
