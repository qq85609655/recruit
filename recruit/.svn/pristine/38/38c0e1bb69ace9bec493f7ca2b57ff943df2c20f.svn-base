package org.amberframework.core.mybatis.pojo;

import java.io.Serializable;

public class Page implements Serializable {

  private static final long serialVersionUID = 24096182070948965L;

  /** 分页查询起始位置，最小从0开始 */
  private int begin;
  /** 分页查询结束位置 */
  private int end;
  /** 每页显示记录数，不能为0 */
  private int length;
  /** 查询结果总记录数 */
  private int total;
  /** 当前页码 */
  private int current;
  /** 总页数 */
  private int count;
  
  private Page(Builder builder) {
    this.begin = builder.begin;
    this.end = builder.end;
    this.length = builder.length;
    this.total = builder.total;
    this.current = builder.current;
    this.count = builder.count;
  }

  /**
   * 根据记录起始位置，生成分页文件.
   * 
   * @param begin 从0开始算
   * @param length 须大于0
   * @return 分页对象
   */
  public static Page newInstanceWithBegin(int begin, int length) {
    return new Page.Builder(length).buildWithBegin(begin);
  }

  /**
   * 根据当前页号，生成分页文件，index从0开始.
   * 
   * @param current 从0开始算
   * @param length 须大于0
   * @return 分页对象
   */
  public static Page newInstanceWithPageIndex(int current, int length) {
    return new Page.Builder(length).buildWithPageIndex(current);
  }
  
  private static class Builder {
    private int begin;
    private int end;
    private int length;
    private int total;
    private int current;
    private int count;

    /** length:每页显示记录数，不能为0 */
    public Builder(int length) {
      if (0 == length) {
        this.length = 1;
      } else {
        this.length = length;
      }
    }

    /** 分页查询起始位置，最小从0开始 */
    public Builder begin(int begin) {
      this.begin = begin;
      return this;
    }

    /** 分页查询结束位置 */
    public Builder end(int end) {
      this.end = end;
      return this;
    }

    /** 查询结果总记录数 */
    public Builder total(int total) {
      this.total = total;
      return this;
    }

    /** 当前页码 */
    public Builder current(int current) {
      this.current = current;
      return this;
    }

    /** 总页数 */
    public Builder count(int count) {
      this.count = count;
      return this;
    }

    /**
     * 根据记录起始位置，生成分页文件.
     * 
     * @param begin 从0开始算
     * @return 分页对象
     */
    public Page buildWithBegin(int begin) {
      this.begin = begin;
      this.end = this.begin + this.length;
      this.current = (int) Math.floor((this.begin * 1.0d) / this.length) + 1;
      return new Page(this);
    }

    /**
     * 根据当前页号，生成分页文件，index从0开始.
     * 
     * @param current 从0开始算
     * @return 分页对象
     */
    public Page buildWithPageIndex(int current) {
      this.current = current;
      this.begin = this.current * this.length;
      this.end = this.begin + this.length;
      return new Page(this);
    }
  }

  /** 分页查询起始位置，最小从0开始 */
  public int getBegin() {
    return begin;
  }

  /** 分页查询起始位置，最小从0开始 */
  public void setBegin(int begin) {
    this.begin = begin;
  }

  /** 分页查询结束位置 */
  public int getEnd() {
    return end;
  }

  /** 分页查询结束位置 */
  public void setEnd(int end) {
    this.end = end;
  }

  /** 每页显示记录数，不能为0 */
  public int getLength() {
    return length;
  }

  /** 每页显示记录数，不能为0 */
  public void setLength(int length) {
    this.length = length;
  }

  /** 总页数 */
  public int getCount() {
    return count;
  }

  /** 总页数 */
  public void setCount(int count) {
    this.count = count;
  }

  /** 当前页码，从0开始算起 */
  public int getCurrent() {
    return current;
  }

  /** 当前页码，从0开始算起 */
  public void setCurrent(int curent) {
    this.current = curent;
  }

  /** 查询结果总记录数 */
  public int getTotal() {
    return total;
  }

  /** 查询结果总记录数 */
  public void setTotal(int total) {
    this.total = total;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 17;
    result = result * prime + begin;
    result = result * prime + end;
    result = result * prime + length;
    result = result * prime + total;
    result = result * prime + current;
    result = result * prime + count;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    
    if (obj == null) {
      return false;
    }
    
    if (this.getClass() != obj.getClass()) {
      return false;
    }
    
    Page page = (Page)obj;
    
    if (this.getBegin() != page.getBegin()) {
      return false;
    }
    if (this.getEnd() != page.getEnd()) {
      return false;
    }
    if (this.getLength() != page.getLength()) {
      return false;
    }
    if (this.getTotal() != page.getTotal()) {
      return false;
    }
    if (this.getCurrent() != page.getCurrent()) {
      return false;
    }
    if (this.getCount() != page.getCount()) {
      return false;
    }
    
    return true;
  }
}
