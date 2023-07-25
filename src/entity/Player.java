package entity;

import main.GamePanel;
import main.KeyHandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Player extends Entity
{
    GamePanel gp;
    KeyHandler keyH;

    public Player(GamePanel gp, KeyHandler keyH)
    {
        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getPlayerImage();
    }

    public void setDefaultValues()
    {
        x = 100;
        y = 100;
        speed = 5;
        direction = "down";
    }

    public void getPlayerImage()
    {
        try
        {
            up1 = ImageIO.read(getClass().getResource("/res/player/boy_up_1.png"));
            up2 = ImageIO.read(getClass().getResource("/res/player/boy_up_2.png"));
            down1 = ImageIO.read(getClass().getResource("/res/player/boy_down_1.png"));
            down2 = ImageIO.read(getClass().getResource("/res/player/boy_down_2.png"));
            right1 = ImageIO.read(getClass().getResource("/res/player/boy_right_1.png"));
            right2 = ImageIO.read(getClass().getResource("/res/player/boy_right_2.png"));
            left1 = ImageIO.read(getClass().getResource("/res/player/boy_left_1.png"));
            left2 = ImageIO.read(getClass().getResource("/res/player/boy_left_2.png"));
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void update()
    {

        if (keyH.upPressed || keyH.downPressed || keyH.leftPressed || keyH.rightPressed)
        {
            if (keyH.upPressed == true) {
                direction = "up";
                y -= speed;
            }
            if (keyH.downPressed == true) {
                direction = "down";
                y += speed;
            }
            if (keyH.rightPressed == true)
            {
                direction = "right";
                x += speed;
            }
            if (keyH.leftPressed == true)
            {
                direction = "left";
                x -= speed;
            }

            spriteCounter++;
            if (spriteCounter > 12) {
                if (spriteNb == 1) {
                    spriteNb = 2;
                } else if (spriteNb == 2) {
                    spriteNb = 1;
                }
                spriteCounter = 0;
            }
        }


    }

    public void draw(Graphics2D g2)
    {
        BufferedImage image = null;

        switch (direction)
        {
            case "up":
                if (spriteNb == 1) { image = up1; }
                if (spriteNb == 2) { image = up2; }
                break;
            case "down" :
                if (spriteNb == 1) { image = down1; }
                if (spriteNb == 2) { image = down2; }
                break;
            case "right":
                if (spriteNb == 1) { image = right1; }
                if (spriteNb == 2) { image = right2; }
                break;
            case "left":
                if (spriteNb == 1) { image = left1; }
                if (spriteNb == 2) { image = left2; }
                break;
        }
        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }

}
