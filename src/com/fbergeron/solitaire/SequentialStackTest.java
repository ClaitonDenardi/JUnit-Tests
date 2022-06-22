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
import java.util.ArrayList;
import java.util.Collection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class SequentialStackTest {
    
    private SequentialStack sequentialStack;
    
    public SequentialStackTest() {}
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() {
        sequentialStack = new SequentialStack();
        sequentialStack.push(new ClassicCard(Value.V_1, Suit.HEART)); // carta vermelha
    }
    
    @After
    public void tearDown() { }

    /**
     * Test of isValid method, of class SequentialStack.
     * Teste: Tornar metodo buildCards da classe ClassicDeck publico -> erro
     */
    @Test
    public void testIsValid_ClassicCard() {
        // metodo usado para verificar se a carta a ser colocada na pilha de sequencia é valida
        // stack esta com a carta Value.V_1, Suit.HEART, logo a proxima deve ser  Value.V_2, Suit.HEART
        
        // cria todas as cartas
        Collection<ClassicCard> cards = new ArrayList<>();
         for(int suit = 0; suit < Suit.suits.length; suit++ ) {
            for ( int value = 0; value < Value.values.length; value++ ) {
                ClassicCard c = new ClassicCard( Value.values[ value ], Suit.suits[ suit ] );
                cards.add(c);
            }
        }
            
        for (ClassicCard card : cards) {
            if (card.getValue().equals(Value.V_2) && card.getSuit().equals(Suit.HEART))
                assertTrue(sequentialStack.isValid(card));
            else
                assertFalse(sequentialStack.isValid(card)); // todas demais cartas devem ser invalidas
        }
    }

    /**
     * Test of isValid method, of class SequentialStack.
     */
    @Test
    public void testIsValid_Stack() {
        // testa se pode arrastar a carta de cima da pilha, pode arrastar se for 
        // apenas uma e estiver no topo

        // cria todas as cartas
        Collection<ClassicCard> cards = new ArrayList<>();
        for (Suit suit : Suit.suits) {
            for (Value value : Value.values) {
                ClassicCard c = new ClassicCard(value, suit);
                cards.add(c);
            }
        }
            
        cards.forEach((card) -> {
            Stack s = new Stack();
            s.push(card);
            if (card.getValue().equals(Value.V_2) && card.getSuit().equals(Suit.HEART)) 
                assertTrue(sequentialStack.isValid(s));
            else
                assertFalse(sequentialStack.isValid(s));
        });
    }
    
}
