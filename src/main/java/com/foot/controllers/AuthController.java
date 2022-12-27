package com.foot.controllers;

import java.io.IOException;
import java.util.Optional;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Path;

import com.foot.models.Client;
import com.foot.services.ClientService;

@WebServlet("/login")
public class AuthController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	private ClientService clientService;

	public AuthController() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		Client client = clientService.findByEmail(email);
		if (client != null && client.getPassword().equals(password)) {
			HttpSession session = request.getSession();
//			System.out.println("[LOGIN] User: " + client.getEmail());
			session.setAttribute("username", email);
			request.getRequestDispatcher("/index.html").forward(request, response);
		}

		doGet(request, response);
	}

}
