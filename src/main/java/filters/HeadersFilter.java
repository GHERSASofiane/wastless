package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeadersFilter implements Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	
	public void doFilter(ServletRequest request, ServletResponse  response, FilterChain chain)
			throws IOException, ServletException {

		 ((HttpServletResponse) response).setHeader("Access-Control-Allow-Origin", "*"); 
		 ((HttpServletResponse) response).setHeader("Accept-Charset", "utf-8"); 
		 ((HttpServletResponse) response).setHeader("Access-Control-Allow-Credentials", "true");
		 ((HttpServletResponse) response).setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
		 ((HttpServletResponse) response).setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type, Accept, X-Requested-With");

		 
	    	
		chain.doFilter(request, response);
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	

}
