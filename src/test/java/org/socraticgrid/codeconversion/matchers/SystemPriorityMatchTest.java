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
public class SystemPriorityMatchTest extends TestCase
{
    
    public SystemPriorityMatchTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        TestSuite suite = new TestSuite(SystemPriorityMatchTest.class);
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
     * Test of match method, of class SystemPriorityMatch.
     */
    public void testMatch()
    {
        System.out.println("match");
        CodeSearch matchCd = new CodeSearch("1","2","3","4");
        List<CodeReference> out = new LinkedList<CodeReference>();
        SystemPriorityMatch instance = new SystemPriorityMatch();

        boolean b = instance.match(matchCd, out);

        // TODO review the generated test code and remove the default call to fail.
       // fail("The test case is a prototype.");
    }
}
