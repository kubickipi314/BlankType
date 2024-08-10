package animation;

import javax.swing.*;

public class AnimationPanel extends JPanel implements Runnable {

    private static final int FPS = 60;
    Thread animationThread;
    public void startAnimationThread() {
        animationThread = new Thread(this);
        animationThread.start();
    }

    @Override
    public void run() {
        double drawInterval = (double) 1000000000 / FPS;

        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (animationThread != null){
            currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / drawInterval;
            lastTime = currentTime;
            if (delta >= 1){
                update();
                repaint();
                delta--;
            }
        }

    }

    private void update() {

    }
}
