package com.company;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.*;

public class GameTest {
    Game g ;
    @Before
    public void setUp() throws Exception {
        g = new Game();

    }

    @Test
    public void  testTwoThrows(){
        g.add(5);
        g.add(4);
        assertEquals(1,g.getCurrentFrame());
        assertEquals(9, g.getScore());

    }

    @Test
    public void testFourThrowsNoMark(){
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);
        assertEquals(2,g.getCurrentFrame());
        assertEquals(18,g.getScore());
        assertEquals(9,g.getScoreForFrame(1));
        assertEquals(18,g.getScoreForFrame(2));
    }

    @Test
    public void testSimpleSpare() throws Exception {
        g.add(2);
        g.add(8);
        g.add(3);
        assertEquals(1,g.getCurrentFrame());
        assertEquals(13,g.getScoreForFrame(1));
    }

    @Test
    public void testSimpleFrameAfterSpare() throws Exception {
        g.add(2);
        g.add(8);
        g.add(3);
        g.add(2);
        assertEquals(2,g.getCurrentFrame());
        assertEquals(13,g.getScoreForFrame(1));
        assertEquals(18,g.getScoreForFrame(2));
        assertEquals(18,g.getScore());
    }

    @Test
    public void strike() throws Exception {
        g.add(10);
        g.add(3);
        g.add(6);
        assertEquals(19,g.getScoreForFrame(1));
        assertEquals(28, g.getScore());
        assertEquals(3,g.getCurrentFrame());

    }


    public void testPerfectGame() throws Exception {
        for (int i = 0; i < 12; i++) {
            g.add(10);
        }
        assertEquals(300,g.getScore());
        assertEquals(10, g.getCurrentFrame());

    }
}
