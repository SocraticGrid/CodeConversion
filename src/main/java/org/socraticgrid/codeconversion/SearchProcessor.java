
package org.socraticgrid.codeconversion;

import com.google.common.cache.Cache;
import java.util.LinkedList;
import java.util.List;
import org.socraticgrid.codeconversion.elements.CodeReference;
import org.socraticgrid.codeconversion.elements.CodeSearch;
import com.google.common.cache.CacheBuilder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import org.socraticgrid.codeconversion.elements.NullCodeReference;
import org.socraticgrid.codeconversion.elements.SearchOptions;
import javax.annotation.PostConstruct;


/**
 * Master Search Processor class that will manage multiple search pipelines.
 * Also handles caching of results.
 *
 * @author Jerry Goodnough
 */

public class SearchProcessor
{
    private List<SearchPipeline> pipeLineList;
    private Cache<CodeSearch, List<CodeReference>> searchCache = null;
    private boolean onSearchFailUseOrginal = false;
    private boolean searchAllPipelines = false;
    private int cacheSize = 128;
    private HashMap<String, String> codeTargetMap = new HashMap<String, String>();

    /**
     *
     */
    public SearchProcessor()
    {
    }

    /**
     *
     * @return
     */
    public List<SearchPipeline> getPipeLineList()
    {
        return this.pipeLineList;
    }

    /**
     *
     * @param list
     */
    public void setPipeLineList(List<SearchPipeline> list)
    {
        this.pipeLineList = list;
    }
    /**
     *
     * @param cacheSize
     */
    public void setCacheSize(int cacheSize)
    {
        this.cacheSize = cacheSize;
    }

    /**
     *
     */
    @PostConstruct
    public void initialize()
    {
        searchCache = CacheBuilder.newBuilder().maximumSize(cacheSize).expireAfterWrite(10, TimeUnit.MINUTES).build();
    }

    /*
     public static CodeReference getCodeReference(String targetSystem, String sourceSystem, String sourceCode, String sourceText)
     {
     return getSerchProcessor().findCode(targetSystem, sourceSystem, sourceCode, sourceText);

     }
     */
    /**
     *
     * @param sourceSystem
     * @param sourceCode
     * @param sourceText
     * @return
     */
    public CodeReference translateCode(String sourceSystem, String sourceCode, String sourceText)
    {
        CodeReference out;
        if (codeTargetMap.containsKey(sourceSystem))
        {
            out = this.findCode(codeTargetMap.get(sourceSystem), sourceSystem, sourceCode, sourceText);
        }
        else
        {
            //Refelect back out what we have.
            out = new CodeReference(sourceSystem, sourceCode, sourceText);
        }
        return out;
    }

    /**
     *
     * @param targetSystem
     * @param sourceSystem
     * @param sourceCode
     * @param sourceText
     * @return
     */
    public CodeReference findCode(String targetSystem, String sourceSystem, String sourceCode, String sourceText)
    {
        CodeReference result;

        List<CodeReference> found = this.findCodes(targetSystem, sourceSystem, sourceCode);
        if (!found.isEmpty())
        {
            result = found.get(0);
        }
        else
        {
            if (onSearchFailUseOrginal)
            {
                result = new CodeReference(sourceSystem, sourceCode, sourceText);
            }
            else
            {
                result = NullCodeReference.getNullCode();
            }
        }
        return result;
    }

    /**
     *
     * @param targetSystem
     * @param sourceText
     * @return
     */
    public CodeReference findCodeByText(String targetSystem, String sourceText)
    {
        CodeReference result;

        List<CodeReference> found = this.findCodesByText(targetSystem, sourceText);
        if (!found.isEmpty())
        {
            result = found.get(0);
        }
        else
        {
            if (onSearchFailUseOrginal)
            {
                result = new CodeReference("", "", sourceText);
            }
            else
            {
                result = NullCodeReference.getNullCode();
            }
        }
        return result;

    }

    ;
    /**
     *
     * @param targetSystem
     * @param sourceSystem
     * @param sourceCode
     * @return
     */
    public List<CodeReference> findCodes(String targetSystem, String sourceSystem, String sourceCode)
    {
        List<CodeReference> result = new LinkedList<CodeReference>();

        CodeSearch find = new CodeSearch(sourceSystem, sourceCode, "", targetSystem);
        try
        {
            result = searchCache.get(find, new PipelineSearcher(find, pipeLineList, searchAllPipelines));
        }
        catch (ExecutionException e)
        {
        }

        return result;
    }

    /**
     *
     * @param targetSystem
     * @param sourceText
     * @return
     */
    public List<CodeReference> findCodesByText(String targetSystem, String sourceText)
    {
        List<CodeReference> result = new LinkedList<CodeReference>();

        CodeSearch find = new CodeSearch();
        find.setDisplay(sourceText);
        find.setTargetSystem(targetSystem);
        find.setSearchType(SearchOptions.ANY_Code + SearchOptions.LITERAL_TargetSystem + SearchOptions.LITERAL_Display);

        try
        {
            result = searchCache.get(find, new PipelineSearcher(find, pipeLineList, searchAllPipelines));
        }
        catch (ExecutionException e)
        {
        }

        return result;
    }

    class PipelineSearcher implements Callable<List<CodeReference>>
    {

        CodeSearch find;
        List<SearchPipeline> pipelines;
        boolean searchAllPipelines;

        PipelineSearcher(CodeSearch find, List<SearchPipeline> pipelines, boolean searchAllPipelines)
        {
            this.find = find;
            this.pipelines = pipelines;
            this.searchAllPipelines = searchAllPipelines;

        }

        @Override
        public List<CodeReference> call()
        {
            LinkedList<CodeReference> out = new LinkedList<CodeReference>();

            Iterator<SearchPipeline> itr = pipelines.iterator();
            while (itr.hasNext())
            {
                SearchPipeline sp = itr.next();
                if (sp.SupportsTarget(find))
                {
                    sp.match(find, out);
                }

            }
            return out;
        }
    }

    /**
     * Controls if just the first pipeline to find a match should be consulted.
     *
     * @param bool true if all pipelines should be searched for matches
     */
    public void setSearchAllPipelines(boolean bool)
    {
        this.searchAllPipelines = bool;
    }

    /**
     * If true all pipelines will be searched for a result, even after on has
     * found a match
     *
     * @return
     */
    public boolean getSearchAllPipelines()
    {
        return this.searchAllPipelines;
    }

    /**
     * Determine if the original code value is returned as the result on a
     * failed search
     *
     * @param bool true if the original code value is returned as the result on
     * a failed search
     */
    public void setOnSearchFailUseOrginal(boolean bool)
    {
        this.onSearchFailUseOrginal = bool;
    }

    /**
     * Determine if the original code value is returned as the result on a
     * failed search
     *
     * @return true if the original code value is returned as the result on a
     * failed search
     */
    public boolean getOnSearchFailUseOrginal()
    {
        return this.onSearchFailUseOrginal;
    }
}
