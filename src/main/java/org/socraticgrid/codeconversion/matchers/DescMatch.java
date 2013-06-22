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
import org.socraticgrid.codeconversion.exceptions.InitializationException;
import org.socraticgrid.codeconversion.matchers.xml.DescMatch.TargetSystem;
import org.socraticgrid.codeconversion.matchers.xml.DescMatch.TargetSystem.SourceCoding;

import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import javax.annotation.PostConstruct;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;


// TODO:  Fix code Description/code system issue
// Map Target System -> Description -> System -> Entry

/**
 * Implement Code Mapping based on a Mapped XML file. This mapper is optimized for 1
 * to 1 replacements using the target system and the code description
 *
 * <p>Map based matcher - Description Optimized- Does not support a single target
 * system with multiple mappings.</p>
 *
 * @author  Jerry Goodnough
 */
public class DescMatch extends BaseMatcher
{
    private Resource mapFileResource = null;

    /** The Internal Map Match. */
    private HashMap<String, TargetSystemCodeMap> tsMap =
        new HashMap<String, TargetSystemCodeMap>();

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
     * Load the XML Document.
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
            org.socraticgrid.codeconversion.matchers.xml.DescMatch xmlMap =
                (org.socraticgrid.codeconversion.matchers.xml.DescMatch)
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
                    HashMap<String, SourceCoding> map;

                    if (tsm.SrchMap.containsKey(sc.getSourceName()))
                    {
                        map = tsm.SrchMap.get(sc.getSourceName());
                    }
                    else
                    {
                        map = new HashMap<>();
                        tsm.SrchMap.put(sc.getSourceName(), map);
                    }

                    map.put(sc.getSourceSystem(), sc);
                }
            }
        }
        catch (JAXBException exp)
        {
            throw new InitializationException("MapMap, Error parsing code map", exp);
        }
    }

    @Override
    protected boolean match_TA_CA_DL(CodeSearch matchCd, List<CodeReference> outList)
    {
        Iterator<String> itr = tsMap.keySet().iterator();

        while (itr.hasNext())
        {

            TargetSystemCodeMap map = tsMap.get(itr.next());

            if (map != null)
            {

                if (map.SrchMap.containsKey(matchCd.getDisplay()))
                {

                    HashMap<String, SourceCoding> sysMap = map.SrchMap.get(
                            matchCd.getDisplay());

                    Iterator<String> sysItr = sysMap.keySet().iterator();

                    while (sysItr.hasNext())
                    {
                        SourceCoding sc = sysMap.get(sysItr.next());

                        outList.add(new CodeReference(matchCd.getTargetSystem(),
                                sc.getTargetCode(), sc.getSourceName(),
                                sc.getSourceNote()));

                    }
                }
            }
        }

        return true;
    }

    @Override
    protected boolean match_TA_CL_DL(CodeSearch matchCd, List<CodeReference> outList)
    {

        Iterator<String> itr = tsMap.keySet().iterator();

        while (itr.hasNext())
        {

            TargetSystemCodeMap map = tsMap.get(itr.next());

            if (map != null)
            {

                if (map.SrchMap.containsKey(matchCd.getDisplay()))
                {
                    HashMap<String, SourceCoding> sysMap = map.SrchMap.get(
                            matchCd.getDisplay());
                    SourceCoding sc = sysMap.get(matchCd.getSystem());

                    if (sc != null)
                    {

                        if (sc.getSourceCode().compareTo(matchCd.getCode()) == 0)
                        {
                            outList.add(new CodeReference(matchCd.getTargetSystem(),
                                    sc.getTargetCode(), sc.getSourceName(),
                                    sc.getSourceNote()));
                        }
                    }

                }
            }
        }

        return true;
    }

    @Override
    protected boolean match_TL_CA_DL(CodeSearch matchCd, List<CodeReference> outList)
    {
        TargetSystemCodeMap map = tsMap.get(matchCd.getTargetSystem());

        if (map != null)
        {

            if (map.SrchMap.containsKey(matchCd.getDisplay()))
            {
                HashMap<String, SourceCoding> sysMap = map.SrchMap.get(
                        matchCd.getDisplay());

                Iterator<String> sysItr = sysMap.keySet().iterator();

                while (sysItr.hasNext())
                {
                    SourceCoding sc = sysMap.get(sysItr.next());

                    outList.add(new CodeReference(matchCd.getTargetSystem(),
                            sc.getTargetCode(), sc.getSourceName(),
                            sc.getSourceNote()));
                }
            }
        }

        return true;
    }

    /**
     * Target System Code Map.
     */
    public class TargetSystemCodeMap
    {

        /** Map by name to code reference. */
        public HashMap<String, HashMap<String, SourceCoding>> SrchMap;

        public TargetSystemCodeMap()
        {
            this.SrchMap = new HashMap<>();
        }
    }
}
