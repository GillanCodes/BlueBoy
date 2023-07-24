package main;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    //Screen settings
    final int originalTileSize = 16; // 16x16 pixel
    final int scale = 3;

    final int tileSize = originalTileSize * scale; // Final scale will be 48x48
    final int maxScreenCols = 16;
    final int maxScreenRows = 12;
    final int screenWidth = tileSize * maxScreenCols;
    final int screenHeight = tileSize * maxScreenRows;

    Thread gameThread;

    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run()
    {
        while (gameThread != null)
        {
            update();
            repaint(); // this call paintComponents method
        }
    }

    public void update()
    {

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.white);
        g2.fillRect(100,100, tileSize, tileSize);
        g2.dispose();
    }
}
