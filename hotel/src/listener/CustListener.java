package listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import javaBean.Customer;

/**
 * Application Lifecycle Listener implementation class CustListener
 *
 */
@WebListener
public class CustListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public CustListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent se)  { 
         // TODO Auto-generated method stub
    	@SuppressWarnings("unchecked")
		Map<String, HttpSession> map = (Map<String, HttpSession>) se.getSession().getServletContext().getAttribute("map");
        if (map==null) {
            map = new HashMap<String, HttpSession>();
            se.getSession().getServletContext().setAttribute("map", map);
        }
        // Map map = new HashMap();
        Object object = se.getValue();
        if (object instanceof Customer) {
            Customer user = (Customer) object;
            map.put(user.getName(), se.getSession());
        }
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }
	
}
