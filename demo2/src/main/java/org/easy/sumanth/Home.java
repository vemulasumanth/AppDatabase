package org.easy.sumanth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.easy.sumanth.entity.Detail;
import org.easy.sumanth.model.Detailmodel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.ast.SwitchExpression;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("page");
		switch (page) {
		case "Home": {
			request.setAttribute("title","HomePage");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			break;
		}
		default:
			request.setAttribute("title", "Errorpage");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
