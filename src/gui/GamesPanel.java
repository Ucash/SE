package gui;

import common.game.Game;
import java.util.List;
import javax.swing.*;
import java.awt.*;

public class GamesPanel extends JPanel {

    private JPanel gamesPanel;

    public GamesPanel(){
        super();
        gamesPanel = new JPanel(new GridLayout(0, 1));
        this.add(gamesPanel);
    }

    public void updateView(List<Game> games) {
        JPanel newGamesPanel = new JPanel(new GridLayout(0, 1));
        if (games.isEmpty()){
            JLabel gameLabel = new JLabel("Nie znaleziono :(");
            newGamesPanel.add(gameLabel);
        }
        for (Game game : games) {
            JLabel gameLabel = new JLabel(game.getDisplayName());
            gameLabel.setHorizontalAlignment(JLabel.CENTER);
            newGamesPanel.add(gameLabel);
        }
        this.remove(gamesPanel);
        gamesPanel = newGamesPanel;
        this.add(gamesPanel);
        this.invalidate();
    }
}
