package atj;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class SessionCounterListener implements HttpSessionListener {

	static private	int	counter = 0;
    public SessionCounterListener() {
     
    }

	
    public void sessionCreated(HttpSessionEvent arg0)  { 
    	arg0.getSession().setAttribute("sessionCounter", new Integer(++counter));
    }

	
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	arg0.getSession().setAttribute("sessionCounter", new Integer(--counter));
    }
    public static int getSessionCounter() {
    	return counter;
    }
}
