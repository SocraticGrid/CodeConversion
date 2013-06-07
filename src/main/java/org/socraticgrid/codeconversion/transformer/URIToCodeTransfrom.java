/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.transformer;

import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import org.socraticgrid.codeconversion.elements.CodeReference;
import org.socraticgrid.codeconversion.elements.CodeSearch;
import org.socraticgrid.codeconversion.matchers.BaseMatcher;

/**
 * Converts code values that are whole uri reference into a valid match code.
 * Value is expected to be in the form of uri:system:code
 *
 * The SystemMap property may be used to remap specific code systems names to
 * another one. This allows changes such as case or variant system naming.
 *
 * @author Jerry Goodnough
 */
public class URIToCodeTransfrom extends BaseMatcher
{

    private Map<String, String> SystemMap;

    /**
     * Get the value of SystemMap
     *
     * @return the value of SystemMap
     */
    public Map<String, String> getSystemMap()
    {
        return SystemMap;
    }

    /**
     * Set the value of SystemMap
     *
     * @param SystemMap new value of SystemMap
     */
    public void setSystemMap(Map<String, String> SystemMap)
    {
        this.SystemMap = SystemMap;
    }

    @Override
    public boolean match(CodeSearch matchCd, List<CodeReference> out)
    {
        //We presume the that the value of the code is actually a URI
        //In the form of uri:system:code
        //
        //Parse and translate the URI as required
        String code = matchCd.getCode();
        StringTokenizer tok = new StringTokenizer(code, ":");
        if (tok.countTokens() == 3)
        {
            //Possible Valuid URI Pattern
            String uri = tok.nextToken();
            String system = tok.nextToken();
            String actualCode = tok.nextToken();
            if (uri.compareToIgnoreCase("uri") == 0)
            {
                if ((SystemMap != null) && (SystemMap.containsKey(system)))
                {
                    system = SystemMap.get(system);
                }
                matchCd.setCode(actualCode);
                matchCd.setSystem(system);
            }
            return true;
        }
        else
        {
            //The value is not a uri and we have reached here - Not Good
            throw new IllegalArgumentException(code+" is not a uri formated code");
        }

    }
}
