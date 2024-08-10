package ui;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    JLabel wordCountLabel;
    JLabel charCountLabel;
    JLabel speedLabel;
    TextPanel textPanel;
    JButton button;
    JButton button2;
    JButton button3;

    public MainPanel() {
        setLayout(null);

        Font font = new Font("DialogInput", Font.PLAIN, 15);
        wordCountLabel = new JLabel("Words: 0");
        wordCountLabel.setBounds(0,300,200,20);
        wordCountLabel.setFont(font);
        wordCountLabel.setForeground(Color.GREEN);
        charCountLabel = new JLabel("Characters: 0");
        charCountLabel.setBounds(0,320,200,20);
        charCountLabel.setFont(font);
        charCountLabel.setForeground(Color.GREEN);
        speedLabel = new JLabel("Speed: 0 WPM");
        speedLabel.setBounds(0,340, 200, 20);
        speedLabel.setFont(font);
        speedLabel.setForeground(Color.GREEN);

        textPanel = new TextPanel(wordCountLabel,charCountLabel,speedLabel);
        textPanel.setVisible(true);

        //BUTTONS
        button = new JButton("RESET");
        button.addActionListener(e -> {
            textPanel.getTextArea().setText("");
            textPanel.getTextArea().requestFocusInWindow();
        });
        button.setBackground(Color.BLACK);
        button.setVisible(true);
        button.setBounds(400, 0, 100, 100);

        button2 = new JButton("BLANK");
        button2.addActionListener(e -> {
            textPanel.getTextArea().setCaretColor(Color.BLACK);
            textPanel.getTextArea().setForeground(Color.BLACK);
            textPanel.getTextArea().requestFocusInWindow();
        });
        button2.setBackground(Color.BLACK);
        button2.setVisible(true);
        button2.setBounds(400, 100, 100, 100);

        button3 = new JButton("GREEN");
        button3.addActionListener(e -> {
            textPanel.getTextArea().setCaretColor(Color.GREEN);
            textPanel.getTextArea().setForeground(Color.GREEN);
            textPanel.getTextArea().requestFocusInWindow();
        });
        button3.setBackground(Color.BLACK);
        button3.setForeground((Color.GREEN));
        button3.setVisible(true);
        button3.setBounds(400, 200, 100, 100);

        //PANEL
        add(button);
        add(button2);
        add(button3);
        add(textPanel);
        add(wordCountLabel);
        add(charCountLabel);
        add(speedLabel);

        setPreferredSize(new Dimension(200, 200));
        setBackground(Color.BLACK);
    }
}
