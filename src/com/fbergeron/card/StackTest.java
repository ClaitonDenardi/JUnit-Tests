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
import java.util.Vector;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class StackTest {
    
    private static Stack stack;
    
    public StackTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() {
        stack = new Stack();
    }
    
    @After
    public void tearDown() { }

    /**
     * Test of isEmpty method, of class Stack.
     */
    @Test
    public void testIsEmpty() {
        assertTrue( stack.isEmpty() );
        stack.push(new ClassicCard(Value.V_1, Suit.CLUB));
        assertFalse( stack.isEmpty() );
    }

    /**
     * Test of getCards method, of class Stack.
     */
    @Test
    public void testGetCards() {
        ClassicCard card = new ClassicCard(Value.V_1, Suit.CLUB);
        stack.push( card );
        // Hamcrest -> mais legeivel (card is equal to...)
        assertThat(card, is(equalTo(stack.getCards().firstElement())));
    }

    /**
     * Test of firstFaceUp method, of class Stack.
     */
    @Test
    public void testFirstFaceUp() { // retorna indice da primeira carta faceUp ou -1 se nao houver
        ClassicCard card = new ClassicCard(Value.V_1, Suit.CLUB);
        stack.push( card );
        ClassicCard firstCard = (ClassicCard) stack.getCards().firstElement();
        firstCard.turnFaceDown();
        assertThat(-1, is(equalTo(stack.firstFaceUp())));
        firstCard.turnFaceUp();
        assertThat(0, is(equalTo(stack.firstFaceUp())));
    }

    /**
     * Test of top method, of class Stack.
     */
    @Test
    public void testTop() {
        assertNull( stack.top() ); // esta vazia
        stack.push( new ClassicCard(Value.V_1, Suit.CLUB) );
        assertNotNull( stack.top() );
    }

    /**
     * Test of elementAt method, of class Stack.
     */
    @Test
    public void testElementAt() {
        // nao trata posicao invalida
        // assertNull( stack.elementAt(10) ); 
        ClassicCard card = new ClassicCard(Value.V_1, Suit.CLUB);
        stack.push( card );
        assertThat(card, is(equalTo(stack.elementAt(0))));
    }

    /**
     * Test of push method, of class Stack.
     */
    @Test
    public void testPush_Card() {
        stack.push( new ClassicCard(Value.V_1, Suit.CLUB) );
        ClassicCard card = (ClassicCard) stack.top();
        assertNotNull( card.getLocation() ); // deveria ter gerado uma locacalizacao
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop_0args() {
        stack.pop(); 
        stack.push( new ClassicCard(Value.V_1, Suit.CLUB) );
        stack.pop();
        assertTrue( stack.isEmpty() );
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop_int() {
        Stack a = stack.pop(5); // numero de cartas a serem desempilhadas
        assertTrue(a.isEmpty());
        stack.push( new ClassicCard(Value.V_1, Suit.CLUB) );
        Stack b = stack.pop(1);
        assertFalse(b.isEmpty()); 
    }

    /**
     * Test of pop method, of class Stack.
     */
    @Test
    public void testPop_Card() {
        ClassicCard card = new ClassicCard(Value.V_1, Suit.CLUB);
        stack.push( card );
        assertNotNull( stack.pop( card ) );
    }

    /**
     * Test of cardCount method, of class Stack.
     */
    @Test
    public void testCardCount() {
        assertEquals(0, stack.cardCount());
        stack.push( new ClassicCard(Value.V_1, Suit.CLUB) );
        assertEquals(1, stack.cardCount());
    }

    /**
     * Test of contains method, of class Stack.
     */
    @Test
    public void testContains_Card() {
        ClassicCard card = new ClassicCard(Value.V_1, Suit.CLUB);
        assertFalse( stack.contains(card) );
        stack.push(card);
        assertTrue( stack.contains(card) );
    }

    /**
     * Test of contains method, of class Stack.
     */
    @Test
    public void testContains_Point() {
        assertTrue(stack.contains(new Point(50, 50)));
        stack.setLocation(500, 600);
        assertFalse(stack.contains(new Point(50, 50)));
    }

    /**
     * Test of isValid method, of class Stack.
     */
    @Test
    public void testIsValid_Card() {
        ClassicCard card = new ClassicCard(Value.V_1, Suit.CLUB);
        assertEquals(true, stack.isValid(card));
    }

    /**
     * Test of isValid method, of class Stack.
     */
    @Test
    public void testIsValid_Stack() {
        assertEquals(true, stack.isValid(stack));
    }

    /**
     * Test of getSpreadingDirection method, of class Stack.
     */
    @Test
    public void testGetSpreadingDirection() {
        assertEquals("Variável inicializada previamente", 0, stack.getSpreadingDirection());
    }

    /**
     * Test of setSpreadingDirection method, of class Stack.
     */
    @Test
    public void testSetSpreadingDirection() {
        stack.setSpreadingDirection(1);
        assertEquals(1, stack.getSpreadingDirection());
    }

    /**
     * Test of getSpreadingDelta method, of class Stack.
     */
    @Test
    public void testGetSpreadingDelta() {
        assertEquals("Variável inicializada previamente", 0, stack.getSpreadingDelta());
    }

    /**
     * Test of setSpreadingDelta method, of class Stack.
     */
    @Test
    public void testSetSpreadingDelta() {
        stack.setSpreadingDelta(1);
        assertEquals(1, stack.getSpreadingDelta());
    }

    /**
     * Test of paint method, of class Stack.
     */
    @Test
    public void testPaint() {
        Solitaire s = new Solitaire(false); // isApplet = false
        Dimension dim = s.getSize();
        Image offscreen = s.createImage( dim.width, dim.height );
        Graphics2D offscreenGr = (Graphics2D)offscreen.getGraphics();
        stack.paint(offscreenGr, true); // como a pilha esta vazia cor deve ser black
        stack.setLocation(500, 500); // null
        assertEquals(Color.BLACK,offscreenGr.getColor());
    }

    /**
     * Test of getClickedCard method, of class Stack.
     */
    @Test
    public void testGetClickedCard() {
        assertNull( stack.getClickedCard(null) );
        assertNull( stack.getClickedCard(new Point(500, 500)) );
    }

    /**
     * Test of reverse method, of class Stack.
     */
    @Test
    public void testReverse() {
        Stack stackB = new Stack();
        stackB.push(new ClassicCard(Value.V_1, Suit.CLUB));
        stackB.push(new ClassicCard(Value.V_12, Suit.DIAMOND));
        
        stack.push(new ClassicCard(Value.V_12, Suit.DIAMOND));
        stack.push(new ClassicCard(Value.V_1, Suit.CLUB));
        stack.reverse();
        
        assertArrayEquals(stackB.getCards().toArray(), stack.getCards().toArray());
    }

    /**
     * Test of setLocation method, of class Stack.
     */
    @Test
    public void testSetLocation() {
        Point p = new Point(500, 600);
        stack.setLocation(500, 600);
        assertEquals(p.x, stack.getLocation().x);
        assertEquals(p.y, stack.getLocation().y);
    }

    /**
     * Test of getLocation method, of class Stack.
     */
    @Test
    public void testGetLocation() {
        stack.setLocation(500, 600);
        assertEquals(new Point(500, 600), stack.getLocation());
    }

    /**
     * Test of toString method, of class Stack.
     */
    @Test
    public void testToString() {
        String s = stack.toString();
        stack.push(new ClassicCard(Value.V_1, Suit.CLUB));
        assertThat(s, not(equalTo(stack.toString())));
    }
    
}
