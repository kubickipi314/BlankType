import ui.MainWindow;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {



        GraphicsEnvironment GE = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //List<String> AVAILABLE_FONT_FAMILY_NAMES = GE.getAvailableFontFamilyNames();
        for (String name : GE.getAvailableFontFamilyNames()){
            System.out.println(name);
        }
        //SwingUtilities.invokeLater(Main::Application);
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
    }
}