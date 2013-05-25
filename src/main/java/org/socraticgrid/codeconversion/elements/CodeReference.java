/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.elements;

import org.socraticgrid.codeconversion.elements.Code;

/**
 *
 * @author Jerry Goodnough
 */
public class CodeReference extends Code {

   
    public CodeReference(String system, String code, String display, CodeSource source)
    {
        super(system, code, display);
        this.source=source;
    }
    
    public CodeReference(String system, String code, String display)
    {
        super(system, code, display);
        this.source=null;
    }
    
    protected CodeSource source;

    /**
     * Get the value of source
     *
     * @return the value of source
     */
    public CodeSource getSource() {
        return source;
    }

    /**
     * Set the value of source
     *
     * @param source new value of source
     */
    public void setSource(CodeSource source) {
        this.source = source;
    }



}
