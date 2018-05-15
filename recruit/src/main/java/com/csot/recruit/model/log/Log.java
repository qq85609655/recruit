package com.csot.recruit.model.log;

import java.io.Serializable;
import java.util.Date;

public class Log implements Serializable {
    private String logid;

    private String broswer;

    private String logcontent;

    private Integer loglevel;
    
    // 隐私级别 
    private Integer privacylevel;

    private String note;

    private Date operatetime;
    
    // 与当前时间差 用于显示
    private String time;

    private String operatetype;

    private String account;
    
    // 被操作对象的id
    private String operand;

    private static final long serialVersionUID = 1L;
    
    public Log(){};
    
    public Log(String userName, String operatetype, String logcontent) {
      this.operatetype = operatetype;
      this.operatetime = new Date();
      this.account = userName;
      this.logcontent = logcontent;
    }

    public String getLogid() {
        return logid;
    }

    public void setLogid(String logid) {
        this.logid = logid;
    }

    public String getBroswer() {
        return broswer;
    }

    public void setBroswer(String broswer) {
        this.broswer = broswer;
    }

    public String getLogcontent() {
        return logcontent;
    }

    public void setLogcontent(String logcontent) {
        this.logcontent = logcontent;
    }

    public Integer getLoglevel() {
        return loglevel;
    }

    public void setLoglevel(Integer loglevel) {
        this.loglevel = loglevel;
    }

    public Integer getPrivacylevel() {
      return privacylevel;
    }

    public void setPrivacylevel(Integer privacylevel) {
      this.privacylevel = privacylevel;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getOperatetime() {
        return operatetime;
    }

    public void setOperatetime(Date operatetime) {
        this.operatetime = operatetime;
    }

    public String getTime() {
      return time;
    }

    public void setTime(String time) {
      this.time = time;
    }

    public String getOperatetype() {
        return operatetype;
    }

    public void setOperatetype(String operatetype) {
        this.operatetype = operatetype;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String userName) {
        this.account = userName;
    }

    public String getOperand() {
      return operand;
    }

    public void setOperand(String operand) {
      this.operand = operand;
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
        Log other = (Log) that;
        return (this.getLogid() == null ? other.getLogid() == null : this.getLogid().equals(other.getLogid()))
            && (this.getBroswer() == null ? other.getBroswer() == null : this.getBroswer().equals(other.getBroswer()))
            && (this.getLogcontent() == null ? other.getLogcontent() == null : this.getLogcontent().equals(other.getLogcontent()))
            && (this.getLoglevel() == null ? other.getLoglevel() == null : this.getLoglevel().equals(other.getLoglevel()))
            && (this.getNote() == null ? other.getNote() == null : this.getNote().equals(other.getNote()))
            && (this.getOperatetime() == null ? other.getOperatetime() == null : this.getOperatetime().equals(other.getOperatetime()))
            && (this.getOperatetype() == null ? other.getOperatetype() == null : this.getOperatetype().equals(other.getOperatetype()))
            && (this.getAccount() == null ? other.getAccount() == null : this.getAccount().equals(other.getAccount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getLogid() == null) ? 0 : getLogid().hashCode());
        result = prime * result + ((getBroswer() == null) ? 0 : getBroswer().hashCode());
        result = prime * result + ((getLogcontent() == null) ? 0 : getLogcontent().hashCode());
        result = prime * result + ((getLoglevel() == null) ? 0 : getLoglevel().hashCode());
        result = prime * result + ((getNote() == null) ? 0 : getNote().hashCode());
        result = prime * result + ((getOperatetime() == null) ? 0 : getOperatetime().hashCode());
        result = prime * result + ((getOperatetype() == null) ? 0 : getOperatetype().hashCode());
        result = prime * result + ((getAccount() == null) ? 0 : getAccount().hashCode());
        return result;
    }
}