package com.bemach.web;

import javax.servlet.http.HttpServlet;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class StartupServlet extends HttpServlet {
	private static final Logger logger = Logger.getLogger(StartupServlet.class);
	private static final long serialVersionUID = 1L;
	
	public StartupServlet() {
		super();
	}
	
	public void init() {
		BasicConfigurator.configure();
		logger.info("StartupServlet started.");
	}
}
