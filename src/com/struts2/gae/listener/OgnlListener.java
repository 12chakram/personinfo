package com.struts2.gae.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import ognl.OgnlRuntime;

public class OgnlListener implements ServletContextListener {

        @Override
        public void contextDestroyed(ServletContextEvent arg0) {

        }

        @Override
        public void contextInitialized(ServletContextEvent arg0) {
                OgnlRuntime.setSecurityManager(null);
        }

}