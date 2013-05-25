/*
 * 
 */
package org.socraticgrid.codeconversion.matchers;

import java.util.List;
import org.socraticgrid.codeconversion.elements.CodeReference;
import org.socraticgrid.codeconversion.elements.CodeSearch;

/**
 * Scan the existing match list and Orders it by system priority
 * @author Jerry Goodnough
 */
public class SystemPriorityMatch extends BaseMatcher
{

    
    public void match(CodeSearch matchCd,List<CodeReference> out)
    {
        //TODO - Reorder the list in our priority order
    }
 

}
