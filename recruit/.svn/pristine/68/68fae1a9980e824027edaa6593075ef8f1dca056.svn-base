package org.amberframework.core.shiro.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.cas.CasAuthenticationException;
import org.apache.shiro.cas.CasRealm;
import org.apache.shiro.cas.CasToken;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.apache.shiro.util.StringUtils;
import org.jasig.cas.client.authentication.AttributePrincipal;
import org.jasig.cas.client.validation.Assertion;
import org.jasig.cas.client.validation.TicketValidationException;
import org.jasig.cas.client.validation.TicketValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.Map;

/**
 * Created by WangYu on 2016/8/19.
 */
public class CustomCasRealm extends CasRealm {

  private static Logger log = LoggerFactory.getLogger(CustomCasRealm.class);

  private PrincipalsAssembler principalsAssembler;

  public PrincipalsAssembler getPrincipalsAssembler() {
    return principalsAssembler;
  }

  public void setPrincipalsAssembler(PrincipalsAssembler principalsAssembler) {
    this.principalsAssembler = principalsAssembler;
  }

  @Override
  protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token)
      throws AuthenticationException {
    CasToken casToken = (CasToken) token;
    if (token == null) {
      return null;
    } else {
      String ticket = (String) casToken.getCredentials();
      if (!StringUtils.hasText(ticket)) {
        return null;
      } else {
        TicketValidator ticketValidator = this.ensureTicketValidator();

        try {
          Assertion e = ticketValidator.validate(ticket, this.getCasService());
          AttributePrincipal casPrincipal = e.getPrincipal();
          String userId = casPrincipal.getName();
          log.debug("Validate ticket : {} in CAS server : {} to retrieve user : {}",
              new Object[] {ticket, this.getCasServerUrlPrefix(), userId});
          Map attributes = casPrincipal.getAttributes();
          casToken.setUserId(userId);
          String rememberMeAttributeName = this.getRememberMeAttributeName();
          String rememberMeStringValue = (String) attributes.get(rememberMeAttributeName);
          boolean isRemembered =
              rememberMeStringValue != null && Boolean.parseBoolean(rememberMeStringValue);
          if (isRemembered) {
            casToken.setRememberMe(true);
          }

          Collection principals;
          if (null == principalsAssembler) {
            principals = CollectionUtils.asList(new Object[] {userId, attributes});
          } else {
            principals = principalsAssembler.createPrincipalCollection(casPrincipal);
          }
          SimplePrincipalCollection principalCollection =
              new SimplePrincipalCollection(principals, this.getName());
          return new SimpleAuthenticationInfo(principalCollection, ticket);
        } catch (TicketValidationException var14) {
          throw new CasAuthenticationException("Unable to validate ticket [" + ticket + "]", var14);
        }
      }
    }
  }
}
