package com.company;

/**
 * Created by wuzhan on 2017/2/18.
 */
public class Game {
    private int currentFrame;
    private boolean isFirstThrow  = true;
    private Scorer itsScorer = new Scorer();


    public void add(int pins) {
        itsScorer.addThrow(pins);
        adjustCurrentFrame(pins);
    }

    public int getScore() {
        return itsScorer.scoreForFrame(getCurrentFrame());
    }

    public int scoreForFrame(int theFrame) {
        return itsScorer.scoreForFrame(theFrame);
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

}
