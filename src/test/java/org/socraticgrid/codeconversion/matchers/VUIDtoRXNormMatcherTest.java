/*
 * To change this template, choose Tools | Templates and open the template in the
 * editor.
 */
package org.socraticgrid.codeconversion.matchers;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.AfterClass;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import org.junit.runner.RunWith;


import org.socraticgrid.codeconversion.elements.CodeReference;
import org.socraticgrid.codeconversion.elements.CodeSearch;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;
import org.junit.Ignore;


/**
 * @author  Jerry Goodnough
 */

@ContextConfiguration(locations = { "classpath:Test-CodeConversion.xml" })
@RunWith(SpringJUnit4ClassRunner.class)

public class VUIDtoRXNormMatcherTest extends TestCase
{
    @Autowired
    private ApplicationContext ctx;


    public VUIDtoRXNormMatcherTest()
    {
    
    }
   @BeforeClass
    public static void setUpClass()
    {
    }

    @AfterClass
    public static void tearDownClass()
    {
    }

    @Before
    public void setUp()
    {
    }

    @After
    public void tearDown()
    {
    }

    /**
     * Test of getRXNORM method, of class VUIDtoRXNormMatcher.
     */
    @Test
    public void testGetRXNORM() throws Exception
    {
        System.out.println("getRXNORM");

        String vuid = "4005766";
        VUIDtoRXNormMatcher instance = (VUIDtoRXNormMatcher) ctx.getBean(
                "VUIDRxNorm");
        String expResult = "308416";
        String result = instance.getRXNORM(vuid);
        assertEquals(expResult, result);

    }

    /**
     * Test of match method, of class VUIDtoRXNormMatcher. 4020400, 4021569, 4010153
     * 4004608, 4021565, 4019836 4021632, 4023979, 4014984 4021557, 4019972, 4013990
     * 4021582, 4017536, 4005766
     */
    @Test
    public void testMatch()
    {
        System.out.println("match");

        CodeSearch matchCd = new CodeSearch();
        matchCd.setCode("4005766");
        matchCd.setSystem("vuid");

        List<CodeReference> out = new LinkedList<CodeReference>();

        VUIDtoRXNormMatcher instance = (VUIDtoRXNormMatcher) ctx.getBean(
                "VUIDRxNorm");

        boolean b = instance.match(matchCd, out);

        assertTrue(out.size() > 0);

        CodeReference fnd = out.get(0);
        assertEquals(fnd.getCode(), "308416");

    }

    /**
     * Test of setJenaServerURL method, of class VUIDtoRXNormMatcher.
     */
    @DirtiesContext
    @Test
    public void testSetJenaServerURL()
    {
        System.out.println("\nsetJenaServerURL");

        String url = "";
        VUIDtoRXNormMatcher instance = (VUIDtoRXNormMatcher) ctx.getBean(
                "VUIDRxNorm");
        instance.setJenaServerURL(url);

    }
}
