package com.mygdx.game;

import com.badlogic.gdx.math.MathUtils;

import java.util.concurrent.TimeUnit;

/**
 * Created by jarod on 9/14/2016.
 */
public class worldGen {
    int maxHeight;
    int maxWidth;
    int grassBlock;
    int dirtBlock;
    int stoneBlock;
    boolean up;
    boolean down;
    int startHeight;
    int number;
    int[][] blocks ;

    public worldGen(int width, int height) {
        maxHeight = height;
        maxWidth = width;
    }
    public void generate() {
        int[][] blocks = new int [maxHeight/16][maxWidth/16];
        startHeight = maxHeight/32;
        grassBlock = 1;
        dirtBlock = 2;
        stoneBlock = 3;
        up = false;
        down = false;
        for (int i = 0; i <= (maxWidth / 16) - 1; i++) {
            number = MathUtils.random(0,2);
            if (number == 0 && !up) {
                startHeight = startHeight - 1;
                blocks[startHeight][i] = grassBlock;
                for (int j = startHeight - 1; j >= startHeight - 3; j--) {
                    blocks[j][i] = dirtBlock;
                }
                for (int k = startHeight - 4; k >= 0; k--) {
                    blocks[k][i] = stoneBlock;
                }
                down = true;
                up = false;
            }
            else if (number == 2 && !down) {
                startHeight = startHeight + 1;
                blocks[startHeight][i] = grassBlock;
                for (int j = startHeight - 1; j >= startHeight - 3; j--) {
                    blocks[j][i] = dirtBlock;
                }
                for (int k = startHeight - 4; k >= 0; k--) {
                    blocks[k][i] = stoneBlock;
                }
                up = true;
                down = false;
            }
            else if (number == 1 || number == 0 && up || number == 2 && down) {
                blocks[startHeight][i] = grassBlock;
                for (int j = startHeight - 1; j >= startHeight - 3; j--) {
                    blocks[j][i] = dirtBlock;
                }
                for (int k = startHeight - 4; k >= 0; k--) {
                    blocks[k][i] = stoneBlock;
                }
                up = false;
                down = false;
            }
        }
    }
}
