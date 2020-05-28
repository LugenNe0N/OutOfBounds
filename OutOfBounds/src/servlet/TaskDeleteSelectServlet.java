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

import model.dao.TaskDAO;
import model.entity.TaskBean;

/**
 * Servlet implementation class TaskDeleteSelectServlet
 */
@WebServlet("/task-delete-select-servlet")
public class TaskDeleteSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskDeleteSelectServlet() {
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
		try {
			// DAOの利用
			task = taskDao.select(taskId);

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		String taskName = task.getTaskName();

		request.setAttribute("taskName", taskName);

		RequestDispatcher rd = request.getRequestDispatcher("task-delete.jsp");
		rd.forward(request, response);

	}

}
