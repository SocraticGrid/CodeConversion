/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.matchers;

import java.util.HashSet;

/**
 * Abstraction of of the Matching provided by the mapper;
 * @author Jerry Goodnough
 */
public class MatchContract
{
    
    private boolean matchAny;
    protected HashSet<String> systems = new HashSet<String>();
    /**
     * Get the value of matchAny
     *
     * @return the value of matchAny
     */
    
    public boolean isReady()
    {
       
        return (systems.size()>0)||matchAny||filter;
    
    }
    public boolean isMatchAny()
    {
        return matchAny;
    }
    private boolean filter;

    /**
     * Get the value of filter
     *
     * @return the value of filter
     */
    public boolean isFilter()
    {
        return filter;
    }

    /**
     * Set the value of filter
     *
     * @param filter new value of filter
     */
    public void setFilter(boolean filter)
    {
        this.filter = filter;
    }

    /**
     * Set the value of matchAny
     *
     * @param matchAny new value of matchAny
     */
    public void setMatchAny(boolean matchAny)
    {
        this.matchAny = matchAny;
    }
    
    public void addMatchContract(MatchContract other)
    {
        if (other.isFilter())
        {
            matchAny=false;
            this.systems.removeAll(other.systems);
        }
        else
        {
            this.systems.addAll(other.systems);
        }
        if (other.isMatchAny())
        {
            matchAny=true;
        }
    }

        
    public boolean supportsTargetSystem(String system)
    {
        if (matchAny)
        {
            return true;
        }
        else
        {   
            return systems.contains(system);
        }
    }
    
    public void addTargetSystem(String system)
    {
        systems.add(system);
    }
}
