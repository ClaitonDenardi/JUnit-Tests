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

public class SuitTest {
    
    private static Suit suit;
    
    public SuitTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() { 
        suit = Suit.DIAMOND;
    }
    
    @After
    public void tearDown() { }

    /**
     * Test of toString method, of class Suit.
     */
    @Test
    public void testToString() {
        // Set up suit = DIAMOND
        assertEquals("D", suit.toString());
        suit = Suit.CLUB;
        assertEquals("C", suit.toString());
        suit = Suit.HEART;
        assertEquals("H", suit.toString());
        suit = Suit.SPADE;
        assertEquals("S", suit.toString());
    }
    
}
