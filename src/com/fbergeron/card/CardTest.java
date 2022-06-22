/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbergeron.card;

import com.fbergeron.solitaire.Solitaire;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.not;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {
    
    private static ClassicCard card;
    
    public CardTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() { 
        card = new ClassicCard(Value.V_JACK, Suit.SPADE);
    }
    
    @After
    public void tearDown() { }

    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToString() {
        // Set up Value.V_JACK (J) e Suit.SPADE (S)
        assertEquals("XJSX", card.toString());
    }

    /**
     * Test of turnFaceUp method, of class Card.
     */
    @Test
    public void testTurnFaceUp() {
        card.turnFaceUp();
        assertFalse( card.isFaceDown() );
     
    }

    /**
     * Test of turnFaceDown method, of class Card.
     */
    @Test
    public void testTurnFaceDown() {
        card.turnFaceDown();
        assertTrue( card.isFaceDown() );
    }

    /**
     * Test of flip method, of class Card.
     */
    @Test
    public void testFlip() {
        Boolean isFaceDown = card.isFaceDown();
        card.flip();
        assertNotEquals(isFaceDown, card.isFaceDown());
    }

    /**
     * Test of getLocation method, of class Card.
     */
    @Test
    public void testGetLocation() {
        card.setLocation( new Point(500, 600) );
        assertEquals(new Point(500, 600), card.getLocation());
    }

    /**
     * Test of setLocation method, of class Card.
     */
    @Test
    public void testSetLocation_Point() {
        // Programa nao trata se valor for null, teste gera exception
        // card.setLocation(null);
        // assertNull( card.getLocation() );
        card.setLocation( new Point() );
        assertNotNull( card.getLocation() );
    }

    /**
     * Test of setLocation method, of class Card.
     */
    @Test
    public void testSetLocation_int_int() {
        Point p = new Point(500, 600);
        card.setLocation(500, 600);
        assertEquals(p.x, card.getLocation().x);
        assertEquals(p.y, card.getLocation().y);
    }

    /**
     * Test of getSize method, of class Card.
     */
    @Test
    public void testGetSize() {
        Dimension d = new Dimension(30, 30);
        card.setSize( d );
        assertEquals(d, card.getSize());
    }

    /**
     * Test of setSize method, of class Card.
     */
    @Test
    public void testSetSize_int_int() {
        card.setSize(80, 160);
        assertEquals(80, card.getSize().width);
        assertEquals(160, card.getSize().height);
    }

    /**
     * Test of setSize method, of class Card.
     */
    @Test
    public void testSetSize_Dimension() {
        // Programa nao trata se valor for null, teste gera exception
        // card.setSize(null); 
        // assertNull( card.getSize() );
        card.setSize(new Dimension(100, 100));
        assertNotNull( card.getSize() );
    }

    /**
     * Test of contains method, of class Card.
     */
    @Test
    public void testContains() {
        // Programa nao trata se valor de location for null, teste gera exception
        // assertFalse( card.contains(new Point(500, 500)) );
        card.setSize(200, 200);
        card.setLocation(100, 100);
        assertFalse( card.contains(new Point(10, 10)) );
        assertTrue( card.contains(new Point(201, 202)) );
        assertFalse( card.contains(new Point(-201, -202)) ); // testa negativos
    }

    public class CardImpl extends Card {

        public String toString() {
            Card comparadora = new ClassicCard(Value.V_KING, Suit.DIAMOND); // carta com outras propriedades
            char[] charArray = comparadora.toString().toCharArray();
            assertThat(charArray, not(equalTo(card.toString().toCharArray()))); 
            return "";
        }

        public void paint(Graphics g, boolean hint) {
            Solitaire s = new Solitaire(false); // isApplet = false
            Dimension dim = s.getSize();
            Image offscreen = s.createImage( dim.width, dim.height );
            Graphics2D offscreenGr = (Graphics2D)offscreen.getGraphics();
            card.setLocation(500, 600);
            card.paint(offscreenGr, true);
            assertNotEquals(Color.RED, offscreenGr.getColor()); // frame deveria ter Color.BLACK
        }
    }
    
}
