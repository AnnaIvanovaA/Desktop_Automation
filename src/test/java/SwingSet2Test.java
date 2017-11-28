import org.fest.swing.annotation.RunsInEDT;
import org.fest.swing.core.GenericTypeMatcher;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JCheckBoxFixture;
import org.fest.swing.fixture.JPanelFixture;
import org.fest.swing.fixture.JToolBarFixture;
import org.fest.swing.junit.testcase.FestSwingJUnitTestCase;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.fest.swing.edt.GuiActionRunner.execute;

/**
 * Created by Anna on 25.11.2017.
 */
public class SwingSet2Test extends FestSwingJUnitTestCase {

    private FrameFixture editor;
    private JPanelFixture editorPanel;
    private SwingSet2 sw;

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

    @Test
    public void should_open_file() throws InterruptedException {
        Thread.sleep(1000);
        JToolBarFixture toolBar = editor.toolBar();


        // open jtable demo toggleBtn
        GenericTypeMatcher<JToggleButton> jToggleBtnMatcher = new GenericTypeMatcher<JToggleButton>(JToggleButton.class) {
            protected boolean isMatching(JToggleButton toggleBtn) {
                return toggleBtn.getToolTipText().equals("JTable demo");
            }
        };
        toolBar.toggleButton(jToggleBtnMatcher).click();

        //
        GenericTypeMatcher<JCheckBox> jCheckboxByTextMatcher = new GenericTypeMatcher<JCheckBox>(JCheckBox.class) {
            protected boolean isMatching(JCheckBox checkBox) {
                return checkBox.getText().equals("Reordering allowed");
            }
        };
        JCheckBoxFixture reorderingChbx = editor.checkBox(jCheckboxByTextMatcher);
        reorderingChbx.click();

        Thread.sleep(1000);

        GenericTypeMatcher<JCheckBox> jCheckboxByTextMatcher2 = new GenericTypeMatcher<JCheckBox>(JCheckBox.class) {
            protected boolean isMatching(JCheckBox checkBox) {
                return checkBox.getText().equals("Horiz. Lines");
            }
        };

        JCheckBoxFixture horixLinesChbx = editor.checkBox(jCheckboxByTextMatcher2);
        horixLinesChbx.click();

        Thread.sleep(1000);
        GenericTypeMatcher<JCheckBox> jCheckboxByTextMatcher3 = new GenericTypeMatcher<JCheckBox>(JCheckBox.class) {
            protected boolean isMatching(JCheckBox checkBox) {
                return checkBox.getText().equals("Vert. Lines");
            }
        };
        JCheckBoxFixture vertLinesChbx = editor.checkBox(jCheckboxByTextMatcher3);
        vertLinesChbx.click();
        Thread.sleep(1000);

        GenericTypeMatcher<JCheckBox> jCheckboxByTextMatcher4 = new GenericTypeMatcher<JCheckBox>(JCheckBox.class) {
            protected boolean isMatching(JCheckBox checkBox) {
                return checkBox.getText().equals("Row selection");
            }
        };



        JCheckBoxFixture rowSelectionChbx = editor.checkBox(jCheckboxByTextMatcher4);
        rowSelectionChbx.click();
        Thread.sleep(1000);

        GenericTypeMatcher<JCheckBox> jCheckboxByTextMatcher5 = new GenericTypeMatcher<JCheckBox>(JCheckBox.class) {
            protected boolean isMatching(JCheckBox checkBox) {
                return checkBox.getText().equals("Column selection");
            }
        };

        JCheckBoxFixture columnSelectionChbx = editor.checkBox(jCheckboxByTextMatcher5);
        columnSelectionChbx.click();

        Thread.sleep(1000);


        GenericTypeMatcher<JCheckBox> jCheckboxByTextMatcher6 = new GenericTypeMatcher<JCheckBox>(JCheckBox.class) {
            protected boolean isMatching(JCheckBox checkBox) {
                return checkBox.getText().equals("Fit Width");
            }
        };

        JCheckBoxFixture fitWidthChbx = editor.checkBox(jCheckboxByTextMatcher6);
        fitWidthChbx.click();

        Thread.sleep(5000);
    }


}
