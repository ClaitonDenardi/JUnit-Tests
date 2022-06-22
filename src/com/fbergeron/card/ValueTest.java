/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbergeron.card;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValueTest {
    
    
    public ValueTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() { }

    /**
     * Test of getValue method, of class Value.
     */
    @Test
    public void testGetValue() {
        // testa todos valores
        for ( int i = 0; i < Value.values.length; i++ ) {
            Value v = Value.values[ i ];
            assertEquals(i+1, v.getValue());
        }
    }

    /**
     * Test of toString method, of class Value.
     */
    @Test
    public void testToString() {
        Value value = Value.V_ACE;
        assertEquals("A", value.toString());
        value = Value.V_JACK;
        assertEquals("J", value.toString());
        value = Value.V_QUEEN;
        assertEquals("Q", value.toString());
        value = Value.V_KING;
        assertEquals("K", value.toString());
        // testa os numericos
        for ( int i = 2; i < 10; i++ ) {
            Value v = Value.values[ i-1 ];
            assertEquals(i, v.getValue());
        }
    }
    
}
