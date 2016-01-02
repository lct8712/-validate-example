package com.chentian.validate_example.validate;

import com.chentian.validate_example.utils.ValidateUtils;

/**
 * 可以对字符串做各种校验的类型
 *
 * @author chentian
 */
public interface ValidateMode {

  boolean validate(String value);

  /**
   * 校验姓名
   */
  class Name implements ValidateMode {

    @Override
    public boolean validate(String value) {
      return ValidateUtils.checkName(value);
    }
  }

  /**
   * 校验拼音
   */
  class Pinyin implements ValidateMode {

    @Override
    public boolean validate(String value) {
      return ValidateUtils.checkPinyin(value);
    }
  }

  /**
   * 校验邮箱
   */
  class Email implements ValidateMode {

    @Override
    public boolean validate(String value) {
      return ValidateUtils.checkEmail(value);
    }
  }
}
