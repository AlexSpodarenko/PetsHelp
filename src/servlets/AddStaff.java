package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImplJPA.DaoFactory;
import dto.AdminDB;
import dto.Client;
import dto.Staff;

/**
 * Servlet implementation class AddStaff
 */
public class AddStaff extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStaff() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Обрабатывает запрос на добавление сотрудника в базу с формы.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object rightsO=request.getSession().getAttribute("rights");
		if(rightsO!=null)
		{	String rights=rightsO.toString();
			if(rights.equals("admin"))
			{
			String login=request.getParameter("login");
			if(testExistLogin(login))
			{	String respStr="already exist";
				response.getOutputStream().write(respStr.getBytes());
				return;
			}
			Staff tmp=new Staff();
			tmp.setAge(Integer.parseInt(request.getParameter("age")));
			tmp.setCount(0);
			tmp.setSalary(Integer.parseInt(request.getParameter("salary")));
			tmp.setStaffLogin(login);
			tmp.setStaffPassword(request.getParameter("Password"));
			tmp.setStaffName(request.getParameter("Name_staff"));	
			DaoFactory.getStaffDao().save(tmp);
			}
		}
	}
	
	public boolean testExistLogin(String login)
	{	
		Staff testLog=DaoFactory.getStaffDao().testLogin(login);
		if(testLog!=null)	
			return true;
		AdminDB ad=DaoFactory.getAdminDao().testLogin(login);
		if(ad!=null)
			return true;
		Client cl=DaoFactory.getClientDao().testLogin(login);
		if(cl!=null)
			return true;
		return false;		
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
