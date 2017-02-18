package com.company;

/**
 * Created by wuzhan on 2017/2/18.
 */
public class Game {
    private int score = 0;

    public void add(int i) {
        score += i;
    }

    public int getScore() {
        return score;
    }

    public int getscoreForFrame(int i) {
        return 0;
    }
}
