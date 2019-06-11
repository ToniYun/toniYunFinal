/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac;

import java.lang.ArrayIndexOutOfBoundsException;

/**
 *
 * @author yunant000
 */
public class foodSpace {

    private boolean[][] conner;
    private int space;
    private int pos;

    public foodSpace() {
        conner = new boolean[2000][2000];
        space = 50;
        pos = 124;
    }

    public boolean[][] space() {
        //first vertical
        for (int i = -20 + pos; i < 628 + pos; i = i + 72) {
            conner[i + space][-25 + space + pos] = true;
        }
        //second vertical
        for (int i = -20 + pos; i < 630 + pos; i = i + 72) {
            conner[i + space][173 + space + pos] = true;
        }
        //third vertical
        for (int i = -20 + pos; i < 630 + pos; i = i + 72) {
            if ((i <= 120) || (i >= 550) && i < 650) {
                conner[i + pos][74 + space + pos] = true;
            }
        }
        //first horizontal
        for (int i = -25 + pos; i < 210 + pos; i = i + 99) {
            conner[-20 + space + pos][i + space] = true;
        }
        //second horizontal
        for (int i = -25 + pos; i < 210 + pos; i = i + 99) {
            conner[124 + space + pos][i + space] = true;
        }
        //third horizontal
        for (int i = -25 + pos; i < 210 + pos; i = i + 99) {
            conner[484 + space + pos][i + space] = true;
        }
        //frouth horizontal
        for (int i = -25 + pos; i < 210 + pos; i = i + 99) {
            conner[628 + space + pos][i + space] = true;
        }
        //first outside
        for (int i = -124 + pos; i < 273 + pos; i = i + 99) {
            conner[-120 + space + pos][i + space] = true;
        }
        //second outside
        for (int i = -124 + pos; i < 273 + pos; i = i + 99) {
            conner[724 + space + pos][i + space] = true;
        }
        //top outside p1
        for (int i = -120 + pos; i < 96 + pos; i = i + 72) {
            conner[i + space][-124 + space + pos] = true;
        }
        //top outside p2
        for (int i = 125 + pos; i < 630 + pos; i = i + 72) {
            conner[i + space][-124 + space + pos] = true;
        }
        //bot outside p1
        for (int i = -120 + pos; i < 96 + pos; i = i + 72) {
            conner[i + space][272 + space + pos] = true;
        }
        //bot outside p2
        for (int i = 125 + pos; i < 630 + pos; i = i + 72) {
            conner[i + space][272 + space + pos] = true;
        }
        return conner;
    }

    public boolean[][] find(boolean[][] conner, int x, int y) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                conner[x + space + i][y + space + j] = false;
            }
        }
        return conner;
    }

    public boolean isTrue(boolean[][] conner, int x, int y) {
        return conner[x][y];
    }
}
