/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.matchers;

import java.util.List;
import org.socraticgrid.codeconversion.elements.CodeReference;
import org.socraticgrid.codeconversion.elements.CodeSearch;

import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.socraticgrid.codeconversion.elements.SearchOptions;
import org.w3c.dom.NodeList;

/**
 *
 * @author Jerry Goodnough
 */
public class VUIDtoRXNormMatcher extends BaseMatcher
{

    private String jenaServerURL = "";
    private static String JENA_QUERY = "?query=";

    public VUIDtoRXNormMatcher()
    {
        contract.addTargetSystem("RxNorm");
    }

    public void setJenaServerURL(String url)
    {
        this.jenaServerURL = url;
    }

    @Override
    public void match(CodeSearch matchCd, List<CodeReference> out)
    {

        if ((matchCd.getSearchType() & SearchOptions.LITERAL_TargetSystem) > 0)
        {
            //Connect to server and push the request
            if (matchCd.getSystem().equalsIgnoreCase("VUID"))
            {
                if (((matchCd.getSearchType() & SearchOptions.LITERAL_Code) > 0) && ((matchCd.getSearchType() & SearchOptions.ANY_Display) > 0))
                {
                    String rxCode = getRXNORM(matchCd.getCode());
                    if (rxCode != null)
                    {
                        out.add(new CodeReference("RxNorm", rxCode, ""));
                    }
                }
            }
        }
    }
    //private static String JENA_EP = "http://192.168.1.111:3030/data/sparql?query=";
    //------------------------------------
    //PREFIXES
    //------------------------------------
    private static String PREFIXES =
            "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>"
            + " PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>"
            + " PREFIX skos: <http://www.w3.org/2004/02/skos/core#>"
            + " PREFIX cgkos: <http://datasets.caregraf.org/ontology#>"
            + " PREFIX owl: <http://www.w3.org/2002/07/owl#>"
            + " PREFIX splo: <http://datasets.caregraf.org/splo/>"
            + " PREFIX ndfrt: <http://datasets.caregraf.org/ndfrt/>"
            + " PREFIX snomed: <http://datasets.caregraf.org/snomed/>"
            + " PREFIX vacohorto: <http://datasets.caregraf.org/vacohorto/>"
            + " PREFIX ndfrto: <http://datasets.caregraf.org/ndfrto/>"
            + " PREFIX rxnorm: <http://datasets.caregraf.org/rxnorm/>"
            + " PREFIX icd9cm: <http://datasets.caregraf.org/icd9cm/> ";
    //------------------------------------
    //QUERY: FROM VUID to RxNORM
    //------------------------------------
    private static String QUERY_VUIDTORXNORM = //SPARQLQueryUtil.PREFIXES +
            "SELECT ?RxNORMUri"
            + " (REPLACE(STR(?RxNORMUri),\"http://datasets.caregraf.org/rxnorm/\",\"\") as ?RxNORMCode)"
            + " WHERE {"
            + " GRAPH <http://datasets.caregraf.org/rxnorm> {"
            + " ?RxNORMUri <http://www.w3.org/2004/02/skos/core#exactMatch> <http://datasets.caregraf.org/vandf/%s> ."
            + " } }";

    /**
     *
     * @param vuid default.
     * @return
     * @throws Exception
     */
    public String getRXNORM(String vuid)
    {
        String ret = null;

        String query = String.format(QUERY_VUIDTORXNORM, vuid);

        // EXEC the query
        Document response;
        try
        {
            response = request(query);
            //response.getDocumentElement().;

            NodeList nodes = response.getElementsByTagName("literal");

            Logger.getLogger(VUIDtoRXNormMatcher.class.getName()).log(Level.FINE, "{0} nodes found", nodes.getLength());

            if (nodes.getLength() > 0)
            {
                ret = nodes.item(0).getTextContent();
            }

        }
        catch (Exception ex)
        {
            Logger.getLogger(VUIDtoRXNormMatcher.class.getName()).log(Level.SEVERE, null, ex);
        }



        return ret;

    }
    /*
     * 
     *
     * Returns a buffered reader
     */

    private Document request(String query) throws Exception
    {
        Document out;
        //System.out.println("JENA query@UTF-8= "+ enc);

        String sparqlrs = jenaServerURL + JENA_QUERY + URLEncoder.encode(query, "UTF-8");

        //Default Format is XML
        //System.out.println("SPARQLEP+query= " + sparqlrs);

        Logger.getLogger(VUIDtoRXNormMatcher.class.getName()).log(Level.FINE, "SPARQLEP+query= {0}", sparqlrs);


        URL sparqlr = new URL(sparqlrs);

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        out = db.parse(sparqlr.openStream());


        return out;
    }
}
