/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pac;

/**
 *
 * @author home
 */
public class stay {

    private boolean[][] cover;

    public stay() {
        cover = new boolean[2000][2000];
    }

    public void find(int x, int y) {
        cover[x][y] = true;
    }

    public boolean isTrue(int x, int y) {
        return cover[x][y];
    }
}
