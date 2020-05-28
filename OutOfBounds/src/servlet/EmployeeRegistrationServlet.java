/*
 * WebApp_ex0501
 * servlet.EmployeeRegistrationServlet.java
 */
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
 * 従業員情報の登録処理を制御する
 * @author emBex Education
 */
@WebServlet("/employee-registration-servlet")
public class EmployeeRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeRegistrationServlet() {
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

		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		Timestamp update_datetime = new Timestamp(System.currentTimeMillis());

		EmployeeBean employee = new EmployeeBean();
		employee.setId(id);
		employee.setPassword(password);
		employee.setName(name);
		employee.setUpdateDate(update_datetime);

		// DAOの生成
		EmployeeDAO employeeDao = new EmployeeDAO();

		String url = null;
		HttpSession session = request.getSession();

		try {
			// DAOの利用
			employeeDao.insert(employee);
			session.setAttribute("id", id);

			url = "employee-registration-result.jsp";

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			url = "error.jsp";
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}