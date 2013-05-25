/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.elements;

/**
 *
 * @author Jerry Goodnough
 */
public class SearchMapping {

    public SearchMapping(String system, String code)
    {
        this.code=code;
        this.system=system;
    }
    public SearchMapping(CodeSearch cs)
    {
        this.code=cs.getCode();
        this.system=cs.getSystem();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SearchMapping other = (SearchMapping) obj;
        if ((this.code == null) ? (other.code != null) : !this.code.equals(other.code)) {
            return false;
        }
        if ((this.system == null) ? (other.system != null) : !this.system.equals(other.system)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + (this.code != null ? this.code.hashCode() : 0);
        hash = 97 * hash + (this.system != null ? this.system.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "SearchMapping{" + "code=" + code + ", system=" + system + '}';
    }

    //Coding
    
    private String code;
    private String system;

    /**
     * Get the value of system
     *
     * @return the value of system
     */
    public String getSystem() {
        return system;
    }

    /**
     * Set the value of system
     *
     * @param system new value of system
     */
    public void setSystem(String system) {
        this.system = system;
    }

    /**
     * Get the value of code
     *
     * @return the value of code
     */
    public String getCode() {
        return code;
    }

    /**
     * Set the value of code
     *
     * @param code new value of code
     */
    public void setCode(String code) {
        this.code = code;
    }



}
