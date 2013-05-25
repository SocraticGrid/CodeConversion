/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.matchers;

import java.io.InputStream;
import org.socraticgrid.codeconversion.elements.CodeReference;
import java.util.List;
import java.util.Properties;
import org.socraticgrid.codeconversion.elements.CodeSearch;
import org.socraticgrid.codeconversion.exceptions.InitializationException;
/**
 *
 * @author Jerry Goodnough
 */
public interface CodeMatcher {
    /* Searchs for matching codes
     
       Literal vs. Match vs. Empty/Null 
        - Support for target
        - Support for code & system
        - Support for display 
     
     */
    public MatchContract getMatchContract();
    
    public void match(CodeSearch matchCd,List<CodeReference> out);
 
}
