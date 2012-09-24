package com.acme;

import java.util.Arrays;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class StartupListener
 *
 */
public class StartupListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public StartupListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event) {
        event.getServletContext().setAttribute("coffees", 
                Arrays.asList("segafredo", "illy", "nesquick"));
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
    }
	
}
