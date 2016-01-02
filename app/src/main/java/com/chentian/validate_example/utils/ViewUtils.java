package com.chentian.validate_example.utils;

import android.widget.RadioGroup;

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
}
