package TestLab2;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by 1 on 27.10.2015.
 */
public class SearchPathTest {

    @Test
    public void testMain() throws Exception {
        boolean[][] t = {{false,false,false,true,false},
                {false,false,true,true,true},
                {false,true,false,false,false},
                {true,true,false,false,false},
                {false,true,false,false,false}};
        SearchPath m = new SearchPath(t,1,3);
        Assert.assertEquals("[0, 3, 1, 2]",m.Main());
    }

    @Test
    public void testMain2() throws Exception {
        boolean[][] t = {{false,false,true,true,true},
                {false,false,false,false,false},
                {true,true,false,true,false},
                {true,false,true,false,true},
                {true,false,false,true,false}};
        SearchPath m = new SearchPath(t,1,5);
        Assert.assertEquals("[0, 4]",m.Main());
    }

    @Test
    public void testMainErrStartLessZero() throws Exception {
        boolean[][] t = {{false,false,true,true,true},
                {false,false,false,false,false},
                {true,true,false,true,false},
                {true,false,true,false,true},
                {true,false,false,true,false}};
        SearchPath m = new SearchPath(t,-5,5);
        Assert.assertEquals("Not exist point start or end in this graph",m.Main());
    }
    @Test
    public void testMainErrEndLessZero() throws Exception {
        boolean[][] t = {{false,false,true,true,true},
                {false,false,false,false,false},
                {true,true,false,true,false},
                {true,false,true,false,true},
                {true,false,false,true,false}};
        SearchPath m = new SearchPath(t,5,-5);
        Assert.assertEquals("Not exist point start or end in this graph",m.Main());
    }
    @Test
    public void testMainErrEndMoreSize() throws Exception {
        boolean[][] t = {{false,false,true,true,true},
                {false,false,false,false,false},
                {true,true,false,true,false},
                {true,false,true,false,true},
                {true,false,false,true,false}};
        SearchPath m = new SearchPath(t,2,6);
        Assert.assertEquals("Not exist point start or end in this graph",m.Main());
    }
    @Test
    public void testMainErrStartMoreSize() throws Exception {
        boolean[][] t = {{false,false,true,true,true},
                {false,false,false,false,false},
                {true,true,false,true,false},
                {true,false,true,false,true},
                {true,false,false,true,false}};
        SearchPath m = new SearchPath(t,6,4);
        Assert.assertEquals("Not exist point start or end in this graph",m.Main());
    }
    @Test
    public void testMainErrSize() throws Exception {
        boolean[][] t = {{false,false,true,true,true},
                {false,false,false,false,false},
                {true,true,false,true,false},
                {true,false,true,false,true},
                {true,false,false,true}};
        SearchPath m = new SearchPath(t,2,4);
        Assert.assertEquals("Error size",m.Main());
    }
    @Test
    public void testMainErrSize2() throws Exception {
        boolean[][] t = {{false,false,true,true},
                {false,false,false,false},
                {true,true,false,true},
                {true,false,true,false},
                {true,false,false,true}};
        SearchPath m = new SearchPath(t,2,4);
        Assert.assertEquals("Error size",m.Main());
    }
    @Test
    public void testMainErrSize3() throws Exception {
        boolean[][] t = {{false,false,true,true,true},
                {false,false,false,false,false},
                {true,true,false,true,false},
                {true,false,true,false,true},
                };
        SearchPath m = new SearchPath(t,2,4);
        Assert.assertEquals("Error size",m.Main());
    }
    @Test
    public void testMainErrNotWay() throws Exception {
        boolean[][] t = {{false,false,true,true,true},
                {false,false,true,false,false},
                {true,false,false,true,false},
                {true,false,true,false,true},
                {true,false,false,true,false}};
        SearchPath m = new SearchPath(t,4,2);
        Assert.assertEquals("Not path",m.Main());
    }
    @Test
    public void testMainErrSmallSize() throws Exception {
        boolean[][] t = {{false,false,true,true,true}};
        SearchPath m = new SearchPath(t,1,1);
        Assert.assertEquals("Start = end",m.Main());
    }
}