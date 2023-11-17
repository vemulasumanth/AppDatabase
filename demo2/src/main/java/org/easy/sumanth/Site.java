package org.easy.sumanth;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.easy.sumanth.entity.Detail;
import org.easy.sumanth.model.Detailmodel;

/**
 * Servlet implementation class Site
 */
@WebServlet("/Site")
public class Site extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page=request.getParameter("page");
		switch (page) {
		case "ListUsers": {
			listUsers(request,response);
			break;
		}
		case "AddUsers": {
			addUsers(request,response);
			break;
		}
		case "UpdateUser": {
			updateuser(request,response);
			break;
		}
		case "DeleteUser": {
			Detailmodel dum2=new Detailmodel();
			dum2.deleteDetails(Integer.parseInt(request.getParameter("user_id")));
			listUsers(request,response);
			break;
		}
		default:
			request.setAttribute("title", "Errorpage");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			break;
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String form=request.getParameter("form");
		switch (form) {
		case "addUseroperation": {
			Detail dummy=new Detail(request.getParameter("username"),request.getParameter("emailid"));
			Detailmodel dum=new Detailmodel();
			dum.addDetails(dummy);
			listUsers(request,response);
			break;
		}
		case "updateUseroperation": {
			Detail updated=new Detail(Integer.parseInt(request.getParameter("userid")),request.getParameter("user_name"),request.getParameter("email_id"));
			Detailmodel dum1=new Detailmodel();
			dum1.updateDetails(updated);
			listUsers(request,response);
			break;
		}
		default:
			request.setAttribute("title", "Errorpage");
			request.getRequestDispatcher("error.jsp").forward(request, response);
			break;
		}
	}


	
	protected void listUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Detail> d=new ArrayList<>();
		request.setAttribute("title", "ListUsers");
		Detailmodel obj=new Detailmodel();
		d=obj.listuser();
		request.setAttribute("listUser",d);
		request.getRequestDispatcher("listusers.jsp").forward(request, response);
	}
    protected void addUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setAttribute("title", "AddUsers");
    	request.getRequestDispatcher("addusers.jsp").forward(request, response);
	}
    protected void updateuser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setAttribute("title", "UpdateUser");
    	request.getRequestDispatcher("updateuser.jsp").forward(request, response);
	}
}
