/*
 * 
 * Map based matcher - Code Optimized - Does not support a single target system with multiple 
 * mappings. 
 * 
 */
package org.socraticgrid.codeconversion.matchers;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import org.socraticgrid.codeconversion.matchers.xml.MapMatch.TargetSystem;
import org.socraticgrid.codeconversion.matchers.xml.MapMatch.TargetSystem.SourceCoding;
import org.socraticgrid.codeconversion.elements.CodeReference;
import org.socraticgrid.codeconversion.elements.CodeSearch;
import org.socraticgrid.codeconversion.elements.SearchMapping;
import org.socraticgrid.codeconversion.elements.SearchOptions;
import org.socraticgrid.codeconversion.exceptions.InitializationException;
import org.springframework.core.io.Resource;
import javax.annotation.PostConstruct;

/**
 *
 * @author Jerry Goodnough
 */
public class MapMatch extends BaseMatcher
{

    /**
     * The Internal Map Match
     *
     */
    private HashMap<String, TargetSystemCodeMap> tsMap = new HashMap<String, TargetSystemCodeMap>();
    private Resource mapFileResource = null;

    /**
     * The Spring resource that holds the Match Map XML file.
     *
     * @param res
     */
    public void setMapFileResource(Resource res)
    {
        this.mapFileResource = res;
    }

    /**
     * Initialization the loaded the Match Mach
     *
     * @throws IOException
     * @throws InitializationException
     */
    @PostConstruct
    public void initialize() throws IOException, InitializationException
    {

        InputStream is = this.mapFileResource.getInputStream();
        if (is != null)
        {

            this.load(is);

        }

    }

