package com.chentian.validate_example.validate;

import java.util.List;

import java8.util.stream.StreamSupport;

/**
 * 可校验对象的集合
 *
 * @author chentian
 */
public class ValidateItemViewCollection {

  private List<ValidateItemView> validateItemViewList;

  public ValidateItemViewCollection(List<ValidateItemView> validateItemViewList) {
    this.validateItemViewList = validateItemViewList;
  }

  public boolean validate() {
    return !StreamSupport.stream(validateItemViewList).anyMatch(itemView -> !itemView.validate());
  }
}
