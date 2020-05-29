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

import model.dao.CategoryDAO;
import model.dao.EmployeeDAO;
import model.dao.StatusDAO;
import model.entity.CategoryBean;
import model.entity.EmployeeBean;
import model.entity.StatusBean;

/**
 * Servlet implementation class EmployeeSelectServlet
 */
@WebServlet("/preload-servlet")
public class PreloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PreloadServlet() {
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
		//カテゴリとステータスを読み込み、sessionに入れておく
		HttpSession session = request.getSession();

		StatusDAO statusDao=new StatusDAO();
		CategoryDAO categoryDao=new CategoryDAO();
		EmployeeDAO employeeDao=new EmployeeDAO();

		try {
			List<StatusBean> statusList = statusDao.selectAll();
			List<CategoryBean> categoryList = categoryDao.selectAll();
			List<EmployeeBean> employeeList = employeeDao.selectAll();
			EmployeeBean emp=employeeDao.select((String)request.getAttribute("id"));
			session.setAttribute("statusList", statusList);
			session.setAttribute("categoryList", categoryList);
			session.setAttribute("employeeList", employeeList);
			session.setAttribute("emp", emp);
		} catch (Exception e) {
			e.printStackTrace();
		}

		RequestDispatcher rd = request.getRequestDispatcher("menu-list-servlet");
		rd.forward(request, response);
	}

}
