package filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;

@WebFilter("/*")
public class Filter implements jakarta.servlet.Filter {
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) {
		try {
			System.out.println("フィルター");
			chain.doFilter(request, response);
		} catch (ServletException se) {
		} catch (IOException e) {
		}
	}

	public void init(FilterConfig filterConfig) {
	}

	public void destroy() {
	}
}
