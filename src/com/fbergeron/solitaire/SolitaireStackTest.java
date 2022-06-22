/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbergeron.solitaire;

import com.fbergeron.card.ClassicCard;
import com.fbergeron.card.Suit;
import com.fbergeron.card.Value;
import java.util.ArrayList;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SolitaireStackTest {
    
    private SolitaireStack solitaireStack;
    
    public SolitaireStackTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() { 
        solitaireStack = new SolitaireStack();
        solitaireStack.push(new ClassicCard(Value.V_3, Suit.DIAMOND));
    }
    
    @After
    public void tearDown() { }

    /**
     * Test of isValid method, of class SolitaireStack.
     */
    @Test
    public void testIsValid_ClassicCard() {
        // é permitido se cor da carta a ser colocada for diferente da carta do topo 
        // e valor da carta a ser colocada for = valor carta do topo - 1
        // default solitaireStack Value.V_3, Suit.DIAMOND, 
        // logo so deve ser permitido: V_2, SPADE e V_2, CLUB
       
        Collection<ClassicCard> cards = new ArrayList<>(); // todas as cartas
        for (Suit suit : Suit.suits) {
            for (Value value : Value.values) {
                ClassicCard c = new ClassicCard(value, suit);
                cards.add(c);
            }
        }
            
         cards.forEach((card) -> {
             if ( card.getValue().equals(Value.V_2) && card.getSuit().equals(Suit.SPADE) ||
                  card.getValue().equals(Value.V_2) && card.getSuit().equals(Suit.CLUB)  )
                 assertTrue(solitaireStack.isValid(card));
             else
                 assertFalse(solitaireStack.isValid(card)); // todas demais cartas devem ser invalidas
        });
    }

    /**
     * Test of isValid method, of class SolitaireStack.
     */
    @Test
    public void testIsValid_Stack() {
        // pode mover se a pilha estiver no topo
        Collection<ClassicCard> cards = new ArrayList<>(); // todas as cartas
        for (Suit suit : Suit.suits) {
            for (Value value : Value.values) {
                ClassicCard c = new ClassicCard(value, suit);
                cards.add(c);
            }
        }
            
         cards.forEach((card) -> {
             if ( card.getValue().equals(Value.V_2) && card.getSuit().equals(Suit.SPADE) ||
                  card.getValue().equals(Value.V_2) && card.getSuit().equals(Suit.CLUB)  )
                 assertTrue(solitaireStack.isValid(card));
             else
                 assertFalse(solitaireStack.isValid(card)); // todas demais cartas devem ser invalidas
        });
    }   
    
}
