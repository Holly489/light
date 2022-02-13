package qwer.qwq.web.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import qwer.qwq.domain.User;

/**
 * 登录页面拦截
 * @author Administrator
 *
 */
@WebFilter("/qwer/index.html")
public class IndexFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest)request;
		HttpServletResponse res=(HttpServletResponse)response;
		User user=(User)req.getSession().getAttribute("User");
		if(user.getStatus()=="Y") {
			chain.doFilter(request, response);
		}
		else {
			res.sendRedirect("http://106.15.94.131/qwer/html/login.html");
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

	@Override
	public void destroy() {	
	}

}
