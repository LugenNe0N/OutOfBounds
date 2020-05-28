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
 * Servlet implementation class TaskRegistrationServlet
 */
@WebServlet("/task-registration-servlet")
public class TaskRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskRegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

				request.setCharacterEncoding("UTF-8");
				HttpSession session = request.getSession();

				String id = (String)session.getAttribute("id");
				String taskName = request.getParameter("taskName");
				int categoryId = Integer.parseInt(request.getParameter("categoryId"));
				Date limitDate = Date.valueOf(request.getParameter("limitDate"));
				String employeeId = request.getParameter("employeeName");
				String status = request.getParameter("status");
				String memo = request.getParameter("memo");
				Timestamp create_datetime = new Timestamp(System.currentTimeMillis());

				TaskBean task = new TaskBean();
				task.setTaskName(taskName);
				task.setCategoryId(categoryId);
				task.setLimitDate(limitDate);
				task.setEmployeeId(id);
				task.setEmployeeId(employeeId);
				task.setStatus(status);
				task.setMemo(memo);
				task.setRegisteredDate(create_datetime);


				// DAOの生成
				TaskDAO taskDao = new TaskDAO();


				try {
					// DAOの利用
					taskDao.insert(task);

				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}

				RequestDispatcher rd = request.getRequestDispatcher("task-registration-result.jsp");
				rd.forward(request, response);

			}

		}