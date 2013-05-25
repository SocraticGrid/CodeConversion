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
public class SearchPipeline {

    //Each Pipeline sould have the following
    public SearchPipeline()
    {
        name = "unnamed";
        matchChain = new LinkedList<CodeMatcher>();
    }
    
    
    private String name;
    private List<CodeMatcher>  matchChain=null;
    private MatchContract contract = new MatchContract();
    
    public boolean isReady()
    {
        boolean out = false;
        if (matchChain!= null)
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

    
    public List<CodeMatcher> getMatchChain()
    {
        return this.matchChain;
    }
    public void setMatchChain(List<CodeMatcher> matchChain)
    {
        this.matchChain=matchChain;
    }
    
    // Supports Target System
    public boolean SupportsTarget(String targetSystem)
    {
        return contract.supportsTargetSystem(targetSystem);
    }
    
    public boolean SupportsTarget(CodeSearch cs)
    {
        if ((cs.getSearchType()&SearchOptions.LITERAL_TargetSystem)!=0)
        {
            //
            return contract.supportsTargetSystem(cs.getTargetSystem());
        }
        else
        {
            //Covers any TargetSystem or Regex
            //In future Rexex may want to filter supported systems
            return true;
        }
        
    }
    
    // Match Chain
    public List<CodeReference> match(CodeSearch matchCd,  LinkedList<CodeReference> out)
    {
                
        ListIterator<CodeMatcher> itr = matchChain.listIterator();
        while(itr.hasNext())
        {
            itr.next().match(matchCd, out);
        }
        return out;
       
    }
    @PostConstruct
    public void initialize(){
        buildMatchContract();
    }
    
    protected void buildMatchContract()
    {
        ListIterator<CodeMatcher> itr = matchChain.listIterator();
        while(itr.hasNext())
        {
            contract.addMatchContract(itr.next().getMatchContract());
        }
    }
    
    
}
