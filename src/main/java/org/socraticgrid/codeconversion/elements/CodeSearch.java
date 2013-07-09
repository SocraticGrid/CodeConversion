
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
 * *************************************************************************************************************/
package org.socraticgrid.codeconversion.elements;

/**
 *
 * @author Jerry Goodnough
 * 
 * TODO: Consider reworking to use a search options mask;
 */
public class CodeSearch extends Code{

    /*
     * Search Type Matrix
     * 
     *                   Literal  |   Any    | Regex
     *                 --------------------------------
     * TargetSystem    |    1     |    8     |   64   |
     * Code/System     |    2     |   16     |  128   |
     * Display         |    4     |   32     |  256   |
     *                 --------------------------------
     */

    private String targetSystem="";
    private int searchType=0;
    /*
    /**
     * Get the value of targetSystem
     *
     * @return the value of targetSystem
     */

    /**
     *
     * @return
     */

    public String getTargetSystem() {
        return targetSystem;
    }

    /**
     * Set the value of targetSystem
     *
     * @param targetSystem new value of targetSystem
     */
    public void setTargetSystem(String targetSystem) {
        this.targetSystem = targetSystem;
    }

    

    /**
     *
     */

    public CodeSearch()
    {
        super();
        searchType=SearchOptions.LITERAL_Code+SearchOptions.ANY_Display+SearchOptions.LITERAL_TargetSystem;
    }
   
    /**
     *
     * @param other
     */
    public CodeSearch(CodeSearch other)
    {
       this.code=other.code;
       this.display=other.display;
       this.searchType=other.searchType;
       this.system=other.system;
       this.targetSystem=other.targetSystem;
    }
   
    /**
     *
     * @param system
     * @param code
     */

    public CodeSearch(String system, String code) {
     
        super(system,code);
        searchType=SearchOptions.LITERAL_Code+SearchOptions.ANY_Display+SearchOptions.LITERAL_TargetSystem;

    }

    /**
     *
     * @param system
     * @param code
     * @param searchType
     */

    public CodeSearch(String system, String code,int searchType) {
     
        super(system,code);
        this.searchType=searchType;

    }



    /**
     *
     * @param system
     * @param code
     * @param display
     */

    public CodeSearch(String system, String code, String display) {
        super(system,code,display);
        searchType=SearchOptions.LITERAL_Code+SearchOptions.ANY_Display+SearchOptions.LITERAL_TargetSystem;
    }


    /**
     *
     * @param system
     * @param code
     * @param display
     * @param searchType
     */

    public CodeSearch(String system, String code, String display, int searchType) {
        super(system,code,display);
        this.searchType=searchType;
    }
    

    /**
     *
     * @param system
     * @param code
     * @param display
     * @param targetSystem
     */

    public CodeSearch(String system, String code, String display, String targetSystem) {
        super(system,code,display);
        this.targetSystem=targetSystem;
        searchType=SearchOptions.LITERAL_Code+SearchOptions.ANY_Display+SearchOptions.LITERAL_TargetSystem;
    }
    
     /**
     *
     * @param system
     * @param code
     * @param display
     * @param targetSystem
     * @param searchType
     */
    public CodeSearch(String system, String code, String display, String targetSystem, int searchType) {

        super(system,code,display);
        this.targetSystem=targetSystem;
        this.searchType=searchType;
    }
    

   
     /* Get the Search Type
     * 
     *   
     *                   Literal  |   Any    | Regex
     *                 --------------------------------
     * TargetSystem    |    1     |    8     |   64   |
     * Code/System     |    2     |   16     |  128   |
     * Display         |    4     |   32     |  256   |
     *                 --------------------------------
     * 
     */

    /**
     *
     * @return
     */
    public int getSearchType()
    {
        return searchType;
    }
    /**
     *
     * @param searchType
     */
    public void setSearchType(int searchType)
    {
        this.searchType=searchType;
    }
    
      private String codeVersion;

    /**
     * Get the value of codeVersion
     *
     * @return the value of codeVersion
     */
    public String getCodeVersion()
    {
        return codeVersion;
    }

    /**
     * Set the value of codeVersion
     *
     * @param codeVersion new value of codeVersion
     */
    public void setCodeVersion(String codeVersion)
    {
        this.codeVersion = codeVersion;
    }
    private String targetCodeVersion;

    /**
     * Get the value of targetCodeVersion
     *
     * @return the value of targetCodeVersion
     */
    public String getTargetCodeVersion()
    {
        return targetCodeVersion;
    }

    /**
     * Set the value of targetCodeVersion
     *
     * @param targetCodeVersion new value of targetCodeVersion
     */
    public void setTargetCodeVersion(String targetCodeVersion)
    {
        this.targetCodeVersion = targetCodeVersion;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (super.equals(obj) == false )
        {
            return false;
        }
        
        final CodeSearch other = (CodeSearch) obj;
        if (this.searchType != other.searchType) 
        {
            return false;
        }
        if ((this.display == null) ? (other.display != null) : !this.display.equals(other.display))
        {
            return false;
        }
        if ((this.targetSystem == null) ? (other.targetSystem != null) : !this.targetSystem.equals(other.targetSystem))
        {
            return false;
        }
         if ((this.targetCodeVersion == null) ? (other.targetCodeVersion != null) : !this.targetCodeVersion.equals(other.targetCodeVersion))
        {
            return false;
        }
          if ((this.codeVersion == null) ? (other.codeVersion != null) : !this.codeVersion.equals(other.codeVersion))
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 5;
        hash = 13 * hash + (this.system != null ? this.system.hashCode() : 0);
        hash = 13 * hash + (this.code != null ? this.code.hashCode() : 0);
        hash = 13 * hash + (this.targetSystem != null ? this.targetSystem.hashCode() : 0);
        hash = 13 * hash + (this.display != null ? this.display.hashCode() : 0);
        hash = 13 * hash + this.searchType;
        hash = 13 * hash + (this.targetCodeVersion != null ? this.targetCodeVersion.hashCode() : 0);
        hash = 13 * hash + (this.codeVersion != null ? this.codeVersion.hashCode() : 0);
        return hash;
    }
  
}
