/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbergeron.solitaire;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class InvokerTest {
    
    private Invoker invoker;
    
    public InvokerTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() {
        invoker = new Invoker();
    }
    
    @After
    public void tearDown() { }

    /**
     * Test of init method, of class Invoker.
     */
    @Test
    public void testInit() {
        // nao é usado por nenhuma classe (ver Call Hierarchy)
        Solitaire solitaire = null;
        invoker.init();
        // gera exception
        // assertTrue( solitaire.isActive() );
        // assertEquals(Locale.ENGLISH, solitaire.getLocale());
    }
    
}
