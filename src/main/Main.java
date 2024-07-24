package main;

import javax.swing.*;
import javax.swing.text.Caret;
import java.awt.*;

public class Main {
    public static void Application(){

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("BlankType");
        window.setSize(500,400);

        JPanel panel = new JPanel();

        panel.setLayout(null);

        //TEXT AREA
        JTextArea area = new JTextArea();
        area.setBackground(Color.BLACK);
        area.setForeground(Color.GREEN);
        area.setBounds(0,0,400,400);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        Caret caret = area.getCaret();
        caret.setBlinkRate(200);
        area.setCaretColor(Color.GREEN);
        area.setCaretPosition(0);

        Font font = new Font("Ubuntu", Font.BOLD, 18); // Font name, style, size
        area.setFont(font);

        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setBounds(0,0,400,400);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));

        //BUTTONS
        JButton button = new JButton("RESET");
        button.addActionListener(e -> area.setText(""));
        button.setBackground(Color.BLACK);
        button.setVisible(true);
        button.setBounds(400,0,100,100);

        JButton button2 = new JButton("BLANK");
        button2.addActionListener(e -> {area.setCaretColor(Color.BLACK); area.setForeground(Color.BLACK);});
        button2.setBackground(Color.BLACK);
        button2.setVisible(true);
        button2.setBounds(400,100,100,100);

        //PANEL
        panel.add(button);
        panel.add(button2);
        panel.add(scrollPane);
        panel.setPreferredSize(new Dimension(200, 200));
        panel.setBackground(Color.BLACK);

        window.add(panel);
        window.setVisible(true);
    }
    public static void main(String[] args) {

        SwingUtilities.invokeLater(Main::Application);
    }
}