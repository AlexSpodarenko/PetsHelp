package servlets;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.WebConstruction;
import dao.ImplJPA.DaoFactory;
import dto.City;

/**
 * Servlet implementation class GetCitySublist
 */
public class GetCitySublist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetCitySublist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String region=request.getParameter("region");
		Collection<City> col=DaoFactory.getCityDao().getByRegion(region);
		if(col==null)
			return;

		Collection<String> strCol=new LinkedList<String>();
		Iterator<City> it=col.iterator();
		while(it.hasNext())
		{
			City tmpCity=it.next();
			strCol.add(tmpCity.getCityName());
		}
		String resp=WebConstruction.getlistBox(strCol, 1, "cityMenu","cityMenu");
		response.getOutputStream().write(resp.getBytes());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
