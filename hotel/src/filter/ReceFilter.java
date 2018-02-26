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
 * Servlet Filter implementation class ReceFilter
 */
@WebFilter(filterName="ReceFilter",urlPatterns= {"/check_in_cur.jsp","/check_in_pre.jsp","/check_out.jsp",
		"/fix_report.jsp","/Receindex.jsp","/management.jsp"})
public class ReceFilter implements Filter {

    /**
     * Default constructor. 
     */
    public ReceFilter() {
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

        if(httpRequest.getSession().getAttribute("rece")!=null){
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
