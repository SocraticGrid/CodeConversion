/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.matchers;

import java.util.List;
import java.util.Map;
import org.socraticgrid.codeconversion.elements.CodeReference;
import org.socraticgrid.codeconversion.elements.CodeSearch;

/**
 * Match a search against a CTS 2.0 System via a Rest call.
 * 
 * @author Jerry Goodnough
 */
public class CTS2Matcher extends BaseMatcher
{

    private boolean includeSourceInfo=false;

    /**
     * Get the value of includeSourceInfo.
     * When true this matcher will include data source information if possible.
     *
     * @return the value of includeSourceInfo
     */
    public boolean isIncludeSourceInfo()
    {
        return includeSourceInfo;
    }

    /**
     * Set the value of includeSourceInfo
     *
     * @param includeSourceInfo new value of includeSourceInfo
     */
    public void setIncludeSourceInfo(boolean includeSourceInfo)
    {
        this.includeSourceInfo = includeSourceInfo;
    }


    private boolean usePreferedMatchOnly=false;

    /**
     * Get the value of usePreferedMatchOnly. When true
     * Only the preferred matches will be place on the output list.
     * Otherwise preferred matches will be added to the output list first
     *
     * @return the value of usePreferedMatchOnly
     */
    public boolean isUsePreferedMatchOnly()
    {
        return usePreferedMatchOnly;
    }

    /**
     * Set the value of usePreferedMatchOnly
     *
     * @param usePreferedMatchOnly new value of usePreferedMatchOnly
     */
    public void setUsePreferedMatchOnly(boolean usePreferedMatchOnly)
    {
        this.usePreferedMatchOnly = usePreferedMatchOnly;
    }

    private Map<String, String> targetSystemMap;

    /**
     * Get the value of targetSystemMap
     *
     * This map is used to translate between the search/result system codes and 
     * the coding being used in the CTS2.0 System
     * 
     * @return the value of targetSystemMap
     */
    public Map<String, String> getTargetSystemMap()
    {
        return targetSystemMap;
    }

    /**
     * Set the value of targetSystemMap
     *
     * @param targetSystemMap new value of targetSystemMap
     */
    public void setTargetSystemMap(Map<String, String> targetSystemMap)
    {
        this.targetSystemMap = targetSystemMap;
    }

    private String CTS2Endpoint;

    /**
     * Get the value of CTS2Endpoint
     *
     * @return the value of CTS2Endpoint
     */
    public String getCTS2Endpoint()
    {
        return CTS2Endpoint;
    }

    /**
     * Set the value of CTS2Endpoint
     *
     * @param CTS2Endpoint new value of CTS2Endpoint
     */
    public void setCTS2Endpoint(String CTS2Endpoint)
    {
        this.CTS2Endpoint = CTS2Endpoint;
    }

    @Override
    public boolean match(CodeSearch matchCd, List<CodeReference> matchingCodeList)
    {
        // Translate code Systems if required
     
        //Form the CTS2 call URL
        
        //request the CTS2 Data
        //Deal with common errors
        
        //Parse the CTS2 Data
        
        //Extact mapping(s) if any - handling the use preferred match only setting
        //Also enforce the includeDataSource option
        
        
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
