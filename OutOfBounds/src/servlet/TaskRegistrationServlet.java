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
		// リクエストオブジェクトのエンコーディング方式の指定
				request.setCharacterEncoding("UTF-8");

				// リクエストパラメータの取得
				String taskName = request.getParameter("taskName");
				int categoryId = Integer.parseInt(request.getParameter("categoryId"));
				Date limitDate = (Date)request.getParameter("limitDate");
				String employeeId = request.getParameter("employeeName");
				String status = request.getParameter("status");
				String memo = request.getParameter("memo");

				TaskBean task = new TaskBean();
				task.setTaskName(taskName);
				task.setCategoryId(categoryId);
				task.setLimitDate(limitDate);
				task.setEmployeeId(employeeId);
				task.setStatus(status);
				task.setMemo(memo);

				// DAOの生成
				TaskDAO taskDao = new TaskDAO();

				int count = 0; // 処理件数

				try {
					// DAOの利用
					count = taskDao.insert(task);

				} catch (ClassNotFoundException | SQLException e) {
					e.printStackTrace();
				}

				// リクエストの転送
				RequestDispatcher rd = request.getRequestDispatcher("employee-registration-result.jsp");
				rd.forward(request, response);

			}

		}