import org.fest.swing.annotation.RunsInEDT;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.junit.testcase.FestSwingJUnitTestCase;
import org.junit.Before;
import org.junit.Test;
import pages.BasePage;

import javax.swing.*;
import java.awt.*;

import static org.fest.swing.edt.GuiActionRunner.execute;

/**
 * Created by Anna on 26.11.2017.
 */
public class BasePageTest extends FestSwingJUnitTestCase {

    static FrameFixture editor;
    private BasePage basePage;

    @Override
    protected void onSetUp() {
        editor = new FrameFixture(robot(), createNewEditor());
        editor.show();
    }

    @RunsInEDT
    private static JFrame createNewEditor() {
        return execute(new GuiQuery<JFrame>() {
            protected JFrame executeInEDT() throws Throwable {
                //SwingSet2.main(new String[] {});
                UIManager.put("swing.boldMetal", Boolean.FALSE);
                SwingSet2 swingSet2 = new SwingSet2(null, GraphicsEnvironment.
                        getLocalGraphicsEnvironment().
                        getDefaultScreenDevice().
                        getDefaultConfiguration());
                swingSet2.loadDemo("TableDemo");

                return swingSet2.getFrame();
            }
        });
    }
    @Before
    public void init() throws InterruptedException {
        basePage = new BasePage(editor);
    }

    @Test
    public void openJTableDemo() throws InterruptedException {
        basePage.openDemo("JTable demo");
    }
}
