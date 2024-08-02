package ui;

import javax.swing.*;

public class MainWindow extends JFrame {
    JPanel panel;

    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("BlankType");
        setSize(500, 400);
        setResizable(false);

        panel = new MainPanel();
        panel.setVisible(true);
        add(panel);
    }

}
