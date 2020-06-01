package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.TaskDAO;
import model.entity.TaskBean;

/**
 * Servlet implementation class TaskEditServlet
 */
@WebServlet("/task-edit-servlet")
public class TaskEditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskEditServlet() {
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
		String url="task-edit-result.jsp";
		int taskId = Integer.parseInt(request.getParameter("categoryID"));
		String taskName = (String) request.getParameter("taskName");
		int categoryId = Integer.parseInt(request.getParameter("categoryID"));
		Date limitDate = Date.valueOf((String) request.getParameter("limitDate"));
		String employeeId = (String) request.getParameter("employeeId");
		String status = (String) request.getParameter("status");
		String memo = (String) request.getParameter("memo");

		TaskBean task = new TaskBean();
		task.setTaskId(taskId);
		task.setTaskName(taskName);
		task.setCategoryId(categoryId);
		task.setLimitDate(limitDate);
		task.setEmployeeId(employeeId);
		task.setStatus(status);
		task.setMemo(memo);

		// DAOの生成
		TaskDAO taskDao = new TaskDAO();
		try {
			// DAOの利用
			taskDao.update(task);

		} catch (ClassNotFoundException | SQLException e) {
			url="error.jsp";
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);

	}

}
