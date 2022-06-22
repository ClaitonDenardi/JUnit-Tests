/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbergeron.card;

import com.fbergeron.solitaire.Solitaire;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import static org.hamcrest.CoreMatchers.equalTo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ClassicCardTest {
    
    private static ClassicCard card;
    
    public ClassicCardTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() {
        Value v = Value.V_ACE;
        Suit s = Suit.HEART;
        card = new ClassicCard(v, s); // carta base para os testes
    }
    
    @After
    public void tearDown() { }

    /**
     * Test of isLegal method, of class ClassicCard.
     */
    @Test
    public void testIsLegal() {
        assertFalse("Por default a carta criada deve ser ilegal", card.isLegal());
    }

    /**
     * Test of setLegal method, of class ClassicCard.
     */
    @Test
    public void testSetLegal() {
        Boolean statusAntigo = card.isLegal(); // guarda status antigo
        card.setLegal( !statusAntigo ); // redefine atributo 'legal'
        assertNotEquals(statusAntigo, card.isLegal()); // o status antigo não pode ter permanecido igual
    }

    /**
     * Test of getColor method, of class ClassicCard.
     */
    @Test
    public void testGetColor() {
        // Set up -> Suit.HEART (Copas = vermelho)
        Color corEsperada = Color.RED;
        Color corRetornada = card.getColor();
        assertEquals(corEsperada.getRGB(), corRetornada.getRGB());
    }

    /**
     * Test of getValue method, of class ClassicCard.
     */
    @Test
    public void testGetValue() {
        // Set up Value.V_ACE;
        Value v = Value.V_ACE;
        assertSame(v, card.getValue()); // devem se referir ao mesmo objeto
    }

    /**
     * Test of getSuit method, of class ClassicCard.
     */
    @Test
    public void testGetSuit() {
        // Set up Suit.HEART;
        Suit s = Suit.HEART;
        assertSame(s, card.getSuit()); // devem se referir ao mesmo objeto
    }

    /**
     * Test of equals method, of class ClassicCard.
     */
    @Test
    public void testEquals() {
        Value v = Value.V_ACE;
        Suit s = Suit.HEART;
        Card comparadora = new ClassicCard(v, s);
        assertEquals("As cartas devem possuir as mesmas propriedades", comparadora, card);
    }

    /**
     * Test of toString method, of class ClassicCard.
     */
    @Test
    public void testToString() {
        Card comparadora = new ClassicCard(Value.V_ACE, Suit.HEART); // carta com as mesmas propriedades
        char[] charArray = comparadora.toString().toCharArray();
        assertArrayEquals("Os arrays devem ser exatamente iguais", charArray, card.toString().toCharArray()); 
        
        /* Esse método recebe dois argumentos: o resultado do teste que queremos inspecionar
        para ver se está correto e um Matcher. Um Matcher do Hamcrest nada mais é do que uma 
        classe cuja função é verificar se um dado objeto tem as propriedades desejadas. 
        Objetivo: deixar testes mais legiveis e mensagens de erro (em caso de falha) mais compreensiveis 
        e rastreaveis */
        assertThat(charArray, equalTo(card.toString().toCharArray())); 
    }

    /**
     * Test of paint method, of class ClassicCard.
     */
    @Test
    public void testPaint() {
        Solitaire s = new Solitaire(false); // isApplet = false
        Dimension dim = s.getSize();
        Image offscreen = s.createImage( dim.width, dim.height );
        Graphics2D offscreenGr = (Graphics2D)offscreen.getGraphics();
        card.setLocation(500, 600);
        card.paint(offscreenGr, true);
        assertEquals(Color.BLACK, offscreenGr.getColor()); // se passar o frame base foi desenhado
    }
    
}
