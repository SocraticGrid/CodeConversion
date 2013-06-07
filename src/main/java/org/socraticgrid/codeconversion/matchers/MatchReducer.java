/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.matchers;

import java.util.List;
import org.socraticgrid.codeconversion.elements.CodeReference;
import org.socraticgrid.codeconversion.elements.CodeSearch;

/**
 * Reduce matches to a single entry
 * @author Jerry Goodnough
 */
public class MatchReducer extends BaseMatcher
{
   


     /*
     *
     * @param matchCd
     * @param out
     * @return  
     */
    
    public boolean match(CodeSearch matchCd, List<CodeReference> out)
    {
        if (!out.isEmpty())
        {
            CodeReference cr = out.get(0);
            out.clear();
            out.add(cr);
        }

        return true;

    }
 

}
