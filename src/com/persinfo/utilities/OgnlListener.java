/**
 * 
 */
package com.persinfo.utilities;

/**
 * @author deva
 *
 */

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ognl.OgnlRuntime;

public class OgnlListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		OgnlRuntime.setSecurityManager(null);
	}

}

