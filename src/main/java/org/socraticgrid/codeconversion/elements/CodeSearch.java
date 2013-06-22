/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.elements;

/**
 *
 * @author Jerry Goodnough
 * 
 * TODO: Consider reworking to use a search options mask;
 */
public class CodeSearch extends Code{

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

    private String targetSystem="";
    private int searchType=0;
    /*
    /**
     * Get the value of targetSystem
     *
     * @return the value of targetSystem
     */

    /**
     *
     * @return
     */

    public String getTargetSystem() {
        return targetSystem;
    }

    /**
     * Set the value of targetSystem
     *
     * @param targetSystem new value of targetSystem
     */
    public void setTargetSystem(String targetSystem) {
        this.targetSystem = targetSystem;
    }

    

    /**
     *
     */

    public CodeSearch()
    {
        super();
        searchType=SearchOptions.LITERAL_Code+SearchOptions.ANY_Display+SearchOptions.LITERAL_TargetSystem;
    }
   
    /**
     *
     * @param other
     */
    public CodeSearch(CodeSearch other)
    {
       this.code=other.code;
       this.display=other.display;
       this.searchType=other.searchType;
       this.system=other.system;
       this.targetSystem=other.targetSystem;
    }
   
    /**
     *
     * @param system
     * @param code
     */

    public CodeSearch(String system, String code) {
     
        super(system,code);
        searchType=SearchOptions.LITERAL_Code+SearchOptions.ANY_Display+SearchOptions.LITERAL_TargetSystem;

    }

    /**
     *
     * @param system
     * @param code
     * @param searchType
     */

    public CodeSearch(String system, String code,int searchType) {
     
        super(system,code);
        this.searchType=searchType;

    }



    /**
     *
     * @param system
     * @param code
     * @param display
     */

    public CodeSearch(String system, String code, String display) {
        super(system,code,display);
        searchType=SearchOptions.LITERAL_Code+SearchOptions.ANY_Display+SearchOptions.LITERAL_TargetSystem;
    }


    /**
     *
     * @param system
     * @param code
     * @param display
     * @param searchType
     */

    public CodeSearch(String system, String code, String display, int searchType) {
        super(system,code,display);
        this.searchType=searchType;
    }
    

    /**
     *
     * @param system
     * @param code
     * @param display
     * @param targetSystem
     */

    public CodeSearch(String system, String code, String display, String targetSystem) {
        super(system,code,display);
        this.targetSystem=targetSystem;
        searchType=SearchOptions.LITERAL_Code+SearchOptions.ANY_Display+SearchOptions.LITERAL_TargetSystem;
    }
    
     /**
     *
     * @param system
     * @param code
     * @param display
     * @param targetSystem
     * @param searchType
     */
    public CodeSearch(String system, String code, String display, String targetSystem, int searchType) {

        super(system,code,display);
        this.targetSystem=targetSystem;
        this.searchType=searchType;
    }
    

   
     /* Get the Search Type
     * 
     *   
     *                   Literal  |   Any    | Regex
     *                 --------------------------------
     * TargetSystem    |    1     |    8     |   64   |
     * Code/System     |    2     |   16     |  128   |
     * Display         |    4     |   32     |  256   |
     *                 --------------------------------
     * 
     */

    /**
     *
     * @return
     */
    public int getSearchType()
    {
        return searchType;
    }
    /**
     *
     * @param searchType
     */
    public void setSearchType(int searchType)
    {
        this.searchType=searchType;
    }
    
    
}
