package ui;

import javax.swing.*;
import javax.swing.text.Caret;
import java.awt.*;

public class TextPanel extends JPanel {
    private final JTextArea textArea;

    public TextPanel() {

        setLayout(null);

        textArea = new JTextArea();
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.GREEN);
        textArea.setBounds(0, 0, 400, 300);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        Caret caret = textArea.getCaret();
        caret.setBlinkRate(200);
        textArea.setCaretColor(Color.GREEN);
        textArea.setCaretPosition(0);

        Font font = new Font("Calibri", Font.BOLD, 18); // Font name, style, size
        textArea.setFont(font);

        JScrollPane scrollPane = new JScrollPane(textArea);

        scrollPane.setBackground(Color.BLACK);
        scrollPane.setBounds(0, 0, 400, 300);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));

        setBounds(0,0,400,300);
        add(scrollPane);
        setVisible(true);
    }
    public JTextArea getTextArea(){
        return textArea;
    }

}
