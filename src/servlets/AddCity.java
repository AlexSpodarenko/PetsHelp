package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.WebConstruction;
import dao.ImplJPA.DaoFactory;
import dto.City;

/**
 * Servlet implementation class AddCity
 */
public class AddCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCity() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Вызываеться для обработки запроса от формы добавления города. Принимает параметры из формы создает
	 * обект класса город и сохраняет его в базе
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Object rightsO=request.getSession().getAttribute("rights");
		if(rightsO!=null)
		{	String rights=rightsO.toString();
			if((rights.equals("staff"))||(rights.equals("admin")))
			{
				City tmp=new City();
				tmp.setCityName(request.getParameter("Name_city"));
				tmp.setMaire(request.getParameter("maire"));
				tmp.setPopulation(Integer.parseInt(request.getParameter("population")));
				tmp.setRegion(request.getParameter("region"));
				DaoFactory.getCityDao().save(tmp);
			}
		}
		WebConstruction.backToIndex(response,request);
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
