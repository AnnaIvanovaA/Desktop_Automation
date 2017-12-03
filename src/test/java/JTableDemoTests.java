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
    private String horizLinesChbx = Filters.Checkbox.HORIZ_LINES.getDescription();
    private String vertLinesChbx = Filters.Checkbox.VERT_LINES.getDescription();
    private String rowSelectionChbx = Filters.Checkbox.ROW_SELECTION.getDescription();
    private String columnSelectionChbx = Filters.Checkbox.COLUMN_SELECTION.getDescription();
    private String firWidthChbx = Filters.Checkbox.FIT_WIDTH.getDescription();

    private Filters.Slider interCellSlider = Filters.Slider.INTER_CELL_SPACING;
    private Filters.Slider rowHeightSlider = Filters.Slider.ROW_HEIGHT;

    private Filters.Dropdown selectionModeDrdwn = Filters.Dropdown.SELECTION_MODE;
    private Filters.Dropdown autoresizeModeDrdwn = Filters.Dropdown.AUTORESIZE_MODE;

    private String singleSelModeValue = Filters.SelectionModeDropdown.SINGLE.getDescription();
    private String oneRangeSelModeValue = Filters.SelectionModeDropdown.ONE_RANGE.getDescription();
    private String multipleRangeSelModeValue = Filters.SelectionModeDropdown.MUTLIPLE_RANGES.getDescription();

    private Color selectedCellBackgroundColor = new Color(184, 207, 229);
    private Color notSelectedCellBackgroundColor = new Color(255,255,255);



    BasePage basePage;
    JTableDemoPage jTableDemoPage;

    @Before
    public void init() {
       basePage = new BasePage(editor);
        jTableDemoPage = new JTableDemoPage(editor);
        basePage.openDemo("JTable demo");
    }

    @Test
    public void reorderingCheckboxTest(){
        jTableDemoPage.pressCheckbox(reorderingChbx);

        //TODO add assert
    }

    @Test
    public void horizLinesCheckboxTest(){
        jTableDemoPage.pressCheckbox(horizLinesChbx);

        //TODO add assert that horizontal lines in the table are not displayed
    }

    @Test
    public void verticalLinesCheckboxTest(){
        jTableDemoPage.pressCheckbox(vertLinesChbx);

        //TODO add assert that vertical lines in the table are not displayed
    }

    @Test
    public void interCellSpacingSliderTest(){
        jTableDemoPage.selectSlider(interCellSlider, 0.75);

        //TODO add table cells format check
    }

    @Test
    public void rowHeightSliderTest(){
        jTableDemoPage.selectSlider(rowHeightSlider, 0.60);

        //TODO add table cells format check
    }

    //@Test
    public void printingPanelTest(){
        String oldValueHeader = "JTable Printing";
        String oldValueFooter = "Page {0}";
        String newValueFooter = "Some new text";
        String newValueHeader = "Table Header";
        jTableDemoPage.inputText(oldValueHeader, newValueHeader);
        jTableDemoPage.inputText(oldValueFooter, newValueFooter);

        jTableDemoPage.pressCheckbox(firWidthChbx);

        String btnText = "Print";
        jTableDemoPage.clickOnBtn(btnText);

        //TODO add check that new window was opened
    }

    @Test
    public void table() throws InterruptedException{
        jTableDemoPage.selectSection(0, 0, 0, 5);
    }

    @Test
    public void singleSelectionModeTest() {
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
    public void oneRangeSelectionModeTest() {
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
    public void oneRangeSelectionModeWithTwoSectionsTest() {
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
    public void multipleRangeSelectionModeTest() {
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

    @Test
    public void columnSingleSelectionTest() {
        //unselect selected by default checkbox
        jTableDemoPage.pressCheckbox(rowSelectionChbx);
        //select column selection
        jTableDemoPage.pressCheckbox(columnSelectionChbx);

        jTableDemoPage.selectCell(3,5);

        //check that all cells in this column was selected
        checkSectionIsSelected(3,0,3,jTableDemoPage.getNumberOfRows()-1);

        checkSectionIsNotSelected(0,0,2,jTableDemoPage.getNumberOfRows()-1);
        checkSectionIsNotSelected(4,0,5,jTableDemoPage.getNumberOfRows()-1);
    }

    @Test
    public void columnOneRangeSelectionTest(){
        //deselect selected by default checkbox
        jTableDemoPage.pressCheckbox(rowSelectionChbx);
        //select column selection
        jTableDemoPage.pressCheckbox(columnSelectionChbx);

        //select section (1,2)-(3,2) -- 3 columns should be selected
        jTableDemoPage.selectSection(1,2,3,2);

        checkSectionIsSelected(1,0,3,jTableDemoPage.getNumberOfRows()-1);

        checkSectionIsNotSelected(0,0,0,jTableDemoPage.getNumberOfRows()-1);
        checkSectionIsNotSelected(4,0,5,jTableDemoPage.getNumberOfRows()-1);
    }

    @Test
    public void columnMultipleRangeSelectionTest(){
        //deselect selected by default checkbox
        jTableDemoPage.pressCheckbox(rowSelectionChbx);
        //select column selection
        jTableDemoPage.pressCheckbox(columnSelectionChbx);

        //select section (0,0)-(1,0) -- 2 columns should be selected
        // add another column (5,0)
        jTableDemoPage.selectSection(0,0,1,0);
        jTableDemoPage.addSection(5,0, 5,0);

        checkSectionIsSelected(0,0,1,jTableDemoPage.getNumberOfRows()-1);
        checkSectionIsSelected(5,0,5,jTableDemoPage.getNumberOfRows()-1);

        checkSectionIsNotSelected(2,0,4,jTableDemoPage.getNumberOfRows()-1);
    }

    @Test
    public void rowAndColumnMultipleSelectionTest() {
        //select column selection, row selection is selected by default
        jTableDemoPage.pressCheckbox(columnSelectionChbx);

        //select section (0,0)-(3,3) -- 16 cells should be selected
        jTableDemoPage.selectSection(0,0,3,3);
        checkSectionIsSelected(0,0,3,3);
        checkSectionIsNotSelected(4,0,5,3);

        // add another section (4,6)-(5,7) -- 6 rows will be selected
        jTableDemoPage.addSection(4,6, 5,7);
        checkSectionIsSelected(0,0,5,3);
        checkSectionIsSelected(0,6,5,7);

        checkSectionIsNotSelected(0,4,5,5);
        checkSectionIsNotSelected(0,8,5,jTableDemoPage.getNumberOfRows()-1);

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
