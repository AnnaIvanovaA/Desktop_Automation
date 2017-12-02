import objectModel.Filters;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.BasePage;
import pages.JTableDemoPage;

import java.awt.*;

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

    Color selectedCellBackgroundColor = new Color(184, 207, 229);
    Color notSelectedCellBackgroundColor = new Color(255,255,255);



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
        // default row selection checkbox is selected + single selection mode in dropdown
        jTableDemoPage.selectValueInDropdown(selectionModeDrdwn, singleSelModeValue);

        //try select section (0,0)-(0,5) -- only 1 last row(4) should be selected
        jTableDemoPage.selectSection(0, 0, 0, 5);

        checkSectionIsSelected(0,5,5,5);

        //check that all rows expect 4 are NOT selected
        checkSectionIsNotSelected(0, 0,5, 4);
        checkSectionIsNotSelected(0, 6,5, jTableDemoPage.getNumberOfRows()-1);

    }

    @Test
    public void oneRangeSelectionModeTest() throws InterruptedException {
        // default row selection checkbox is selected + one range selection mode in dropdown
        jTableDemoPage.selectValueInDropdown(selectionModeDrdwn, oneRangeSelModeValue);

        //select section (0,2)-(0,11) -- all 10 rows should be selected
        jTableDemoPage.selectSection(0, 2, 0, 10);

        //check that all cells in section are selected
        checkSectionIsSelected(0,2,5,10);

        //check that all rows except 2-11 are NOT selected
        checkSectionIsNotSelected(0, 0,5, 1);
        checkSectionIsNotSelected(0, 11,5, jTableDemoPage.getNumberOfRows()-1);

    }

    @Test
    public void oneRangeSelectionModeWithTwoSectionsTest() throws InterruptedException {
        // default row selection checkbox is selected + one range selection mode in dropdown
        jTableDemoPage.selectValueInDropdown(selectionModeDrdwn, oneRangeSelModeValue);

        //select section (0,0)-(0,1) -- first 2 rows should be selected
        jTableDemoPage.selectSection(0, 0, 0, 1);

        //check that all cells in section are selected
        checkSectionIsSelected(0,0,5,1);

        //check that all rows except first two are NOT selected
        checkSectionIsNotSelected(0, 2,5, jTableDemoPage.getNumberOfRows()-1);

        //try to select another one section (0,4) - (0,8) -- first selection should disappear
        jTableDemoPage.addSection(0, 4, 0,8);

        //check that all cells in second section are selected
        checkSectionIsSelected(0,4,5,8);

        //check that fist section is NOT selected
        checkSectionIsNotSelected(0,0,5,1);

    }


    @Test
    public void multipleRangeSelectionModeTest() throws InterruptedException {
        // default row selection checkbox is selected + multiple range selection mode in dropdown
        jTableDemoPage.selectValueInDropdown(selectionModeDrdwn, multipleRangeSelModeValue);

        //select 3 sections: (0,2)-(0,4) -- 3 rows should be selected
        // (1,6) - (2,7) -- 2 rows
        //  (3,11) - (3,15) -- 5 rows
        jTableDemoPage.selectSection(0, 2, 0, 4);
        jTableDemoPage.addSection(1, 6, 1, 7);
        jTableDemoPage.addSection(3, 11, 3, 15);

        //check that all cells in sections are selected
        checkSectionIsSelected(0,2,5,4);
        checkSectionIsSelected(0, 6, 5, 7);
        checkSectionIsSelected(0, 11, 5, 15);

        //check that all other rows are NOT selected
        checkSectionIsNotSelected(0, 5,5, 5);
        checkSectionIsNotSelected(0, 8,5, 10);
        checkSectionIsNotSelected(0, 16,5, jTableDemoPage.getNumberOfRows()-1);
    }


    private void checkSectionIsSelected(int x1, int y1, int x2, int y2){
        //do not check column 3, because there are another backgrounds and cells could not be selected
        int dismissColumn = 2;

        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                if (j != dismissColumn) {
                    Assert.assertEquals(jTableDemoPage.getCellBackgroundColor(j, i), selectedCellBackgroundColor);
                }
            }
        }
    }

    private void checkSectionIsNotSelected(int x1, int y1, int x2, int y2){
        //do not check column 3, because there are another backgrounds and cells could not be selected
        int dismissColumn = 2;

        for (int i = y1; i <= y2; i++) {
            for (int j = x1; j <= x2; j++) {
                if (j != dismissColumn) {
                    Assert.assertEquals(jTableDemoPage.getCellBackgroundColor(j, i), notSelectedCellBackgroundColor);
                }
            }
        }
    }

}
