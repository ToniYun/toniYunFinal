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
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
/**
 *
 * @author semos_000
 */
public class frame extends JFrame{
    public frame(JFrame frame, JButton startButton, ImageIcon pic, InputStream songs, BufferedImage back) throws IOException{
        super("frame");
        frame.setSize(back.getWidth()+20, back.getHeight()+35);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = frame.getContentPane();
        c.setBackground(Color.BLUE);
        //frame.add(new JLabel(pic));
        frame.setVisible(true);
        
    }
}
