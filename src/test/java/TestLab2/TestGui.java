package TestLab2;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.loadui.testfx.GuiTest;

import static junit.framework.Assert.assertFalse;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;
import static org.loadui.testfx.Assertions.verifyThat;
import static org.loadui.testfx.controls.impl.VisibleNodesMatcher.visible;


/**
 * Created by 1 on 13.12.2015.
 */
public class TestGui extends GuiTest {

    private static final String INSERT = "Insert:";
    private static final String RESULT = "Result:";
    private static final String HELLO_WORLD = "hello world";
    private static final String NEW_LINE = "\n";
    private static final String EMPTY = "";

    private static Parent root;

    @BeforeClass
        public static void beforeClass()
        {
            Main.onLoad(r -> root = r);
        }
    @Before
    public void before() throws InterruptedException
    {
        Thread.sleep(2000);
    }

    @Test
    public void normalUser() throws Exception
    {
        click("#tf00").type('0');
        click("#tf01").type('0');
        click("#tf02").type('0');
        click("#tf03").type('0');
        click("#tf10").type('0');
        click("#tf11").type('0');
        click("#tf12").type('0');
        click("#tf13").type('0');
        click("#tf20").type('0');
        click("#tf21").type('0');
        click("#tf22").type('0');
        click("#tf23").type('0');
        click("#tf30").type('0');
        click("#tf31").type('0');
        click("#tf32").type('0');
        click("#tf33").type('0');

        click("#Start").type('1');
        click("#End").type('2');

        click("#btnResult");


        verifyText("#Res", "Not path");

        click("#btnClear");
    }

    @Test
    public void normalUser2() throws Exception
    {
        click("#tf00").type('0');
        click("#tf01").type('1');
        click("#tf02").type('1');
        click("#tf03").type('1');
        click("#tf10").type('1');
        click("#tf11").type('0');
        click("#tf12").type('0');
        click("#tf13").type('0');
        click("#tf20").type('1');
        click("#tf21").type('0');
        click("#tf22").type('0');
        click("#tf23").type('1');
        click("#tf30").type('0');
        click("#tf31").type('1');
        click("#tf32").type('0');
        click("#tf33").type('0');


        click("#End").type('4');
        click("#Start").type('1');

        click("#btnResult");

        verifyText("#Res", "[0, 3]");

        click("#btnClear");
    }

    @Test
    public void addSimbol() throws Exception
    {
        click("#tf00").type('a');
        click("#tf01").type('s');
        click("#tf02").type('z');
        click("#tf03").type('c');
        click("#tf10").type('x');
        click("#tf11").type('g');
        click("#tf12").type('f');
        click("#tf13").type('e');
        click("#tf20").type('t');
        click("#tf21").type('u');
        click("#tf22").type('a');
        click("#tf23").type('d');
        click("#tf30").type('w');
        click("#tf31").type('e');
        click("#tf32").type('e');
        click("#tf33").type('h');


        click("#End").type('t');
        click("#Start").type('j');

        verifyTextField("#tf00", "");
        verifyTextField("#tf01", "");
        verifyTextField("#tf02", "");
        verifyTextField("#tf03", "");
        verifyTextField("#tf10", "");
        verifyTextField("#tf11", "");
        verifyTextField("#tf12", "");
        verifyTextField("#tf13", "");
        verifyTextField("#tf20", "");
        verifyTextField("#tf21", "");
        verifyTextField("#tf22", "");
        verifyTextField("#tf23", "");
        verifyTextField("#tf30", "");
        verifyTextField("#tf31", "");
        verifyTextField("#tf32", "");
        verifyTextField("#tf33", "");

        verifyTextField("#Start", "");
        verifyTextField("#End","");

        click("#btnClear");
    }

    @Test
    public void addBigInt() throws Exception
    {
        click("#tf00").type("12");
        click("#tf01").type("132");
        click("#tf02").type("34");
        click("#tf03").type("54");
        click("#tf10").type("112");
        click("#tf11").type("523");
        click("#tf12").type("645");
        click("#tf13").type("76");
        click("#tf22").type("345");
        click("#tf23").type("756");
        click("#tf30").type("978");
        click("#tf31").type("456");
        click("#tf32").type("876");
        click("#tf33").type("96");


        click("#End").type("2344");
        click("#Start").type("1231");

        verifyTextField("#tf00", "");
        verifyTextField("#tf01", "");
        verifyTextField("#tf02", "");
        verifyTextField("#tf03", "");
        verifyTextField("#tf10", "");
        verifyTextField("#tf11", "");
        verifyTextField("#tf12", "");
        verifyTextField("#tf13", "");
        verifyTextField("#tf20", "");
        verifyTextField("#tf21", "");
        verifyTextField("#tf22", "");
        verifyTextField("#tf23", "");
        verifyTextField("#tf30", "");
        verifyTextField("#tf31", "");
        verifyTextField("#tf32", "");
        verifyTextField("#tf33", "");

        verifyTextField("#Start", "");
        verifyTextField("#End","");


        click("#btnClear");
    }

