/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.matchers;


import java.io.InputStream;
import java.util.Properties;
import org.socraticgrid.codeconversion.exceptions.InitializationException;

/**
 * Base Abstract class for matcher.
 * 
 * @author Jerry Goodnough
 */
public abstract class BaseMatcher implements CodeMatcher
{
    /*
     * Base Instance of the Match Contract
     */
    protected MatchContract contract = new MatchContract();
    /**
     * Returns the Match Contract associated with this instance
     * 
     * @return
     */
    /**
     *
     * @return
     */
    public MatchContract getMatchContract()
    {
        return contract;
    }
    
    //public void match(CodeSearch matchCd,List<CodeReference> out);
 
    /**
     *
     * @param is
     * @throws InitializationException
     */
    public void initialize(InputStream is)  throws InitializationException
    {
        
    }
    /**
     *
     * @param props
     * @throws InitializationException
     */
    public void initialize(Properties props)  throws InitializationException
    {
        
    }

}
