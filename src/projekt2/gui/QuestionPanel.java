package projekt2.gui;

import common.gui.AbstractQuestionPanel;
import common.gui.GamesPanel;
import projekt2.proxy.GenieProxy;
import projekt2.question.Question;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Hashtable;

public class QuestionPanel extends AbstractQuestionPanel {
    private JPanel questionPanel;
    private JLabel questionLabel;
    private JButton startButton;
    private JSlider slider;
    private JButton okButton;


    private GamesPanel gamesPanel;
    private Question question;
    private GenieProxy proxy;

    public QuestionPanel(GamesPanel gamesPanel, String path) {
        super();
        buildView();
        this.gamesPanel = gamesPanel;
        this.gamesPanel.setRestartButtonListener(restart());
        proxy = new GenieProxy(path);
        gamesPanel.updateView(proxy.updateGames());
        setButtonsVisibility(false);
    }

    public void updateView() {
        questionLabel.setText(question.getFullQuestionText());

    }

    private void buildView() {
        questionPanel = new JPanel(new GridLayout(0, 1));
        questionPanel.setPreferredSize(new Dimension(230, 500));

        startButton = buildButton("KLIKNIJ ABY ROZPOCZ¥C", start());
        questionPanel.add(startButton);
        questionLabel = buildLabel("Question");
        questionPanel.add(questionLabel);

        JPanel answerPanel = new JPanel(new GridLayout(0, 1));
        JLabel value = new JLabel("0,50 - 0,50");

        slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 50);
//Create the label table
        Hashtable labelTable = new Hashtable();
        labelTable.put(new Integer(0), new JLabel("TAK"));
        labelTable.put(new Integer(50), value);
        labelTable.put(new Integer(100), new JLabel("NIE"));
        slider.setLabelTable(labelTable);
        slider.addChangeListener(e -> {
            double v = slider.getValue() / 100.0;
            value.setText(String.format("%.2f - %.2f", v, 1 - v));
        });

        slider.setPaintLabels(true);
        okButton = buildButton("OK", answerButtonListener());
        answerPanel.add(slider);
        answerPanel.add(okButton);
        answerPanel.add(Box.createHorizontalStrut(5));

        questionPanel.add(answerPanel);
        questionPanel.add(Box.createHorizontalStrut(5));
        setElementsVisibility(false);
        this.add(questionPanel);
        this.invalidate();
        this.validate();
    }

    private void setElementsVisibility(boolean isVisible) {
        questionLabel.setVisible(isVisible);
        setButtonsVisibility(isVisible);
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


    private ActionListener answerButtonListener() {
        return e -> {
            double value = slider.getValue() / 100.0;
            double[] values = {value, 1.0 - value};
            question = proxy.onAnswer(question, values);
            gamesPanel.updateView(proxy.updateGames());
            if (question == null) {
                questionLabel.setText("<html>NIE MA WIÊCEJ PYTAÑ<br>PROPOZYCJA W PRAWYM PANELU");
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
            question = proxy.restart();
            question = proxy.getNextQuestion();
            updateView();
        };
    }

    private ActionListener restart() {
        return e -> {
            question = proxy.restart();
            gamesPanel.clean();
            setElementsVisibility(true);
            updateView();
        };
    }

    public void setButtonsVisibility(boolean buttonsVisibility) {
        this.slider.setVisible(buttonsVisibility);
        this.okButton.setVisible(buttonsVisibility);
    }
}
