/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.elements;

/**
 *
 * @author Jerry Goodnough
 */
public class SearchOptions
{
     /*
     * Search Type Matrix
     * 
     *                   Literal  |   Any    | Regex
     *                 --------------------------------
     * TargetSystem    |    1     |    8     |   64   |
     * Code/System     |    2     |   16     |  128   |
     * Display         |    4     |   32     |  256   |
     *                 --------------------------------
     */
    final public static int LITERAL_Code=2;
    final public static int LITERAL_Display=4;
    final public static int LITERAL_TargetSystem=1;
    final public static int ANY_Display=32;
    final public static int ANY_Code=16;
    final public static int ANY_TargetSystem=8;
    final public static int REGEX_Display=256;
    final public static int REGEX_Code=128;
    final public static int REGEX_TargetSystem=64;
    
    
}
