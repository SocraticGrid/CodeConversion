/*-
 *
 * *************************************************************************************************************
 *  Copyright (C) 2013 by Cognitive Medical Systems, Inc
 *  (http://www.cognitivemedciine.com) * * Licensed under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except in compliance *
 *  with the License. You may obtain a copy of the License at * *
 *  http://www.apache.org/licenses/LICENSE-2.0 * * Unless required by applicable
 *  law or agreed to in writing, software distributed under the License is *
 *  distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied. * See the License for the specific language
 *  governing permissions and limitations under the License. *
 * *************************************************************************************************************
 *
 * *************************************************************************************************************
 *  Socratic Grid contains components to which third party terms apply. To comply
 *  with these terms, the following * notice is provided: * * TERMS AND
 *  CONDITIONS FOR USE, REPRODUCTION, AND DISTRIBUTION * Copyright (c) 2008,
 *  Nationwide Health Information Network (NHIN) Connect. All rights reserved. *
 *  Redistribution and use in source and binary forms, with or without
 *  modification, are permitted provided that * the following conditions are met:
 *  - Redistributions of source code must retain the above copyright notice, this
 *  list of conditions and the *     following disclaimer. * - Redistributions in
 *  binary form must reproduce the above copyright notice, this list of
 *  conditions and the *     following disclaimer in the documentation and/or
 *  other materials provided with the distribution. * - Neither the name of the
 *  NHIN Connect Project nor the names of its contributors may be used to endorse
 *  or *     promote products derived from this software without specific prior
 *  written permission. * * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS
 *  AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED * WARRANTIES, INCLUDING,
 *  BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 *  A * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER
 *  OR CONTRIBUTORS BE LIABLE FOR * ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, *
 *  PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 *  OR BUSINESS INTERRUPTION HOWEVER * CAUSED AND ON ANY THEORY OF LIABILITY,
 *  WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR
 *  OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, * EVEN IF
 *  ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. * * END OF TERMS AND CONDITIONS *
 * *************************************************************************************************************
 */
package org.socraticgrid.codeconversion.wrapper;

import org.socraticgrid.codeconversion.wrappers.CodeSystemTransformWrapper;
import java.util.HashMap;
import static junit.framework.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import org.junit.runner.RunWith;

import org.socraticgrid.codeconversion.elements.CodeReference;
import org.socraticgrid.codeconversion.elements.CodeSearch;
import org.socraticgrid.codeconversion.matchers.CodeMatcher;
import org.socraticgrid.codeconversion.matchers.MatchContract;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.ApplicationContext;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * DOCUMENT ME!
 *
 * @author  Jerry Goodnough
 */

