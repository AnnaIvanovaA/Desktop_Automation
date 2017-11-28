package pages;

import objectModel.Filters;
import org.fest.swing.core.GenericTypeMatcher;
import org.fest.swing.fixture.*;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import static org.fest.swing.data.TableCell.row;

/**
 * Created by Anna on 26.11.2017.
 */
public class JTableDemoPage extends BasePage {

    //FrameFixture editor;


    public JTableDemoPage(FrameFixture editor) {
        super(editor);
    }

    public void pressCheckbox(final String checkboxName) throws InterruptedException {
        GenericTypeMatcher<JCheckBox> jCheckboxByTextMatcher = new GenericTypeMatcher<JCheckBox>(JCheckBox.class) {
            protected boolean isMatching(JCheckBox checkBox) {
                return checkBox.getText().equals(checkboxName);
            }
        };
        JCheckBoxFixture checkBox = editor.checkBox(jCheckboxByTextMatcher);
        checkBox.click();

        Thread.sleep(1000);
    }

    public void selectValueInDropdown() throws InterruptedException {

        GenericTypeMatcher<JComboBox> jComboboxByDefaultValueMatcher = new GenericTypeMatcher<JComboBox>(JComboBox.class) {
            protected boolean isMatching(JComboBox combobox) {
                return combobox.getSelectedItem().equals("Multiple ranges");
            }
        };
        JComboBoxFixture combobox = editor.comboBox(jComboboxByDefaultValueMatcher);
        combobox.selectItem("One range");

        GenericTypeMatcher<JComboBox> jComboboxByDefaultValueMatcher2 = new GenericTypeMatcher<JComboBox>(JComboBox.class) {
            protected boolean isMatching(JComboBox combobox) {
                return combobox.getSelectedItem().equals("Subsequent columns");
            }
        };
        JComboBoxFixture combobox2 = editor.comboBox(jComboboxByDefaultValueMatcher2);
        combobox2.selectItem("Column boundaries");

        Thread.sleep(5000);

    }

    public void selectSlider(final Filters.Slider sliderName) throws InterruptedException {


        GenericTypeMatcher<JSlider> jSliderByMaxValuesMatcher = new GenericTypeMatcher<JSlider>(JSlider.class) {
            protected boolean isMatching(JSlider slider) {
                return slider.getMaximum() == sliderName.getMaxValue();
            }
        };

        JSliderFixture slider = editor.slider(jSliderByMaxValuesMatcher);
        slider.slideToMaximum();
        Thread.sleep(5000);

    }

    public void inputText() throws InterruptedException {

//        GenericTypeMatcher<JPanel> jPanelMatcher = new GenericTypeMatcher<JPanel>(JPanel.class) {
//            protected boolean isMatching(JPanel panel) {
//                //return textComponent.getText().equals("JTable Printing");
//                return panel.getBorder().toString().equals(null);
//            }
//        };
//        JPanelFixture panel = editor.panel(jPanelMatcher);

        GenericTypeMatcher<JTextComponent> jTextFieldMatcher = new GenericTypeMatcher<JTextComponent>(JTextComponent.class) {
            protected boolean isMatching(JTextComponent textComponent) {
                //return textComponent.getText().equals("JTable Printing");
                return textComponent.getText().equals("Page {0}");
            }
        };

        JTextComponentFixture jText = editor.textBox(jTextFieldMatcher);
        jText.deleteText().enterText("dsfsd");
        jText.enterText("qwert");
        Thread.sleep(5000);
    }

    public void clickPrint() throws InterruptedException {
        GenericTypeMatcher<JButton> jButtonMatcher = new GenericTypeMatcher<JButton>(JButton.class) {
            protected boolean isMatching(JButton btn) {
                //return textComponent.getText().equals("JTable Printing");
                return btn.getText().equals("Print");
            }
        };

        JButtonFixture printBtn = editor.button(jButtonMatcher);
        printBtn.click();
        Thread.sleep(5000);
    }

    public void table() throws InterruptedException{

        JTableFixture table = editor.table();
        table.enterValue(row(0).column(2), "Aqua");
        System.out.println((table.fontAt(row(0).column(0))).description());


        //table.selectRows(0).click().pressKey(MouseEvent.MOUSE_CLICKED).pressKey(KeyEvent.VK_DOWN).pressKey(KeyEvent.VK_DOWN);
        table.selectRows(0).click().pressKey(MouseEvent.MOUSE_CLICKED).pressKey(MouseEvent.MOUSE_DRAGGED).pressKey(KeyEvent.VK_DOWN);
        Thread.sleep(5000);
        JTableCellFixture cell = editor.table().cell(row(1).column(1));
        ColorFixture color = cell.background();
        //System.out.println(color.requireEqualTo("7fffd4"));
        System.out.println(color.toString());


        System.out.println((table.cell(row(0).column(2))).value());
        System.out.println((table.cell(row(0).column(5))).background().description());
        System.out.println((table.cell(row(0).column(2))).background().description());

        System.out.println(table.clientProperty("autoResizeMode"));


    }

}
