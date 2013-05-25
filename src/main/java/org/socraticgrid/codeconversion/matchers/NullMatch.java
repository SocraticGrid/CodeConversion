/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.matchers;

import java.util.List;
import org.socraticgrid.codeconversion.elements.CodeReference;
import org.socraticgrid.codeconversion.elements.CodeSearch;
import org.socraticgrid.codeconversion.exceptions.InitializationException;
import org.springframework.core.io.Resource;
/**
 *
 * @author Jerry Goodnough
 */
public class NullMatch extends BaseMatcher {

 
    public NullMatch()
    {

        contract.setMatchAny(true);
    }
   
    public  void match(CodeSearch matchCd, List<CodeReference> out) {
        return;
    }
    
}
