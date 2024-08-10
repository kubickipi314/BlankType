package ui;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Caret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.Queue;

public class TextPanel extends JPanel {
    private final JTextArea textArea;
    AtomicInteger charCount;
    AtomicInteger wordCount;
    AtomicInteger lastCharCount;

    public TextPanel(JLabel wordCountLabel, JLabel charCountLabel, JLabel speedLabel) {

        setLayout(null);

        charCount = new AtomicInteger(0);
        wordCount = new AtomicInteger(0);

        textArea = new JTextArea("");

        textArea.setBackground(Color.BLACK);
        textArea.setForeground(Color.GREEN);
        textArea.setBounds(0, 0, 400, 300);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        textArea.getDocument().addDocumentListener(new DocumentListener() {
            public void update() {
                // Get the text from the JTextArea
                String text = textArea.getText();

                // Count characters
                charCount.set(text.length());

                // Count words
                String[] words = text.trim().split("\\s+");
                wordCount.set(text.trim().isEmpty() ? 0 : words.length);

                // Update labels
                wordCountLabel.setText("Words: " + wordCount.get());
                charCountLabel.setText("Characters: " + charCount.get());
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                update();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                update();
            }
        });

        Timer timer = new Timer(500, new ActionListener() {
            int lastCharCount;
            int charsInMemory;
            final Queue<Integer> charsInIntervals = new LinkedList<>(Arrays.asList(0,0,0,0));
            @Override
            public void actionPerformed(ActionEvent e) {
                int charsTypedLastInterval = charCount.get() - lastCharCount;
                charsInIntervals.add(charsTypedLastInterval);

                charsInMemory += charsTypedLastInterval;
                charsInMemory -= charsInIntervals.remove();

                // Calculate speed in words per minute
                int speedWPM = ((charsInMemory) * 30 / 5 );

                speedLabel.setText("Speed: " + speedWPM + " WPM");

                // Update last counts
                lastCharCount = charCount.get();
            }
        });
        timer.start();

        Caret caret = textArea.getCaret();
        caret.setBlinkRate(200);
        textArea.setCaretColor(Color.GREEN);
        textArea.setCaretPosition(0);

        Font font = new Font("DialogInput", Font.PLAIN, 18); // Font name, style, size
        textArea.setFont(font);

        JScrollPane scrollPane = new JScrollPane(textArea);

        scrollPane.setBackground(Color.BLACK);
        scrollPane.setBounds(0, 0, 400, 300);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 0));
        scrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 0));

        setBounds(0, 0, 400, 300);
        add(scrollPane);
        setVisible(true);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

}
