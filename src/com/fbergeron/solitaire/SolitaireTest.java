/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbergeron.solitaire;

import com.fbergeron.card.ClassicCard;
import com.fbergeron.card.Stack;
import com.fbergeron.card.Suit;
import com.fbergeron.card.Value;
import java.util.Locale;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SolitaireTest {
    
    private Solitaire solitaire;
    
    public SolitaireTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() {
        solitaire = new Solitaire(false);  // isApplet
    }
    
    @After
    public void tearDown() { }

    /**
     * Test of setVisible method, of class Solitaire.
     */
    @Test
    public void testSetVisible() {
        solitaire.setVisible(false);
        assertFalse( solitaire.isVisible() );
        solitaire.setVisible(true);
        assertTrue( solitaire.isVisible() );
    }

    /**
     * Test of setLocale method, of class Solitaire.
     */
    @Test
    public void testSetLocale() {
        solitaire.setLocale(Locale.ITALY);
        assertEquals(Locale.ITALY, solitaire.getLocale());
    }

    /**
     * Test of setGameType method, of class Solitaire.
     */
    @Test
    public void testSetGameType() {
        solitaire.setGameType(GameInfo.RANDOM);
        assertNotNull(solitaire.gameInfo);
    }

    /**
     * Test of main method, of class Solitaire.
     */
    @Test
    public void testMain() {
        // nao trata null, gera exception: locale may be fr (for french) or en (for english)
        // solitaire.main(null); 
        String args[] = { Locale.CHINESE.toString() };
        solitaire.main(args); 
        // Como o jogo so aceita FR ou EN, a locale nao pode ter ficado como CHINESE
        // o default é US
        assertEquals(Locale.US, solitaire.getLocale());
    }

    /**
     * Test of newGame method, of class Solitaire.
     */
    @Test
    public void testNewGame() {
        solitaire.setGameType(GameInfo.WINNABLE_EASY);
        solitaire.newGame();
        // verifica se novo game foi criado
        assertNotNull(solitaire.gameInfo.getSeed()); 
        assertNotNull(solitaire.deck);
        assertNotNull(solitaire.revealedCards);
        assertNotNull(solitaire.currStack);
        assertNotNull(solitaire.table);
    }

    /**
     * Test of getNewCards method, of class Solitaire.
     */
    @Test
    public void testGetNewCards() {
        solitaire.getNewCards();
        assertNotNull("Novo deck foi criado?", solitaire.deck );
    }

    /**
     * Test of play method, of class Solitaire.
     */
    @Test
    public void testPlay() {
        String args[] = { Locale.CHINESE.toString() };
        solitaire.main(args); 
        solitaire.newGame();
        Stack stack = new Stack();
        stack.push(new ClassicCard(Value.V_ACE, Suit.HEART));
        stack.top().turnFaceDown();;
        // abre o jogo
        solitaire.play(new Stack(), stack, new Stack());
        assertFalse(stack.top().isFaceDown()); // carta deve ter virado para cima
    }
    
}
