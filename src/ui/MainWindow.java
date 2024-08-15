package ui;

import javax.swing.*;

public class MainWindow extends JFrame {
    final int WINDOW_WIDTH = 500;
    final int WINDOW_HEIGHT = 400;
    JPanel panel;

    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BlankType");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setResizable(false);

        panel = new MainPanel();
        panel.setVisible(true);
        add(panel);
    }

}
