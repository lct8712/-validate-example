package com.chentian.validate_example.validate;

import java.util.List;

import android.support.annotation.StringRes;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.chentian.validate_example.utils.CollectionUtils;
import com.chentian.validate_example.utils.ViewUtils;

/**
 * 可被校验的 view 对象
 *
 * @author chentian
 */
public interface ValidateItemView {

  boolean validate();

  class TextViewItem implements ValidateItemView {

    private TextView textView;
    private ValidateMode validateMode;
    private @StringRes int errorTipResId;

    public TextViewItem(TextView textView, ValidateMode validateMode, int errorTipResId) {
      this.textView = textView;
      this.validateMode = validateMode;
      this.errorTipResId = errorTipResId;

      textView.setOnFocusChangeListener((v, hasFocus) -> {
        if (!hasFocus) {
          validate();
        }
      });
    }

    @Override
    public boolean validate() {
      if (validateMode.validate(textView.getText().toString())) {
        return true;
      }

      Toast.makeText(textView.getContext(), errorTipResId, Toast.LENGTH_SHORT).show();
      return false;
    }
  }

  class RadioGroupItem implements ValidateItemView {

    private RadioGroup radioGroup;
    private @StringRes int errorTipResId;

    public RadioGroupItem(RadioGroup radioGroup, int errorTipResId) {
      this.radioGroup = radioGroup;
      this.errorTipResId = errorTipResId;
    }

    @Override
    public boolean validate() {
      if (ViewUtils.isRadioGroupSelected(radioGroup)) {
        return true;
      }

      Toast.makeText(radioGroup.getContext(), errorTipResId, Toast.LENGTH_SHORT).show();
      return false;
    }
  }

  class CheckBoxItem implements ValidateItemView {

    private List<CheckBox> checkBoxList;
    private @StringRes int errorTipResId;

    public CheckBoxItem(List<CheckBox> checkBoxList, int errorTipResId) {
      if (CollectionUtils.isEmpty(checkBoxList)) {
        throw new IllegalArgumentException("check box list should not be empty");
      }

      this.checkBoxList = checkBoxList;
      this.errorTipResId = errorTipResId;
    }

    @Override
    public boolean validate() {
      if (ViewUtils.isCheckBoxSelected(checkBoxList)) {
        return true;
      }

      Toast.makeText(checkBoxList.get(0).getContext(), errorTipResId, Toast.LENGTH_SHORT).show();
      return false;
    }
  }
}
