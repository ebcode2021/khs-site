package khs.common.visit;



import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.catalina.SessionEvent;

import khs.main.model.dto.Visit;
import khs.main.model.service.VisitService;


@WebListener
public class VisitListener implements ServletContextListener, HttpSessionAttributeListener {
	Visit visit = new Visit();
    public VisitListener() {
    
    }

	
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	
    public void attributeAdded(HttpSessionBindingEvent event)  { 
    	if(event.getName().equals("authentication")) {
    		//DB에서 방문자 수를 가져옴
    		VisitService visitService = new VisitService();
    		Integer todayCnt = (Integer)visitService.getTodayVisitCnt();
    		Integer totalCnt = (Integer)visitService.getTotalVisitCnt();
    		
    		HttpSession session = event.getSession();
    		session.setAttribute("todayCnt", todayCnt);
    		session.setAttribute("totalCnt", totalCnt);
    	}    		   		
     }
    



	
    public void attributeReplaced(HttpSessionBindingEvent event)  { 
         // TODO Auto-generated method stub
   }

	
    public void contextInitialized(ServletContextEvent sce)  { 
         ServletContext context = sce.getServletContext();
         context.setAttribute("memberCnt", 0);
         context.setAttribute("memberAccumulateCnt", 0);
    }


	


	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub
		
	}
	
}
