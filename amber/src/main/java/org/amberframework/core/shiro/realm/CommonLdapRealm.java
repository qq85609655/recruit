package org.amberframework.core.shiro.realm;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.realm.ldap.JndiLdapRealm;
import org.apache.shiro.realm.ldap.LdapContextFactory;
import org.apache.shiro.realm.ldap.LdapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.NameNotFoundException;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.LdapContext;

/**
 * Created by WangYu on 2016/8/17.
 */
public class CommonLdapRealm extends JndiLdapRealm {

  private static final Logger log = LoggerFactory.getLogger(CommonLdapRealm.class);

  protected Object getLdapPrincipalDn(AuthenticationToken token,
      LdapContextFactory ldapContextFactory) throws NamingException {
    LdapContext ctx = null;
    Object principal = (String) token.getPrincipal();
    String userDn = "";
    try {
      ctx = ldapContextFactory.getSystemLdapContext();
      // Open system LDAP context to search the DN of principal. Return the userDN string.
      SearchControls constraints = new SearchControls();
      constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
      constraints.setReturningAttributes(new String[] {"entryDN"});
      // Search user DN by uid or login name.
      NamingEnumeration nameEnum = ctx.search("",
          "(|(uid=" + principal + ")(smart-csot-loginname=" + principal + "))", constraints);
      if (!nameEnum.hasMoreElements()) {
        throw new NameNotFoundException(principal + "is not found in LDAP Context");
      } else {
        // Generate user DN string.
        SearchResult searchResult;
        while (nameEnum.hasMoreElements()) { // maybe more than one element
          Object element = nameEnum.nextElement();
          if (element instanceof SearchResult) {
            searchResult = (SearchResult) element;
            userDn = searchResult.getName();
            Attributes attrs = searchResult.getAttributes();
            if (attrs != null) {
              Attribute dnAttr = attrs.get("entryDN");
              userDn = (String) dnAttr.get();
            }
            break;
          }
        }
      }
    } finally {
      LdapUtils.closeContext(ctx);
    }
    return userDn;
  }

  @Override
  protected AuthenticationInfo queryForAuthenticationInfo(AuthenticationToken token,
      LdapContextFactory ldapContextFactory) throws NamingException {
    Object principal = token.getPrincipal();
    Object credentials = token.getCredentials();

    log.debug("Authenticating user '{}' through LDAP", principal);

    principal = getLdapPrincipalDn(token, ldapContextFactory);

    log.debug("Authenticating userDN is '{}'", principal);

    LdapContext ctx = null;
    try {
      ctx = ldapContextFactory.getLdapContext(principal, credentials);
      // context was opened successfully, which means their credentials were valid. Return the
      // AuthenticationInfo:
      return createAuthenticationInfo(token, principal, credentials, ctx);
    } finally {
      LdapUtils.closeContext(ctx);
    }
  }
}