    /**
     * Uses a the mactdCh to search for a match in an internal code map load
     * from a specific resource.
     *
     * This implementation acts a switch to specific protected implementation
     * bases of the exact criteria of the code search.
     *
     * Currently unsupported search type will cause this method to throw a
     * UnsupportedOperationException.
     *
     * @param matchCd The Code to match - No modification is made be this
     * matcher to this object.
     * @param matchingCodeList The List of code that are matched so far. The
     * caller is required to provide this list and this match may added results
     * to it.d
     * @return always returns true to allow match processing to continue.
     */
    public boolean match(CodeSearch matchCd, List<CodeReference> matchingCodeList)
    {

        //First Find the Map for each the Target System
        //We have three major variables - Target System/Source Code&System/Display 
        //Simplest case is a Straight System/Code Source 
        int searchType = matchCd.getSearchType();

        List<CodeReference> out = null;

        if ((searchType & SearchOptions.LITERAL_TargetSystem) != 0)
        {
            if ((searchType & SearchOptions.LITERAL_Code) != 0)
            {
                if ((searchType & SearchOptions.ANY_Display) != 0)
                {
                    out = match_TL_CL_DA(matchCd);
                }
                  else if ((searchType & SearchOptions.LITERAL_Display) != 0)
                {
                    out = match_TL_CL_DL(matchCd);
                }
                else if ((searchType & SearchOptions.REGEX_Display) != 0)
                {
                    out = match_TL_CL_DR(matchCd);
                }
                else
                {
                    throw new UnsupportedOperationException("Display Search type not supported yet.");
                }
            }
            else if ((searchType & SearchOptions.ANY_Code) != 0)
            {
                if ((searchType & SearchOptions.ANY_Display) != 0)
                {

                    out = match_TL_CA_DA(matchCd);
                }
                else if ((searchType & SearchOptions.LITERAL_Display) != 0)
                {
                    out = match_TL_CA_DL(matchCd);
                }
                else if ((searchType & SearchOptions.REGEX_Display) != 0)
                {
                    out = match_TL_CA_DR(matchCd);
                }
                else
                {
                    throw new UnsupportedOperationException("Display Search type not supported yet.");
                }
            }
            else if ((searchType & SearchOptions.REGEX_Code) != 0)
            {
                if ((searchType & SearchOptions.ANY_Display) != 0)
                {

                    out = match_TL_CR_DA(matchCd);
                }
                else if ((searchType & SearchOptions.LITERAL_Display) != 0)
                {
                    out = match_TL_CR_DL(matchCd);
                }
                else if ((searchType & SearchOptions.REGEX_Display) != 0)
                {
                    out = match_TL_CR_DR(matchCd);

                }
                else
                {
                    throw new UnsupportedOperationException("Display Search type not supported yet.");
                }

            }
            else
            {
                throw new UnsupportedOperationException("Display Search type not supported yet.");
            }

        }
        else if ((searchType & SearchOptions.ANY_TargetSystem) != 0)
        {
            if ((searchType & SearchOptions.LITERAL_Code) != 0)
            {
                if ((searchType & SearchOptions.ANY_Display) != 0)
                {

                    out = match_TA_CL_DA(matchCd);
                }
                else if ((searchType & SearchOptions.LITERAL_Display) != 0)
                {
                    out = match_TA_CL_DL(matchCd);
                }
                else if ((searchType & SearchOptions.REGEX_Display) != 0)
                {
                    out = match_TA_CL_DR(matchCd);

                }
                else
                {
                    throw new UnsupportedOperationException("Display Search type not supported yet.");
                }
            }
            else if ((searchType & SearchOptions.ANY_Code) != 0)
            {
                if ((searchType & SearchOptions.ANY_Display) != 0)
                {

                    out = match_TA_CA_DA(matchCd);
                }
                else if ((searchType & SearchOptions.LITERAL_Display) != 0)
                {
                    out = match_TA_CA_DL(matchCd);
                }
                else if ((searchType & SearchOptions.REGEX_Display) != 0)
                {

                }
                else
                {
                    throw new UnsupportedOperationException("Display Search type not supported yet.");
                }
            }
            else if ((searchType & SearchOptions.REGEX_Code) != 0)
            {
                if ((searchType & SearchOptions.ANY_Display) != 0)
                {

                    out = match_TA_CR_DA(matchCd);
                }
                else if ((searchType & SearchOptions.LITERAL_Display) != 0)
                {
                    out = match_TA_CR_DL(matchCd);
                }
                else if ((searchType & SearchOptions.REGEX_Display) != 0)
                {
                    out = match_TA_CR_DR(matchCd);

                }
                else
                {
                    throw new UnsupportedOperationException("Display Search type not supported yet.");
                }

            }
            else
            {
                throw new UnsupportedOperationException("Display Search type not supported yet.");
            }
        }
        else if ((searchType & SearchOptions.REGEX_TargetSystem) != 0)
        {
            if ((searchType & SearchOptions.LITERAL_Code) != 0)
            {
                if ((searchType & SearchOptions.ANY_Display) != 0)
                {

                    out = match_TR_CL_DA(matchCd);
                }
                else if ((searchType & SearchOptions.LITERAL_Display) != 0)
                {
                    out = match_TR_CL_DL(matchCd);
                }
                else if ((searchType & SearchOptions.REGEX_Display) != 0)
                {
                    out = match_TR_CL_DR(matchCd);

                }
                else
                {
                    throw new UnsupportedOperationException("Display Search type not supported yet.");
                }
            }
            else if ((searchType & SearchOptions.ANY_Code) != 0)
            {
                if ((searchType & SearchOptions.ANY_Display) != 0)
                {

                    out = match_TR_CA_DA(matchCd);
                }
                else if ((searchType & SearchOptions.LITERAL_Display) != 0)
                {
                    out = match_TR_CA_DL(matchCd);
                }
                else if ((searchType & SearchOptions.REGEX_Display) != 0)
                {
                    out = match_TR_CA_DR(matchCd);

                }
                else
                {
                    throw new UnsupportedOperationException("Display Search type not supported yet.");
                }
            }
            else if ((searchType & SearchOptions.REGEX_Code) != 0)
            {
                if ((searchType & SearchOptions.ANY_Display) != 0)
                {

                    out = match_TR_CR_DA(matchCd);
                }
                else if ((searchType & SearchOptions.LITERAL_Display) != 0)
                {
                    out = match_TR_CR_DL(matchCd);
                }
                else if ((searchType & SearchOptions.REGEX_Display) != 0)
                {
                    out = match_TR_CR_DR(matchCd);

                }
                else
                {
                    throw new UnsupportedOperationException("Display Search type not supported yet.");
                }

            }
            else
            {
                throw new UnsupportedOperationException("Display Search type not supported yet.");
            }

        }
        else
        {
            throw new UnsupportedOperationException("Not supported yet.");
        }


        out.addAll(out);
        return true;

    }

