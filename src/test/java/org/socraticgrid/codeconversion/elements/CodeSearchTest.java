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
public class CodeSearchTest extends TestCase
{
    
    public CodeSearchTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        TestSuite suite = new TestSuite(CodeSearchTest.class);
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
     * Test of getTargetSystem method, of class CodeSearch.
     */
    public void testGetTargetSystem()
    {
        System.out.println("getTargetSystem");
        CodeSearch instance = new CodeSearch();
        String expResult = "";
        String result = instance.getTargetSystem();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTargetSystem method, of class CodeSearch.
     */
    public void testSetTargetSystem()
    {
        System.out.println("setTargetSystem");
        String targetSystem = "RxNorm";
        CodeSearch instance = new CodeSearch();
        instance.setTargetSystem(targetSystem);
    }

    /**
     * Test of getSearchType method, of class CodeSearch.
     */
    public void testGetSearchType()
    {
        System.out.println("getSearchType");
        CodeSearch instance = new CodeSearch();
        int expResult = 35;
        int result = instance.getSearchType();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSearchType method, of class CodeSearch.
     */
    public void testSetSearchType()
    {
        System.out.println("setSearchType");
        int searchType = SearchOptions.LITERAL_Code|SearchOptions.LITERAL_TargetSystem|SearchOptions.ANY_Display;
        CodeSearch instance = new CodeSearch();
        instance.setSearchType(searchType);
    }
}
