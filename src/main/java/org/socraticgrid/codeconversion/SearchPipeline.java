/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.PostConstruct;
import org.socraticgrid.codeconversion.elements.CodeReference;
import org.socraticgrid.codeconversion.elements.CodeSearch;
import org.socraticgrid.codeconversion.elements.SearchOptions;
import org.socraticgrid.codeconversion.matchers.CodeMatcher;
import org.socraticgrid.codeconversion.matchers.MatchContract;

/**
 *
 * @author Jerry Goodnough
 */
public class SearchPipeline
{

    /**
     * Standard Constructor
     */
    /**
     * Standard Constructor
     */
    public SearchPipeline()
    {
        name = "unnamed";
        matchChain = new LinkedList<CodeMatcher>();
    }
    private String name;
    private List<CodeMatcher> matchChain = null;
    private MatchContract contract = new MatchContract();

    /**
     * Check if the Search Pipeline is ready
     *
     * @return true if the pipeline is ready for use.
     */
    public boolean isReady()
    {
        boolean out = false;
        if (matchChain != null)
        {
            if (contract.isReady())
            {
                out = true;
            }
        }
        return out;
    }

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Get the list of Code Matcher used by this Pipeline
     *
     * @return
     */
    public List<CodeMatcher> getMatchChain()
    {
        return this.matchChain;
    }

    /**
     * Set the List of Code Matcher. Generally used by Spring.
     *
     * @param matchChain
     */
    public void setMatchChain(List<CodeMatcher> matchChain)
    {
        this.matchChain = matchChain;
    }

    // Supports Target System
    /**
     * Determine if the requested target system is supported by this pipeline.
     *
     * @param targetSystem
     * @return true if the requested target system is available on this
     * pipeline.
     */
    public boolean SupportsTarget(String targetSystem)
    {
        return contract.supportsTargetSystem(targetSystem);
    }

    /**
     * Determine if the requested target system is supported by this pipeline.
     *
     * @param searchCode Search code with a specific target system. Helper
     * function that is a wrapper for the SupportsTarget method.
     *
     * @return true is the search code matches a
     */
    public boolean SupportsTarget(CodeSearch searchCode)
    {
        if ((searchCode.getSearchType() & SearchOptions.LITERAL_TargetSystem) != 0)
        {
            //
            return contract.supportsTargetSystem(searchCode.getTargetSystem());
        }
        else
        {
            //Covers any TargetSystem or Regex
            //In future Rexex may want to filter supported systems
            return true;
        }
    }

    /**
     * Search the pipeline for a match.
     *
     * @param searchCode The code to match in the pipeline (mutable)
     * @param matchingCodeList A list of the matching codes
     */
    public void match(CodeSearch searchCode, LinkedList<CodeReference> matchingCodeList)
    {

        ListIterator<CodeMatcher> itr = matchChain.listIterator();
        while (itr.hasNext())
        {
            itr.next().match(searchCode, matchingCodeList);
        }

    }

    /**
     * Initialization of the pipeline. Used by Spring. Currently builds the
     * match contract.
     */
    @PostConstruct
    public void initialize()
    {
        buildMatchContract();
    }

    /**
     * Walk the match chain and assemble the Match Contract. The Match Contract
     * is used to determine if this pipeline handles a particular translation
     */
    protected void buildMatchContract()
    {
        ListIterator<CodeMatcher> itr = matchChain.listIterator();
      
        while (itr.hasNext())
        {
           
            contract.addMatchContract(itr.next().getMatchContract());
        }
    }
}
