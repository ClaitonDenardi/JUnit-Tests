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

public class FrameCongratulationsTest {
    
    private FrameCongratulations frame;
    
    public FrameCongratulationsTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() {
        Solitaire s = new Solitaire(false);
        s.setLocale(Locale.ENGLISH);
        frame = new FrameCongratulations();
    }
    
    @After
    public void tearDown() { }

    /**
     * Test of setVisible method, of class FrameCongratulations.
     */
    @Test
    public void testSetVisible() {
        frame.setVisible(false);
        assertFalse( frame.isVisible() );
        frame.setVisible(true);
        assertTrue( frame.isVisible() );
    }

    /**
     * Test of addNotify method, of class FrameCongratulations.
     */
    @Test
    public void testAddNotify() {
        frame.fComponentsAdjusted = false;
        frame.addNotify();
        assertTrue( frame.fComponentsAdjusted );
    }
    
}
