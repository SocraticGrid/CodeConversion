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
public class CodeReferenceTest extends TestCase
{
    
    public CodeReferenceTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        TestSuite suite = new TestSuite(CodeReferenceTest.class);
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
     * Test of getSource method, of class CodeReference.
     */
    public void testGetSource()
    {
        System.out.println("getSource");
        CodeReference instance = new CodeReference("1","2","3");
        CodeSource expResult = null;
        CodeSource result = instance.getSource();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSource method, of class CodeReference.
     */
    public void testSetSource()
    {
        System.out.println("setSource");
        CodeSource source = new CodeSource();
        CodeReference instance = new CodeReference("1","2","3");
        instance.setSource(source);
    }
}
