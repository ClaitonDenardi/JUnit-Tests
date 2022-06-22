/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbergeron.util;

import java.awt.Insets;
import java.util.Locale;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FrameAboutTest {
    
    private FrameAbout frameAbout;
    
    public FrameAboutTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() {
        frameAbout = new FrameAbout();
    }
    
    @After
    public void tearDown() { }

    /**
     * Test of getInsets method, of class FrameAbout.
     */
    @Test
    public void testGetInsets() {
        Insets insets = frameAbout.getInsets();
        // testa dimensoes minimas
        assertEquals(true, (insets.top > 10));
        assertEquals(true, (insets.bottom > 10)); 
        assertEquals(true, (insets.left > 10)); 
        assertEquals(true, (insets.right > 10)); 
    }

    /**
     * Test of setVisible method, of class FrameAbout.
     */
    @Test
    public void testSetVisible() {
        frameAbout.setVisible(false);
        assertEquals(false, frameAbout.isVisible());
        frameAbout.setVisible(true);
        assertTrue(frameAbout.isVisible());
    }

    /**
     * Test of setLocale method, of class FrameAbout.
     */
    @Test
    public void testSetLocale() {
       frameAbout.setLocale(Locale.CANADA);
       assertThat(Locale.CANADA, is(equalTo(frameAbout.getLocale())));
    }
    
}
