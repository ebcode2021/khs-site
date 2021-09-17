package khs.common.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import khs.common.wrapper.RequestWrapper;
import khs.common.wrapper.ResponseWrapper;



public class WrapperFilter implements Filter {

    public WrapperFilter() {
    }

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		RequestWrapper requestWrapper = new RequestWrapper((HttpServletRequest) request);
		ResponseWrapper responseWrapper = new ResponseWrapper((HttpServletResponse) response);
		chain.doFilter(requestWrapper, responseWrapper);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
