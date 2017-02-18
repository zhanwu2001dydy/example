package com.company;

import junit.framework.Assert;
import org.junit.Test;

public class GameTest {

    @Test
    public void  testOneThrows(){
        Game g = new Game();
        g.add(5);
        Assert.assertEquals(5, g.getScore());
    }
}
