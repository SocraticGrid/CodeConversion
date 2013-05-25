/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.matchers;

import java.util.LinkedList;
import java.util.List;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.runner.RunWith;
import org.junit.Test;

import org.socraticgrid.codeconversion.elements.CodeReference;
import org.socraticgrid.codeconversion.elements.CodeSearch;
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
public class VUIDtoRXNormMatcherTest extends TestCase implements ApplicationContextAware
{

    public VUIDtoRXNormMatcherTest()
    {
    }

    public static junit.framework.Test suite()
    {
        TestSuite suite = new TestSuite(VUIDtoRXNormMatcherTest.class);
        return suite;
    }

    private ApplicationContext ctx;
    public void setApplicationContext(ApplicationContext context)
    {
        this.ctx=context;
    }

    /**
     * Test of setJenaServerURL method, of class VUIDtoRXNormMatcher.
     */
    @Test
    public void testSetJenaServerURL()
    {
        System.out.println("setJenaServerURL");
        String url = "";
        VUIDtoRXNormMatcher instance = new VUIDtoRXNormMatcher();
        instance.setJenaServerURL(url);

    }

    /**
     * Test of match method, of class VUIDtoRXNormMatcher. 4020400, 4021569,
     * 4010153 4004608, 4021565, 4019836 4021632, 4023979, 4014984 4021557,
     * 4019972, 4013990 4021582, 4017536, 4005766
     */
    @Test
    public void testMatch()
    {
        System.out.println("match");
        CodeSearch matchCd = new CodeSearch();
        matchCd.setCode("4005766");
        matchCd.setSystem("vuid");
        List<CodeReference> out = new LinkedList<CodeReference>();
        VUIDtoRXNormMatcher instance = (VUIDtoRXNormMatcher)ctx.getBean("VUIDRxNorm");
        instance.match(matchCd, out);
        assertTrue(out.size() > 0);
        CodeReference fnd = out.get(0);
        assertEquals(fnd.getCode(), "308416");

    }

    /**
     * Test of getRXNORM method, of class VUIDtoRXNormMatcher.
     */
    @Test
    public void testGetRXNORM() throws Exception
    {
        System.out.println("getRXNORM");
        String vuid = "4005766";
        VUIDtoRXNormMatcher instance = (VUIDtoRXNormMatcher)ctx.getBean("VUIDRxNorm");
        String expResult = "308416";
        String result = instance.getRXNORM(vuid);
        assertEquals(expResult, result);

    }
}
