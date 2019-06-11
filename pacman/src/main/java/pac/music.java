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

/**
 *
 * @author semos_000
 */
public class music {

    public music(JFrame frame, JButton startButton, ImageIcon pic, InputStream songs) throws IOException {
        AudioStream audios = new AudioStream(songs);
        AudioPlayer.player.start(audios);
    }
}
