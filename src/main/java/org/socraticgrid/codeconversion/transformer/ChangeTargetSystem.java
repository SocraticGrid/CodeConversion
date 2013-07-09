/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.transformer;

import java.util.List;
import java.util.Map;
import org.socraticgrid.codeconversion.elements.CodeReference;
import org.socraticgrid.codeconversion.elements.CodeSearch;
import org.socraticgrid.codeconversion.matchers.BaseMatcher;

/**
 * Allows a the conversion chain to change the target system
 * 
 * @author Jerry Goodnough
 * 
 * TODO: Consider how Version information might be handled
 */
public class ChangeTargetSystem extends BaseMatcher
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

        String targetSystem = matchCd.getTargetSystem();
        if (SystemMap.containsKey(targetSystem))
        {
            matchCd.setTargetSystem(SystemMap.get(targetSystem));
        }
        return true;
    }
}
