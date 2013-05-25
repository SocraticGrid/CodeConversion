/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.matchers;

import java.io.InputStream;
import java.util.Properties;
import org.socraticgrid.codeconversion.exceptions.InitializationException;

/**
 *
 * @author Jerry Goodnough
 */
public abstract class BaseMatcher implements CodeMatcher
{
    protected MatchContract contract = new MatchContract();
    public MatchContract getMatchContract()
    {
        return contract;
    }
    
    //public void match(CodeSearch matchCd,List<CodeReference> out);
 
    public void initialize(InputStream is)  throws InitializationException
    {
        
    }
    public void initialize(Properties props)  throws InitializationException
    {
        
    }
}
