package com.csot.recruit.soa.handler;

import org.apache.wss4j.common.ext.WSPasswordCallback;

import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.UnsupportedCallbackException;
import java.io.IOException;

/**
 * ESB用户密码验证的加密处理Handler
 * Created by WangYu on 2016/1/27.
 */
public class AuthClientPasswordHandler implements CallbackHandler {

  private String passwd;

  public AuthClientPasswordHandler(String passwd) {
    this.passwd = passwd;
  }

  @Override public void handle(Callback[] callbacks)
      throws IOException, UnsupportedCallbackException {
    WSPasswordCallback pc = (WSPasswordCallback) callbacks[0];
    pc.setPassword(this.passwd);
  }
}
