/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion;

import java.util.List;
import org.junit.Test;
import junit.framework.TestCase;
import static junit.framework.TestCase.assertEquals;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.socraticgrid.codeconversion.elements.CodeReference;
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
public class SearchProcessorTest extends TestCase implements ApplicationContextAware
{
    private ApplicationContext ctx;
    public void setApplicationContext(ApplicationContext context)
    {
        this.ctx = context;
    }

    public SearchProcessorTest()
    {
        
    }

    public static junit.framework.Test suite()
    {
        TestSuite suite = new TestSuite(SearchProcessorTest.class);
        return suite;
    }
    



    /**
     * Test of translateCode method, of class SearchProcessor.
     */
    public void testTranslateCode()
    {
        System.out.println("translateCode");
        String sourceSystem = "vuid";
        String sourceCode = "4005766";
        String sourceText = "";
          
        SearchProcessor instance = (SearchProcessor) ctx.getBean("SearchProcessor");
        
        CodeReference result = instance.translateCode(sourceSystem, sourceCode, sourceText);
     
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCode method, of class SearchProcessor.
     */
    @Test
    public void testFindCode()
    {
        System.out.println("findCode");
        String targetSystem = "RxNorm";
        String sourceSystem = "vuid";
        String sourceCode = "4005766";
        String sourceText = "";
   
        SearchProcessor instance = (SearchProcessor) ctx.getBean("SearchProcessor");
        
        CodeReference result = instance.findCode(targetSystem, sourceSystem, sourceCode, sourceText);
        assertNotNull(result);
        assertEquals(result.getSystem(),"RxNorm");
        assertEquals(result.getCode(),"308416");

    }

    /**
     * Test of findCodeByText method, of class SearchProcessor.
     */
    public void testFindCodeByText()
    {
        System.out.println("findCodeByText");
        String targetSystem = "";
        String sourceText = "";
        SearchProcessor instance = null;
        CodeReference expResult = null;
        CodeReference result = instance.findCodeByText(targetSystem, sourceText);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCodes method, of class SearchProcessor.
     */
    public void testFindCodes()
    {
        System.out.println("findCodes");
        String targetSystem = "";
        String sourceSystem = "";
        String sourceCode = "";
        SearchProcessor instance = null;
        List expResult = null;
        List result = instance.findCodes(targetSystem, sourceSystem, sourceCode);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findCodesByText method, of class SearchProcessor.
     */
    public void testFindCodesByText()
    {
        System.out.println("findCodesByText");
        String targetSystem = "";
        String sourceText = "";
        SearchProcessor instance = null;
        List expResult = null;
        List result = instance.findCodesByText(targetSystem, sourceText);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
