package com.csot.gm.util;

import java.math.BigDecimal;

/**
 * Created by WangYu on 2015/11/5.
 */
public class PropTypeTestBean {
  private String name;
  private long id;
  private short age;
  private int identity;
  private double salary;
  private float height;
  private boolean gender;
  private char status;
  private BigDecimal savedMoney;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public short getAge() {
    return age;
  }

  public void setAge(short age) {
    this.age = age;
  }

  public int getIdentity() {
    return identity;
  }

  public void setIdentity(int identity) {
    this.identity = identity;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public float getHeight() {
    return height;
  }

  public void setHeight(float height) {
    this.height = height;
  }

  public boolean isGender() {
    return gender;
  }

  public void setGender(boolean gender) {
    this.gender = gender;
  }

  public char getStatus() {
    return status;
  }

  public void setStatus(char status) {
    this.status = status;
  }

  public BigDecimal getSavedMoney() {
    return savedMoney;
  }

  public void setSavedMoney(BigDecimal savedMoney) {
    this.savedMoney = savedMoney;
  }
}
