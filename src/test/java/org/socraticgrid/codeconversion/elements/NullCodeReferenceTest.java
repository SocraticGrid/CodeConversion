/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.elements;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Jerry Goodnough
 */
public class NullCodeReferenceTest extends TestCase
{
    
    public NullCodeReferenceTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        TestSuite suite = new TestSuite(NullCodeReferenceTest.class);
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
     * Test of getNullCode method, of class NullCodeReference.
     */
    public void testGetNullCode()
    {
        System.out.println("getNullCode");
        NullCodeReference expResult = null;
        NullCodeReference result = NullCodeReference.getNullCode();
    }

    /**
     * Test of equals method, of class NullCodeReference.
     */
    public void testEquals()
    {
        System.out.println("equals");
        NullCodeReference obj = new NullCodeReference("1","2","4");
        NullCodeReference instance = NullCodeReference.getNullCode();
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }
}
