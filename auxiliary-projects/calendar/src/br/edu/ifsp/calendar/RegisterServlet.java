package br.edu.ifsp.calendar;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifsp.calendar.dao.UserDAO;
import br.edu.ifsp.calendar.dao.UserDAOImpl;
import br.edu.ifsp.calendar.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    User user = new User();
	    user.setUsername(request.getParameter("username"));
	    user.setPassword(request.getParameter("password"));
	    
	    UserDAO usersDao = new UserDAOImpl();
	    try {
            usersDao.insert(user);
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
	    
	    request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
