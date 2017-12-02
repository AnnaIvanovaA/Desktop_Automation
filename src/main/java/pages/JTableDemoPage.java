package pages;

import objectModel.Filters;
import org.fest.swing.core.GenericTypeMatcher;
import org.fest.swing.fixture.*;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.KeyEvent;

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

    public void selectValueInDropdown(final Filters.Dropdown dropdown, String value) throws InterruptedException {

        GenericTypeMatcher<JComboBox> jComboboxByDefaultValueMatcher = new GenericTypeMatcher<JComboBox>(JComboBox.class) {
            protected boolean isMatching(JComboBox combobox) {
                return combobox.getSelectedItem().equals(dropdown.getDefaultValue());
            }
        };

        JComboBoxFixture combobox = editor.comboBox(jComboboxByDefaultValueMatcher);
        combobox.selectItem(value);

        Thread.sleep(2000);

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
        //table.selectRows(0).click().pressKey(MouseEvent.MOUSE_CLICKED).pressKey(MouseEvent.MOUSE_DRAGGED).pressKey(KeyEvent.VK_DOWN);

        table.selectRows(9).pressKey(KeyEvent.VK_SHIFT).click().releaseKey(KeyEvent.VK_SHIFT);
        //table.pressKey(KeyEvent.KEY_RELEASED);
        Thread.sleep(5000);

        JTableCellFixture cell = editor.table().cell(row(1).column(1));
        ColorFixture color = cell.background();
        //System.out.println(color.requireEqualTo("7fffd4"));
        System.out.println(color.toString());


        System.out.println((table.cell(row(0).column(2))).value());
        System.out.println((table.cell(row(0).column(5))).background().description());
        System.out.println((table.cell(row(0).column(2))).background().description());

        System.out.println(table.clientProperty("autoResizeMode"));

        editor.panel();
        Thread.sleep(5000);
    }


    public void selectSection(int x1, int y1, int x2, int y2) throws InterruptedException {
        JTableFixture table = editor.table();
        table.cell(row(y1).column(x1)).click();
        table.pressKey(KeyEvent.VK_SHIFT);
        table.cell(row(y2).column(x2)).click();
        table.releaseKey(KeyEvent.VK_SHIFT);
        Thread.sleep(2000);
    }

    public void addSection(int x1, int y1, int x2, int y2)throws InterruptedException{
        JTableFixture table = editor.table();
        table.pressKey(KeyEvent.VK_CONTROL);
        selectSection(x1, y1, x2, y2);
        table.releaseKey(KeyEvent.VK_CONTROL);
    }


    public Color getCellBackgroundColor(int x, int y){
        JTableFixture table = editor.table();
        return table.cell(row(y).column(x)).background().target();
    }

    public int getNumberOfRows(){
        return editor.table().rowCount();
    }

    public void selectTableHeaderSorting(){

    }

}
