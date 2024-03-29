package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ex.Replace;
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
		EmployeeBean employee = (EmployeeBean)session.getAttribute("emp");
		//追加
		String id = Replace.replace(employee.getId());
		String password = Replace.replace(request.getParameter("password"));
		String name = Replace.replace(request.getParameter("name"));
		//
		//String password = request.getParameter("password");
		//String name = request.getParameter("name");

		employee.setId(id);
		employee.setPassword(password);
		employee.setName(name);

		employee = Replace.replaceUser(employee); //add

		/* add
		String url = null;
		if (employee.getId().isEmpty()
				|| employee.getPassword().isEmpty()
				|| employee.getName().isEmpty()) {
			url = "error.jsp";
		} else {
			url = "employee-edit-result.jsp";

			// DAOの生成
			EmployeeDAO employeeDao = new EmployeeDAO();

			try {
				// DAOの利用
				employeeDao.update(employee);

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
				url = "error.jsp";
			}
		}
		*/


		// DAOの生成
		EmployeeDAO employeeDao = new EmployeeDAO();

		String url = null;

		try {
			// DAOの利用
			employeeDao.update(employee);
			List<EmployeeBean> employeeList = employeeDao.selectAll();
			session.setAttribute("employeeList", employeeList);
			url = "employee-edit-result.jsp";

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			url = "error.jsp";
		}


		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}