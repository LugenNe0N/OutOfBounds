package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.EmployeeDAO;
import model.dao.TaskDAO;
import model.entity.EmployeeBean;
import model.entity.TaskBean;

/**
 * Servlet implementation class MenuListServlet
 */
@WebServlet("/menu-list-servlet")
public class MenuListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MenuListServlet() {
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

		TaskDAO taskDao = new TaskDAO();
		EmployeeDAO employeeDao =new EmployeeDAO();
		HttpSession session =request.getSession();
		EmployeeBean employee =(EmployeeBean)session.getAttribute("emp");


		try {
			List<TaskBean> taskList = taskDao.selectAll();
			EmployeeBean name =employeeDao.select(employee.getId());

			request.setAttribute("taskList", taskList);
			request.setAttribute("name", name);

		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("menu-list.jsp");
		rd.forward(request, response);
	}
}