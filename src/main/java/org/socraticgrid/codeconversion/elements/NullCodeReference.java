/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.elements;

/**
 *
 * @author Jerry Goodnough
 */
public class NullCodeReference extends CodeReference{
    
    /**
     *
     * @param system
     * @param code
     * @param display
     */
    public NullCodeReference(String system, String code,String display)
    {
        super(system,code,display);
    }
    
    private static NullCodeReference singleton = new NullCodeReference("","","<Null>");
 

    /**
     *
     * @return
     */

    public static NullCodeReference getNullCode()
    {
        return singleton;
    }


    public boolean equals(Object obj) {
        if (obj == null) {
            return true;
        }
        //This should be changed for instanceof
        if (getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }
    
}
