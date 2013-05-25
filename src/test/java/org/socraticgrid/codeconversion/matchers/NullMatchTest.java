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
public class NullMatchTest extends TestCase
{
    
    public NullMatchTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        TestSuite suite = new TestSuite(NullMatchTest.class);
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
     * Test of match method, of class NullMatch.
     */
    public void testMatch()
    {
        System.out.println("match");
        CodeSearch matchCd = new CodeSearch("1","2","3","4");
        List<CodeReference> out = new LinkedList<CodeReference>();
        NullMatch instance = new NullMatch();
        instance.match(matchCd, out);
        // TODO review the generated test code and remove the default call to fail.
    }
}
