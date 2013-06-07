/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.transformer;

import java.util.List;
import java.util.StringTokenizer;
import org.socraticgrid.codeconversion.elements.CodeReference;
import org.socraticgrid.codeconversion.elements.CodeSearch;

/**
 * Checks if a code value is uri formatted and if so converts the match code.
 * 
 * @author Jerry Goodnough
 */
public class AsNeededURICodeTransform extends URIToCodeTransfrom
{

    @Override
    public boolean match(CodeSearch matchCd, List<CodeReference> out)
    {
        
        String code = matchCd.getCode();
        StringTokenizer tok = new StringTokenizer(code, ":");
        if (tok.countTokens() == 3)
        {
            //Possible Valuid URI Pattern
            String uri = tok.nextToken();
            if (uri.compareToIgnoreCase("uri") == 0)
            {
                return super.match(matchCd, out);
            }
        }
        return true;
    }
    
}
