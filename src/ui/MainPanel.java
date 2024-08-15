package ui;

import animation.AnimationPanel;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {

    JLabel speedLabel;
    JPanel speedStrip;
    TextPanel textPanel;
    //JPanel animationPanel;
    JButton button;
    JButton button2;
    JButton button3;

    public MainPanel() {
        setLayout(null);

        Font font = new Font("DialogInput", Font.PLAIN, 18);

        speedLabel = new JLabel("Speed: 0 WPM");
        speedLabel.setBounds(0,300, 200, 20);
        speedLabel.setFont(font);
        speedLabel.setForeground(Color.GREEN);

        speedStrip = new JPanel();
        speedStrip.setBackground(Color.GREEN);

        textPanel = new TextPanel(speedLabel,speedStrip);
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
            //animationPanel = new AnimationPanel();
        });
        button2.setBackground(Color.BLACK);
        button2.setVisible(true);
        button2.setBounds(400, 100, 100, 100);

        button3 = new JButton("GRAY");
        button3.addActionListener(e -> {
            textPanel.getTextArea().setCaretColor(Color.GRAY);
            textPanel.getTextArea().setForeground(Color.GRAY);
            textPanel.getTextArea().requestFocusInWindow();
        });
        button3.setBackground(Color.BLACK);
        button3.setForeground((Color.GRAY));
        button3.setVisible(true);
        button3.setBounds(400, 200, 100, 100);

        //PANEL
        add(button);
        add(button2);
        add(button3);
        add(textPanel);
        //add(animationPanel);
        add(speedLabel);
        add(speedStrip);

        setPreferredSize(new Dimension(200, 200));
        setBackground(Color.BLACK);
    }
}
