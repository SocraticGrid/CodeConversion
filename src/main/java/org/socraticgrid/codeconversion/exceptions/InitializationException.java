/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.exceptions;

/**
 *
 * @author Jerry Goodnough
 */
public class InitializationException extends Exception
{
    public InitializationException(Throwable cause)
    {
         super(cause);
    }
    public InitializationException(String message,Throwable cause)
    {
         super(message,cause);
    }
}
