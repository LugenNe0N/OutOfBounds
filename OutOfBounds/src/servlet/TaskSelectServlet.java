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
import javax.servlet.http.HttpSession;

import model.dao.CategoryDAO;
import model.dao.TaskDAO;
import model.entity.CategoryBean;
import model.entity.TaskBean;

/**
 * Servlet implementation class TaskSelectServlet
 */
@WebServlet("/task-select-servlet")
public class TaskSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskSelectServlet() {
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

		String taskId = request.getParameter("taskId");

		HttpSession session = request.getSession();
		session.setAttribute("taskId", taskId);

		TaskDAO taskDao = new TaskDAO();
		TaskBean task = new TaskBean();

		CategoryDAO categoryDao = new CategoryDAO();
		CategoryBean category = new CategoryBean();
		int categoryId;
		String categoryName = null;

		try {
			// DAOの利用
			task = taskDao.select(taskId);
			categoryId = task.getCategoryId();
			category = categoryDao.select(categoryId);
			categoryName = category.getName();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		String taskName = task.getTaskName();
		Date limitDate = task.getLimitDate();
		String employeeId = task.getEmployeeId();
		String status = task.getStatus();
		String memo = task.getMemo();

		request.setAttribute("taskName", taskName);
		request.setAttribute("categoryName", categoryName);
		request.setAttribute("limitDate", limitDate);
		request.setAttribute("employeeId", employeeId);
		request.setAttribute("status", status);
		request.setAttribute("memo", memo);

		RequestDispatcher rd = request.getRequestDispatcher("task-edit.jsp");
		rd.forward(request, response);

	}

}
