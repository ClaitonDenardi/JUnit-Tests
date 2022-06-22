/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fbergeron.util;

import java.awt.event.WindowEvent;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class WindowManagerTest {
        
    public WindowManagerTest() { }
    
    @BeforeClass
    public static void setUpClass() { }
    
    @AfterClass
    public static void tearDownClass() { }
    
    @Before
    public void setUp() { }    
    @After
    public void tearDown() { }

    /**
     * Test of windowClosing method, of class WindowManager.
     */
    @Test
    public void testWindowClosing() {
        FrameAbout frame = new FrameAbout();
        WindowManager w = new WindowManager(frame, WindowManager.DISPOSE_ON_CLOSE);
        WindowEvent event = new WindowEvent(frame, 0);
        frame.setVisible( true ); // true para teste posterior

        // esperado:  case HIDE_ON_CLOSE : window.setVisible( false );
        w.windowClosing( event );
        assertFalse("Realizou setVisible( false )", frame.isVisible() );

        // esperado:  case DISPOSE_ON_CLOSE : window.dispose(); 
        w = new WindowManager(frame, WindowManager.DISPOSE_ON_CLOSE);
        w.windowClosing( event );
        assertFalse("Realizou window.dispose()", frame.isActive() );  
        
        // esperado: case EXIT_ON_CLOSE : window.dispose(); System.exit( 0 ); 
        // deve sair da JVM
        /* w = new WindowManager(frame, WindowManager.EXIT_ON_CLOSE);
        w.windowClosing( event ); */     
    }
    
}
