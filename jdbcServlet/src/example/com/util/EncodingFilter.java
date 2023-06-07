package example.com.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/*")
public class EncodingFilter implements Filter {
	private String encoding;

	public void init(FilterConfig conf) {
		ServletContext sct = conf.getServletContext();
		encoding = sct.getInitParameter("encoding");
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws ServletException, IOException {

		request.setCharacterEncoding(encoding);
		chain.doFilter(request, response);
	}

	public void destroy() {
	}

}