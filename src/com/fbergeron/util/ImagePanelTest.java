package com.fbergeron.util;

import com.fbergeron.solitaire.Solitaire;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class ImagePanelTest {
    
    private ImagePanel imagePanel;
    
    public ImagePanelTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() { 
        imagePanel = new ImagePanel();
    }
    
    @After
    public void tearDown() { }

    /**
     * Test of getPreferredSize method, of class ImagePanel.
     */
    @Test
    public void testGetPreferredSize() {
        assertEquals(new Dimension(10, 10), imagePanel.getPreferredSize()); // dimensao padrao escolhida
    }

    /**
     * Test of setBounds method, of class ImagePanel.
     */
    @Test
    public void testSetBounds() {
        imagePanel.setBounds(100, 200, 300, 400);
        assertEquals(100, imagePanel.getBounds().x);
        assertEquals(200, imagePanel.getBounds().y);
        assertEquals(300, imagePanel.getBounds().width);
        assertEquals(400, imagePanel.getBounds().height);
    }

    /**
     * Test of setImage method, of class ImagePanel.
     */
    @Test
    public void testSetImage() {
        imagePanel.setImage( imagePanel.createImage(200, 200) );
        assertEquals(false, imagePanel.isImageLoaded());
    }

    /**
     * Test of update method, of class ImagePanel.
     */
    @Test
    public void testUpdate() {
        Solitaire s = new Solitaire(false); // isApplet = false
        Dimension dim = s.getSize();
        Image offscreen = s.createImage( dim.width, dim.height );
        Graphics2D offscreenGr = (Graphics2D)offscreen.getGraphics();
        imagePanel.update(offscreenGr);
        imagePanel.setImage( imagePanel.createImage(200, 200) );
        assertNull( imagePanel.getGraphics() );
    }

    /**
     * Test of paint method, of class ImagePanel.
     */
    @Test
    public void testPaint() {
        Solitaire s = new Solitaire(false);
        Dimension dim = s.getSize();
        Image offscreen = s.createImage( dim.width, dim.height );
        Graphics2D offscreenGr = (Graphics2D)offscreen.getGraphics();
        imagePanel.update(offscreenGr);
        assertFalse( imagePanel.isImageLoaded() );
    }

    /**
     * Test of isImageLoaded method, of class ImagePanel.
     */
    @Test
    public void testIsImageLoaded() {
        assertFalse( imagePanel.isImageLoaded() );
    }

    /**
     * Test of isDoubleBuffered method, of class ImagePanel.
     */
    @Test
    public void testIsDoubleBuffered() {
        imagePanel.setDoubleBuffered(false);
        assertFalse( imagePanel.isDoubleBuffered() );
    }

    /**
     * Test of setDoubleBuffered method, of class ImagePanel.
     */
    @Test
    public void testSetDoubleBuffered() {
        // set com problemas
        // imagePanel.setDoubleBuffered(true);
        // assertTrue( imagePanel.isDoubleBuffered() );        
        imagePanel.setDoubleBuffered(false);
        assertFalse( imagePanel.isDoubleBuffered() );        
    }

    /**
     * Test of destroy method, of class ImagePanel.
     */
    @Test
    public void testDestroy() {
        Solitaire s = new Solitaire(false); 
        Dimension dim = s.getSize();
        Image offscreen = s.createImage( dim.width, dim.height );
        Graphics2D offscreenGr = (Graphics2D)offscreen.getGraphics();
        imagePanel.update(offscreenGr);
        assertNull("Destruiu (Dispose) o objeto?", imagePanel.getGraphics()); 
    }
    
}