    /*
     * Find a specific code in a specific target system
     */

    /**
     * Target Literal, Code Literal, Display Any Search
     *
     * @param matchCd - The Code to match
     * @return List of Matches
     */

    protected List<CodeReference> match_TL_CL_DA(CodeSearch matchCd)
    {
        LinkedList<CodeReference> out = new LinkedList<CodeReference>();

        TargetSystemCodeMap scMap = tsMap.get(matchCd.getTargetSystem());
        if (scMap != null)
        {
            SearchMapping fnd = new SearchMapping(matchCd);
            if (scMap.SrchMap.containsKey(fnd))
            {
                out.add(scMap.SrchMap.get(fnd));
            }
        }

        return out;
    }


    /**
     * Regex Code search in a specific target system.
     *
     * @param matchCd - The Code to match
     * @return List of Matches

     */
    /**
     *
     * @param matchCd
     * @return
     */
    protected List<CodeReference> match_TL_CR_DA(CodeSearch matchCd)
    {
        LinkedList<CodeReference> out = new LinkedList<CodeReference>();

        TargetSystemCodeMap scMap = tsMap.get(matchCd.getTargetSystem());
        if (scMap != null)
        {
            //TODO:  Implement
        }

        throw new UnsupportedOperationException("Search not supported yet.");
    }

    /*
     * Copy all codes mapped for a target system.

     * @param matchCd - The Code to match
     * @return List of Matches

     */
    /**
     *
     * @param matchCd
     * @return
     */
    protected List<CodeReference> match_TL_CA_DA(CodeSearch matchCd)
    {
        LinkedList<CodeReference> out = new LinkedList<CodeReference>();

        TargetSystemCodeMap scMap = tsMap.get(matchCd.getTargetSystem());
        if (scMap != null)
        {

            Iterator<Entry<SearchMapping,CodeReference>>  itr = scMap.SrchMap.entrySet().iterator();
            while (itr.hasNext())
            {
                Entry<SearchMapping,CodeReference> ent = itr.next();
                out.add(ent.getValue());
            }
            

        }
        return out;
    }


    /**
     * Target Literal, Class Literal, Display Literal
     *
     * @param matchCd - The Code to match
     * @return List of Matches
     */


    protected List<CodeReference> match_TL_CL_DL(CodeSearch matchCd)
    {
        LinkedList<CodeReference> out = new LinkedList<CodeReference>();

        TargetSystemCodeMap scMap = tsMap.get(matchCd.getTargetSystem());
        if (scMap != null)
        {
            SearchMapping fnd = new SearchMapping(matchCd);
            if (scMap.SrchMap.containsKey(fnd))
            {
                if (scMap.SrchMap.get(fnd).getDisplay().compareTo(matchCd.getDisplay()) == 0)
                {
                    out.add(scMap.SrchMap.get(fnd));
                }
            }
        }
        return out;
    }


