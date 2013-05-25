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
public class SearchMappingTest extends TestCase
{

    public SearchMappingTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        TestSuite suite = new TestSuite(SearchMappingTest.class);
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
     * Test of equals method, of class SearchMapping.
     */
    public void testEquals()
    {
        System.out.println("equals");
        SearchMapping obj = new SearchMapping(new CodeSearch("1", "2", "3", "4"));
        SearchMapping instance = new SearchMapping("1", "2");
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class SearchMapping.
     */
    public void testHashCode()
    {
        System.out.println("hashCode");
        SearchMapping instance = new SearchMapping("1", "2");
        int result = instance.hashCode();
        assertTrue(result > 0);
    }

    /**
     * Test of toString method, of class SearchMapping.
     */
    public void testToString()
    {
        System.out.println("toString");
        SearchMapping instance = new SearchMapping("1", "2");
        String result = instance.toString();
    }

    /**
     * Test of getSystem method, of class SearchMapping.
     */
    public void testGetSystem()
    {
        System.out.println("getSystem");
        SearchMapping instance = new SearchMapping("1", "2");
        String expResult = "1";
        String result = instance.getSystem();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSystem method, of class SearchMapping.
     */
    public void testSetSystem()
    {
        System.out.println("setSystem");
        String system = "3";
        SearchMapping instance = new SearchMapping("1", "2");
        instance.setSystem(system);
    }

    /**
     * Test of getCode method, of class SearchMapping.
     */
    public void testGetCode()
    {
        System.out.println("getCode");
        SearchMapping instance = new SearchMapping("1", "2");
        String expResult = "2";
        String result = instance.getCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCode method, of class SearchMapping.
     */
    public void testSetCode()
    {
        System.out.println("setCode");
        String code = "4";
        SearchMapping instance = new SearchMapping("1", "2");
        instance.setCode(code);
    }
}
