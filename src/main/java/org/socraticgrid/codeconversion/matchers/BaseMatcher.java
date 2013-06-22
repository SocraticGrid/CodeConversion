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
import org.socraticgrid.codeconversion.elements.SearchOptions;

import java.util.List;


/**
 * Base Abstract class for matcher.
 *
 * @author  Jerry Goodnough
 */
public abstract class BaseMatcher implements CodeMatcher
{

    /** Base Instance of the Match Contract. */


    protected MatchContract contract = new MatchContract();

    /**
     * Returns the Match Contract associated with this instance.
     *
     * @return  Returns the Match Contract associated with this instance.
     */
    public MatchContract getMatchContract()
    {
        return contract;
    }


    /**
     * Target Any, Code Any, Display Any.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */

    protected boolean match_TA_CA_DA(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Any, Code Any, Display Literal.
     *
     * <p>Expensive operation on this matcher</p>
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */

    protected boolean match_TA_CA_DL(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }

    /**
     * Target Any, Code Any, Display Regex.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */

    protected boolean match_TA_CA_DR(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }

    // Regex based target system


    /**
     * Target Any, Code Literal, Display Any.
     *
     * <p>Search all mappings for the requested code.</p>
     *
     * @param   matchCd  - The Code to match @return List of Matches
     *
     * @return  true to continue searching
     */
    protected boolean match_TA_CL_DA(CodeSearch matchCd, List<CodeReference> outList)
    {

        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Any, Code Literal, Display Literal.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */

    protected boolean match_TA_CL_DL(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Any, Code Literal, Display Regex.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */

    protected boolean match_TA_CL_DR(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Any, Code Regex, Display Any.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */

    protected boolean match_TA_CR_DA(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Any, Code Regex, Display Literal.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */

    protected boolean match_TA_CR_DL(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Any, Code Regex, Display Regex.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */

    protected boolean match_TA_CR_DR(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }

    /**
     * Copy all codes mapped for a target system.
     *
     * @param   matchCd  - The Code to match @return List of Matches
     *
     * @return  true to continue searching
     */
    protected boolean match_TL_CA_DA(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Literal, Code Any, Display Literal.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */

    protected boolean match_TL_CA_DL(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Literal, Code Any, Display Regex.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */

    protected boolean match_TL_CA_DR(CodeSearch matchCd, List<CodeReference> outList)
    {

        throw new UnsupportedOperationException("Search not supported yet.");
    }

    /**
     * Target Literal, Code Literal, Display Any Search.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */

    protected boolean match_TL_CL_DA(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Literal, Class Literal, Display Literal.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */


    protected boolean match_TL_CL_DL(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Literal, Code Literal, Display Regex Target.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */

    protected boolean match_TL_CL_DR(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Regex Code search in a specific target system.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */
    protected boolean match_TL_CR_DA(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Literal, Code Regex, Display Literal.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */
    protected boolean match_TL_CR_DL(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }

    /**
     * Target Literal, Code Regex, Display Regex.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */

    protected boolean match_TL_CR_DR(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Regex, Code Any, Display Any.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */

    protected boolean match_TR_CA_DA(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }

    /**
     * DOCUMENT ME!
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */

    protected boolean match_TR_CA_DL(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * DOCUMENT ME!
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */

    protected boolean match_TR_CA_DR(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }

    /**
     * Regex Target, Code Literal, Display Any.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */

    protected boolean match_TR_CL_DA(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Regex, Code Literal, Display Literal.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */

    protected boolean match_TR_CL_DL(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Regex Target, Code Literal, Display Regex.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */

    protected boolean match_TR_CL_DR(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Regex Target, Code Regex, Display Any.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */

    protected boolean match_TR_CR_DA(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Regex, Code Regex, Display Literal.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */

    protected boolean match_TR_CR_DL(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }

    /**
     * Target Regex, Code Regex, Displpay Regex.
     *
     * @param   matchCd  - The Code to match
     *
     * @return  true to continue searching
     */

    protected boolean match_TR_CR_DR(CodeSearch matchCd, List<CodeReference> outList)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }

    /**
     *  Stock implementation that jus calls vectorMatch
     */
    @Override
    public boolean match(CodeSearch matchCd, List<CodeReference> matchingCodeList)
    {
        return this.vectorMatch(matchCd, matchingCodeList);
    }


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
    protected boolean vectorMatch(CodeSearch matchCd,
        List<CodeReference> matchingCodeList)
    {

        // First Find the Map for each the Target System
        // We have three major variables - Target System/Source Code&System/Display
        // Simplest case is a Straight System/Code Source
        int searchType = matchCd.getSearchType();
        boolean out = true;


        if ((searchType & SearchOptions.LITERAL_TargetSystem) != 0)
        {

            if ((searchType & SearchOptions.LITERAL_Code) != 0)
            {

                if ((searchType & SearchOptions.ANY_Display) != 0)
                {
                    out = match_TL_CL_DA(matchCd, matchingCodeList);
                }
                else if ((searchType & SearchOptions.LITERAL_Display) != 0)
                {
                    out = match_TL_CL_DL(matchCd, matchingCodeList);
                }
                else if ((searchType & SearchOptions.REGEX_Display) != 0)
                {
                    out = match_TL_CL_DR(matchCd, matchingCodeList);
                }
                else
                {
                    throw new UnsupportedOperationException(
                        "Display Search type not supported yet.");
                }
            }
            else if ((searchType & SearchOptions.ANY_Code) != 0)
            {

                if ((searchType & SearchOptions.ANY_Display) != 0)
                {

                    out = match_TL_CA_DA(matchCd, matchingCodeList);
                }
                else if ((searchType & SearchOptions.LITERAL_Display) != 0)
                {
                    out = match_TL_CA_DL(matchCd, matchingCodeList);
                }
                else if ((searchType & SearchOptions.REGEX_Display) != 0)
                {
                    out = match_TL_CA_DR(matchCd, matchingCodeList);
                }
                else
                {
                    throw new UnsupportedOperationException(
                        "Display Search type not supported yet.");
                }
            }
            else if ((searchType & SearchOptions.REGEX_Code) != 0)
            {

                if ((searchType & SearchOptions.ANY_Display) != 0)
                {

                    out = match_TL_CR_DA(matchCd, matchingCodeList);
                }
                else if ((searchType & SearchOptions.LITERAL_Display) != 0)
                {
                    out = match_TL_CR_DL(matchCd, matchingCodeList);
                }
                else if ((searchType & SearchOptions.REGEX_Display) != 0)
                {
                    out = match_TL_CR_DR(matchCd, matchingCodeList);

                }
                else
                {
                    throw new UnsupportedOperationException(
                        "Display Search type not supported yet.");
                }

            }
            else
            {
                throw new UnsupportedOperationException(
                    "Display Search type not supported yet.");
            }

        }
        else if ((searchType & SearchOptions.ANY_TargetSystem) != 0)
        {

            if ((searchType & SearchOptions.LITERAL_Code) != 0)
            {

                if ((searchType & SearchOptions.ANY_Display) != 0)
                {

                    out = match_TA_CL_DA(matchCd, matchingCodeList);
                }
                else if ((searchType & SearchOptions.LITERAL_Display) != 0)
                {
                    out = match_TA_CL_DL(matchCd, matchingCodeList);
                }
                else if ((searchType & SearchOptions.REGEX_Display) != 0)
                {
                    out = match_TA_CL_DR(matchCd, matchingCodeList);

                }
                else
                {
                    throw new UnsupportedOperationException(
                        "Display Search type not supported yet.");
                }
            }
            else if ((searchType & SearchOptions.ANY_Code) != 0)
            {

                if ((searchType & SearchOptions.ANY_Display) != 0)
                {

                    out = match_TA_CA_DA(matchCd, matchingCodeList);
                }
                else if ((searchType & SearchOptions.LITERAL_Display) != 0)
                {
                    out = match_TA_CA_DL(matchCd, matchingCodeList);
                }
                else if ((searchType & SearchOptions.REGEX_Display) != 0)
                {

                }
                else
                {
                    throw new UnsupportedOperationException(
                        "Display Search type not supported yet.");
                }
            }
            else if ((searchType & SearchOptions.REGEX_Code) != 0)
            {

                if ((searchType & SearchOptions.ANY_Display) != 0)
                {

                    out = match_TA_CR_DA(matchCd, matchingCodeList);
                }
                else if ((searchType & SearchOptions.LITERAL_Display) != 0)
                {
                    out = match_TA_CR_DL(matchCd, matchingCodeList);
                }
                else if ((searchType & SearchOptions.REGEX_Display) != 0)
                {
                    out = match_TA_CR_DR(matchCd, matchingCodeList);

                }
                else
                {
                    throw new UnsupportedOperationException(
                        "Display Search type not supported yet.");
                }

            }
            else
            {
                throw new UnsupportedOperationException(
                    "Display Search type not supported yet.");
            }
        }
        else if ((searchType & SearchOptions.REGEX_TargetSystem) != 0)
        {

            if ((searchType & SearchOptions.LITERAL_Code) != 0)
            {

                if ((searchType & SearchOptions.ANY_Display) != 0)
                {

                    out = match_TR_CL_DA(matchCd, matchingCodeList);
                }
                else if ((searchType & SearchOptions.LITERAL_Display) != 0)
                {
                    out = match_TR_CL_DL(matchCd, matchingCodeList);
                }
                else if ((searchType & SearchOptions.REGEX_Display) != 0)
                {
                    out = match_TR_CL_DR(matchCd, matchingCodeList);

                }
                else
                {
                    throw new UnsupportedOperationException(
                        "Display Search type not supported yet.");
                }
            }
            else if ((searchType & SearchOptions.ANY_Code) != 0)
            {

                if ((searchType & SearchOptions.ANY_Display) != 0)
                {

                    out = match_TR_CA_DA(matchCd, matchingCodeList);
                }
                else if ((searchType & SearchOptions.LITERAL_Display) != 0)
                {
                    out = match_TR_CA_DL(matchCd, matchingCodeList);
                }
                else if ((searchType & SearchOptions.REGEX_Display) != 0)
                {
                    out = match_TR_CA_DR(matchCd, matchingCodeList);

                }
                else
                {
                    throw new UnsupportedOperationException(
                        "Display Search type not supported yet.");
                }
            }
            else if ((searchType & SearchOptions.REGEX_Code) != 0)
            {

                if ((searchType & SearchOptions.ANY_Display) != 0)
                {

                    out = match_TR_CR_DA(matchCd, matchingCodeList);
                }
                else if ((searchType & SearchOptions.LITERAL_Display) != 0)
                {
                    out = match_TR_CR_DL(matchCd, matchingCodeList);
                }
                else if ((searchType & SearchOptions.REGEX_Display) != 0)
                {
                    out = match_TR_CR_DR(matchCd, matchingCodeList);

                }
                else
                {
                    throw new UnsupportedOperationException(
                        "Display Search type not supported yet.");
                }

            }
            else
            {
                throw new UnsupportedOperationException(
                    "Display Search type not supported yet.");
            }

        }
        else
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }


        return out;

    }


}