    @Test
    public void testClear() throws Exception
    {
        click("#tf00").type('0');
        click("#tf01").type('1');
        click("#tf02").type('1');
        click("#tf03").type('1');
        click("#tf10").type('1');
        click("#tf11").type('0');
        click("#tf12").type('0');
        click("#tf13").type('0');
        click("#tf20").type('1');
        click("#tf21").type('0');
        click("#tf22").type('0');
        click("#tf23").type('1');
        click("#tf30").type('0');
        click("#tf31").type('1');
        click("#tf32").type('0');
        click("#tf33").type('0');

        click("#End").type('4');
        click("#Start").type('1');

        click("#btnResult");

        click("#btnClear");

        verifyTextField("#tf00", "");
        verifyTextField("#tf01", "");
        verifyTextField("#tf02", "");
        verifyTextField("#tf03", "");
        verifyTextField("#tf10", "");
        verifyTextField("#tf11", "");
        verifyTextField("#tf12", "");
        verifyTextField("#tf13", "");
        verifyTextField("#tf20", "");
        verifyTextField("#tf21", "");
        verifyTextField("#tf22", "");
        verifyTextField("#tf23", "");
        verifyTextField("#tf30", "");
        verifyTextField("#tf31", "");
        verifyTextField("#tf32", "");
        verifyTextField("#tf33", "");

        verifyTextField("#Start", "");
        verifyTextField("#End", "");

        click("#btnClear");
    }

    @Test
    public void testDasable1() throws Exception
    {
        click("#tf00").type('0');
        click("#tf01").type('1');
        click("#tf02").type('1');
        click("#tf03").type('1');
        click("#tf10").type('1');
        click("#tf11").type('0');
        click("#tf12").type('0');
        click("#tf13").type('0');
        click("#tf20").type('1');
        click("#tf21").type('0');
        click("#tf22").type('0');
        click("#tf23").type('1');
        click("#tf30").type('0');
        click("#tf31").type('1');
        click("#tf32").type('0');
        click("#tf33").type('0');

        click("#End").type('4');
        click("#Start").type('1');

        assertFalse(find("#btnResult").isDisable());

        click("#btnClear");

    }

    @Test
    public void testDasable2() throws Exception
    {
        click("#tf00").type('0');
        click("#tf01").type('1');
        click("#tf02").type('1');
        click("#tf03").type('1');
        click("#tf10").type('1');
        click("#tf11").type('0');
        click("#tf12").type('0');
        click("#tf13").type('0');
        click("#tf20").type('1');
        click("#tf21").type('0');
        click("#tf22").type('0');
        click("#tf23").type('1');
        click("#tf30").type('0');
        click("#tf31").type('1');
        click("#tf32").type('0');
        click("#tf33").type('0');

        click("#Start").type('4');


        assertTrue(find("#btnResult").isDisable());
        Thread.sleep(1000);

        click("#btnClear");
    }

    @Test
    public void testDasable3() throws Exception
    {
        click("#tf00").type('0');
        click("#tf01").type('1');
        click("#tf02").type('1');
        click("#tf03").type('1');
        click("#tf10").type('1');
        click("#tf11").type('0');
        click("#tf12").type('0');
        click("#tf13").type('0');
        click("#tf20").type('1');
        click("#tf21").type('0');
        click("#tf22").type('0');
        click("#tf23").type('1');
        click("#tf30").type('0');
        click("#tf31").type('1');
        click("#tf32").type('0');
        click("#tf33").type('0');

        click("#End").type('3');


        assertTrue(find("#btnResult").isDisable());
        Thread.sleep(1000);

        click("#btnClear");
    }

    @Test
    public void testDasable4() throws Exception
    {
        click("#tf00").type('0');
        click("#tf01").type('1');
        click("#tf02").type('1');
        click("#tf03").type('1');
        click("#tf10").type('1');
        click("#tf11").type('0');
        click("#tf12").type('0');
        click("#tf13").type('0');
        click("#tf20").type('1');
        click("#tf21").type('0');
        click("#tf22").type('0');
        click("#tf23").type('1');
        click("#tf30").type('0');
        click("#tf31").type('1');
        click("#tf32").type('0');

        click("#End").type('1');
        click("#Start").type('3');


        assertTrue(find("#btnResult").isDisable());

        click("#btnClear");
    }


    private void verifyText(String node, String string)
    {
        waitUntil(node, is(visible()), 10);

        String text = ((Text)find(node)).getText();

        verifyThat(text, containsString(string));
    }

    private void verifyTextField(String node, String string)
    {
        waitUntil(node, is(visible()), 10);

        String text = ((TextField)find(node)).getText();

        verifyThat(text, containsString(string));
    }



    private StringBuilder builder()
    {
        return new StringBuilder();
    }

    @Override
    public void setupStage() throws Throwable {
        new Thread(() -> Application.launch(Main.class))
                .start();
    }

    @Override
    protected Parent getRootNode()
    {
        return root;
    }

}
