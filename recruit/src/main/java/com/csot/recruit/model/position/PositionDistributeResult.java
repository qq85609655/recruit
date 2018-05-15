package com.csot.recruit.model.position;

import java.io.Serializable;

/**
 * 用于调用职位分发接口后接收返回信息
 * @author honglu     {"Result":false,"FailedReason":"验证码错误","ExceptionMessage":null,"ErrorCode":0}
 *
 */
public class PositionDistributeResult implements Serializable {
  
  private static final long serialVersionUID = 1L;

  private String result;
  
  private String failedReason;
  
  // 这个属性还不清楚具体类型，暂用str
  private String exceptionMessage;
  
  private int errorCode;

  /**
   * @return the result
   */
  public String getResult() {
    return result;
  }

  /**
   * @param result the result to set
   */
  public void setResult(String result) {
    this.result = result;
  }

  /**
   * @return the failedReason
   */
  public String getFailedReason() {
    return failedReason;
  }

  /**
   * @param failedReason the failedReason to set
   */
  public void setFailedReason(String failedReason) {
    this.failedReason = failedReason;
  }

  /**
   * @return the exceptionMessage
   */
  public String getExceptionMessage() {
    return exceptionMessage;
  }

  /**
   * @param exceptionMessage the exceptionMessage to set
   */
  public void setExceptionMessage(String exceptionMessage) {
    this.exceptionMessage = exceptionMessage;
  }

  /**
   * @return the errorCode
   */
  public int getErrorCode() {
    return errorCode;
  }

  /**
   * @param errorCode the errorCode to set
   */
  public void setErrorCode(int errorCode) {
    this.errorCode = errorCode;
  }
}
