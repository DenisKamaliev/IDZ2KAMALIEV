import org.junit.Assert;
import org.junit.Test;

public class StringProcessorTest {
    @Test
    public void testTestdoStringByN(){
        StringProcessor string = new StringProcessor();
        int N1 = 2;
        String t = "test ";
        String t2 = string.doStringByN( N1 , t);
        Assert.assertEquals("test test ", t2);
    }
    @Test
    public void testNisNull(){
        StringProcessor string = new StringProcessor();
        int N2 = 0;
        String t = "test ";
        String t2 = string.doStringByN( N2 , t);
        Assert.assertEquals("", t2);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testBelowZero(){
        StringProcessor string = new StringProcessor();
        int N3 = -1;
        String t = "test ";
        String t2 = string.doStringByN( N3 , t);
    }
    @Test
    public void testSinS(){
        int count;
        StringProcessor string = new StringProcessor();
        String t1 = "abc";
        String t2 = "abcdabcdabc";
        count = string.stringInString(t2 ,t1);
        Assert.assertEquals(3, count);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSinSexeption(){
        int count;
        StringProcessor string = new StringProcessor();
        String t1 = null;
        String t2 = "";
        count = string.stringInString(t2 ,t1);
    }
    @Test
    public void testbuildString(){
        StringProcessor string = new StringProcessor();
        String t1 = "1213 - буквы";

        Assert.assertEquals("одиндваодинтри - буквы", string.buildString(t1));

    }
    @Test
    public void testdeleteSeconds(){
        StringBuilder s = new StringBuilder();
        StringProcessor string = new StringProcessor();
        s.append("qwert");
        Assert.assertEquals("qet", (string.deleteSecond(s)).toString());
    }
    @Test
    public void testreverse(){
        StringProcessor string = new StringProcessor();
        Assert.assertEquals(" ccc  bbb   aa  ",string.reverse(" aa  bbb   ccc  ") );
    }


}