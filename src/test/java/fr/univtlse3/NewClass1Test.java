/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.univtlse3;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 21408147
 */
public class NewClass1Test {
    
    public NewClass1Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTest method, of class NewClass1.
     */
    @Test
    public void testGetTest() {
        //System.out.println("getTest");
        NewClass1 instance = new NewClass1();
        int expResult = 1;
        int result = instance.getTest();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setTest method, of class NewClass1.
     */
    @Test
    public void testSetTest() {
        //System.out.println("setTest");
        int test = 0;
        NewClass1 instance = new NewClass1();
        instance.setTest(test);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}