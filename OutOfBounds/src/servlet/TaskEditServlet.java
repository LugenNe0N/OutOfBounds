package servlet;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;

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

		HttpSession session = request.getSession();

		int taskId = (int) session.getAttribute("taskId");
		String taskName = request.getParameter("taskName");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		Date limitDate = Date.valueOf(request.getParameter("limitDate"));
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		String memo = request.getParameter("memo");
		Timestamp update_datetime = new Timestamp(System.currentTimeMillis());

		TaskBean task = new TaskBean();
		task.setTaskId(taskId);
		task.setTaskName(taskName);
		task.setCategoryId(categoryId);
		task.setLimitDate(limitDate);
		task.setEmployeeId(id);
		task.setStatus(status);
		task.setMemo(memo);
		task.setUpdateDate(update_datetime);

		// DAOの生成
		TaskDAO taskDao = new TaskDAO();

		try {
			// DAOの利用
			taskDao.update(task);
			session.removeAttribute("taskId");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("task-edit-result.jsp");
		rd.forward(request, response);

	}

}
