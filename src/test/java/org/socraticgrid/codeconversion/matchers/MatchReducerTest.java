/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.matchers;

import java.util.LinkedList;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.socraticgrid.codeconversion.elements.CodeReference;
import org.socraticgrid.codeconversion.elements.CodeSearch;

/**
 *
 * @author Jerry Goodnough
 */
public class MatchReducerTest extends TestCase
{
    
    public MatchReducerTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        TestSuite suite = new TestSuite(MatchReducerTest.class);
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
     * Test of match method, of class MatchReducer.
     */
    public void testMatch()
    {
        System.out.println("match");
        CodeSearch matchCd = new CodeSearch("1","2","3","4");
        LinkedList<CodeReference> out = new LinkedList<CodeReference>();
        out.add(new CodeReference("1","2","3"));
        out.add(new CodeReference("4","5","6"));
        out.add(new CodeReference("7","8","9"));        
        MatchReducer instance = new MatchReducer();
        instance.match(matchCd, out);
        assertTrue(out.size()==1);
    }
}
