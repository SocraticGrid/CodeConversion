/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.elements;

/**
 *
 * @author Jerry Goodnough
 */
public class CodeSource {
    // Orignal Search Info
    //   System
    //   Code
    //   Orignal Text
    // Search Tree responders / Logic Path

   
    private String sourceNote;

    /**
     * Get the value of sourceNote
     *
     * @return the value of sourceNote
     */
    public String getSourceNote()
    {
        return sourceNote;
    }

    /**
     * Set the value of sourceNote
     *
     * @param sourceNote new value of sourceNote
     */
    public void setSourceNote(String sourceNote)
    {
        this.sourceNote = sourceNote;
    }
 
    private double matchStrength;

    /**
     * Get the value of matchStrength
     *
     * @return the value of matchStrength
     */
    public double getMatchStrength()
    {
        return matchStrength;
    }

    /**
     * Set the value of matchStrength
     *
     * @param matchStrength new value of matchStrength
     */
    public void setMatchStrength(double matchStrength)
    {
        this.matchStrength = matchStrength;
    }

}
