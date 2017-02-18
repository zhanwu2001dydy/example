package com.company;

import junit.framework.Assert;
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
    public void  testOneThrows(){
        g.add(5);
        assertEquals(5, g.getScore());
    }

    @Test
    public void  testTwoThrows(){
        g.add(5);
        g.add(4);
        assertEquals(9, g.getScore());
    }

    @Test
    public void testFourThrowsNoMark(){
        g.add(5);
        g.add(4);
        g.add(7);
        g.add(2);
        assertEquals(18,g.getScore());
        assertEquals(9,g.getscoreForFrame(1));
        assertEquals(18,g.getscoreForFrame(2));
    }
}
