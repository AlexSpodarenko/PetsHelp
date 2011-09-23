package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.WebConstruction;
import dao.ImplJPA.DaoFactory;
import dto.AdminDB;
import dto.Client;
import dto.Staff;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	boolean rightLog;
	boolean rightPass;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Обеспечивает авторизацию на сайте
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login=request.getParameter("login");
		String pass=request.getParameter("password");
		AdminDB tested=DaoFactory.getAdminDao().testLogin(login);
		if (tested!=null)
		rightLog=true;
		if(rightLog)
		{
			if(tested.getAdminPasswod().equals(pass))
			{
				this.loginAdmin(login,request,response);
				return;
			}
			else
			{
				this.incorrectPass(request,response);
				return;
			}	
		};
		Staff testedS=DaoFactory.getStaffDao().testLogin(login);
		if(testedS!=null)
		rightLog=true;
		if(rightLog)
		{
					
			if(testedS.getStaffPassword().equals(pass))
				{
					this.loginStaff(login,request,response);
					return;
				}
				else
				{
					this.incorrectPass(request,response);
					return;
				}	
		};	
		Client testedC=DaoFactory.getClientDao().testLogin(login);
		if(testedC!=null)
		rightLog=true;
		if(rightLog)
			{
			if(testedC.getClientPassword().equals(pass))
			{
				this.loginClient(login,request,response);
				return;
			}
			else 
			{
				this.incorrectPass(request,response);
				return;
			}
		};
		String mess="неверный логин";
		request.getSession().setAttribute("message",mess);
		WebConstruction.backToIndex(response, request);
	}
	
	private void loginClient(String login,HttpServletRequest request,HttpServletResponse response) throws IOException
	{   String rights="client";
		request.getSession().setAttribute("rights", rights);
		request.getSession().setAttribute("login", login);
		String mess="вы вошли как "+login;
		request.getSession().setAttribute("message",mess);
		WebConstruction.backToIndex(response,request);
		rightLog=false;
		rightPass=false;
	}
	
	private void loginStaff(String login,HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		String rights="staff";
		request.getSession().setAttribute("rights", rights);
		request.getSession().setAttribute("login", login);
		String mess="вы вошли как "+login;
		request.getSession().setAttribute("message",mess);
		WebConstruction.backToIndex(response,request);
		rightLog=false;
		rightPass=false;
	}
	
	private void loginAdmin(String login,HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		String rights="admin";
		request.getSession().setAttribute("rights", rights);
		request.getSession().setAttribute("login", login);
		String mess="вы вошли как "+login+" поздравляю!";
		request.getSession().setAttribute("message",mess);
		WebConstruction.backToIndex(response,request);
		rightLog=false;
		rightPass=false;
	}
	
	private void incorrectPass(HttpServletRequest request,HttpServletResponse response) throws IOException
	{	String mess="вы ввели неверный пароль";
		request.getSession().setAttribute("message",mess);
		WebConstruction.backToIndex(response,request);
	}
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
