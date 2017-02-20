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

    public void add(int pins) {
         itsThrows[itsCurrentThrows++] = pins;
        score += pins;
        adjustCurrentFrame(pins);
    }

    public int getScore() {
        return getScoreForFrame(getCurrentFrame());
    }

    public int getScoreForFrame(int theFrame) {
        int score = 0;
        int ball = 0;
        for(int currentFrame = 0;currentFrame < theFrame; currentFrame++){
            int firstThrow = itsThrows[ball];
            int secondThrow = itsThrows[ball +1];
            int frameScore = firstThrow + secondThrow;
            if(firstThrow == 10){
                ball += 1;
                score += frameScore + itsThrows[ball+1];
            }else if(frameScore == 10){
                ball += 2;
                score += frameScore + itsThrows[ball];
            }else {
                ball += 2;
                score += frameScore;
            }
        }
        return score;
    }

    private void adjustCurrentFrame(int pins) {
        if(isFirstThrow){
            if(pins == 10){
                currentFrame++;
            }else {
                isFirstThrow = false;
                return;
            }

        }
        currentFrame++;
        isFirstThrow = true;
        currentFrame = Math.min(10,currentFrame);
    }

    public int getCurrentFrame() {
        return currentFrame;
    }
}
