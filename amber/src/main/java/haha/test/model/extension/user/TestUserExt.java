package haha.test.model.extension.user;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TestUserExt implements Serializable {
  private String id;

  private String name;

  private String address;

  private Date birthday;

  private Integer age;

  private BigDecimal salary;

  private String workPlace;

  private static final long serialVersionUID = 1L;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  public String getWorkPlace() {
    return workPlace;
  }

  public void setWorkPlace(String workPlace) {
    this.workPlace = workPlace;
  }

  @Override
  public boolean equals(Object that) {
    if (this == that) {
      return true;
    }
    if (that == null) {
      return false;
    }
    if (getClass() != that.getClass()) {
      return false;
    }
    TestUserExt other = (TestUserExt) that;
    return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
        && (this.getName() == null ? other.getName() == null : this.getName().equals(
            other.getName()))
        && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(
            other.getAddress()))
        && (this.getBirthday() == null ? other.getBirthday() == null : this.getBirthday().equals(
            other.getBirthday()))
        && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
        && (this.getSalary() == null ? other.getSalary() == null : this.getSalary().equals(
            other.getSalary()))
        && (this.getWorkPlace() == null ? other.getWorkPlace() == null : this.getWorkPlace()
            .equals(other.getWorkPlace()));
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
    result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
    result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
    result = prime * result + ((getBirthday() == null) ? 0 : getBirthday().hashCode());
    result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
    result = prime * result + ((getSalary() == null) ? 0 : getSalary().hashCode());
    result = prime * result + ((getWorkPlace() == null) ? 0 : getWorkPlace().hashCode());
    return result;
  }
}
