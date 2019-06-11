/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac;

/**
 *
 * @author semos_000
 */
public class Level1 {

    private boolean[][] blue;

    public Level1() {
        blue = new boolean[2000][2000];
    }

    public boolean[][] edge() {
        for (int j = 0; j < 66; j++) {
            for (int i = 0; i < 95; i++) {
                blue[636 + j][i] = true;
            }
        }
        for (int j = 0; j < 66; j++) {
            for (int i = 0; i < 95; i++) {
                blue[185 + j][i] = true;
            }
        }
        for (int j = 0; j < 66; j++) {
            for (int i = 38; i < 197; i++) {
                blue[38 + j][i] = true;
            }
        }
        for (int j = 0; j < 66; j++) {
            for (int i = 342; i < 445; i++) {
                blue[636 + j][i] = true;
            }
        }
        for (int j = 0; j < 66; j++) {
            for (int i = 342; i < 445; i++) {
                blue[185 + j][i] = true;
            }
        }
        for (int j = 0; j < 66; j++) {
            for (int i = 233; i < 392; i++) {
                blue[38 + j][i] = true;
            }
        }
        for (int j = 0; j < 66; j++) {
            for (int i = 233; i < 392; i++) {
                blue[787 + j][i] = true;
            }
        }
        for (int j = 0; j < 66; j++) {
            for (int i = 38; i < 197; i++) {
                blue[787 + j][i] = true;
            }
        }
        for (int j = 100; j > 38; j--) {
            for (int i = 288; i < 600; i++) {
                blue[i][j] = true;
            }
        }
        for (int j = 400; j > 339; j--) {
            for (int i = 288; i < 600; i++) {
                blue[i][j] = true;
            }
        }
        for (int j = 96; j > 38; j--) {
            for (int i = 100; i < 150; i++) {
                blue[i][j] = true;
            }
        }
        for (int j = 396; j > 338; j--) {
            for (int i = 740; i < 790; i++) {
                blue[i][j] = true;
            }
        }
        for (int j = 396; j > 338; j--) {
            for (int i = 100; i < 150; i++) {
                blue[i][j] = true;
            }
        }
        for (int j = 96; j > 38; j--) {
            for (int i = 740; i < 790; i++) {
                blue[i][j] = true;
            }
        }
        for (int j = 196; j > 138; j--) {
            for (int i = 640; i < 745; i++) {
                blue[i][j] = true;
            }
        }
        for (int j = 296; j > 238; j--) {
            for (int i = 640; i < 745; i++) {
                blue[i][j] = true;
            }
        }
        for (int j = 296; j > 238; j--) {
            for (int i = 140; i < 248; i++) {
                blue[i][j] = true;
            }
        }
        for (int j = 196; j > 138; j--) {
            for (int i = 140; i < 248; i++) {
                blue[i][j] = true;
            }
        }
        for (int j = 298; j > 138; j--) {
            for (int i = 288; i < 600; i++) {
                blue[i][j] = true;
            }
        }
        return blue;
    }
}
