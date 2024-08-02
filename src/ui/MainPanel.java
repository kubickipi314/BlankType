package ui;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel {
    TextPanel textPanel;
    JButton button;
    JButton button2;
    JButton button3;

    public MainPanel() {
        setLayout(null);

        textPanel = new TextPanel();
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

        setPreferredSize(new Dimension(200, 200));
        setBackground(Color.BLACK);
    }
}
