package com.chentian.validate_example.utils;

import android.text.TextUtils;

/**
 * 校验用户输入的合法性
 *
 * @author chentian
 */
public class ValidateUtils {

  private static final int MIN_NAME_LENGTH = 2;

  private ValidateUtils() {}

  /**
   * 校验输入的姓名
   * 不为空，且长度大于 2
   */
  public static boolean checkName(String name) {
    return !TextUtils.isEmpty(name) && name.length() > MIN_NAME_LENGTH;
  }

  public static boolean checkPinyin(String pinyin) {
    return !TextUtils.isEmpty(pinyin);
  }

  public static boolean checkEmail(String email) {
    return !TextUtils.isEmpty(email);
  }
}
