/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.matchers;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.socraticgrid.codeconversion.elements.CodeReference;
import org.socraticgrid.codeconversion.elements.CodeSearch;
import org.springframework.core.io.Resource;

/**
 *
 * @author Jerry Goodnough
 */
public class MapMatchTest extends TestCase
{
    
    public MapMatchTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        TestSuite suite = new TestSuite(MapMatchTest.class);
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
     * Test of setMapFileResource method, of class MapMatch.
     */
    public void testSetMapFileResource()
    {
        //TODO: Implement Sping pattern
        System.out.println("setMapFileResource");
        Resource res = null;
        MapMatch instance = new MapMatch();
        instance.setMapFileResource(res);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of initialize method, of class MapMatch.
     */
    public void testInitialize() throws Exception
    {
        //TODO: Implement Sping pattern
        System.out.println("initialize");
        MapMatch instance = new MapMatch();
        //instance.initialize();
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of match method, of class MapMatch.
     */
    public void testMatch()
    {
        System.out.println("match");
        CodeSearch matchCd = new CodeSearch("RxNorm","vuid","1","");
        List<CodeReference> finalOut = new LinkedList<CodeReference>();
        MapMatch instance = new MapMatch();

        boolean b = instance.match(matchCd, finalOut);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }


    /**
     * Test of load method, of class MapMatch.
     */
    public void testLoad() throws Exception
    {
        System.out.println("load");
        //TODO: IMplement based on Spring resources
        //InputStream is = null;
        //MapMatch instance = new MapMatch();
        //instance.load(is);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
}
