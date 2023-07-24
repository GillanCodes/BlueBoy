package main;

import javax.swing.JPanel;
import java.awt.*;

public class GamePanel extends JPanel {

    //Screen settings
    final int originalTileSize = 16; // 16x16 pixel
    final int scale = 3;

    final int tileSize = originalTileSize * scale; // Final scale will be 48x48
    final int maxScreenCols = 16;
    final int maxScreenRows = 12;
    final int screenWidth = tileSize * maxScreenCols;
    final int screenHeight = tileSize * maxScreenRows;

    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
    }

}
