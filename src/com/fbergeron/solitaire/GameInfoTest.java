/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbergeron.solitaire;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameInfoTest {
    
    private GameInfo info;
    private GameInfo infoIniciada;
    
    public GameInfoTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() {
        info = new GameInfo();
        infoIniciada = new GameInfo(GameInfo.WINNABLE_TRICKY, 0);
    }
    
    @After
    public void tearDown() { }

    /**
     * Test of getType method, of class GameInfo.
     */
    @Test
    public void testGetType() {
        assertEquals(GameInfo.RANDOM, info.getType()); // default String type = RANDOM;
        assertEquals(GameInfo.WINNABLE_TRICKY, infoIniciada.getType());
    }

    /**
     * Test of setType method, of class GameInfo.
     */
    @Test
    public void testSetType() {
        info.setType(GameInfo.WINNABLE_EASY);
        infoIniciada.setType(GameInfo.WINNABLE_HARD);
        assertSame(GameInfo.WINNABLE_EASY, info.getType());
        assertSame(GameInfo.WINNABLE_HARD, infoIniciada.getType());
    }

    /**
     * Test of getSeed method, of class GameInfo.
     */
    @Test
    public void testGetSeed() {
        assertEquals(-1, info.getSeed()); // default int seed = -1;
        assertNotNull( infoIniciada.getSeed() );
    }

    /**
     * Test of setSeed method, of class GameInfo.
     */
    @Test
    public void testSetSeed() {
        info.setSeed(1);
        infoIniciada.setSeed(2);
        assertThat(1, is(equalTo(info.getSeed())));
        assertThat(2, is(equalTo(infoIniciada.getSeed())));
    }

    /**
     * Test of equals method, of class GameInfo.
     */
    @Test
    public void testEquals() {
        info.setType(GameInfo.WINNABLE_NORMAL);
        info.setSeed(1);
        infoIniciada.setSeed(1);
        infoIniciada.setType(GameInfo.WINNABLE_NORMAL);
        assertTrue( info.equals(infoIniciada) );
        info.setSeed(2);
        assertFalse( infoIniciada.equals(info) );
    }

    /**
     * Test of hashCode method, of class GameInfo.
     */
    @Test
    public void testHashCode() {
        assertNotEquals(info.hashCode(), infoIniciada.hashCode());
    }

    /**
     * Test of toString method, of class GameInfo.
     */
    @Test
    public void testToString() {
        // default infoIniciada GameInfo.RANDOM | 0
        assertEquals("Random|-1", info.toString());
        assertEquals("Winnable-Tricky|0", infoIniciada.toString());
    }
    
}
