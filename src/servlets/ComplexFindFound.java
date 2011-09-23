package servlets;

import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ImplJPA.DaoFactory;
import dto.FindingPet;

/**
 * Servlet implementation class ComplexFindSought
 */
public class ComplexFindFound extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComplexFindFound() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Метод вызываеться при нажатии кнопки "поиск" на странице просмотра найденых животных. Осуществляет поиск по заданым
	 * параметрам
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String region=request.getParameter("region");
		String petType=request.getParameter("petType");
		String city=request.getParameter("city");
		String species=request.getParameter("species");
		String size=request.getParameter("size");
		Collection<FindingPet> resFindCol=DaoFactory.getFindingPetDao().complexFind(region, city, petType, species, size);
		String resParse="<table style=\"width:90%;\">";
		int i=0;
		Iterator<FindingPet> it=resFindCol.iterator();
		while(it.hasNext())
		{	FindingPet cur=it.next();
			if(request.getParameter("isDragable")!=null)
			{
				resParse+="<tr name=\"Frow\" id=\"Frow" + cur.getId()+"\"  class=\"drag\"><td style=\"width:40%\"><img src=\""+cur.getPhoto()+ "\"/></td>";
			}
			else
				resParse+="<tr><td style=\"width:40%\"><img src=\""+cur.getPhoto()+ "\"/></td>";
			resParse+="<td style=\"width:60% height:100px\">";
			String resHTML="<p> %s \n порода - %s \n найден в городе %s %s области \n в данный момент находиться: %s \n " +
					"особые приметы:%s</p> <p> <input id=\"F" + cur.getId()+"\" name=\"moreReference\" type=\"button\" value=\"more\" /></p></td></tr>";
			resParse+=String.format(resHTML,cur.getIdPet().getPatType(),cur.getIdPet().getSpecies(),cur.getCity().getCityName(),
					cur.getCity().getRegion(),cur.getWherePlaced(),cur.getSpecialFeatures());			
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
