/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.transformer;

import java.util.List;
import org.socraticgrid.codeconversion.elements.CodeReference;
import org.socraticgrid.codeconversion.elements.CodeSearch;
import org.socraticgrid.codeconversion.elements.SearchOptions;
import org.socraticgrid.codeconversion.matchers.BaseMatcher;

/**
 * Class used to swap and found result in the preferred target For example a
 * final code of System C might be desired, and The input source is code set A,
 * There is no direct mapping between set A and C, but there is a a A->B mapping
 * and a B-> C mapping
 *
 * It is envisioned that a chain searching for For a C target would be
 * configured An Early stage would swap in System B as the Target, while a later
 * stage would swap in the results found in B and swap Target to C Again.
 *
 * One side effect is the current result set will be emptied after this is
 * called.
 *
 * Note the search Type is Transformed to
 * ANY_Display+LITERAL_Code+LITERAL_TargetSystem
 *
 * @author Jerry Goodnough
 */
public class SwapResultToSearch extends BaseMatcher
{

    private String newSystem;

    /**
     * Get the value of newSystem
     *
     * @return the value of newSystem
     */
    public String getNewSystem()
    {
        return newSystem;
    }

    /**
     * Set the value of newSystem
     *
     * @param newSystem new value of newSystem
     */
    public void setNewSystem(String newSystem)
    {
        this.newSystem = newSystem;
    }

    @Override
    public boolean match(CodeSearch matchCd, List<CodeReference> out)
    {
        CodeReference ref = out.get(0);
        if (ref != null)
        {
            out.clear();
            matchCd.setTargetSystem(newSystem);
            matchCd.setSystem(ref.getSystem());
            matchCd.setCode(ref.getCode());
            matchCd.setSearchType(SearchOptions.ANY_Display + SearchOptions.LITERAL_Code + SearchOptions.LITERAL_TargetSystem);
            return true;
        }
        else
        {
            //No prior code was found to swap to. Abort this chain


            return false;
        }
    }
}

