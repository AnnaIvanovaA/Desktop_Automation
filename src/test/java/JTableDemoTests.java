import objectModel.Filters;
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


//    static BasePage basePage;
//    static JTableDemoPage jTableDemoPage;
//
//
//    @BeforeClass
//    public static void init() throws InterruptedException {
//       basePage = new BasePage(editor);
//        jTableDemoPage = new JTableDemoPage(editor);
//        basePage.openDemo("JTable demo");
//    }

    @Test
    public void selectFilterCheckbox() throws InterruptedException {
        BasePage basePage = new BasePage(editor);
        basePage.openDemo("JTable demo");

        JTableDemoPage jTableDemoPage = new JTableDemoPage(editor);
        jTableDemoPage.pressCheckbox(reorderingChbx);
        Thread.sleep(3000);
    }

    @Test
    public void selectSlider()throws InterruptedException{
        BasePage basePage = new BasePage(editor);
        basePage.openDemo("JTable demo");

        JTableDemoPage jTableDemoPage = new JTableDemoPage(editor);
        jTableDemoPage.selectSlider(interCellSlider);
    }

    @Test
    public void selectDropdown()throws InterruptedException{
        BasePage basePage = new BasePage(editor);
        basePage.openDemo("JTable demo");

        JTableDemoPage jTableDemoPage = new JTableDemoPage(editor);
        jTableDemoPage.selectValueInDropdown();
    }

    @Test
    public void input() throws InterruptedException {
        BasePage basePage = new BasePage(editor);
        basePage.openDemo("JTable demo");

        JTableDemoPage jTableDemoPage = new JTableDemoPage(editor);
        jTableDemoPage.inputText();
    }

    @Test
    public void clickPrint() throws InterruptedException {
        BasePage basePage = new BasePage(editor);
        basePage.openDemo("JTable demo");

        JTableDemoPage jTableDemoPage = new JTableDemoPage(editor);
        jTableDemoPage.clickPrint();

    }

    @Test
    public void table() throws InterruptedException{
        BasePage basePage = new BasePage(editor);
        basePage.openDemo("JTable demo");

        JTableDemoPage jTableDemoPage = new JTableDemoPage(editor);
        jTableDemoPage.table();
    }

}
