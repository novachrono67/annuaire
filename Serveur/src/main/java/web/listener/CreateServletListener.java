package web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class CreateServletListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Servlet créée");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {		
	}

}
