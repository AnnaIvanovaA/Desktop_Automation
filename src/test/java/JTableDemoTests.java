import objectModel.Filters;
import org.junit.Before;
import org.junit.Test;
import pages.BasePage;
import pages.JTableDemoPage;

/**
 * Created by Anna on 26.11.2017.
 */
public class JTableDemoTests extends BasePageTest {

    private String reorderingChbx = Filters.Checkbox.REORDERING.getDescription();
    private String horinzLinesChbx = Filters.Checkbox.HORIZ_LINES.getDescription();

    private Filters.Slider interCellSlider = Filters.Slider.INTER_CELL_SPACING;

    private Filters.Dropdown selectionModeDrdwn = Filters.Dropdown.SELECTION_MODE;
    private Filters.Dropdown autoresizeModeDrdwn = Filters.Dropdown.AUTORESIZE_MODE;

    private String singleSelModeValue = Filters.SelectionModeDropdown.SINGLE.getDescription();
    private String oneRangeSelModeValue = Filters.SelectionModeDropdown.ONE_RANGE.getDescription();
    private String multipleRangeSelModeValue = Filters.SelectionModeDropdown.MUTLIPLE_RANGES.getDescription();



    BasePage basePage;
    JTableDemoPage jTableDemoPage;


    @Before
    public void init() throws InterruptedException {
       basePage = new BasePage(editor);
        jTableDemoPage = new JTableDemoPage(editor);
        basePage.openDemo("JTable demo");
    }

    @Test
    public void selectFilterCheckbox() throws InterruptedException {
        jTableDemoPage.pressCheckbox(reorderingChbx);
        Thread.sleep(3000);
    }

    @Test
    public void selectSlider()throws InterruptedException{
        jTableDemoPage.selectSlider(interCellSlider);
    }

    @Test
    public void input() throws InterruptedException {
        jTableDemoPage.inputText();
    }

    @Test
    public void clickPrint() throws InterruptedException {
        jTableDemoPage.clickPrint();

    }

    @Test
    public void table() throws InterruptedException{
        jTableDemoPage.selectSection(0, 0, 0, 5);
    }

    @Test
    public void singleSelectionModeTest() throws InterruptedException {
        jTableDemoPage.selectValueInDropdown(selectionModeDrdwn, singleSelModeValue);
        jTableDemoPage.selectSection(0, 0, 0, 5);
    }

    @Test
    public void oneRangeSelectionModeTest() throws InterruptedException {
        jTableDemoPage.selectValueInDropdown(selectionModeDrdwn, oneRangeSelModeValue);
        jTableDemoPage.selectSection(0, 0, 0, 5);
    }

    @Test
    public void multipleRangeSelectionModeTest() throws InterruptedException {
        jTableDemoPage.selectValueInDropdown(selectionModeDrdwn, multipleRangeSelModeValue);
        jTableDemoPage.selectSection(0, 0, 0, 5);
        jTableDemoPage.addSection(0, 7,0,9);
    }
}
