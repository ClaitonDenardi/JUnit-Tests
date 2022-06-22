/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbergeron.card;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNot;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeckTest {
    
    private ClassicDeck deck;
    
    public DeckTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() { 
        deck = new ClassicDeck();
    }
    
    @After
    public void tearDown() { }

    /**
     * Test of shuffle method, of class Deck.
     */
    @Test
    public void testShuffle() {
        deck.push(new ClassicCard(Value.V_1, Suit.CLUB));
        deck.push(new ClassicCard(Value.V_2, Suit.DIAMOND));
        deck.push(new ClassicCard(Value.V_3, Suit.HEART));
        deck.push(new ClassicCard(Value.V_4, Suit.SPADE));
        Object naoEmbaralhado = deck.getCards().toArray();
        deck.shuffle(5); // param: seed
        assertThat(naoEmbaralhado, IsNot.not(IsEqual.equalTo(deck.getCards().toArray())));
    }
    
}
