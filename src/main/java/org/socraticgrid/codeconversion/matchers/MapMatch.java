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

import org.socraticgrid.codeconversion.elements.CodeReference;
import org.socraticgrid.codeconversion.elements.CodeSearch;
import org.socraticgrid.codeconversion.elements.SearchMapping;
import org.socraticgrid.codeconversion.elements.SearchOptions;
import org.socraticgrid.codeconversion.exceptions.InitializationException;
import org.socraticgrid.codeconversion.matchers.xml.MapMatch.TargetSystem;
import org.socraticgrid.codeconversion.matchers.xml.MapMatch.TargetSystem.SourceCoding;

import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


/**
 * Implement Code Mapping based on a Mapped XML file. This mapper is optimized for 1
 * to 1 target/code replacements Map based matcher - Code Optimized - Does not
 * support a single target system with multiple mappings.
 *
 * @author  Jerry Goodnough
 */
public class MapMatch extends BaseMatcher
{
    private Resource mapFileResource = null;

    /** The Internal Map Match. */
    private HashMap<String, TargetSystemCodeMap> tsMap =
        new HashMap<String, TargetSystemCodeMap>();

    /**
     * Uses a the mactdCh to search for a match in an internal code map load from a
     * specific resource.
     *
     * <p>This implementation acts a switch to specific protected implementation
     * bases of the exact criteria of the code search.</p>
     *
     * <p>Currently unsupported search type will cause this method to throw a
     * UnsupportedOperationException.</p>
     *
     * @param   matchCd           The Code to match - No modification is made be this
     *                            matcher to this object.
     * @param   matchingCodeList  The List of code that are matched so far. The
     *                            caller is required to provide this list and this
     *                            match may added results to it.d
     *
     * @return  always returns true to allow match processing to continue.
     */
    public boolean match(CodeSearch matchCd, List<CodeReference> matchingCodeList)
    {
        return this.vectorMatch(matchCd, matchingCodeList);

    }


    /**
     * The Spring resource that holds the Match Map XML file.
     *
     * @param  res
     */
    public void setMapFileResource(Resource res)
    {
        this.mapFileResource = res;
    }

    /**
     * Initialization the loaded the Match Mach.
     *
     * @throws  IOException
     * @throws  InitializationException
     */
    @PostConstruct
    protected void initialize() throws IOException, InitializationException
    {

        InputStream is = this.mapFileResource.getInputStream();

        if (is != null)
        {

            this.load(is);

        }

    }


    /**
     * Initialize the map from the inputstream.
     *
     * @param   is
     *
     * @throws  InitializationException
     */

    protected void load(InputStream is) throws InitializationException
    {

        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(
                    org.socraticgrid.codeconversion.matchers.xml.ObjectFactory.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            org.socraticgrid.codeconversion.matchers.xml.MapMatch xmlMap =
                (org.socraticgrid.codeconversion.matchers.xml.MapMatch)
                jaxbUnmarshaller.unmarshal(is);

            Iterator<TargetSystem> itr = xmlMap.getTargetSystem().iterator();

            while (itr.hasNext())
            {
                TargetSystem ts = itr.next();

                // Update
                contract.addTargetSystem(ts.getTargetSystemCode());

                TargetSystemCodeMap tsm = new TargetSystemCodeMap();
                tsMap.put(ts.getTargetSystemCode(), tsm);

                ListIterator<SourceCoding> sItr = ts.getSourceCoding()
                    .listIterator();

                while (sItr.hasNext())
                {
                    SourceCoding sc = sItr.next();

                    CodeReference cd = new CodeReference(ts.getTargetSystemCode(),
                            sc.getTargetCode(), sc.getTargetName());
                    SearchMapping sm = new SearchMapping(sc.getSystem(),
                            sc.getCode());
                    tsm.SrchMap.put(sm, cd);
                }
            }
        }
        catch (JAXBException exp)
        {
            throw new InitializationException("MapMap, Error parsing code map", exp);
        }
    }


    /**
     * Target Any, Code Literal, Display Any.
     *
     * <p>Search all mappings for the requested code.</p>
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */
    @Override
    protected boolean match_TA_CL_DA(CodeSearch matchCd, List<CodeReference> outList)
    {
        TargetSystemCodeMap scMap = tsMap.get(matchCd.getTargetSystem());
        Iterator<Entry<String, TargetSystemCodeMap>> itr = tsMap.entrySet()
            .iterator();

        while (itr.hasNext())
        {
            Entry<String, TargetSystemCodeMap> ent = itr.next();


            scMap = ent.getValue();

            SearchMapping fnd = new SearchMapping(matchCd);

            if (scMap.SrchMap.containsKey(fnd))
            {
                outList.add(scMap.SrchMap.get(fnd));
            }
        }

        return true;
    }


    /**
     * Copy all codes mapped for a target system.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */
    @Override
    protected boolean match_TL_CA_DA(CodeSearch matchCd, List<CodeReference> outList)
    {


        TargetSystemCodeMap scMap = tsMap.get(matchCd.getTargetSystem());

        if (scMap != null)
        {

            Iterator<Entry<SearchMapping, CodeReference>> itr = scMap.SrchMap
                .entrySet().iterator();

            while (itr.hasNext())
            {
                Entry<SearchMapping, CodeReference> ent = itr.next();
                outList.add(ent.getValue());
            }


        }

        return true;
    }

    /**
     * Target Literal, Code Literal, Display Any Search.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */

    @Override
    protected boolean match_TL_CL_DA(CodeSearch matchCd, List<CodeReference> outList )
    {
      

        TargetSystemCodeMap scMap = tsMap.get(matchCd.getTargetSystem());

        if (scMap != null)
        {
            SearchMapping fnd = new SearchMapping(matchCd);

            if (scMap.SrchMap.containsKey(fnd))
            {
                outList.add(scMap.SrchMap.get(fnd));
            }
        }

        return true;
    }


    /**
     * Target Literal, Class Literal, Display Literal.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  List of Matches
     */


    @Override
    protected boolean match_TL_CL_DL(CodeSearch matchCd, List<CodeReference> outList)
    {


        TargetSystemCodeMap scMap = tsMap.get(matchCd.getTargetSystem());

        if (scMap != null)
        {
            SearchMapping fnd = new SearchMapping(matchCd);

            if (scMap.SrchMap.containsKey(fnd))
            {

                if (scMap.SrchMap.get(fnd).getDisplay().compareTo(
                            matchCd.getDisplay()) == 0)
                {
                    outList.add(scMap.SrchMap.get(fnd));
                }
            }
        }

        return true;
    }

    /**
     * Nested Target System Code Map.
     */
    public class TargetSystemCodeMap
    {

        /** DOCUMENT ME! */
        public HashMap<SearchMapping, CodeReference> SrchMap =
            new HashMap<SearchMapping, CodeReference>();
    }
}
