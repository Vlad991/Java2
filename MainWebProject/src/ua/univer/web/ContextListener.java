package ua.univer.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import ua.univer.controller.DAO.AccountDAO;
import ua.univer.controller.DAO.AdministratorDAO;
import ua.univer.controller.DAO.ClientDAO;

@WebListener
public class ContextListener implements ServletContextListener {
	private AccountDAO accountDAO;
	private ClientDAO clientDAO;
	private AdministratorDAO adminDAO;

	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		
		accountDAO = new AccountDAO();
		clientDAO = new ClientDAO();
		adminDAO = new AdministratorDAO();
		
		final ServletContext servletContext = servletContextEvent.getServletContext();
		
		servletContext.setAttribute("accountDAO", accountDAO);
		servletContext.setAttribute("clientDAO", clientDAO);
		servletContext.setAttribute("adminDAO", adminDAO);
		
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		accountDAO.closeConection();
		clientDAO.closeConnection();
		adminDAO.closeConnection();
	}

}
