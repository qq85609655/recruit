package org.amberframework.web.system.model;

import java.io.Serializable;
import java.util.Date;

public class BaseUser implements Serializable {
    private String id;

    private String account;

    private String password;

    private String status;

    private String name;
    
    private String tel;
    
    private String cellphone;
    
    private Integer userOrgId;
    
    private String depId;
    
    private String userRoleId;
    
    private String roleId;
    
    private String roleName;
    
    private String deptName;
    
    private Date createTime;
    
    private String time;
    
    private String email;
    
    private String workCode;
    
    public String getWorkCode() {
      return workCode;
    }

    public void setWorkCode(String workCode) {
      this.workCode = workCode;
    }

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getTel() {
      return tel;
    }

    public void setTel(String tel) {
      this.tel = tel;
    }

    public String getCellphone() {
      return cellphone;
    }

    public void setCellphone(String cellphone) {
      this.cellphone = cellphone;
    }

    public String getDepId() {
      return depId;
    }

    public void setDepId(String depId) {
      this.depId = depId;
    }

    public String getRoleName() {
      return roleName;
    }

    public void setRoleName(String roleName) {
      this.roleName = roleName;
    }

    public String getDeptName() {
      return deptName;
    }

    public void setDeptName(String deptName) {
      this.deptName = deptName;
    }
    
    public Date getCreateTime() {
      return createTime;
    }

    public void setCreateTime(Date createTime) {
      this.createTime = createTime;
    }

    public String getTime() {
      return time;
    }

    public void setTime(String time) {
      this.time = time;
    }

    public Integer getUserOrgId() {
      return userOrgId;
    }

    public void setUserOrgId(Integer userOrgId) {
      this.userOrgId = userOrgId;
    }

    public String getUserRoleId() {
      return userRoleId;
    }

    public void setUserRoleId(String userRoleId) {
      this.userRoleId = userRoleId;
    }

    public String getRoleId() {
      return roleId;
    }

    public void setRoleId(String roleId) {
      this.roleId = roleId;
    }
    

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
        BaseUser other = (BaseUser) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}