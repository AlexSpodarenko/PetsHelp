package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImplJPA.DaoFactory;
import dto.Client;

/**
 * Servlet implementation class Registration
 */
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fn=request.getParameter("FirstName");
		
		String login=request.getParameter("login");
		Client cli=DaoFactory.getClientDao().testLogin(login);
		if(cli!=null)
		{
			response.getOutputStream().write("already exist".getBytes());
			return;
		}
		Client tmp=new Client();
		tmp.setClientPassword(request.getParameter("Password"));
		tmp.setClientName(request.getParameter("FirstName"));
		tmp.setClientLogin(login);
		tmp.setEMail(request.getParameter("Mail"));
		tmp.setTelephone(request.getParameter("phone"));
		DaoFactory.getClientDao().save(tmp);
		return;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
