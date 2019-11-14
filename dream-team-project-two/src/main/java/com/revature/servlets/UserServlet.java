package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.revature.models.User;
import com.revature.services.UserServices;
import com.revature.util.HibernateUtil;

public class UserServlet extends HttpServlet {
	// Random Generated serial ID
	private static final long serialVersionUID = 1L;

	// init fields
	private UserServices userServices = new UserServices();
	private ObjectMapper om = new ObjectMapper();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		super.service(req, resp);
	}

	@Override
	public void init() throws ServletException {
		HibernateUtil.configureHibernate();
		om.registerModule(new Hibernate5Module());
	}

	@Override
	public void destroy() {
		HibernateUtil.sessionFactory.close();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// String info = req.getPathInfo();

		om.readValue(req.getReader(), User.class);
		//int id = Integer.parseInt(req.getParameter("id"));
		User user = userServices.getUserById(1);

		om.writeValue(resp.getWriter(), user);

	}
}
