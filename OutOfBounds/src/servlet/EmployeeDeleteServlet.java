package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.EmployeeDAO;
import model.entity.EmployeeBean;

/**
 * Servlet implementation class EmployeeDeleteServlet
 */
@WebServlet("/employee-delete-servlet")
public class EmployeeDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();

		EmployeeBean employeeBean = (EmployeeBean) session.getAttribute("emp");
		String id =employeeBean.getId();
		EmployeeDAO employeeDao = new EmployeeDAO();

		String url = null;
		try {
			// DAOの利用
			employeeDao.delete(id);
			url = "employee-delete-result.jsp";
			session.invalidate();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}
}