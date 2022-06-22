/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbergeron.solitaire;

import java.util.Locale;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FrameRulesTest {
    
    private FrameRules frame;
    
    public FrameRulesTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() {
        frame = new FrameRules();
    }
    
    @After
    public void tearDown() { }

    /**
     * Test of setLocale method, of class FrameRules.
     */
    @Test
    public void testSetLocale() {
        frame.setLocale(Locale.FRENCH);
        assertEquals("Règles", frame.getTitle());
        frame.setLocale(Locale.ENGLISH);
        assertEquals("Rules", frame.getTitle());
    }
    
}
