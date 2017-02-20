package com.company;

/**
 * Created by wuzhan on 2017/2/18.
 */
public class Game {
    private int score = 0;
    private int[] itsThrows = new int[21];
    private int itsCurrentThrows = 0;
    private int currentFrame;
    private boolean isFirstThrow  = true;
    int ball;


    public void add(int pins) {
        itsThrows[itsCurrentThrows++] = pins;
        score += pins;
        adjustCurrentFrame(pins);
    }

    public int getScore() {
        return scoreForFrame(getCurrentFrame());
    }

    public int scoreForFrame(int theFrame) {
        int score = 0;
        ball = 0;
        for(int currentFrame = 0;currentFrame < theFrame; currentFrame++){
            if(strike()){
                score += 10 + nextTwoBallsForSpike();
                ball += 1;
            }else if(spare()){
                score += 10 + nextBallForSpare();
                ball += 2;
            }else {
                score += nextTwoBalls();
                ball += 2;

            }
        }
        return score;
    }

    private int nextBallForSpare() {
        return itsThrows[ball+2];
    }

    private boolean spare() {
        return nextTwoBalls() == 10;
    }


    private void adjustCurrentFrame(int pins) {
        if(isFirstThrow == true){
            if(pins == 10){
                advanceFrame();
            }else {
                isFirstThrow = false;
            }
        }else {
            isFirstThrow = true;
            advanceFrame();
        }

    }

    private void advanceFrame() {
        currentFrame = Math.min(10,currentFrame+1);
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    private int nextTwoBallsForSpike() {
        return itsThrows[ball+1] + itsThrows[ball + 2];
    }

    private int nextTwoBalls() {
        return itsThrows[ball] + itsThrows[ball + 1];
    }

    private boolean strike() {
        return itsThrows[ball] == 10;
    }
}
