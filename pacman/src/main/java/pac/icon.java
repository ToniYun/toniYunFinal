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
import java.lang.ArrayIndexOutOfBoundsException;

/**
 *
 * @author semos_000
 */
public class icon extends JPanel implements ActionListener, KeyListener {

    private Timer t = new Timer(5, this);
    private double x = 10, y = 0, velx = 0, vely = 0;
    private Ellipse2D image;
    private BufferedImage img;
    private BufferedImage pic;
    private BufferedImage food;
    private BufferedImage food2;
    private JFrame frame;
    private String files;
    private boolean[][] edge;
    private boolean[][] dot;
    private foodSpace foodSpace;
    private ghost blue;
    private ghost pink;
    private JButton startButton;
    private stay blackDot;

    public icon(JFrame fram, JButton startButto) throws IOException {
        t.start();
        files = "C:/Users/hosub/Documents/2019 Spring Quarter/CSS 143/pacman/src/main/java/pac/";
        frame = fram;
        JButton startButton = startButto;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);
        img = ImageIO.read(new File(files + "pacman-facts3.png"));
        pic = ImageIO.read(new File(files + "back.png"));
        food = ImageIO.read(new File(files + "food.png"));
        food2 = ImageIO.read(new File(files + "black.png"));
        Level1 pac = new Level1();
        edge = pac.edge();
        blue = new ghost(edge, files + "blue2.png", 100, 20);
        pink = new ghost(edge, files + "pink.fw.png", 200, 230);
        foodSpace = new foodSpace();
        dot = foodSpace.space();
        blackDot = new stay();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        try {
            stop();
        } catch (IOException ex) {
            Logger.getLogger(icon.class.getName()).log(Level.SEVERE, null, ex);
        }
        g2.drawImage(pic, null, 0, 0);
        y += vely;
        x += velx;
        /*
         * try {
         * 
         * food white = white = new food(); white.paintComponent(g); } catch
         * (IOException ex) { Logger.getLogger(icon.class.getName()).log(Level.SEVERE,
         * null, ex); }
         */
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (foodSpace.isTrue(dot, (int) x + i + 120, (int) y + j + 130)) {
                    dot = foodSpace.find(dot, (int) x + 90, (int) y + 92);
                }
            }
        }
        for (int k = 0; k < 2000; k = k + 1) {
            for (int l = 0; l < 2000; l = l + 1) {
                if (foodSpace.isTrue(dot, k, l)) {
                    g2.drawImage(food, null, k - 120, l - 120);
                }
            }
        } /*
           * for (int k = 0; k < 2000; k = k + 2) { for (int l = 0; l < 2000; l = l + 8) {
           * if (blackDot.isTrue(k, l)) { g2.drawImage(food2, null, k, l); } } }
           */

        pink.paintComponent(g);
        blue.paintComponent(g);
        g2.drawImage(img, null, (int) x, (int) y);
        int numX = blue.getX();
        int numY = blue.getY();
        int numPX = pink.getX();
        int numPY = pink.getY();
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                if (x + 10 + i == numX && y - 23 + j == numY) {
                    try {
                        frame.setContentPane(
                                new JLabel(new ImageIcon(ImageIO.read(new File(files + "background.png")))));
                    } catch (IOException ex) {
                        Logger.getLogger(icon.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                if (x + 10 + i == numPX && y - 23 + j == numPY) {
                    try {
                        frame.setContentPane(
                                new JLabel(new ImageIcon(ImageIO.read(new File(files + "background.png")))));
                    } catch (IOException ex) {
                        Logger.getLogger(icon.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }

    }

    public void wallRIGHT() throws IOException {
        if (edge[(int) x + 94][(int) y + 110]) {
            velx = 0;
            x = x - 4;
        }
    }

    public void wallLEFT() throws IOException {
        if (edge[(int) x + 94][(int) y + 110]) {
            velx = 0;
            x = x + 4;
        }
    }

    public void wallDOWN() throws IOException {
        if (edge[(int) x + 94][(int) y + 110]) {
            vely = 0;
            y = y - 4;
        }
    }

    public void wallUP() throws IOException {
        if (edge[(int) x + 94][(int) y + 110]) {
            vely = 0;
            y = y + 4;
        }
    }

    public void up() throws IOException {
        vely = -2;
        velx = 0;
        img = ImageIO.read(new File(files + "pacman-facts4.png"));
        wallUP();
    }

    public void down() throws IOException {
        vely = 2;
        velx = 0;
        img = ImageIO.read(new File(files + "pacman-facts2.png"));
        wallDOWN();
    }

    public void right() throws IOException {
        vely = 0;
        velx = 2;
        img = ImageIO.read(new File(files + "pacman-facts3.png"));
        wallRIGHT();
    }

    public void left() throws IOException {
        vely = 0;
        velx = -2;
        img = ImageIO.read(new File(files + "pacman-facts.png"));
        wallLEFT();
    }

    public void stop() throws IOException {
        if (velx == 2) {
            wallRIGHT();
        }
        if (velx == -2) {
            wallLEFT();
        }
        if (vely == 2) {
            wallDOWN();
        }
        if (vely == -2) {
            wallUP();
        }

        if (y > 322) {
            vely = 0;
            y = 320;
        }
        if (y < -108) {
            vely = 0;
            y = -106;
        }
        if (x > 787) {
            velx = 0;
            x = 786;
        }
        if (x < -93) {
            velx = 0;
            x = -92;
        }
    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_UP) {
            try {
                up();
            } catch (IOException ex) {
                System.out.println("no pic");
            }
        }
        if (code == KeyEvent.VK_DOWN) {
            try {
                down();
            } catch (IOException ex) {
                System.out.println("no pic");
            }
        }
        if (code == KeyEvent.VK_RIGHT) {
            try {
                right();
            } catch (IOException ex) {
                System.out.println("no pic");
            }
        }
        if (code == KeyEvent.VK_LEFT) {
            try {
                left();
            } catch (IOException ex) {
                System.out.println("no pic");
            }
        }

    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyRelesed(KeyEvent e) {
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        repaint();

        if (y >= 322) {
            try {
                stop();
            } catch (IOException ex) {
                Logger.getLogger(icon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (y <= -108) {
            try {
                stop();
            } catch (IOException ex) {
                Logger.getLogger(icon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (x >= 787) {
            try {
                stop();
            } catch (IOException ex) {
                Logger.getLogger(icon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (x <= -93) {
            try {
                stop();
            } catch (IOException ex) {
                Logger.getLogger(icon.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent ke) {

    }

}
