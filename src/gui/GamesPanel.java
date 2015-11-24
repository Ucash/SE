package gui;

import common.game.Game;

import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;

public class GamesPanel extends JPanel {

    JLabel answerLabel;
    JButton restartButton;

    public GamesPanel(){
        super();
        answerLabel = new JLabel("");
        answerLabel.setHorizontalAlignment(JLabel.CENTER);
        restartButton = new JButton("Zapytaj ponownie!");
        this.add(restartButton);
        this.add(answerLabel);
    }

    public void setRestartButtonListener(ActionListener listener){
        restartButton.addActionListener(listener);
    }

    public void updateView(List<Game> games) {
        if (games.isEmpty()){
            answerLabel.setText("Nie znaleziono :(");
            return;
        }
        StringBuilder answer = new StringBuilder("<html>");
        for (Game game : games) {
            answer.append(String.format("%s<br>", game.getDisplayName()));
        }
        answerLabel.setText(answer.toString());
    }

    public void clean() {
        answerLabel.setText("");
    }
}
