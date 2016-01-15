package common.gui;

import javax.swing.*;
import java.awt.*;

public class GameExpertFrame extends JFrame {

    private static final Dimension FRAME_SIZE = new Dimension(600, 600);
    private static final int SPLIT_DIVIDER_LOCATION = 300;

    private static final GameExpertFrame instance = new GameExpertFrame();

    private AbstractQuestionPanel questionPanel;
    private GamesPanel gamesPanel;

    private GameExpertFrame() {
        super("GAME EXPERT");
    }

    public static GameExpertFrame getInstance() {
        return instance;
    }

    public void open(String path, AbstractQuestionPanel questionPanel, GamesPanel gamesPanel) {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.gamesPanel = gamesPanel;
        this.questionPanel = questionPanel;
        setContentPane(createSplitPanel());
        setSize(FRAME_SIZE);
        setVisible(true);
        setResizable(false);
    }

    private JSplitPane createSplitPanel() {
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, questionPanel, gamesPanel);
        splitPane.setDividerSize(5);
        splitPane.setDividerLocation(SPLIT_DIVIDER_LOCATION);
        splitPane.setEnabled(false);

        return splitPane;
    }
}