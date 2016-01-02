package com.chentian.validate_example.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Utils to operate collections
 *
 * @author chentian
 */
@SuppressWarnings("unused")
public class CollectionUtils {

  private CollectionUtils() {}

  public static boolean isEmpty(Collection<?> collection) {
    return collection == null || collection.isEmpty();
  }

  public static <T> boolean isEmpty(T[] array) {
    return array == null || array.length == 0;
  }

  /**
   * Sub the list without exception
   */
  public static <T> List<T> safeSubList(List<T> list, int start, int end) {
    if (start >= list.size()) {
      return Collections.emptyList();
    }
    return list.subList(start, Math.min(end, list.size()));
  }

  /**
   * If list is null, change to empty list
   */
  public static <T> List<T> notNull(List<T> list) {
    if (list == null) {
      return Collections.emptyList();
    }
    return list;
  }
}
