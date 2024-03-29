package servlet;

import java.io.IOException;

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
 * ログイン認証処理を制御する
 * @author emBex Education
 */
@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = null;

		request.setCharacterEncoding("UTF-8");

		String id = Replace.replace(request.getParameter("id"));
		String password = Replace.replace(request.getParameter("password"));

		try {
			// DAOの生成
			EmployeeDAO employeeDao = new EmployeeDAO();

			// DAOの利用
			if (employeeDao.loginCheck(id, password)) {

				url = "preload-servlet";
				HttpSession session = request.getSession();
				EmployeeBean emp= employeeDao.select(id);
				session.setAttribute("emp", emp);



			} else {

				url = "loginerror.jsp";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

}