    /**
     * Target Lireral, Code Regex, Display Literal
     *
     * @param matchCd - The Code to match
     * @return List of Matches
     */
    protected List<CodeReference> match_TL_CR_DL(CodeSearch matchCd)
    {
        LinkedList<CodeReference> out = new LinkedList<CodeReference>();

        TargetSystemCodeMap scMap = tsMap.get(matchCd.getTargetSystem());
        if (scMap != null)
        {

        }
        //return out;
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Literal, Code Any, Display Literal
     * 
      * @param matchCd - The Code to match
     * @return List of Matches
     */

    protected List<CodeReference> match_TL_CA_DL(CodeSearch matchCd)
    {
        LinkedList<CodeReference> out = new LinkedList<CodeReference>();

        TargetSystemCodeMap scMap = tsMap.get(matchCd.getTargetSystem());
        if (scMap != null)
        {

        }
        //return out;
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Literal, Code Literal, Display Regex
     * Target
     * @param matchCd - The Code to match
     * @return List of Matches
     * 
     */

    protected List<CodeReference> match_TL_CL_DR(CodeSearch matchCd)
    {
        LinkedList<CodeReference> out = new LinkedList<CodeReference>();

        TargetSystemCodeMap scMap = tsMap.get(matchCd.getTargetSystem());
        if (scMap != null)
        {

        }
        //return out;
        throw new UnsupportedOperationException("Search not supported yet.");
    }

    /**
     * Target Literal, Code Regex, Display Regex
     * 
     * @param matchCd - The Code to match
     * @return List of Matches
     */

    protected List<CodeReference> match_TL_CR_DR(CodeSearch matchCd)
    {
        LinkedList<CodeReference> out = new LinkedList<CodeReference>();

        TargetSystemCodeMap scMap = tsMap.get(matchCd.getTargetSystem());
        if (scMap != null)
        {

        }
        //return out;
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Literal, Code Any, Display Regex
     * 
     * @param matchCd - The Code to match
     * @return List of Matches
     */

    protected List<CodeReference> match_TL_CA_DR(CodeSearch matchCd)
    {
        LinkedList<CodeReference> out = new LinkedList<CodeReference>();

        TargetSystemCodeMap scMap = tsMap.get(matchCd.getTargetSystem());
        if (scMap != null)
        {

        }
        //return out;
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /*
     * Target Any, Code Literal, Display Any
     * 
     * Search all mappings for the requested code.
     *
     * @param matchCd - The Code to match
     * @return List of Matches
     */
    protected List<CodeReference> match_TA_CL_DA(CodeSearch matchCd)
    {

        LinkedList<CodeReference> out = new LinkedList<CodeReference>();

        TargetSystemCodeMap scMap = tsMap.get(matchCd.getTargetSystem());
        Iterator<Entry<String, TargetSystemCodeMap>> itr = tsMap.entrySet().iterator();

        while (itr.hasNext())
        {
            Entry<String, TargetSystemCodeMap> ent = itr.next();


            scMap = ent.getValue();
            SearchMapping fnd = new SearchMapping(matchCd);
            if (scMap.SrchMap.containsKey(fnd))
            {
                out.add(scMap.SrchMap.get(fnd));
            }
        }

        return out;
    }


    /**
     * Target Any, Code Regex, Display Any
     * @param matchCd - The Code to match
     * @return List of Matches
     */

    protected List<CodeReference> match_TA_CR_DA(CodeSearch matchCd)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Any, Code Any, Display Any
     * 
     * @param matchCd - The Code to match
     * @return List of Matches
     */

    protected List<CodeReference> match_TA_CA_DA(CodeSearch matchCd)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Any, Code Literal, Display Literal
     * @param matchCd - The Code to match
     * @return List of Matches
     */

    protected List<CodeReference> match_TA_CL_DL(CodeSearch matchCd)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Any, Code Regex, Display Literal
     * @param matchCd - The Code to match
     * @return List of Matches
     */

    protected List<CodeReference> match_TA_CR_DL(CodeSearch matchCd)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Any, Code Any, Display Literal
     * 
     * Expensive operation on this matcher
     * 
     * @param matchCd - The Code to match
     * @return List of Matches
     */

    protected List<CodeReference> match_TA_CA_DL(CodeSearch matchCd)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Any, Code Literal, Display Regex
     * 
     * @param matchCd - The Code to match
     * @return List of Matches
     */

    protected List<CodeReference> match_TA_CL_DR(CodeSearch matchCd)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Any, Code Regex, Display Regex
     * @param matchCd - The Code to match
     * @return List of Matches
     */

    protected List<CodeReference> match_TA_CR_DR(CodeSearch matchCd)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }

    /**
     * Target Any, Code Any, Display Regex
     * 
     * Very expensive search operation
     * 
     * @param matchCd - The Code to match
     * @return List of Matches
     */

    protected List<CodeReference> match_TA_CA_DR(CodeSearch matchCd)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }

    // Regex based target system

    /**
     * Regex Target, Code Literal, Display Any
     * 
     * @param matchCd - The Code to match
     * @return List of Matches
     */

    protected List<CodeReference> match_TR_CL_DA(CodeSearch matchCd)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Regex Target, Code Regex, Display Any
     * 
     * Very expensive operation
     * 
     * @param matchCd - The Code to match
     * @return List of Matches
     */

    protected List<CodeReference> match_TR_CR_DA(CodeSearch matchCd)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Regex, Code Any, Display Any
     * 
     * @param matchCd - The Code to match
     * @return List of Matches
     */

    protected List<CodeReference> match_TR_CA_DA(CodeSearch matchCd)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Regex, Code Literal, Display Literal
     * 
     * @param matchCd - The Code to match
     * @return List of Matches
     */

    protected List<CodeReference> match_TR_CL_DL(CodeSearch matchCd)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     * Target Regex, Code Regex, Display Literal
     * @param matchCd - The Code to match
     * @return List of Matches
     */

    protected List<CodeReference> match_TR_CR_DL(CodeSearch matchCd)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }

    /**
     * 
     * @param matchCd - The Code to match
     * @return List of Matches
     */

    protected List<CodeReference> match_TR_CA_DL(CodeSearch matchCd)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     *
     * @param matchCd - The Code to match
     * @return List of Matches
     */

    protected List<CodeReference> match_TR_CL_DR(CodeSearch matchCd)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }

