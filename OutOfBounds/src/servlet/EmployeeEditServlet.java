package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;

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
 * Servlet implementation class EmployeeEditServlet
 */
@WebServlet("/employee-edit-servlet")
public class EmployeeEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeEditServlet() {
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
		EmployeeBean employee = new EmployeeBean();

		String id = (String) session.getAttribute("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		Timestamp create_datetime = new Timestamp(System.currentTimeMillis());

		employee.setId(id);
		employee.setPassword(password);
		employee.setName(name);
		employee.setUpdateDate(create_datetime);

		// DAOの生成
		EmployeeDAO employeeDao = new EmployeeDAO();

		try {
			// DAOの利用
			employeeDao.update(employee);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("employee-edit-result.jsp");
		rd.forward(request, response);

	}

}