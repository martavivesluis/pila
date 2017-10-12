package edu.upc.data;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CuaTest {

    private Cua<String> c;



    @Before
    public void before() {
        c = new CuaImpl<String>(10);
        c.push("aaaaa");
        System.out.println("before done");
    }

    @After
    public void after() {
        System.out.println("after");
    }

    @Test
    public void size1() throws Exception {
        Assert.assertEquals(1, c.size());
    }
    @Test
    public void size2() throws Exception {
        c.push("bbbbb");
        Assert.assertEquals(2, c.size());
    }

    @Test
    public void sizepop() throws Exception {
        c.pop();
        Assert.assertEquals(0, c.size());
    }

    @Test
    public void sizepushpop() throws Exception {
        c.push("bbbbb");
        c.pop();
        Assert.assertEquals(1, c.size());
    }

    @Test
    public void popcontent() throws Exception {
        String answer= c.pop();
        Assert.assertEquals("aaaaa", answer);
    }

    @Test
    public void popcontent2() throws Exception {
        c.push("bbbbb");
        String vbbb= c.pop();
        String vaaa= c.pop();
        Assert.assertEquals("aaaaa", vaaa);
        Assert.assertEquals("bbbbb", vbbb);
    }

    @Test
    public void popcontent3() throws Exception {

        String vaaa= c.pop();
        c.push("bbbbb");
        String vbbb= c.pop();

        Assert.assertEquals("aaaaa", vaaa);
        Assert.assertEquals("bbbbb", vbbb);
        Assert.assertEquals(0, c.size());
    }

    @Test
    public void popcontent4() throws Exception {

        c.push("bbbbb");
        c.push("ccccc");
        String vccc= c.pop();
        String vbbb= c.pop();
        String vaaa= c.pop();
        Assert.assertEquals("aaaaa", vaaa);
        Assert.assertEquals("bbbbb", vbbb);
        Assert.assertEquals("ccccc", vccc);
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