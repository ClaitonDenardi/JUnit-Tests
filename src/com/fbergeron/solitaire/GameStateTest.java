/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbergeron.solitaire;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class GameStateTest {
       
    private GameState gameState;
        
    public GameStateTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() { 
        Solitaire solitaire = new Solitaire(false);
        solitaire.newGame();
        gameState = solitaire.gameStates.iterator().next();
    }
    
    @After
    public void tearDown() { }

    /**
     * Test of isGameWon method, of class GameState.
     */
    @Test
    public void testIsGameWon() {
        Solitaire solitaire = new Solitaire(false);
        solitaire.newGame();
        GameState state = solitaire.gameStates.iterator().next();
        assertFalse( state.isGameWon() );
    }

    /**
     * Test of equals method, of class GameState.
     */
    @Test
    public void testEquals() {
        Solitaire solitaire = new Solitaire(false);
        solitaire.newGame();
        GameState state = solitaire.gameStates.iterator().next();
        assertNotEquals(gameState.gameInfo, state.gameInfo); // cada game tem random
    }

    /**
     * Test of legalMoves method, of class GameState.
     */
    @Test
    public void testLegalMoves() {
        Solitaire solitaire = new Solitaire(false);
        solitaire.newGame();
        GameState state = solitaire.gameStates.iterator().next();
        assertEquals(gameState.legalMoves(true), state.legalMoves(false)); // ambos devem ser null
    }
    
  
    /**
     * Test of toString method, of class GameState.
     */
    @Test
    public void testToString() {
        assertNotNull( gameState.toString() );
    }
    
}
