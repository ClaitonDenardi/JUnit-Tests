/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbergeron.card;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClassicDeckTest {
    
    private static ClassicDeck deck;
    
    public ClassicDeckTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() { 
        deck = new ClassicDeck();
    }
    
    @After
    public void tearDown() { }

    /**
     * Test of buildCards method, of class ClassicDeck.
     */
    @Test
    public void testBuildCards() {
        deck.buildCards();
        assertEquals("As 52 cartas foram geradas?", 52, deck.getCards().size());
    }
    
}
