package com.foot.controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.foot.models.Client;
import com.foot.services.ClientService;

@WebServlet("/registration")
public class RegistrationController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private ClientService clientService;

	public RegistrationController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/registration.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Client clientToCreate = Client.builder()
				.email(request.getParameter("email"))
				.password(request.getParameter("password"))
				.fullName(request.getParameter("fullname"))
				.phone(request.getParameter("phone"))
				.build();
		clientService.add(clientToCreate);

		doGet(request, response);
	}
}
