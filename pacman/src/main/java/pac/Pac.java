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
import javax.imageio.ImageIO;
import java.*;
import java.awt.image.BufferedImage;
import java.lang.ArrayIndexOutOfBoundsException;

/**
 *
 * @author yunant000
 */
public class Pac {

        private JButton startButton;
        private ImageIcon pic;
        private AudioStream songs;

        /**
         * @param args the command line arguments
         * @throws java.io.FileNotFoundException
         */
        public static void main(String[] args) throws FileNotFoundException, IOException {
                // DrawingPanel panel = new DrawingPanel(200, 100);
                JButton startButton = new JButton("Game Over");
                JFrame frame = new JFrame("pacman game");
                Container c = frame.getContentPane();
                BufferedImage back = ImageIO.read(new File("back.png"));
                InputStream songs = new FileInputStream(new File("Dj Habibi.wav"));
                ImageIcon pic = new ImageIcon("pacman-facts.png");
                music mus = new music(frame, startButton, pic, songs);
                icon s = new icon(frame, startButton);
                frame.add(s);
                c.setBackground(Color.BLUE);
                frame edge = new frame(frame, startButton, pic, songs, back);
        }

}
