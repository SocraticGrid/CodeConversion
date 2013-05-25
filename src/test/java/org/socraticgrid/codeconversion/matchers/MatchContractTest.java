/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.matchers;

import junit.framework.Test;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertTrue;
import junit.framework.TestSuite;

/**
 *
 * @author Jerry Goodnough
 */
public class MatchContractTest extends TestCase
{
    
    public MatchContractTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        TestSuite suite = new TestSuite(MatchContractTest.class);
        return suite;
    }
    
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception
    {
        super.tearDown();
    }

    /**
     * Test of isMatchAny method, of class MatchContract.
     */
    public void testIsMatchAny()
    {
        System.out.println("isMatchAny");
        MatchContract instance = new MatchContract();
        boolean expResult = false;
        boolean result = instance.isMatchAny();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFilter method, of class MatchContract.
     */
    public void testIsFilter()
    {
        System.out.println("isFilter");
        MatchContract instance = new MatchContract();
        boolean expResult = false;
        boolean result = instance.isFilter();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFilter method, of class MatchContract.
     */
    public void testSetFilter()
    {
        System.out.println("setFilter");
        boolean filter = true;
        MatchContract instance = new MatchContract();
        instance.setFilter(filter);
    }

    /**
     * Test of setMatchAny method, of class MatchContract.
     */
    public void testSetMatchAny()
    {
        System.out.println("setMatchAny");
        boolean matchAny = true;
        MatchContract instance = new MatchContract();
        assertFalse(instance.supportsTargetSystem("TestSystem"));
        instance.setMatchAny(matchAny);
        assertTrue(instance.supportsTargetSystem("TestSystem"));
 
    }

    /**
     * Test of addMatchContract method, of class MatchContract.
     */
    public void testAddMatchContract()
    {
        System.out.println("addMatchContract");
        MatchContract other = new MatchContract();
        other.addTargetSystem("George");
        MatchContract instance = new MatchContract();
        instance.addTargetSystem("Frank");
        instance.addMatchContract(other);
        assertTrue(instance.supportsTargetSystem("George"));
        assertTrue(instance.supportsTargetSystem("Frank"));
    }

    /**
     * Test of supportsTargetSystem method, of class MatchContract.
     */
    public void testSupportsTargetSystem()
    {
        System.out.println("supportsTargetSystem");
        String system = "RxNorm";
        MatchContract instance = new MatchContract();
        boolean expResult = false;
        boolean result = instance.supportsTargetSystem(system);
        assertEquals(expResult, result);
        instance.addTargetSystem(system);
        result=instance.supportsTargetSystem(system);
        assertTrue(result);
    }

    /**
     * Test of addTargetSystem method, of class MatchContract.
     */
    public void testAddTargetSystem()
    {
        System.out.println("addTargetSystem");
        String system = "RxNorm";
        MatchContract instance = new MatchContract();
        instance.addTargetSystem(system);
        assertTrue(instance.supportsTargetSystem(system));
    }
}
