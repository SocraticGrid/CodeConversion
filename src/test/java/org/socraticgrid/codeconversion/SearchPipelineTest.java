/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion;

import java.util.LinkedList;
import java.util.List;
import org.junit.Test;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.socraticgrid.codeconversion.elements.CodeReference;
import org.socraticgrid.codeconversion.elements.CodeSearch;
import org.socraticgrid.codeconversion.matchers.CodeMatcher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author Jerry Goodnough
 */
@RunWith(SpringJUnit4ClassRunner.class)
// ApplicationContext will be loaded from "/applicationContext.xml" and "/applicationContext-test.xml"
// in the root of the classpath
@ContextConfiguration(locations =
{
    "classpath:Test-CodeConversion.xml"
})
public class SearchPipelineTest extends TestCase implements ApplicationContextAware
{

    

    
    

    public SearchPipelineTest()
    {
        super();
    }
    private ApplicationContext ctx;

    public void setApplicationContext(ApplicationContext context)
    {
        this.ctx = context;
    }

    public static junit.framework.Test suite()
    {
        TestSuite suite = new TestSuite(SearchPipelineTest.class);
        return suite;
    }

    /**
     * Test of getName method, of class SearchPipeline.
     */
    @Test
    public void testGetName()
    {
        System.out.println("getName");
        SearchPipeline instance = (SearchPipeline) ctx.getBean("ExamplePipeline");

        String expResult = "Example";
        String result = instance.getName();
        assertEquals(expResult, result);

    }

    /**
     * Test of setName method, of class SearchPipeline.
     */
    @Test
    public void testSetName()
    {
        System.out.println("setName");
        String name = "AName";
        SearchPipeline instance = new SearchPipeline();
        instance.setName(name);

    }

    /**
     * Test of getMatchChain method, of class SearchPipeline.
     */
    @Test
    public void testGetMatchChain()
    {
        System.out.println("getMatchChain");
        SearchPipeline instance = (SearchPipeline) ctx.getBean("ExamplePipeline");

        List result = instance.getMatchChain();
        assertTrue(result.size() > 0);

    }

    /**
     * Test of setMatchChain method, of class SearchPipeline.
     */
    @Test
    public void testSetMatchChain()
    {
        System.out.println("setMatchChain");
        List<CodeMatcher> matchChain = null;
        SearchPipeline instance = new SearchPipeline();
        instance.setMatchChain(matchChain);

    }

    /**
     * Test of SupportsTarget method, of class SearchPipeline.
     */
    @Test
    public void testSupportsTarget_String()
    {
        System.out.println("SupportsTarget");
        String targetSystem = "RxNorm";
        SearchPipeline instance = (SearchPipeline) ctx.getBean("ExamplePipeline");
        boolean expResult = true;
        boolean result = instance.SupportsTarget(targetSystem);
        assertEquals("Invalid Target String support, should support " + targetSystem, expResult, result);
        targetSystem = "InvalidSystem";
        expResult = false;
        result = instance.SupportsTarget(targetSystem);
        assertEquals("Invalid Target String support, should not support " + targetSystem, expResult, result);
    }

    /**
     * Test of SupportsTarget method, of class SearchPipeline.
     */
    @Test
    public void testSupportsTarget_CodeSearch()
    {
        System.out.println("SupportsTarget");
        CodeSearch cs = new CodeSearch();
        cs.setTargetSystem("RxNorm");
        SearchPipeline instance = (SearchPipeline) ctx.getBean("ExamplePipeline");
        boolean expResult = true;
        boolean result = instance.SupportsTarget(cs);
        assertEquals("Invalid Target CodeSearch support, should support RxNorm", expResult, result);
        cs.setTargetSystem("InvalidSystem");
        expResult = false;
        result = instance.SupportsTarget(cs);
        assertEquals("Invalid Target CodeSearch support, should not support Invalud", expResult, result);
    }

    /**
     * Test of match method, of class SearchPipeline.
     */
    @Test
    public void testMatch()
    {
        System.out.println("match");
        CodeSearch matchCd = new CodeSearch();
        matchCd.setTargetSystem("RxNorm");
        matchCd.setSystem("VUID");
        matchCd.setCode("4005766");
        LinkedList<CodeReference> out = new LinkedList<CodeReference>();
        SearchPipeline instance = (SearchPipeline) ctx.getBean("ExamplePipeline");
  
        List result = instance.match(matchCd, out);
        assertTrue( result.size()>0);
        
        //308416
       
    }

    /**
     * Test of initialize method, of class SearchPipeline.
     */
    @Test
    public void testInitialize()
    {
        System.out.println("initialize");
        SearchPipeline instance = (SearchPipeline) ctx.getBean("ExamplePipeline");
        assertTrue(instance.isReady());
    }

   
}
