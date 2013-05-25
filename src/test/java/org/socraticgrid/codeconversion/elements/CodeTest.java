/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.socraticgrid.codeconversion.elements;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 *
 * @author Jerry Goodnough
 */
public class CodeTest extends TestCase
{
    
    public CodeTest(String testName)
    {
        super(testName);
    }

    public static Test suite()
    {
        TestSuite suite = new TestSuite(CodeTest.class);
        return suite;
    }
    
    @Override
    protected void setUp() throws Exception
    {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception
    {
        super.tearDown();
    }

    /**
     * Test of getDisplay method, of class Code.
     */
    public void testGetDisplay()
    {
        System.out.println("getDisplay");
        Code instance = new Code("1","2","3");
        String expResult = "3";
        String result = instance.getDisplay();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDisplay method, of class Code.
     */
    public void testSetDisplay()
    {
        System.out.println("setDisplay");
        String display = "3";
        Code instance = new Code();
        instance.setDisplay(display);
    }

    /**
     * Test of toString method, of class Code.
     */
    public void testToString()
    {
        System.out.println("toString");
        Code instance = new Code("1","2","3");
        String expResult = "code{system=1, code=2,display=3}";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCode method, of class Code.
     */
    public void testGetCode()
    {
        System.out.println("getCode");
        Code instance = new Code("1","2","3");
        String expResult = "2";
        String result = instance.getCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of setCode method, of class Code.
     */
    public void testSetCode()
    {
        System.out.println("setCode");
        String code = "2";
        Code instance = new Code();
        instance.setCode(code);
    }

    /**
     * Test of equals method, of class Code.
     */
    public void testEquals()
    {
        System.out.println("equals");
        Code obj = new Code("1","2","3");
        Code instance = new Code("1","2","3");
        boolean expResult = true;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
    }

    /**
     * Test of hashCode method, of class Code.
     */
    public void testHashCode()
    {
        System.out.println("hashCode");
        Code instance = new Code("1","2","3");
        int result = instance.hashCode();
        assertTrue(result>0);
    }

    /**
     * Test of getSystem method, of class Code.
     */
    public void testGetSystem()
    {
        System.out.println("getSystem");
        Code instance = new Code("1","2","3");
        String expResult = "1";
        String result = instance.getSystem();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSystem method, of class Code.
     */
    public void testSetSystem()
    {
        System.out.println("setSystem");
        String system = "1";
        Code instance = new Code();
        instance.setSystem(system);
    }
}
