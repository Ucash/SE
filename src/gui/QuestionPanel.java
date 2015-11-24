package gui;

import proxy.PrologProxy;
import common.question.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class QuestionPanel extends JPanel {

    private JPanel questionPanel;
    private JLabel questionLabel;
    private JButton startButton;

    private JButton firstOptionButton;
    private JButton secondOptionButton;
    private JButton thirdOptionButton;
    private JButton fourthOptionButton;

    private GamesPanel gamesPanel;
    private Question question;
    private PrologProxy proxy;

    public QuestionPanel(GamesPanel gamesPanel){
        super();
        buildView();
        this.gamesPanel = gamesPanel;
    }

    public void updateView(){
        questionLabel.setText(question.getFullQuestionText());
        firstOptionButton.setText(question.getAnswer(0).getDisplayValue());
        secondOptionButton.setText(question.getAnswer(1).getDisplayValue());
        thirdOptionButton.setText(question.getAnswer(2).getDisplayValue());
        if (question.getAnswersCount() > 3){
            fourthOptionButton.setVisible(true);
            fourthOptionButton.setText(question.getAnswer(3).getDisplayValue());
        } else {
            fourthOptionButton.setVisible(false);
        }
    }

    private void buildView() {
        questionPanel = new JPanel(new GridLayout(0, 1));
        questionPanel.setPreferredSize(new Dimension(230, 500));

        startButton = buildButton("KLIKNIJ ABY ROZPOCZĄC", start());
        questionPanel.add(startButton);
        questionLabel = buildLabel("Question");
        questionPanel.add(questionLabel);

        JPanel answerPanel = new JPanel(new GridLayout(0, 1));
        firstOptionButton = buildButton("1. opcja", answerButtonListener(0));
        answerPanel.add(firstOptionButton);
        secondOptionButton = buildButton("2. opcja", answerButtonListener(1));
        answerPanel.add(secondOptionButton);
        thirdOptionButton = buildButton("3. opcja", answerButtonListener(2));
        answerPanel.add(thirdOptionButton);
        fourthOptionButton = buildButton("4. opcja", answerButtonListener(3));
        answerPanel.add(fourthOptionButton);
        answerPanel.add(Box.createHorizontalStrut(5));

        questionPanel.add(answerPanel);
        questionPanel.add(Box.createHorizontalStrut(5));
        setElementsVisibility(false);
        this.add(questionPanel);
        this.invalidate();
        this.validate();
    }

    private void setElementsVisibility(boolean isVisible){
        questionLabel.setVisible(isVisible);
        setButtonsVisibility(isVisible);
    }

    private void setButtonsVisibility(boolean isVisible){
        firstOptionButton.setVisible(isVisible);
        secondOptionButton.setVisible(isVisible);
        thirdOptionButton.setVisible(isVisible);
        fourthOptionButton.setVisible(isVisible);
    }

    private JLabel buildLabel(String text) {
        JLabel label = new JLabel(text);
        label.setHorizontalAlignment(JLabel.CENTER);
        return label;
    }

    private JButton buildButton(String title, ActionListener listener) {
        JButton button = new JButton(title);
        button.setSize(400, 50);
        button.addActionListener(listener);
        return button;
    }

    private ActionListener answerButtonListener(int index) {
        return e -> {
            //System.out.println(index);
            question = proxy.onAnswer(question.getAnswer(index).getValue());
            gamesPanel.updateView(proxy.getPossibleGames());
            if (question == null){
                questionLabel.setText("NIE MA WIĘCEJ PYTAŃ\nPROPOZYCJA W PRAWYM PANELU");
                setButtonsVisibility(false);
                questionPanel.add(startButton);
                this.invalidate();
                this.validate();
                return;
            }
            updateView();
        };
    }

    private ActionListener start() {
        return e -> {
            questionPanel.remove(startButton);
            this.invalidate();
            this.validate();
            setElementsVisibility(true);
            proxy = new PrologProxy();
            question = proxy.loadEngine();
            updateView();
        };
    }
}
