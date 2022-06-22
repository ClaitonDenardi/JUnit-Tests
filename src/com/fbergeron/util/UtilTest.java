/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbergeron.util;

import java.awt.Image;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class UtilTest {
        
    public UtilTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() { }
    
    @After
    public void tearDown() { }

    /**
     * Test of getImageResourceFile method, of class Util.
     */
    @Test
    public void testGetImageResourceFile() {
        // nao testa null
        // assertNull( Util.getImageResourceFile("", null) );
        FrameAbout frame = new FrameAbout();
        Image image = Util.getImageResourceFile( "logo.jpg", frame.getClass() );
        assertNotNull( image );
    }

    /**
     * Test of loadImages method, of class Util.
     */
    @Test
    public void testLoadImages() {
        FrameAbout frame = new FrameAbout();
        Image image = Util.getImageResourceFile( "logo.jpg", frame.getClass() );
        assertEquals("sun.awt.image.ToolkitImage", image.getClass().getName()); // carregada
    }

    /**
     * Test of copy method, of class Util.
     * @throws java.lang.Exception
     */
    @Test
    public void testCopy() throws Exception {
        String strResourceFilename = "logo.jpg";
        Class srcClass = new FrameAbout().getClass();     
        BufferedInputStream in = new BufferedInputStream(srcClass.getResourceAsStream( strResourceFilename ));
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        assertEquals(0, out.size()); // size inicial = 0
        Util.copy(in, out); 
        assertEquals(28875, out.size()); // 28875 size da imagem copiada (logo.jpg)
    }
    
}
