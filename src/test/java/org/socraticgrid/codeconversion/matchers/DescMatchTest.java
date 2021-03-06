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
package org.socraticgrid.codeconversion.matchers;

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

import org.springframework.core.io.Resource;

import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.InputStream;

import java.util.LinkedList;
import java.util.List;
import org.socraticgrid.codeconversion.elements.SearchOptions;


/**
 * DOCUMENT ME!
 *
 * @author  Jerry Goodnough
 */

@ContextConfiguration(locations = { "classpath:Test-CodeConversion.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class DescMatchTest
{
    @Autowired
    private ApplicationContext ctx;

    public DescMatchTest()
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
     * Test of Match method, of class DescMatch.
     */
    @Test
    public void testMatch() throws Exception
    {
        System.out.println("Match");

    
        CodeSearch matchCd = new CodeSearch();
        matchCd.setSearchType(SearchOptions.LITERAL_TargetSystem+SearchOptions.ANY_Code+SearchOptions.LITERAL_Display);
        matchCd.setDisplay("Hypertension");
        matchCd.setTargetSystem("snomed");
        matchCd.setSystem("ICD9");
        List<CodeReference> outList = new LinkedList<>();
        DescMatch instance = (DescMatch) ctx.getBean("DescMatch");
       

        boolean expResult = true;
        boolean result = instance.match_TL_CA_DL(matchCd, outList);
        assertEquals(expResult, result);
        assertTrue(outList.size()>0);
    }

    /**
     * Test of match_TA_CA_DL method, of class DescMatch.
     */
    @Test
    public void testMatch_TA_CA_DL()
    {
        System.out.println("match_TA_CA_DL");

        CodeSearch matchCd = new CodeSearch();
        matchCd.setSearchType(SearchOptions.ANY_TargetSystem+SearchOptions.ANY_Code+SearchOptions.LITERAL_Display);
        matchCd.setDisplay("Hypertension");
        matchCd.setTargetSystem("snomed");
        matchCd.setSystem("ICD9");
        List<CodeReference> outList = new LinkedList<>();
        DescMatch instance = (DescMatch) ctx.getBean("DescMatch");
       

        boolean expResult = true;
        boolean result = instance.match_TL_CA_DL(matchCd, outList);
        assertEquals(expResult, result);
        assertTrue(outList.size()>0);
    }

    /**
     * Test of match_TA_CL_DL method, of class DescMatch.
     */
    @Test
    public void testMatch_TA_CL_DL()
    {
        System.out.println("match_TA_CL_DL");

        CodeSearch matchCd = new CodeSearch();
        matchCd.setSearchType(SearchOptions.ANY_TargetSystem+SearchOptions.LITERAL_Code+SearchOptions.LITERAL_Display);
        matchCd.setDisplay("Hypertension");
        matchCd.setTargetSystem("snomed");
        matchCd.setSystem("ICD9");
        matchCd.setCode("401.9");
        List<CodeReference> outList = new LinkedList<>();
        DescMatch instance = (DescMatch) ctx.getBean("DescMatch");
       

        boolean expResult = true;
        boolean result = instance.match_TL_CA_DL(matchCd, outList);
        assertEquals(expResult, result);
        assertTrue(outList.size()>0);
    }

    /**
     * Test of match_TL_CA_DL method, of class DescMatch.
     */
    @Test
    public void testMatch_TL_CA_DL()
    {
        System.out.println("match_TL_CA_DL");

        CodeSearch matchCd = new CodeSearch();
        matchCd.setSearchType(SearchOptions.LITERAL_TargetSystem+SearchOptions.ANY_Code+SearchOptions.LITERAL_Display);
        matchCd.setDisplay("Hypertension");
        matchCd.setTargetSystem("snomed");
        matchCd.setSystem("ICD9");
        List<CodeReference> outList = new LinkedList<>();
        DescMatch instance = (DescMatch) ctx.getBean("DescMatch");
       

        boolean expResult = true;
        boolean result = instance.match_TL_CA_DL(matchCd, outList);
        assertEquals(expResult, result);
        assertTrue(outList.size()>0);
    }

  
}
