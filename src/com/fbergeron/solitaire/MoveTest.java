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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class MoveTest {
    
    Move move;
    
    public MoveTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() { 
        move = new Move();
    }
    
    @After
    public void tearDown() { }

    @Test
    public void testSomeMethod() {
        Stack stack = new Stack();
        stack.push(new ClassicCard(Value.V_1, Suit.CLUB));
        move.curr = stack;
        move.dst = stack;
        move.src = stack;
        assertNotNull( move.curr );
        assertNotNull( move.dst );
        assertNotNull( move.src );
        assertEquals(move.curr, move.dst);
        assertEquals(move.dst, move.src);              
    }
    
}
