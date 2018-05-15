package org.amberframework.web.system.auth.service.impl.user;

import org.amberframework.web.system.auth.model.original.user.SysUser;
import org.amberframework.web.system.util.AuthUtils;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class PasswordHelper {

  private RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
  private String algorithmName = "md5";
  private int hashIterations = 2;

  public void setRandomNumberGenerator(RandomNumberGenerator randomNumberGenerator) {
    this.randomNumberGenerator = randomNumberGenerator;
  }

  public void setAlgorithmName(String algorithmName) {
    this.algorithmName = algorithmName;
  }

  public void setHashIterations(int hashIterations) {
    this.hashIterations = hashIterations;
  }

  /**
   * 生成密码
   */
  public void encryptPassword(SysUser user) {

    user.setSalt(randomNumberGenerator.nextBytes().toHex());

    String newPassword =
        new SimpleHash(algorithmName, user.getPassword(), ByteSource.Util.bytes(AuthUtils
            .getUserCredentialSalt(user)), hashIterations).toHex();

    user.setPassword(newPassword);
  }
}
