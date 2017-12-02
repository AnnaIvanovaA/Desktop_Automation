package objectModel;

import org.fest.swing.core.GenericTypeMatcher;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;

/**
 * Created by Anna on 02.12.2017.
 */
public class Matchers{

    public static GenericTypeMatcher<JCheckBox> getCheckBoxByTextMatcher(final String checkboxName) {
        return new GenericTypeMatcher<JCheckBox>(JCheckBox.class) {
            protected boolean isMatching(JCheckBox checkBox) {
                return checkBox.getText().equals(checkboxName);
            }
        };
    }

    public static GenericTypeMatcher<JComboBox> getComboboxByDefaultValueMatcher(final Filters.Dropdown dropdown){
        return new GenericTypeMatcher<JComboBox>(JComboBox.class) {
            protected boolean isMatching(JComboBox combobox) {
                return combobox.getSelectedItem().equals(dropdown.getDefaultValue());
            }
        };
    }

    public static GenericTypeMatcher<JSlider> getSliderByMaxValueMatcher(final Filters.Slider sliderName){
        return new GenericTypeMatcher<JSlider>(JSlider.class) {
            protected boolean isMatching(JSlider slider) {
                return slider.getMaximum() == sliderName.getMaxValue();
            }
        };
    }

    public static GenericTypeMatcher<JTextComponent> getTextFieldByDefaultValueMatcher(final String defaultText){
        return new GenericTypeMatcher<JTextComponent>(JTextComponent.class) {
            protected boolean isMatching(JTextComponent textComponent) {
                return textComponent.getText().equals(defaultText);
            }
        };
    }

    public static GenericTypeMatcher<JButton> getButtonByTextMatcher(final String btnText){
        return new GenericTypeMatcher<JButton>(JButton.class) {
            protected boolean isMatching(JButton btn) {
                return btn.getText().equals(btnText);
            }
        };
    }

    //TODO
    //one generic matcher for all components
    public static <T> GenericTypeMatcher<? extends Component> getMatcher(Class<T> supportedType, Object parameter){
        if (supportedType.equals(JSlider.class)){

        }
        return null;
    }



}
