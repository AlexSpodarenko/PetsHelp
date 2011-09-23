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
import dto.Pet;

/**
 * Servlet implementation class GetSpeciesSublist
 */
public class GetSpeciesSublist extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetSpeciesSublist() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String typeP=request.getParameter("petType");
		Collection<Pet> col=DaoFactory.getPetDao().getByType(typeP);
		if(col==null)
			return;
		Collection<String> strCol=new LinkedList<String>();
		Iterator<Pet> it=col.iterator();
		while(it.hasNext())
		{
			Pet tmpPet=it.next();
			strCol.add(tmpPet.getSpecies());
		}
		String resp=WebConstruction.getlistBox(strCol, 1, "SpeciesMenu","SpeciesMenu");
		response.getOutputStream().write(resp.getBytes());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
