package springmvc.mvctest.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {
	private final static String charset = "UTF-8";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String initParameter = filterConfig.getInitParameter("filterDesc");
		System.out.println("---------------" + initParameter);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		req.setCharacterEncoding(charset);
		HttpServletResponse rep = (HttpServletResponse)response;
		rep.setCharacterEncoding(charset);
		chain.doFilter(req, rep);
	}

	@Override
	public void destroy() {
		System.out.println("-----------------destory");
	}

}
