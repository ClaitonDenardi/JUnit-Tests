/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbergeron.util;

import java.awt.Dimension;
import java.awt.Frame;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class DialogMsgTest {
    
    private DialogMsg dialogMsg;
    
    public DialogMsgTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() { 
        dialogMsg = new DialogMsg(new Frame(), "Titulo", false, "Mensagem");
    }
    
    @After
    public void tearDown() { }

    @Test
    public void testDialogMsg() {
        assertEquals("Titulo", dialogMsg.getTitle()); // setou o titulo do dialog
        assertEquals(new Dimension(240,110), dialogMsg.getSize()); // criou a janela
    }
    
}
