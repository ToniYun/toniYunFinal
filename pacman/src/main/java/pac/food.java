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
public class food extends JPanel {

    private BufferedImage food;
    private int space;

    public food() throws IOException {
        food = ImageIO.read(new File("F:\\pictures\\food.png"));
        space = 50;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        //first vertical
        for (int i = -20; i < 628; i=i+72) {
            g2.drawImage(food, null, i+space, -25+space);
        }
        //second vertical
        for (int i = -20; i < 630; i=i+72) {
            g2.drawImage(food, null, i+space, 173+space);
        }
        //third vertical
        for (int i = -20; i < 630; i=i+72) {
            if((i<=120)||(i>=450)){
            g2.drawImage(food, null, i+space, 74+space);
            }
        }
        //first horizontal
        for (int i = -25; i < 210; i=i+99) {
            g2.drawImage(food, null, -20+space, i+space);
        }
        //second horizontal
        for (int i = -25; i < 210; i=i+99) {
            g2.drawImage(food, null, 124+space, i+space);
        }
        //third horizontal
        for (int i = -25; i < 210; i=i+99) {
            g2.drawImage(food, null, 484+space, i+space);
        }
        //frouth horizontal
        for (int i = -25; i < 210; i=i+99) {
            g2.drawImage(food, null, 628+space, i+space);
        }
        //first outside
        for (int i = -124; i < 273; i=i+99) {
            g2.drawImage(food, null, -120+space, i+space);
        }
        //second outside
        for (int i = -124; i < 273; i=i+99) {
            g2.drawImage(food, null, 724+space, i+space);
        }
        //top outside p1
        for (int i = -120; i < 96; i=i+72) {
            g2.drawImage(food, null, i+space, -124+space);
        }
        //top outside p2
        for (int i = 125; i < 630; i=i+72) {
            g2.drawImage(food, null, i+space, -124+space);
        }
        //bot outside p1
        for (int i = -120; i < 96; i=i+72) {
            g2.drawImage(food, null, i+space, 272+space);
        }
        //bot outside p2
        for (int i = 125; i < 630; i=i+72) {
            g2.drawImage(food, null, i+space, 272+space);
        }
    }
}
