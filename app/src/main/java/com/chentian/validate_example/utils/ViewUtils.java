package com.chentian.validate_example.utils;

import java.util.List;

import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import java8.util.stream.StreamSupport;

/**
 * View 相关的工具类
 *
 * @author chentian
 */
@SuppressWarnings("unused")
public class ViewUtils {

  private ViewUtils() {}

  /**
   * 获取 RadioGroup 选中的项
   *
   * @return 选中项的下标，如果无选中项则返回 -1
   */
  public static int getRadioSelectedIndex(RadioGroup radioGroup) {
    int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
    if (checkedRadioButtonId <= 0) {
      return -1;
    }
    return radioGroup.indexOfChild(radioGroup.findViewById(checkedRadioButtonId));
  }

  /**
   * 返回 RadioGroup 是否有至少一项被选中
   */
  public static boolean isRadioGroupSelected(RadioGroup radioGroup) {
    return getRadioSelectedIndex(radioGroup) >= 0;
  }

  /**
   * 返回一组 CheckBox 是否有至少一项被选中
   */
  public static boolean isCheckBoxSelected(List<CheckBox> checkBoxList) {
    return StreamSupport.stream(checkBoxList).filter(CompoundButton::isChecked).count() > 0;
  }
}
