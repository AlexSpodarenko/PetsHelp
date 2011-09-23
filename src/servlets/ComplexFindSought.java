package servlets;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImplJPA.DaoFactory;
import dto.Statemate;

/**
 * Servlet implementation class ComplexFindSiught
 */
public class ComplexFindSought extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplexFindSought() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String region=request.getParameter("region");
		String petType=request.getParameter("petType");
		String city=request.getParameter("city");
		String species=request.getParameter("species");
		String size=request.getParameter("size");
		Collection<Statemate> resFindCol=DaoFactory.getStatemateDao().complexFind(region, city, petType, species, size);
		String resParse="<table style=\"width:90%;\">";
		int i=0;
		Iterator<Statemate> it=resFindCol.iterator();
		while(it.hasNext())
		{	Statemate cur=it.next();
			if(request.getParameter("isDropable")!=null)
			resParse+="<tr name=\"Srow\" id=\"Srow" + cur.getId()+"\"  class=\"drop\"><td style=\"width:40%\"><img src=\""+cur.getPhoto()+ "\"/></td>";
			else
			resParse+="<tr><td style=\"width:40%\"><img src=\""+cur.getPhoto()+ "\"/></td>";
			resParse+="<td style=\"width:60% height:100px\">";
			
			
			
			String resHTML="<p> %s \n порода - %s \n потеряно в городе %s %s области \n отзываеться на кличку \"%s\" \n " +
					" приблизительный вес в момент пропажи %s кг \n особые приметы:%s</p> <input id=\"S" + cur.getId()+"\" name=\"moreReference\" type=\"button\" value=\"more\" /></td></tr>";
			resParse+=String.format(resHTML,cur.getPet().getPatType(),cur.getPet().getSpecies(),cur.getCity().getCityName(),
					cur.getCity().getRegion(),cur.getNamepat(),cur.getWeight(),cur.getSpecialFeatures());			
		}
		resParse+="</table>";
		response.getOutputStream().write(resParse.getBytes());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
