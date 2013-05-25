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
public class SearchOptionsTest extends TestCase
{
    
    public SearchOptionsTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        TestSuite suite = new TestSuite(SearchOptionsTest.class);
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

    public void testSomeMethod()
    {
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
