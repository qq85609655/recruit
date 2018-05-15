package org.amberframework.web.miniui.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 实现Serializable.
 * 
 * @param <T extends Serializable> data属性中集合元素的泛型.
 */
public class MiniRtn2Grid<T extends Serializable> implements Serializable {

  private static final long serialVersionUID = 1L;

  private List<T> data;

  private int total;

  public List<T> getData() {
    return data;
  }

  public void setData(List<T> data) {
    this.data = data;
  }

  public int getTotal() {
    return total;
  }

  public void setTotal(int total) {
    this.total = total;
  }
}
