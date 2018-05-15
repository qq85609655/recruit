package org.amberframework.core.shiro.realm;

import org.jasig.cas.client.authentication.AttributePrincipal;

import java.util.Collection;

/**
 * Created by WangYu on 2016/8/19.
 */
public interface PrincipalsAssembler {
  
  /**
   * 创建principal集合. <code>subject.getPrincipal()</code>获取的是<code>iterator().next()</code>
   * ，也就是迭代器获取的第一个元素.
   *
   * @param principal AttributePrincipal
   * @return principal元素集合
   */
  Collection createPrincipalCollection(AttributePrincipal principal);
}
