package edu.upc.data;

import junit.framework.Assert;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CuaTest {
    private Cua<String> micua;
    static Logger logger = Logger.getLogger(CuaTest.class);
    @Before
    public void before() {
        micua = new CuaImpl<String>(10);
        micua.push("Marta");//afegim primer element
        logger.info("test iniciat");
    }

    @After
    public void after() {
        logger.info("test completat");
    }

    @Test
    public void size1() throws Exception {
        Assert.assertEquals(1,micua.size());
    }
    @Test
    public void size2() throws Exception {
        micua.push("Toni");
        Assert.assertEquals(2, micua.size());
    }

    @Test
    public void sizepop() throws Exception {
        micua.pop();
        Assert.assertEquals(0, micua.size());
    }

    @Test
    public void sizepushpop() throws Exception {
        micua.push("Toni");
        micua.pop();
        Assert.assertEquals(1, micua.size());
    }
    @Test
    public void popcontent() throws Exception {
        String answer= micua.pop();
        Assert.assertEquals("Marta", answer);
    }

    @Test
    public void popcontent2() throws Exception {
        micua.push("toni");
        String valor1= micua.pop();
        Assert.assertEquals("toni", valor1);

    }

    @Test
    public void popcontent3() throws Exception {

        String valor1= micua.pop();
        micua.push("Toni");
        String valor2= micua.pop();
        Assert.assertEquals("Marta", valor1);
        Assert.assertEquals("Toni", valor2);
        Assert.assertEquals(0, micua.size());
    }
    @Test
    public void popcontent4() throws Exception {

        micua.push("Toni");
        micua.push("Pep");
        Assert.assertEquals(3, micua.size());
        String valor1= micua.pop();

        Assert.assertEquals(2, micua.size());
        String valor2= micua.pop();
        Assert.assertEquals(1, micua.size());
        String valor3= micua.pop();
        Assert.assertEquals(0, micua.size());

        Assert.assertEquals("Pep", valor1);
        Assert.assertEquals("Toni", valor2);
        Assert.assertEquals("Marta", valor3);
    }
    /*@Test
    public void testCuaPlena() throws Exception {
       // Assert.assertEquals(0, o.suma(-10,10));
    }

    @Test (expected = PilaBuidaException.class)
    public void testCuaBuida() throws Exception {
        Assert.assertEquals(c.size(), 2);
        String r = c.pop();

        String s=c.pop();
    }*/
}