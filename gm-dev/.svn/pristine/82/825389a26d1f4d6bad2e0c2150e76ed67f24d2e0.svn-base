package org.amberframework.core.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

/**
 * 阻止URL重写显示jsessionid，但是Shiro下测试时发现没什么用（IE8浏览器），以后还可以进一步测试，看看是否真的能不显示jsessionid.
 */
public class DisableUrlSessionFilter implements Filter {

  /**
   * 过滤器，重写URL.
   */
  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    // skip non-http requests
    if (!(request instanceof HttpServletRequest)) {
      chain.doFilter(request, response);
      return;
    }

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    HttpServletResponse httpResponse = (HttpServletResponse) response;

    // clear session if session id in URL
    if (httpRequest.isRequestedSessionIdFromURL()) {
      HttpSession session = httpRequest.getSession();
      if (session != null) {
        session.invalidate();
      }
    }

    // wrap response to remove URL encoding
    HttpServletResponseWrapper wrappedResponse = new FilterHttpServletResponseWrapper(httpResponse);

    // process next request in chain
    chain.doFilter(request, wrappedResponse);
  }

  /**
   * Unused.
   */
  @Override
  public void init(FilterConfig config) throws ServletException {
    // Nothing to do
  }

  /**
   * Unused.
   */
  @Override
  public void destroy() {
    // Nothing to do
  }

  public class FilterHttpServletResponseWrapper extends HttpServletResponseWrapper {

    public FilterHttpServletResponseWrapper(HttpServletResponse response) {
      super(response);
    }

    @Override
    public String encodeRedirectUrl(String url) {
      return url;
    }

    @Override
    public String encodeRedirectURL(String url) {
      return url;
    }

    @Override
    public String encodeUrl(String url) {
      return url;
    }

    @Override
    public String encodeURL(String url) {
      return url;
    }

  }
}
