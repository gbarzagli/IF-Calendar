package br.edu.ifsp.calendar;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifsp.calendar.dao.UserDAO;
import br.edu.ifsp.calendar.dao.UserDAOImpl;
import br.edu.ifsp.calendar.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

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
	    HttpSession session = request.getSession();
	    
	    UserDAO usersDao = new UserDAOImpl();
	    try {
            User user = usersDao.findByUsername(request.getParameter("username"));
            if (user.getPassword().equals(request.getParameter("password"))) {
                session.setAttribute("username", request.getParameter("username"));
                session.setAttribute("password", request.getParameter("password"));
                request.getRequestDispatcher("/home.jsp").forward(request, response);
            } else {
                session.setAttribute("message", "Username and/or password is wrong.");
                request.getRequestDispatcher("/index.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
	}

}
