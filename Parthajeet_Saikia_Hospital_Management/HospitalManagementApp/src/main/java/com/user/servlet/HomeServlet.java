package com.user.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.user.crud.CrudUser;
import com.user.model.Patient;

public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
	@Override
	public void init(ServletConfig config) throws ServletException {
		
	}

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
		List<Patient> listUser = CrudUser.selectAllUser();
		req.setAttribute("listUser", listUser);
		req.getRequestDispatcher("./index.jsp").forward(req, res);
	}

	void updateUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String bgroup = request.getParameter("bgroup");
		String disease = request.getParameter("disease");
		
		Patient newUser = new Patient(id,name, bgroup, disease);
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
		String bgroup = request.getParameter("bgroup");
		String disease = request.getParameter("disease");
		Patient newUser = new Patient(name, bgroup, disease);
		
		CrudUser.insertUserDb(newUser);
		response.sendRedirect("list");
	}

}


