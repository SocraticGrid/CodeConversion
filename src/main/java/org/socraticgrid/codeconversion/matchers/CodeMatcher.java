package org.socraticgrid.codeconversion.matchers;

import org.socraticgrid.codeconversion.elements.CodeReference;
import org.socraticgrid.codeconversion.elements.CodeSearch;

import java.util.List;


/**
 * Contract for a Code Matcher.
 *
 * @author  Jerry Goodnough
 */
public interface CodeMatcher
{

    /* Searchs for matching codes
     *  Literal vs. Match vs. Empty/Null  - Support for target - Support for code &
     * system - Support for display
     */

    /*
     * Get the Match Contract 
     * 
     * @return The Natch Contract
     */
    public MatchContract getMatchContract();

    /**
     * The Primary Match contract - In the simplest form this method will attempt to
     * find a matching code. The nature of the methods allows action along five axis.
     * 1) Code Search - Adds elements to the matchingCodeList 2) Result Manipulation
     * - Trims, Transforms, or reorders the matchingCodeList 3) Search Manipulation -
     * Modify the Code Search fields 4) Search Continuation - Continues or Aborts
     * further searching in the pipeline. 5) Logical Path - May fork or aggregate the
     * other Matchers
     *
     * @param   matchCd           The Code to match - A Mutable value that a matcher
     *                            might change.
     * @param   matchingCodeList  The List of code that are matched so far. The
     *                            caller is required to provide this list and the
     *                            match may add to it or prune it as required
     *
     * @return  true is match processing should continue.
     */
    public boolean match(CodeSearch matchCd, List<CodeReference> matchingCodeList);
}
