package objectModel;

/**
 * Created by Anna on 26.11.2017.
 */
public class Filters {

    public enum Checkbox{
        REORDERING("Reordering allowed"),
        HORIZ_LINES("Horiz. Lines"),
        VERT_LINES("Vert. Lines"),
        ROW_SELECTION("Row selection"),
        COLUMN_SELECTION("Column selection"),
        FIT_WIDTH("Fit Width");

        private String description;

        private Checkbox(String description){
            this.description = description;
        }

        public String getDescription(){
            return description;
        }
    }

    public enum Slider{
        INTER_CELL_SPACING(10),
        ROW_HEIGHT(100);

        private int maxValue;

        private Slider(int maxValue){
            this.maxValue = maxValue;
        }

        public int getMaxValue(){
            return maxValue;
        }
    }


    public enum SelectionModeDropdown{
        SINGLE("Single"),
        ONE_RANGE("One range"),
        MUTLIPLE_RANGES("Multiple ranges");

        private String description;
        private SelectionModeDropdown(String description){
            this.description = description;
        }

        public String getDescription(){
            return description;
        }

        public String getSelected(){
            return MUTLIPLE_RANGES.getDescription();
        }
    }

    public enum AutoresizeModeDropdown{
        OFF("Off"),
        COLUMN_BOUNDARIES("Column boundaries"),
        SUBSEQUENT_COLUMNS("Subsequent columns"),
        LAST_COLUMN("Last column"),
        ALL_COLUMNS("All columns");

        private String description;
        private AutoresizeModeDropdown(String description){
            this.description = description;
        }

        public String getDescription(){
            return description;
        }

        public String getSelected(){
            return SUBSEQUENT_COLUMNS.getDescription();
        }
    }

}
