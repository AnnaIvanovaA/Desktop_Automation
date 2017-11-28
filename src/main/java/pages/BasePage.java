package pages;

import org.fest.swing.core.GenericTypeMatcher;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.fixture.JToolBarFixture;

import javax.swing.*;

/**
 * Created by Anna on 21.11.2017.
 */
public class BasePage {

    static FrameFixture editor;

    public BasePage(FrameFixture editor) {
        this.editor = editor;
    }

    public void openDemo(final String demoName) throws InterruptedException {
        Thread.sleep(1000);
        JToolBarFixture toolBar = editor.toolBar();


        // open jtable demo toggleBtn
        GenericTypeMatcher<JToggleButton> jToggleBtnMatcher = new GenericTypeMatcher<JToggleButton>(JToggleButton.class) {
            protected boolean isMatching(JToggleButton toggleBtn) {
                return toggleBtn.getToolTipText().equals(demoName);
            }
        };
        toolBar.toggleButton(jToggleBtnMatcher).click();
    }

}
