package pages;

import objectModel.Filters;
import objectModel.Matchers;
import org.fest.swing.fixture.*;

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

    public void pressCheckbox(String checkboxName) {
        JCheckBoxFixture checkBox = editor.checkBox(Matchers.getCheckBoxByTextMatcher(checkboxName));
        checkBox.click();
    }

    public void selectValueInDropdown(Filters.Dropdown dropdown, String value) {
        JComboBoxFixture combobox = editor.comboBox(Matchers.getComboboxByDefaultValueMatcher(dropdown));
        combobox.selectItem(value);
    }

    public void selectSlider(Filters.Slider sliderName, Double partOfMax){
        JSliderFixture slider = editor.slider(Matchers.getSliderByMaxValueMatcher(sliderName));
        Double valueD = sliderName.getMaxValue()*partOfMax;
        slider.slideTo(valueD.intValue());

    }

    public void inputText(String oldValue, String newValue){
        JTextComponentFixture jText = editor.textBox(Matchers.getTextFieldByDefaultValueMatcher(oldValue));
        jText.deleteText().enterText(newValue);
    }

    public void clickOnBtn(String btnText) {
        JButtonFixture printBtn = editor.button(Matchers.getButtonByTextMatcher(btnText));
        printBtn.click();
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

    public void selectRows(int y1, int y2){
        JTableFixture table = editor.table();
        table.selectRows(y1, y2);

    }

    public void selectCell(int x, int y){
        JTableFixture table = editor.table();
        table.cell(row(y).column(x)).click();
    }

    public void selectSection(int x1, int y1, int x2, int y2){
        JTableFixture table = editor.table();
        table.cell(row(y1).column(x1)).click();
        table.pressKey(KeyEvent.VK_SHIFT);
        table.cell(row(y2).column(x2)).click();
        table.releaseKey(KeyEvent.VK_SHIFT);
    }

    public void addSection(int x1, int y1, int x2, int y2){
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

    public void checkRowHeight(int x1, int y1, int x2, int y2){
        JTableFixture table = editor.table();


    }

}
