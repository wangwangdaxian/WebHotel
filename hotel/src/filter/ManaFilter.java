package filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class ManaFilter
 */
@WebFilter(filterName="ManaFilter",urlPatterns= {"/ManaIndex.jsp","/ManaStatics.jsp","/ManaCustHere.jsp",
		"/ManaReceAccount.jsp","/ManaRoomControl.jsp"})
public class ManaFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ManaFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpRequest=(HttpServletRequest)request;

        if(httpRequest.getSession().getAttribute("mana")!=null){
            chain.doFilter(request, response);
        }
        else{
        	request.setAttribute("msg", "Please Login First!");
        	request.getRequestDispatcher("index.jsp").forward(request, response);
        }
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
