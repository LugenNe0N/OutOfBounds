/*
 * WebApp_ex0501
 * servlet.EmployeeRegistrationServlet.java
 */
package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		// リクエストオブジェクトのエンコーディング方式の指定
		request.setCharacterEncoding("UTF-8");

		// リクエストパラメータの取得
		String id = request.getParameter("code");
		String password = request.getParameter("name");
		String name = request.getParameter("age");
		Date date = new Date();

		EmployeeBean employee = new EmployeeBean();
		employee.setId(id);
		employee.setPassword(password);
		employee.setName(name);
		employee.setUpdateDate(date);

		// DAOの生成
		EmployeeDAO employeeDao = new EmployeeDAO();

		int count = 0; // 処理件数

		try {
			// DAOの利用
			count = employeeDao.insert(employee);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		// リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("employee-registration-result.jsp");
		rd.forward(request, response);

	}

}