/*
 * To change this template, choose Tools | Templates and open the template in the
 * editor.
 */
package org.socraticgrid.codeconversion.exceptions;

/**
 * @author  Jerry Goodnough
 */
public class InitializationException extends Exception
{

    /**
     * @param  cause
     */

    public InitializationException(Throwable cause)
    {
        super(cause);
    }

    /**
     * @param  message
     * @param  cause
     */

    public InitializationException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
