package com.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.crud.CrudUser;
import com.user.model.User;

public class HibernateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = req.getMethod();

		if(method.equals("GET")) {
			doGet(req, resp);
		}else {
			doPost(req, resp);
		}
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);
		switch(action) {
		case "/list":
			showAllUser(request, response);
			break;
		case "/delete":
			deleteUser(request, response);
			break;
		default:
			showAllUser(request, response);
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		System.out.println(action);

		switch(action) {
		case "/update":
			updateUser(req, resp);
			break;
		case "/insert":
			insertUser(req, resp);
			break;
		default:
			showAllUser(req, resp);
			break;
			
		}
	}
	
	void showAllUser(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		List<User> listUser = CrudUser.selectAllUser();
		req.setAttribute("listUser", listUser);
		req.getRequestDispatcher("/index.jsp").forward(req, res);
		System.out.println(listUser.size());
	}

	void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		User newUser = new User(id,name, email, country);
		CrudUser.updateUserDb(newUser);
		response.sendRedirect("list");
	}

	void deleteUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		CrudUser.deleteUserDb(id);
		response.sendRedirect("list");
	}

	void insertUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		
		User newUser = new User();
		newUser.setUname(name);
		newUser.setEmail(email);
		newUser.setCountry(country);
		
		CrudUser.insertUserDb(newUser);
		response.sendRedirect("list");
	}
}
