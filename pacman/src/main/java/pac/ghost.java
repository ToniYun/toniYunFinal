/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac;

import static com.sun.java.accessibility.util.AWTEventMonitor.addKeyListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import java.applet.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import java.awt.geom.*;

/**
 *
 * @author yunant000
 */
public class ghost extends JPanel implements ActionListener{

    private BufferedImage blue;
    private boolean[][] edge;
    private int x, y, velx = 2, vely = 0;
    private int speed = 2;

    public ghost(boolean[][] wall, String pic, int x, int y) throws IOException {
        blue = ImageIO.read(new File(pic));
        edge = wall;
        this.x = x;
        this.y = y;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(blue, null, x += velx, y += vely);
        if (y >= 330 && x >= 777) {//bottom right
        vely = 0;
        velx = -speed;
        }
        
        if (y <= -80 && x >= 777) {//top right
        velx = 0;
        vely = -speed;
        
        }
        if (y >= 330 && x <= -80) {//bottom left
        vely = 0;
        velx = speed;
        }
        
        if (y <= -85 && x <= -75) {//top left
        vely = 0;
        velx = -speed;
        }
        if (y <= -90) {
            wallUP();
        }
        if (y >= 330) {
            wallDOWN();
        }
        if (x <= -80) {
            wallLEFT();
        }
        if (x >= 787) {
            wallRIGHT();
        }

        if (edge[x + 100][y + 100]) {
            if (velx >= 1) {
                wallRIGHT();
            }
            if (velx <= -1) {
                wallLEFT();
            }
            if (vely >= 1) {
                wallUP();
            }
            if (vely <= -1) {
                wallDOWN();
            }
        }
    }

    public void wallRIGHT() {
        int ran = ((int) (Math.random() * 3));
        if (ran == 1) {
            vely = -speed;
        } else if (ran == 2 || ran == 0) {
            vely = speed;
        }
        else{
            vely = -speed;
        }
        x=x-1;
        velx = 0;

    }

    public void wallLEFT() {
        int ran = ((int) (Math.random() * 3));
        if (ran == 1) {
            velx = -speed;
        } else if (ran == 2 || ran == 0) {
            velx = speed;
        }else{
            velx = -speed;
        }
        x = x+1;
        vely = 0;

    }

    public void wallDOWN() {
        x = x - 4;
        int ran = ((int) (Math.random() * 3));
        if (ran == 1) {
            vely = -speed;
        } else if (ran == 2 || ran == 0) {
            vely = speed;
        }else{
            vely = -speed;
        }
        y = y -1;
        velx = 0;
    }

    public void wallUP() {
        x = x - 4;
        int ran = ((int) (Math.random() * 3));
        if (ran == 1) {
            vely = -speed;
        } else if (ran == 2 || ran == 0) {
            vely = speed;
        }else{
            vely = -speed;
        }
        y = y +1;
        velx = 0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();
    }
}
