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
package org.socraticgrid.codeconversion.wrappers;

import org.socraticgrid.codeconversion.elements.CodeReference;
import org.socraticgrid.codeconversion.elements.CodeSearch;
import org.socraticgrid.codeconversion.matchers.CodeMatcher;
import org.socraticgrid.codeconversion.matchers.MatchContract;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


/**
 * This class wraps a code matcher with the ability to transforms code system names
 * bi-directionally.
 *
 * @author  Jerry Goodnough
 */
public class CodeSystemTransformWrapper implements CodeMatcher
{
    private MatchContract contract;

    private boolean convertExistingMatches;

    private CodeMatcher embeddedMatcher;

    private Map<String, String> inBoundSystemMappings;

    private Map<String, String> outBoundSystemMappings;

    /**
     * Get the value of embeddedMatcher.
     *
     * @return  the value of embeddedMatcher
     */
    public CodeMatcher getEmbeddedMatcher()
    {
        return embeddedMatcher;
    }

    /**
     * Get the value of inBoundSystemMappings. These mappings are used to transform
     * the codes passed into the matcher
     *
     * @return  the value of inBoundSystemMappings
     */
    public Map<String, String> getInBoundSystemMappings()
    {
        return inBoundSystemMappings;
    }

    @Override
    public MatchContract getMatchContract()
    {

        // Build the contract if required - One time operation. Note that in a
        // multithreaded environement there is a possible non fatal race condition
        // which might result in this process being replicated to no functional
        // problem
        if (contract == null)
        {
            MatchContract emContract = embeddedMatcher.getMatchContract();

            MatchContract cont = new MatchContract();
            cont.setFilter(emContract.isFilter());
            cont.setMatchAny(emContract.isMatchAny());

            Iterator<String> itr = emContract.getSystemsIterator();

            while (itr.hasNext())
            {
                String sys = itr.next();

                if (outBoundSystemMappings.containsKey(sys))
                {
                    cont.addTargetSystem(outBoundSystemMappings.get(sys));
                }
                else
                {
                    cont.addTargetSystem(sys);
                }
            }

            contract = cont;
        }

        return contract;
    }

    /**
     * Get the value of outBoundSystemMappings.
     *
     * @return  the value of outBoundSystemMappings
     */
    public Map<String, String> getOutBoundSystemMappings()
    {
        return outBoundSystemMappings;
    }

    /**
     * Get the value of convertExistingMatches.
     *
     * @return  the value of convertExistingMatches
     */
    public boolean isConvertExistingMatches()
    {
        return convertExistingMatches;
    }

    @Override
    public boolean match(CodeSearch matchCd, List<CodeReference> matchingCodeList)
    {
        CodeSearch translatedCode = new CodeSearch(matchCd);
        String sourceSystem = translatedCode.getSystem();

        if (this.inBoundSystemMappings.containsKey(sourceSystem))
        {
            translatedCode.setSystem(inBoundSystemMappings.get(sourceSystem));
        }

        String targetSystem = translatedCode.getTargetSystem();

        if (this.inBoundSystemMappings.containsKey(targetSystem))
        {
            translatedCode.setTargetSystem(inBoundSystemMappings.get(targetSystem));
        }
        
        List<CodeReference> outCodeList=new LinkedList<>();
        
        if (this.isConvertExistingMatches())
        {
            outCodeList.addAll(matchingCodeList);
            ConvertList(outCodeList, this.inBoundSystemMappings);
        }
       
        boolean out = this.embeddedMatcher.match(translatedCode, outCodeList);
        
        if (this.isConvertExistingMatches())
        {
            ConvertList(outCodeList, this.outBoundSystemMappings);
            matchingCodeList.clear();
            matchingCodeList.addAll(outCodeList);
        }
        else
        {
            ConvertList(outCodeList, this.outBoundSystemMappings);
            //We Just add the references out 
            matchingCodeList.addAll(outCodeList);
        }
        return out;
    }
    
    private void ConvertList(   List<CodeReference> list, Map<String, String> map)
    {
        Iterator<CodeReference> itr = list.iterator();
        while(itr.hasNext())
        {
            CodeReference cr = itr.next();
            String system = cr.getSystem();
            if (map.containsKey(system))
            {
                cr.setSystem(map.get(system));
            }
       }
    }
 
    /**
     * Set the value of convertExistingMatches.
     *
     * @param  convertExistingMatches  new value of convertExistingMatches
     */
    public void setConvertExistingMatches(boolean convertExistingMatches)
    {
        this.convertExistingMatches = convertExistingMatches;
    }

    /**
     * Set the value of embeddedMatcher.
     *
     * @param  embeddedMatcher  new value of embeddedMatcher
     */
    public void setEmbeddedMatcher(CodeMatcher embeddedMatcher)
    {
        this.embeddedMatcher = embeddedMatcher;
    }

    /**
     * Set the value of inBoundSystemMappings.
     *
     * @param  inBoundSystemMappings  new value of inBoundSystemMappings
     */
    public void setInBoundSystemMappings(Map<String, String> inBoundSystemMappings)
    {
        this.inBoundSystemMappings = inBoundSystemMappings;
    }

    /**
     * Set the value of outBoundSystemMappings.
     *
     * @param  outBoundSystemMappings  new value of outBoundSystemMappings
     */
    public void setOutBoundSystemMappings(
        Map<String, String> outBoundSystemMappings)
    {
        this.outBoundSystemMappings = outBoundSystemMappings;
    }

}
