package khs.common.visit;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;


@WebListener
public class VisitListener implements ServletContextListener, HttpSessionAttributeListener {

  
    public VisitListener() {
    
    }

	
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	
    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	System.out.println("ㅠㅠ");
    	System.out.println(event.getName());
    	if(event.getName().equals("authentication")) {
    		System.out.println("nnnn");
    		ServletContext context = event.getSession().getServletContext();
    		
    		Integer memberCnt = (Integer) context.getAttribute("memberCnt");
    		Integer memberAccumulateCnt = (Integer) context.getAttribute("memberAccumulateCnt");
    		
    		context.setAttribute("memberCnt", memberCnt+1);
    		context.setAttribute("memberAccumulateCnt", memberAccumulateCnt+1);
         }
    }

	/**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent event)  { 
         if(event.getName().equals("authentication")) {
        	 ServletContext context = event.getSession().getServletContext();
        	 Integer memberCnt = (Integer)context.getAttribute("memberCnt");
        	 context.setAttribute("memberCnt", memberCnt-1);
         }
    }

	/**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
    }

	
    public void contextInitialized(ServletContextEvent sce)  { 
         ServletContext context = sce.getServletContext();
         context.setAttribute("memberCnt", 0);
         context.setAttribute("memberAccumulateCnt", 0);
    }
	
}
