/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbergeron.solitaire;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class LegalGameStatesTest {
    
    private LegalGameStates legalGameStates;
    private GameState gameState;
    
    public LegalGameStatesTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() {
        legalGameStates = new LegalGameStates();
        Solitaire solitaire = new Solitaire(false);
        solitaire.newGame();
        gameState =  solitaire.gameStates.iterator().next();
    }
    
    @After
    public void tearDown() { }

    /**
     * Test of addGameStates method, of class LegalGameStates.
     */
    @Test
    public void testAddGameStates() {
        assertFalse( legalGameStates.getGameStates().size() > 0);
        Solitaire solitaire = new Solitaire(false);
        solitaire.newGame();
        GameState g =  solitaire.gameStates.iterator().next();
        legalGameStates.addGameStates(g);
        assertTrue( legalGameStates.getGameStates().size() > 0);
    }

    /**
     * Test of getGameStates method, of class LegalGameStates.
     */
    @Test
    public void testGetGameStates() {
        legalGameStates.addGameStates(gameState);
        assertEquals(gameState, legalGameStates.getGameStates().iterator().next());
    }

    /**
     * Test of setGameStates method, of class LegalGameStates.
     */
    @Test
    public void testSetGameStates() {
        ArrayList<GameState> gameStates = new ArrayList<>();
        gameStates.add(gameState);
        legalGameStates.setGameStates(gameStates);
        assertArrayEquals(gameStates.toArray(), legalGameStates.getGameStates().toArray());
    }

    /**
     * Test of getGsIdx method, of class LegalGameStates.
     */
    @Test
    public void testGetGsIdx() {
        assertEquals(0, legalGameStates.getGsIdx()); // valor default setado na classe
    }

    /**
     * Test of setGsIdx method, of class LegalGameStates.
     */
    @Test
    public void testSetGsIdx() {
        legalGameStates.setGsIdx(1);
        assertEquals(1, legalGameStates.gsIdx);
    }
    
}
