package ua.univer.web;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.univer.controller.DAO.AccountDAO;
import ua.univer.controller.DAO.AdministratorDAO;
import ua.univer.controller.DAO.ClientDAO;

import static java.util.Objects.nonNull;

public class AuthFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		request.setCharacterEncoding("UTF-8");
		System.out.println("fi");
		final HttpServletRequest req = (HttpServletRequest) request;
		final HttpServletResponse res = (HttpServletResponse) response;

		final String login = req.getParameter("login");
		final String password = req.getParameter("password");

		@SuppressWarnings("unused")
		final AccountDAO accountDAO = (AccountDAO) req.getServletContext().getAttribute("accountDAO");
//		@SuppressWarnings("unused")
		final ClientDAO clientDAO = (ClientDAO) req.getServletContext().getAttribute("clientDAO");
//		@SuppressWarnings("unused")
		final AdministratorDAO adminDAO = (AdministratorDAO) req.getServletContext().getAttribute("adminDAO");

		final HttpSession session = req.getSession();

		if (nonNull(session) && nonNull(session.getAttribute("login")) && nonNull(session.getAttribute("password"))) {

			final String role = (String) session.getAttribute("role");

			moveToMenu(req, res, role);

		} else
			try {
				if (clientDAO.clientIsExist(login, password)) {
					
					final String role = "client";

					req.getSession().setAttribute("password", password);
					req.getSession().setAttribute("login", login);
					req.getSession().setAttribute("role", role);

					moveToMenu(req, res, role);

				} else if (adminDAO.adminIsExist(login, password)) {
					
					final String role = "admin";

					req.getSession().setAttribute("password", password);
					req.getSession().setAttribute("login", login);
					req.getSession().setAttribute("role", role);

					moveToMenu(req, res, role);

				} else {

					moveToMenu(req, res, "unknown");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

	private void moveToMenu(final HttpServletRequest req, final HttpServletResponse res, final String role)
			throws ServletException, IOException {
		
		if (role.equals("admin")) {
			req.getRequestDispatcher("/WEB-INF/view/admin_menu.jsp").forward(req, res);
			
		} else if (role.equals("client")) {

			req.getRequestDispatcher("/WEB-INF/view/user_menu.jsp").forward(req, res);

		} else {

			req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, res);
			
		}
	}

	public void destroy() {
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