@ContextConfiguration(locations = { "classpath:Test-CodeConversion.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class CodeSystemTransformWrapperTest
{
    @Autowired
    private ApplicationContext ctx;


    public CodeSystemTransformWrapperTest()
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
     * Test of getEmbeddedMatcher method, of class CodeSystemTransformWrapper.
     */
    @Test
    public void testGetEmbeddedMatcher()
    {
        System.out.println("getEmbeddedMatcher");

        CodeSystemTransformWrapper instance = (CodeSystemTransformWrapper) ctx.getBean(
                "SystemTransformer");

        CodeMatcher result = instance.getEmbeddedMatcher();
        assertNotNull(result);

    }

    /**
     * Test of getInBoundSystemMappings method, of class CodeSystemTransformWrapper.
     */
    @Test
    public void testGetInBoundSystemMappings()
    {
        System.out.println("getInBoundSystemMappings");

        CodeSystemTransformWrapper instance = (CodeSystemTransformWrapper) ctx.getBean(
                "SystemTransformer");

        Map result = instance.getInBoundSystemMappings();
        assertNotNull(result);

        assertTrue(result.size() > 0);
    }

    /**
     * Test of getMatchContract method, of class CodeSystemTransformWrapper.
     */
    @Test
    public void testGetMatchContract()
    {
        System.out.println("getMatchContract");

        CodeSystemTransformWrapper instance = (CodeSystemTransformWrapper) ctx.getBean(
                "SystemTransformer");

        MatchContract result = instance.getMatchContract();
        assertNotNull(result);

        assertTrue(result.supportsTargetSystem("2.16.840.1.113883.6.88"));
    }

    /**
     * Test of getOutBoundSystemMappings method, of class CodeSystemTransformWrapper.
     */
    @Test
    public void testGetOutBoundSystemMappings()
    {
        System.out.println("getOutBoundSystemMappings");

        CodeSystemTransformWrapper instance = (CodeSystemTransformWrapper) ctx.getBean(
                "SystemTransformer");

        Map result = instance.getOutBoundSystemMappings();
        assertNotNull(result);

    }

    /**
     * Test of isConvertExistingMatches method, of class CodeSystemTransformWrapper.
     */
    @Test
    public void testIsConvertExistingMatches()
    {
        System.out.println("isConvertExistingMatches");

        CodeSystemTransformWrapper instance = (CodeSystemTransformWrapper) ctx.getBean(
                "SystemTransformer");
        boolean expResult = false;
        boolean result = instance.isConvertExistingMatches();
        assertEquals(expResult, result);

    }

    /**
     * Test of match method, of class CodeSystemTransformWrapper.
     */
    @Test
    public void testMatch()
    {
        System.out.println("match");


        List<CodeReference> out = new LinkedList<>();

        CodeSystemTransformWrapper instance = (CodeSystemTransformWrapper) ctx.getBean(
                "SystemTransformer");
        CodeSearch matchCd = new CodeSearch();
        matchCd.setCode("4005766");
        matchCd.setSystem("VAId");
        matchCd.setTargetSystem("2.16.840.1.113883.6.88");

        boolean expResult = false;


        boolean b = instance.match(matchCd, out);

        assertTrue(out.size() > 0);

        CodeReference fnd = out.get(0);
        assertEquals(fnd.getCode(), "308416");
        assertEquals(fnd.getSystem(), "2.16.840.1.113883.6.88");

    }

    /**
     * Test of setConvertExistingMatches method, of class CodeSystemTransformWrapper.
     */
    @DirtiesContext
    @Test
    public void testSetConvertExistingMatches()
    {
        System.out.println("setConvertExistingMatches");

        boolean convertExistingMatches = false;
        CodeSystemTransformWrapper instance = (CodeSystemTransformWrapper) ctx.getBean(
                "SystemTransformer");
        instance.setConvertExistingMatches(convertExistingMatches);


    }

    /**
     * Test of setEmbeddedMatcher method, of class CodeSystemTransformWrapper.
     */
    @DirtiesContext
    @Test
    public void testSetEmbeddedMatcher()
    {
        System.out.println("setEmbeddedMatcher");

        CodeMatcher embeddedMatcher = (CodeMatcher)ctx.getBean(
                "VUIDRxNorm");
        CodeSystemTransformWrapper instance = (CodeSystemTransformWrapper) ctx.getBean(
                "SystemTransformer");
        instance.setEmbeddedMatcher(embeddedMatcher);

 
    }

    /**
     * Test of setInBoundSystemMappings method, of class CodeSystemTransformWrapper.
     */
    @DirtiesContext
    @Test
    public void testSetInBoundSystemMappings()
    {
        System.out.println("setInBoundSystemMappings");

        Map<String, String> inBoundSystemMappings = new HashMap<String, String>();
        inBoundSystemMappings.put("test","Test");
        
        CodeSystemTransformWrapper instance = (CodeSystemTransformWrapper) ctx.getBean(
                "SystemTransformer");
        instance.setInBoundSystemMappings(inBoundSystemMappings);

    }

    /**
     * Test of setOutBoundSystemMappings method, of class CodeSystemTransformWrapper.
     */
    @DirtiesContext
    @Test
    public void testSetOutBoundSystemMappings()
    {
        System.out.println("setOutBoundSystemMappings");

        Map<String, String> outBoundSystemMappings = new HashMap<String, String>();
        outBoundSystemMappings.put("Test", "test");
        
        CodeSystemTransformWrapper instance = (CodeSystemTransformWrapper) ctx.getBean(
                "SystemTransformer");
        instance.setOutBoundSystemMappings(outBoundSystemMappings);

     
    }
}
