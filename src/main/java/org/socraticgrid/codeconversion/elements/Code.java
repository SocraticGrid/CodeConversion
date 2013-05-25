/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.elements;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Jerry Goodnough
 */
@XmlType
public class Code {

    public Code() {
        system = "";
        code = "";
        display = "";

    }

    public Code(String system, String code) {
        this.system = system;
        this.code = code;
        display = "";
    }

    public Code(String system, String code, String display) {
        this.system = system;
        this.code = code;
        this.display = display;
    }
    /**
     * Get the value of display
     *
     * @return the value of display
     */
    @XmlElement
    public String getDisplay() {
        return display;
    }

    /**
     * Set the value of display
     *
     * @param display new value of display
     */
    public void setDisplay(String display) {
        this.display = display;
    }
    protected String system;
    protected String code;
    protected String display;


    @Override
    public String toString() {
        return "code{" + "system=" + system + ", code=" + code + ",display=" + display + '}';
    }

    /**
     * Get the value of CodeReference
     *
     * @return the value of CodeReference
     */
    @XmlElement(required = true)
    public String getCode() {
        return code;
    }

    /**
     * Set the value of CodeReference
     *
     * @param CodeReference new value of CodeReference
     */
    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        //This should be changed for instanceof
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Code other = (Code) obj;
        if ((this.system == null) ? (other.system != null) : !this.system.equals(other.system)) {
            return false;
        }
        if ((this.code == null) ? (other.code != null) : !this.code.equals(other.code)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + (this.system != null ? this.system.hashCode() : 0);
        hash = 13 * hash + (this.code != null ? this.code.hashCode() : 0);
        return hash;
    }

    /**
     * Get the value of system
     *
     * @return the value of system
     */
    @XmlElement(required = true)
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
}