    /**
     *
     * @param matchCd - The Code to match
     * @return List of Matches
     */

    protected List<CodeReference> match_TR_CR_DR(CodeSearch matchCd)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     *
     * @param matchCd - The Code to match
     * @return List of Matches
     */

    protected List<CodeReference> match_TR_CA_DR(CodeSearch matchCd)
    {
        throw new UnsupportedOperationException("Search not supported yet.");
    }


    /**
     *
     * @param is
     * @throws InitializationException
     */

    public void load(InputStream is) throws InitializationException
    {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(org.socraticgrid.codeconversion.matchers.xml.ObjectFactory.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            org.socraticgrid.codeconversion.matchers.xml.MapMatch xmlMap = (org.socraticgrid.codeconversion.matchers.xml.MapMatch) jaxbUnmarshaller.unmarshal(is);

            Iterator<TargetSystem> itr = xmlMap.getTargetSystem().iterator();
            while (itr.hasNext())
            {
                TargetSystem ts = itr.next();
                //Update
                contract.addTargetSystem(ts.getTargetSystemCode());

                TargetSystemCodeMap tsm = new TargetSystemCodeMap();
                tsMap.put(ts.getTargetSystemCode(), tsm);

                ListIterator<SourceCoding> sItr = ts.getSourceCoding().listIterator();
                while (sItr.hasNext())
                {
                    SourceCoding sc = sItr.next();

                    CodeReference cd = new CodeReference(ts.getTargetSystemCode(), sc.getTargetCode(), sc.getTargetName());
                    SearchMapping sm = new SearchMapping(sc.getSystem(), sc.getCode());
                    tsm.SrchMap.put(sm, cd);
                }
            }
        }
        catch (JAXBException exp)
        {
            throw new InitializationException("MapMap, Error parsing code map", exp);
        }
    }

    /**
     *
     */
    public class TargetSystemCodeMap
    {

        /**
         *
         */
        public HashMap<SearchMapping, CodeReference> SrchMap = new HashMap<SearchMapping, CodeReference>();
    }
}
