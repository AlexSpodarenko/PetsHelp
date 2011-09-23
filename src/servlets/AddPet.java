package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.WebConstruction;
import dao.ImplJPA.DaoFactory;
import dto.Pet;

/**
 * Servlet implementation class AddPet
 */
public class AddPet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Обрабатывает запрос на добавление в базу нового вида животных с формы.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object rightsO=request.getSession().getAttribute("rights");
		if(rightsO!=null)
		{	String rights=rightsO.toString();
			if((rights.equals("staff"))||(rights.equals("admin")))
			{
			Pet tmp=new Pet();
			tmp.setPatType(request.getParameter("type"));
			tmp.setPaint(request.getParameter("paint"));
			tmp.setPatSize(request.getParameter("size"));
			tmp.setSpecies(request.getParameter("specias"));
			tmp.setAverageWeight(Integer.parseInt(request.getParameter("aver_weight")));	
			DaoFactory.getPetDao().save(tmp);
			WebConstruction.backToIndex(response,request);
			}
		}
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
